package com.appfood.hung.controller.admin;
import com.appfood.hung.model.Category;
import com.appfood.hung.model.Role;
import com.appfood.hung.model.User;
import com.appfood.hung.payload.dto.ProductDto;
import com.appfood.hung.payload.dto.UserDto;
import com.appfood.hung.payload.request.UserRegistrationReq;
import com.appfood.hung.service.RoleService;
import com.appfood.hung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin/registration")
public class CreateAdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto serDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "admin/registration";
    }

    @PostMapping
    public String registerAdminAccount(@ModelAttribute("user") UserDto userDto, Model model,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "admin/registration";
        }

        List<Role> list = roleService.findAll();
        model.addAttribute("roles", list);
        model.addAttribute("user",userDto);
        userService.save(userDto);
        return "redirect:/admin/registration?success";
    }

    /*@PostMapping("addP")
    public String saveProduct(@ModelAttribute("productDto") ProductDto p, Model model)
    {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        model.addAttribute("productDto",p);
        productService.saveProductToDB(p);
        return "redirect:/admin/product/new";
    }*/

}

