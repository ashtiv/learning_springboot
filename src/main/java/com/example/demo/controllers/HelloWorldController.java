package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private static class NumbersRequest {
        private int num1;
        private int num2;

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    private static class NumbersResponse {
        private int result;

        public NumbersResponse(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {
        String message = "Hello World!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/addbybody")
    public ResponseEntity<NumbersResponse> addNumbers(@RequestBody NumbersRequest request) {
        int num1 = request.getNum1();
        int num2 = request.getNum2();
        int result = num1 + num2;
        NumbersResponse response = new NumbersResponse(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public int addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + num2;
    }
}
