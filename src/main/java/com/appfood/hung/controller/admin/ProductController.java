package com.appfood.hung.controller.admin;

import com.appfood.hung.model.Category;
import com.appfood.hung.model.Product;
import com.appfood.hung.payload.dto.ProductDto;
import com.appfood.hung.service.CategoryService;
import com.appfood.hung.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin/product/")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("listProducts")
    public String showExampleView(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "/admin/product/listProducts";
    }
    @GetMapping("create")
    public String create(Model model) throws Exception{
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product/addProduct.html";
    }
    @GetMapping("new")
    public String createProductForm(Model model) {
        // create student object to hold student form data
        ProductDto p = new ProductDto();
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("productDto", p);
        return "backend/product/create.html";

    }
    @PostMapping("addP")
    public String saveProduct(@ModelAttribute("productDto") ProductDto p, Model model)
    {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        model.addAttribute("productDto",p);
        productService.saveProductToDB(p);
        return "redirect:/product/new";
    }

    @GetMapping("deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {

        productService.deleteProductById(id);
        return "redirect:/listProducts.html";
    }

    @PostMapping("changeName")
    public String changePname(@RequestParam("id") Long id,
                              @RequestParam("newPname") String name)
    {
        productService.chageProductName(id, name);
        return "redirect:/listProducts.html";
    }
    @PostMapping("changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        productService.changeProductDescription(id, description);
        return "redirect:/listProducts.html";
    }

    @PostMapping("changePrice")
    public String changePrice(@RequestParam("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        productService.changeProductPrice(id, price);
        return "redirect:/listProducts.html";
    }
}


