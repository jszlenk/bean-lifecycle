package com.kodilla.lifecycle.controller;


import com.kodilla.lifecycle.event.OperationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        double result = a + b;
        publisher.publishEvent(new OperationEvent(this, "addition", a, b, result));
        return result;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        double result = a - b;
        publisher.publishEvent(new OperationEvent(this, "subtraction", a, b, result));
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        double result = a * b;
        publisher.publishEvent(new OperationEvent(this, "multiplication", a, b, result));
        return result;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        double result = a / b;
        publisher.publishEvent(new OperationEvent(this, "division", a, b, result));
        return result;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}