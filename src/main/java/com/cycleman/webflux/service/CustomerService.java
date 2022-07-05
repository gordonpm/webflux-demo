package com.cycleman.webflux.service;

import com.cycleman.webflux.dao.CustomerDao;
import com.cycleman.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end - start));
        return customers;
    }
}
