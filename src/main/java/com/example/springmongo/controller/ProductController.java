package com.example.springmongo.controller;

import com.example.springmongo.model.Product;
import com.example.springmongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping(value = "/product/", consumes = {"application/json"}, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity addProduct(@RequestBody Product product, UriComponentsBuilder builder)  {
        repository.insert(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Product>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/product/{title}")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@PathVariable String title) {
        Product product = repository.findByTitle(title);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
