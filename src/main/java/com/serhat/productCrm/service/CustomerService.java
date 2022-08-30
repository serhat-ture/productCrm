package com.serhat.productCrm.service;

import com.serhat.productCrm.model.dto.CustomerDTO;
import com.serhat.productCrm.model.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);

    ResponseEntity<CustomerDTO> getCustomerById(Long id);

    long getAllCountInCustomer();
    void addListCustomer(List<CustomerDTO> customerDTOList);

    List<CustomerDTO> getCustomerByName(String name);

    List<CustomerDTO> getGreaterThan40();
    List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase();
    List<CustomerDTO> getNameOrSurnameForCustomer
            (String name,String surname);
}