package com.serhat.productCrm.serviceImp;

import com.serhat.productCrm.model.dto.CustomerDTO;
import com.serhat.productCrm.model.entity.Customer;
import com.serhat.productCrm.repository.CustomerRepository;
import com.serhat.productCrm.service.CustomerService;
import com.serhat.productCrm.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapperUtil modelMapperUtil;


    @Override
    @Transactional
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer =
                modelMapperUtil.convertToModel(customerDTO, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


    @Override
    @Transactional
    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setId(customerDTO.getId());
        customerRepository.save(customer);
    }




    @Override
    @Transactional(readOnly = true)
    public long getAllCountInCustomer() {

        return this.customerRepository.countCustomer();
    }



    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomerByName(String name) {
        return modelMapperUtil.mapAll(
                this.customerRepository.findByName(name), CustomerDTO.class);
    }



    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getGreaterThan40() {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.findByAgeGreaterThan(40),
                CustomerDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase() {
        return this.modelMapperUtil.mapAll(this.customerRepository
                        .findByAgeLessThanEqualAndNameIgnoreCase(40, "can"),
                CustomerDTO.class);
    }



    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getNameOrSurnameForCustomer(String name, String surname) {
        return this.modelMapperUtil.mapAll(
                this.customerRepository.customByNameOrSurname(name, surname),
                CustomerDTO.class);
    }


}