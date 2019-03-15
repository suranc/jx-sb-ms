package com.example.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Data: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/data")
    public Greeting greeting(@RequestParam(value="data", defaultValue="nil") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}