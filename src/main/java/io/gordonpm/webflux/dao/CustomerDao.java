package io.gordonpm.webflux.dao;

import io.gordonpm.webflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
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

    public Flux<Customer> getCustomerStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count: " + i))
                .map(c -> new Customer(c, "Customer" + c));
    }

    public Flux<Customer> getCustomerList() {
        return Flux.range(1,50)
                .doOnNext(i -> System.out.println("Processing count: " + i))
                .map(c -> new Customer(c, "Customer" + c));
    }
}
