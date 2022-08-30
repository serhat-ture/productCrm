package com.serhat.productCrm.controller;

import com.serhat.productCrm.model.dto.ProductDTO;
import com.serhat.productCrm.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO) {
        this.productService.addProduct(productDTO);
        return new ResponseEntity
                ("Başarılı", HttpStatus.CREATED);
    }
/*
    {
            "name":"Iphone",
              "price":200
    }

    {
            "name":"laptop",
              "price":500
    }
    */

    @PutMapping("/update")
    public ResponseEntity updateProduct
            (@RequestBody ProductDTO productDTO) {
        this.productService.updateProduct(productDTO);
        return new ResponseEntity("Başarılı Kayıt",
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProduct(@RequestParam(name = "id")
                                                Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Silindi");
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getListProduct() {
        return ResponseEntity.ok(
                this.productService.getProductList());
    }

}