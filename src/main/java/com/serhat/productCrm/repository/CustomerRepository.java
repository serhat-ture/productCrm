package com.serhat.productCrm.repository;

import com.serhat.productCrm.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer,Long> {
    List<Customer> findByName(String name);

    List<Customer> findByAgeGreaterThan(Integer age);


    List<Customer> findByAgeLessThanEqualAndNameIgnoreCase(Integer age,String name);

    Long countCustomer();



    List<Customer> customByNameOrSurname
            (@Param("name") String name, @Param("surname") String surname);
}