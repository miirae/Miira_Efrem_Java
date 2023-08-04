package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    Customer customer = new Customer();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerController customerController;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnCustomerById() throws Exception {
        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/1")).andExpect(status().isOk()).andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnCustomerByState() throws Exception{
        mockMvc.perform(get("/customers/California")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNewCustomerOnValidPostRequest() throws Exception {

        String inputJson = mapper.writeValueAsString(customer);
        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        post("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/customers/1")).andExpect(status().isNoContent());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        String inputJson = mapper.writeValueAsString(customer);
        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers").content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}
