package com.serhat.productCrm.serviceImp;

import com.serhat.productCrm.model.dto.ProductDTO;
import com.serhat.productCrm.model.entity.Product;
import com.serhat.productCrm.repository.ProductRepository;
import com.serhat.productCrm.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setId(productDTO.getId());
        productRepository.save(product);
    }

    @Override
   // @Transactional(readOnly = true)
    public List<ProductDTO> getProductList() {
        List<ProductDTO>productDTOs = new ArrayList<>();
        Iterator<Product> productIterator =
                productRepository.findAll().iterator();
        while(productIterator.hasNext()){
            ProductDTO productDTO = new ProductDTO();
            Product product = productIterator.next();
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
}