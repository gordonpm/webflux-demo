package com.cycleman.webflux.dao;

import com.cycleman.webflux.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1,20)
                .peek(CustomerDao::sleepExecution)
                .peek(i -> System.out.println("Processing count: " + i))
                .mapToObj(c -> new Customer(c, "Customer" + c))
                .collect(Collectors.toList());


    }
}
