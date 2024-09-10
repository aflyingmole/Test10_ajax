package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    MemberService service;

    @PostMapping("/member/join")
    public ResponseEntity<String> join(MemberDto dto) {
        String result = "success";
        try {
            service.join(dto);
        } catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/member/list")
    public ResponseEntity<List<MemberDto>> list() {
        List<MemberDto> memberList = service.list();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }
    @DeleteMapping("/member/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") String id) {
        String result = "success";
        try{
            service.delete(id);
        }catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/member/update/{id}")
    public ResponseEntity<MemberDto> updateForm(@PathVariable("id") String id) {
        MemberDto member = service.select(id);
        return new ResponseEntity<>(member, HttpStatus.OK);

    }

    @PostMapping("/member/update")
    public ResponseEntity<String> update(MemberDto dto) {
        String result = "success";
        try {
            service.update(dto);
        }catch (Exception e) {
            result = "fail";
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
