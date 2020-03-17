package com.nbcb.demo.service;

import com.nbcb.demo.domain.entity.Hello;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public Hello hello(String name, String title) {
        //call feign client
        //using mapper to map response to domain object
        Hello hello = new Hello();
        hello.setCustomerName(name);

        String greetingName = title != null ? (title + " " + name) : name;
        hello.setMessage("Hi " + greetingName + ", Hello There Too!");
        return hello;
    }
}
