package com.example.crm.controller;

import com.example.crm.model.Category;
import com.example.crm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String getAll(Model model){
        List<Category> categories = categoryService.getAll();

        model.addAttribute("categories",categories);

        return "categorylist";
    }

    @RequestMapping("/addCategory")
    public ModelAndView createCategory(){

        Category category = new Category();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", category);
        modelAndView.setViewName("addCategory");

        return modelAndView;
    }

    @PostMapping("/addCategory")
    public ModelAndView createCategory(@Valid @ModelAttribute("category")Category category, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("addCategory");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/category/");

        categoryService.save(category);

        return modelAndView;
    }

    @RequestMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){

        categoryService.deleteById(id);

        return "redirect:/category/";
    }


}
