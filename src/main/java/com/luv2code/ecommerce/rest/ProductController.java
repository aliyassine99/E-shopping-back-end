package com.luv2code.ecommerce.rest;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam int page,@RequestParam int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return new ResponseEntity<> (productPage, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Product>> getProductByCategory(@RequestParam int page,@RequestParam int size,@PathVariable("id") Long id ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findByCategoryId(pageable,id);
        return new ResponseEntity<>( productPage, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam("name") String name ){
        return new ResponseEntity<>( productRepository.findByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productRepository.findById(id).get(), HttpStatus.OK);
    }



}
