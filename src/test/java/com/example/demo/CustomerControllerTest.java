package com.example.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;

import java.util.List;
import java.util.*;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;//This instantiates the MockMvc as an object in the class.


    @InjectMocks //Creates instance of the class and injects the mocks that are created with the @mock annotations into this instance
    private CustomerController customerController;

    @Mock //This will be injected into CustomerController
    private CustomerService customerService;

    @Before///Indicates that the attached method will be run before any test in the class
    public void setup(){
        mockMvc =
                MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test//Indicates the attached method is a unit test
    public void getAllCustomers() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        }catch(Exception e){
            e.printStackTrace();
        }
        Mockito.verify(customerService).getAllCustomers();

    }

    @Test//Indicates the attached method is a unit test
    public void getCustomer() throws Exception{
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Ashley", 22, "123 CandyCane lane", "Female", "09-28-1995", 20092L ),
                new Customer(1L, "Marie", 23, "444 CandyCane Lane", "Female" , "12-07-1995", 2345L)
        );

        Mockito.when(customerService.getCustomer(1L)).thenReturn(customers.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(customerService).getCustomer(1L);
    }
}
