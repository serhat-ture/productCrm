package com.serhat.productCrm.controller;

import com.serhat.productCrm.model.dto.CustomerDTO;
import com.serhat.productCrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customerDTO) {
        this.customerService.addCustomer(customerDTO);
        return new ResponseEntity
                ("Başarılı", HttpStatus.CREATED);
    }

    /*
        [
    {
    "name":"Can",
    "surname":"Kemal",
    "age":40
    },{
    "name":"Oya",
    "surname":"Kalem",
    "age":34
},{
    "name":"Murat",
    "surname":"Yol",
    "age":26
},{
    "name":"Ahmet",
    "surname":"Mutlu",
    "age":46
}
]
     */
    @PostMapping("addList")
    public ResponseEntity addListCustomer(@RequestBody List<CustomerDTO> customerDTOList) {
        this.customerService.addListCustomer(customerDTOList);
        return new ResponseEntity
                ("Başarılı", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>
                ("Başarılı", HttpStatus.OK);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCustomer(@RequestBody CustomerDTO customerDTO) {
        this.customerService.updateCustomer(customerDTO);
    }

    @GetMapping("findById")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam(value = "id")
                                                               Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("allCount")
    public ResponseEntity<Long> getAllCountInCustomer() {
        return new ResponseEntity<>
                (customerService.getAllCountInCustomer(), HttpStatus.OK);
    }
    //we use NamedQuery -- 4

    @GetMapping("/getByName")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getCustomerByName
            (@RequestParam(name = "name") String name) {
        return this.customerService.getCustomerByName(name);
    }
    //name- Ahmet

    @GetMapping("/getByNameOrSurname")
    public List<CustomerDTO> getCustomerByNameOrSurname(
            @RequestParam(name = "name") String name,   // Ahmet
            @RequestParam(name = "surname") String surname //Yol
    ) {
        return this.customerService.getNameOrSurnameForCustomer(name, surname);
    }

   /* [
    {
        "id": 4,
            "name": "Ahmet",
            "surname": "Mutlu",
            "age": 46
    },
    {
        "id": 3,
            "name": "Murat",
            "surname": "Yol",
            "age": 26
    }
]*/


    @GetMapping("/greaterThan40")
    public List<CustomerDTO> getCustomerGreaterThan40() {
        return this.customerService.getGreaterThan40();
    }
    //Ahmet

    @GetMapping("/ageAndNameIC")
    public List<CustomerDTO> getByAgeLessThanEqualAndNameIgnoreCase() {
        return this.customerService.getByAgeLessThanEqualAndNameIgnoreCase();
    }
//Can



}