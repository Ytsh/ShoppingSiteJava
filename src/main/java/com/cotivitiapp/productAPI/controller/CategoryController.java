package com.cotivitiapp.productAPI.controller;


import com.cotivitiapp.productAPI.model.Category;
import com.cotivitiapp.productAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }
    @PostMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        this.categoryService.createCategory(category);
        return ResponseEntity.ok().body(categoryService.createCategory(category));
    }
    @PutMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        this.categoryService.createCategory(category);
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }
    @DeleteMapping("/category/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HttpStatus deleteCategory(@PathVariable long id){
        this.categoryService.deleteCategory(id);
        return HttpStatus.OK;
    }
}
