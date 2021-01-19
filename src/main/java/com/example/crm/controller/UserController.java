package com.example.crm.controller;

import com.example.crm.model.User;
import com.example.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping("/customers")
    public String customerList(Model model){
        List<User> customer = userService.listAllCustomer();
        model.addAttribute("customer", customer);

        return "customerlist";
    }

    @RequestMapping("/products/{id}")
    public String   customerList(@PathVariable Long id,Model model){

        User user = userService.getById(id);
        model.addAttribute("user", user);

        return "customerProducts";
    }


    @RequestMapping("/addCustomer")
    public ModelAndView addCustomer() {

        User user = new User();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);

        modelAndView.setViewName("addCustomer");

        return modelAndView;
    }

    @PostMapping( "/addCustomer")
    public ModelAndView addCustomer(@Valid @ModelAttribute("user")User user,BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){

            modelAndView.setViewName("addCustomer");

            return modelAndView;
        }

        modelAndView.setViewName("redirect:/");

        userService.save(user);

        return modelAndView;
    }


    @RequestMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable Long id, Model model) {

        User user = userService.getById(id);

        model.addAttribute("user", user);


        return "updateCustomer";
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable Long id,User user) {

        userService.update(id,user);

        return "redirect:/user/customers";
    }



    @RequestMapping("/deleteCustomer/{id}")
    public String assignproduct(@PathVariable Long id){

         userService.deleteById(id);

        return "redirect:/user/customers";
    }


}
