package com.luv2code.ecommerce.rest;

import com.luv2code.ecommerce.dao.ProductCategoryRepository;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product-category")
@CrossOrigin("*")
public class ProductCategoryController {


    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @GetMapping("/all-categories")
    public ResponseEntity <List<ProductCategory>> getCategorys(){
        return new ResponseEntity<>(productCategoryRepository.findAll(), HttpStatus.OK);
    }}



