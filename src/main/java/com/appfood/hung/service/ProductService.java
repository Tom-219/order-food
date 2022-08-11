package com.appfood.hung.service;


import com.appfood.hung.model.Product;
import com.appfood.hung.payload.dto.ProductDto;
import com.appfood.hung.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class
ProductService {
    @Autowired
    private ProductRepository productRepo;

    public void  saveProductToDB(ProductDto p){
        productRepo.save(p.converToEntity());
    }
    public List<Product> getAllProduct()
    {
        return productRepo.findAll();
    }
    public void deleteProductById(Long id)
    {
        productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setName(name);
        productRepo.save(p);
    }
    public void changeProductDescription(Long id , String description)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setDescription(description);
        productRepo.save(p);
    }
    public void changeProductPrice(Long id,int price)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setPrice(price);
        productRepo.save(p);
    }
}
