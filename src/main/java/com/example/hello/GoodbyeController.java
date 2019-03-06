package com.example.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodbyeController {

    private static final String template = "Goodbye %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/goodbye")
    public Goodbye goodbye(@RequestParam(value="name", defaultValue="World") String name) {
        return new Goodbye(counter.incrementAndGet(),
                            String.format(template, name));
    }
}