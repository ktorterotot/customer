package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

//    private List<Customer> customers = new ArrayList<>(Arrays.asList(
//            new Customer("Kimberly", 22),
//            new Customer("Amara", 2)
//    ));

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer>customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(Long id){

        return customerRepository.findOne(id);
    }

    public void addCustomer(Customer customer){
       customerRepository.save(customer);
    }

    public void updateCustomer(Long id, Customer customer) {
       customerRepository.save(customer);

    }

        public void deleteCustomer(Long id){

        customerRepository.delete(id);

        }
    }



