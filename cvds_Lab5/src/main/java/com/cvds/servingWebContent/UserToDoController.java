package com.cvds.servingWebContent;

import com.cvds.servingWebContent.UserToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserToDoController {

    @RequestMapping("/todo/{id}")
    private ModelAndView getUser(@PathVariable Integer id, Model model) {
        String uri = "https://jsonplaceholder.typicode.com/todos/"+ id;
        RestTemplate restTemplate = new RestTemplate();

        UserToDo user = restTemplate.getForObject(uri, UserToDo.class);
        int userId = user.getUserId();
        String title = user.getTitle();
        boolean state = user.isState();

        ModelAndView modelAndView = new ModelAndView("todo");
        modelAndView.addObject("user", user);
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("title", title);
        modelAndView.addObject("state", state);

        return modelAndView;
    }
}
