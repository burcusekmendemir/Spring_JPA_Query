package com.burcu.SpringDemo.controller;

import com.burcu.SpringDemo.entity.Product;
import com.burcu.SpringDemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/save")
    public Product save(Product product){
        return productService.save(product);
    }
    @GetMapping("/find-all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id){
        return productService.findById(id);
    }

    @GetMapping("/update") //PutMapping ile yapmaya calisirsam, PUT request yollarsam 405(Forbidden) dönecektir.
    public Product update(Product product){
        return productService.update(product);
    }

    @GetMapping("/find-by-product-name")
    public Optional<Product> findByProductName(String productName){
        return productService.findByProductName(productName);
    }
    @GetMapping("/find-by-product-name-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productService.findByProductNameIgnoreCase(productName);
    }
    @GetMapping("/find-all-by-product-name-like-ignore-case") //-> Bunun yerine containing kullanmak gerekiyor.
    public  List<Product> findAllByProductNameLikeIgnoreCase(String productName){
        return productService.findAllByProductNameLikeIgnoreCase(productName);
    }

    @GetMapping("/find-all-by-product-name-containing-ignore-case") //http://localhost:8080/product/find-all-by-product-name-containing-ignore-case?name=Be
    public List<Product> findAllByProductNameContainingIgnoreCase(String name){
        return productService.findAllByProductNameContainingIgnoreCase(name);
    }

    @GetMapping("/find-all-by-product-price-between")
    public List<Product> findAllByProductPriceBetween(Double start, Double end){
        return productService.findAllByProductPriceBetween(start,end);
    }
    @GetMapping("/find-all-by-product-price-greater-than")
    public List<Product> findAllByProductPriceGreaterThan(Double price){
        return productService.findAllByProductPriceGreaterThan(price);
    }

    @GetMapping("/find-all-by-product-price-greater-than-equal")
    public List<Product> findAllByProductPriceGreaterThanEqual(Double price){
        return productService.findAllByProductPriceGreaterThanEqual(price);
    }

    @GetMapping("/category-count")
    public Integer categoryCount(){
        return productService.categoryCount();
    }

    @GetMapping("/product-count")
    public Integer productCount(){
        return productService.productCount();
    }
    @GetMapping("/find-all-by-is-product-category-available-true")
    public List<Product> findAllByIsProductCategoryAvailableTrue(String productCategory){
        return productService.findAllByIsProductCategoryAvailableTrue(productCategory);
    }

    @GetMapping("/find-all-by-product-category-is-null")
    public List<Product> findAllByProductCategoryIsNull(){
        return productService.findAllByProductCategoryIsNull();
    }

    @GetMapping("/find-all-by-product-name-starting-with")
    public List<Product> findAllByProductNameStartingWith(String productName){
        return productService.findAllByProductNameStartingWith(productName);
    }
}
