package com.cotivitiapp.productAPI.service;

import com.cotivitiapp.productAPI.model.Category;
import com.cotivitiapp.productAPI.model.Product;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(Long categoryId);
    void deleteCategory(Long categoryId);
//    List<Product> getProduct

}
