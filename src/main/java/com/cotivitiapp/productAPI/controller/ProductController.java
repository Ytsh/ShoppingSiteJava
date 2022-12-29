package com.cotivitiapp.productAPI.controller;

import com.cotivitiapp.productAPI.model.Product;
import com.cotivitiapp.productAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }
    @GetMapping("/products/{id}")
    @PreAuthorize("hasRole('USER')")

    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    @GetMapping("findProductByCategoryId/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable long id){
        return ResponseEntity.ok().body(productService.findProductByCategoryId(id));
    }
    @PostMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        this.productService.createProduct(product);
        return ResponseEntity.ok().body(productService.createProduct(product));
    }
    @PutMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
//        this.productService.updateProduct(product);
        return ResponseEntity.ok().body(productService.updateProduct(product));
    }
    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.productService.deleteProduct((id));
        return HttpStatus.OK; //ResponseEntity.status(HttpStatus.OK);
    }
}
