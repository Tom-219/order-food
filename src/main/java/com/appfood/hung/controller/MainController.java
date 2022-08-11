package com.appfood.hung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    @GetMapping("/index1")
    public String home(){return "index1";}



    @GetMapping("/about")
    public String AboutPage() {
        return "redirect:/about";
    }

    @GetMapping("/contact")
    public String Contact() {
        return "redirect:/contact";
    }

    @GetMapping("/gallery")
    public String Gallery() {
        return "redirect:/gallery";
    }

    @GetMapping("/menu")
    public String MenuPage() {
        return "redirect:/menu";
    }

    @GetMapping("/reservation")
    public String ReservationPage() {
        return "redirect:/reservation";
    }



}
