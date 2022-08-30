package com.serhat.productCrm.repository;

import com.serhat.productCrm.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Long> {
    List<Customer> findByName(String name);

    List<Customer> findByAgeGreaterThan(Integer age);


    List<Customer> findByAgeLessThanEqualAndNameIgnoreCase(Integer age,String name);


    @Query(value = "Select c.name from Customer c order by c.name")
    List<Customer> customFindAll();

    @Query(value = "Select c from Customer c" +
            " where c.name=:name or c.surname=:surname order by c.name")
    List<Customer> customByNameOrSurname
            (@Param("name") String name, @Param("surname") String surname);
}