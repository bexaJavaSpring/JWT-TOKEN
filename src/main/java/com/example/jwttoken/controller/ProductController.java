package com.example.jwttoken.controller;

import com.example.jwttoken.dto.ApiResponse;
import com.example.jwttoken.dto.ProductDto;
import com.example.jwttoken.repository.ProductRepository;
import com.example.jwttoken.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/product")
@RestController
@RequiredArgsConstructor
public class ProductController {
    final ProductRepository productRepository;
    final ProductService productService;

    @PreAuthorize("{hasAnyAuthority('USER','ADMIN')}")
    @GetMapping("/list")
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @PreAuthorize("{hasAuthority('ADMIN')}")
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody ProductDto dto) {
        ApiResponse apiResponse = productService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PreAuthorize("{hasAuthority('ADMIN')}")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody ProductDto dto) {
        ApiResponse apiResponse = productService.edit(id, dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PreAuthorize("{hasAuthority('ADMIN')}")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getByID(@PathVariable Integer id) {
        ApiResponse getoneId = productService.getById(id);
        return ResponseEntity.status(getoneId.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(getoneId);
    }
}
