package com.cotivitiapp.productAPI.repository;

import com.cotivitiapp.productAPI.model.Category;
import com.cotivitiapp.productAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
