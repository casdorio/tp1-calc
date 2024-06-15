package com.infnet.tp1_calc.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MathController {
    
    @GetMapping("/addition")
    public double addition(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    @PostMapping("/addition")
    public double addition(@RequestBody Map<String, Double> requestParams) {
        return requestParams.get("num1") + requestParams.get("num2");
    }

    @GetMapping("/subtraction")
    public double subtraction(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    @PostMapping("/subtraction")
    public double subtraction(@RequestBody Map<String, Double> requestParams) {
        return requestParams.get("num1") - requestParams.get("num2");
    }

    @GetMapping("/multiplication")
    public double multiplication(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    @PostMapping("/multiplication")
    public double multiplication(@RequestBody Map<String, Double> requestParams) {
        return requestParams.get("num1") * requestParams.get("num2");
    }

    @GetMapping("/division")
    public double division(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    @PostMapping("/division")
    public double division(@RequestBody Map<String, Double> requestParams) {
        if (requestParams.get("num2") == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return requestParams.get("num1") / requestParams.get("num2");
    }

    @GetMapping("/exponentiation")
    public double exponentiation(@RequestParam double base, @RequestParam double exponent) {
        return Math.pow(base, exponent);
    }

    @PostMapping("/exponentiation")
    public double exponentiation(@RequestBody Map<String, Double> requestParams) {
        return Math.pow(requestParams.get("base"), requestParams.get("exponent"));
    }
}
