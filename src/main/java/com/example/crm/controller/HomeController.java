package com.example.crm.controller;

import com.example.crm.model.User;
import com.example.crm.model.Product;
import com.example.crm.service.UserService;
import com.example.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String getAll(Model model,Principal principal){

        User user = userService.getUserByEmail(principal.getName());

        model.addAttribute("user",user);

        return "home";
    }

    @RequestMapping("/assignedproducts")
    public String employeeWorks(Model model, Principal principal){

        User user = userService.getUserByEmail(principal.getName());

        List<Product> products= user.getWorks().stream().filter(work -> work.getIsCompleted() == 0).collect(Collectors.toList());

        model.addAttribute("products",products);

        return "assignedproducts";
    }


    @RequestMapping("updateProduct/{id}")
    public String updateWork(@PathVariable Long id){

        productService.updateWork(productService.getById(id));

        return "redirect:/assignedproducts";
    }

    @RequestMapping("/completedProducts")
    public String completedWorks(Model model, Principal principal){

        User user = userService.getUserByEmail(principal.getName());

        List<Product> works = user.getWorks().stream().filter(work -> work.getIsCompleted() == 1).collect(Collectors.toList());

        model.addAttribute("products",works);


        return "completedproducts";
    }


}
