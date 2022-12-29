package com.cotivitiapp.productAPI.service.Impl;

import com.cotivitiapp.productAPI.exception.ResourceNotFoundException;
import com.cotivitiapp.productAPI.model.Product;
import com.cotivitiapp.productAPI.repository.ProductRepository;
import com.cotivitiapp.productAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    Product p = new Product();

    public ProductServiceImpl() {
        p.setName("Name");
        p.setDescription("DESC");
        p.setPrice(BigDecimal.valueOf(2332.2));
    }



    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getId());
        if(productDb.isPresent()){
            Product productUpdate = productDb.get();

            productUpdate.setDescription(product.getDescription());
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setCategory(product.getCategory());

            productRepository.save(productUpdate);
            return productUpdate;
        }
        else{
            throw new ResourceNotFoundException("Product was not found for id :"+ product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
//        this.productRepository.save(p);
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);
        if(productDb.isPresent()){
            return productDb.get();
        }
        else{
            throw new ResourceNotFoundException("Product was not found for id :"+productId);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }
        else{
            throw new ResourceNotFoundException("Product was not found for id :"+productId);
        }

    }

    @Override
    public List<Product> findProductByCategoryId(Long categoryId) {
        return this.productRepository.findProductByCategoryId(categoryId);
    }

//    @Override
//    public List<Product> getProductByCategoryId(Long categoryId) {
////        List<Product> products =
////    }
}
