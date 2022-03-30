package com.example.jwttoken.repository;

import com.example.jwttoken.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {
}
