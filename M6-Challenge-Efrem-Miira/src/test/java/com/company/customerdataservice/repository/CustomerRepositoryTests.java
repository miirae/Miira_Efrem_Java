package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepo;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("jsmith@gmail.com");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("123 Rodeo Dr");
        customer.setAddress2("District");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("23875");
        customer.setCountry("USA");


        customer = customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("jsmith@gmail.com");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("123 Rodeo Dr");
        customer.setAddress2("District");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("23875");
        customer.setCountry("USA");

        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("jsmith@gmail.com");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("123 Rodeo Dr");
        customer.setAddress2("District");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("23875");
        customer.setCountry("USA");

        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("jsmith@gmail.com");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("123 Rodeo Dr");
        customer.setAddress2("District");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("23875");
        customer.setCountry("USA");
        //Assert...
        Optional<Customer> foundCustomer = customerRepo.findById(customer.getId());

        assertEquals(foundCustomer.get(), customer);
    }

    @Test
    public void shouldGetCustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("jsmith@gmail.com");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("123 Rodeo Dr");
        customer.setAddress2("District");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostalCode("23875");
        customer.setCountry("USA");

        customer = customerRepo.save(customer);

        //Assert...
        List<Customer> cList = customerRepo.findByState("California");

        assertEquals(cList.size(), 1);
    }
}
