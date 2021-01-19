package com.example.crm.service;

import com.example.crm.model.Category;
import com.example.crm.model.Product;
import com.example.crm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public void save(Category department){

        categoryRepository.save(department);
    }

    public void deleteById(Long id){

        Category department = categoryRepository.getOne(id);

        for (Product product : department.getProducts()) {
            product.setCategory(null);
        }

        categoryRepository.deleteById(id);
    }

}
