package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindIdController {
    @Autowired
    private MemberService service;
    @PostMapping("/find")
    public ResponseEntity<String> findId(@RequestParam("pwd") String pwd, @RequestParam("email") String email) {
        String id = service.find(pwd, email);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

