package com.example.jwttoken.service;

import com.example.jwttoken.dto.ApiResponse;
import com.example.jwttoken.dto.ProductDto;
import com.example.jwttoken.entity.Product;
import com.example.jwttoken.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ApiResponse add(ProductDto dto) {
        Product product=new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, ProductDto dto) {

        return new ApiResponse("Edit",true);
    }

    public ApiResponse delete(Integer id) {

        return new ApiResponse("Delete",true);
    }

    public ApiResponse getById(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.get();
        return new ApiResponse("Mana",true,product);
    }
}
