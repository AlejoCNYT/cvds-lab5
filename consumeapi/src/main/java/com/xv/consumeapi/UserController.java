package com.xv.consumeapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
 
    @RequestMapping("/hello")
    private String hello() {
        return "hello";
    }
    
    @RequestMapping("/user/{id}")
    private ModelAndView getUser(@PathVariable Integer id, Model model)   {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();
    
        User user = restTemplate.getForObject(uri, User.class);
        Address address = user.getAddress();
        Geo geo = address.getGeo();
        Company company = user.getCompany();
        
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", user);
        modelAndView.addObject("address", address);
        modelAndView.addObject("geo", geo);
        modelAndView.addObject("company", company);
        
        return modelAndView;
    }
    
}