package com.serhat.productCrm.service;

import com.serhat.productCrm.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
    void updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductList();
}