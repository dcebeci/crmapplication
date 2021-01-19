package com.example.crm.service;

import com.example.crm.model.Product;
import com.example.crm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.getOne(id);
    }

    public void save(Product product){

        product.setCreatedDate(new Date());

        product.setIsCompleted(0);


        productRepository.save(product);
    }

    public void updateWork(Product product){

        product.setIsCompleted(1);
        product.setCompletedDate(new Date());
        productRepository.save(product);

    }

    public void deleteById(Long id){

        Product work = productRepository.getOne(id);

//        work.setUser(null);

        productRepository.deleteById(id);
    }

}
