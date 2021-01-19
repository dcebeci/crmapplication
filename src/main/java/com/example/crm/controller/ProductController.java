package com.example.crm.controller;

import com.example.crm.model.User;
import com.example.crm.model.Product;
import com.example.crm.service.CategoryService;
import com.example.crm.service.UserService;
import com.example.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @RequestMapping("/products")
    public String product(Model model){

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "product";
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(){

        Product product = new Product();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.addObject("category", categoryService.getAll());
        modelAndView.addObject("users",userService.listAllCustomer());
        modelAndView.setViewName("addProduct");

        return modelAndView;
    }

    @PostMapping("/addProduct")
    public ModelAndView addProduct(@Valid @ModelAttribute("work") Product product, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){
            modelAndView.addObject("users",userService.listAllCustomer());
            modelAndView.setViewName("addProduct");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/product/products");

        productService.save(product);

        return modelAndView;
    }

    @RequestMapping("/assignProduct/{id}")
    public String assignProduct(@PathVariable Long id,Model model){

        Product product = productService.getById(id);
        List<User> customers = userService.listAllCustomer();
        model.addAttribute("customers", customers);
        model.addAttribute("product",product);

        return "assignProduct";
    }

    @RequestMapping("/assignProduct/{workId}/{userId}")
    public String assignProduct(@PathVariable Long workId,@PathVariable Long userId){

        User employee = userService.getById(userId);

        Product work = productService.getById(workId);

        work.setUser(employee);

        productService.save(work);

        return "redirect:/product/products";
    }



    @RequestMapping("/deleteProduct/{id}")
    public String deletProduct(@PathVariable Long id){

        productService.deleteById(id);

        return "redirect:/product/products";
    }

}
