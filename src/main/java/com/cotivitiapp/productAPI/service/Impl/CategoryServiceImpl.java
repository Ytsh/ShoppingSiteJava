package com.cotivitiapp.productAPI.service.Impl;

import com.cotivitiapp.productAPI.exception.ResourceNotFoundException;
import com.cotivitiapp.productAPI.model.Category;
import com.cotivitiapp.productAPI.repository.CategoryRepository;
import com.cotivitiapp.productAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
         Category existingCategory = this.categoryRepository.findById(category.getId()).orElseThrow(()
                -> new ResourceNotFoundException("Category not found"));
         existingCategory.setName(category.getName());
         existingCategory.setDescription(category.getDescription());
         categoryRepository.save(existingCategory);
         return existingCategory;
//        existingCategory = entityManager.find();
    }

    @Override
    public List<Category> getAllCategory() {
//        System.out.println(categoryRepository.);
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category existingCategory = this.categoryRepository.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category not found"));
        categoryRepository.delete(existingCategory);
    }
}
