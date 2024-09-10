package com.example.demo.controller;

import com.example.demo.dto.MyUser;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class SampleRestController {
    @GetMapping("/info")
    public ResponseEntity<MyUser> userinfo() {
        MyUser user = new MyUser("hello", "1234", "hello@");
        // ResponseEntity에 응답할 데이터와 응답코드(성공) 담기
        ResponseEntity<MyUser> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/info1/{id}/{pwd}")
    public ResponseEntity<MyUser> userinfo1(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
        MyUser user = null;
        if (id != null && pwd != null && id.equals("hello") && pwd.equals("1234")) {
            user = new MyUser("hello", "1234", "hello@");
        } else {
            user = new MyUser("none", "none", "none");
        }

        ResponseEntity<MyUser> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<MyUser>> getList() {
        MyUser m1 = new MyUser("hello", "1234", "hello@");
        MyUser m2 = new MyUser("hello2", "1234", "hello2@");
        MyUser m3 = new MyUser("hello3", "1234", "hello3@");
        List<MyUser> list = new ArrayList<MyUser>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        ResponseEntity<List<MyUser>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        return responseEntity;
    }
}

