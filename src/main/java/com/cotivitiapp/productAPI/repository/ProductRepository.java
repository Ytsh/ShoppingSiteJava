package com.cotivitiapp.productAPI.repository;

import com.cotivitiapp.productAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByCategoryId(Long id);

//    @Query()
//    function()

}
