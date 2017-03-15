package com.hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.hw.model.User;

import javax.validation.Valid;

@Controller
public class HomeController {

    /*@GetMapping("/home")
    public String home(@RequestParam(value="username", required=false, defaultValue="World") String username, Model model) {
        model.addAttribute("username", username);
        return "home";
    }*/

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("userModel", new User());
        return "home";
    }

    /*@PostMapping("/home")
    public String login(@ModelAttribute User userModel, Model model) {
        model.addAttribute("userModel", userModel);
        return "home";
    }*/

    @PostMapping("/home")
    public String login(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        model.addAttribute("userModel", userModel);
        return "home";
    }
}
