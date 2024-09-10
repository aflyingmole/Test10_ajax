package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository mr;

    public MemberDto join(MemberDto dto) {
        Member member = dto.toEntity();
        Member m = mr.save(member);
        return new MemberDto(m);
    }

    public List<MemberDto> list() {
        List<Member> mList = mr.findAll();
        List<MemberDto> list1 = mList.stream().map(m -> new MemberDto(m)).toList();
        return list1;
    }

    public void delete(String id) {
        mr.deleteById(id);
    }

    public MemberDto select(String id) {
        Optional<Member> list = mr.findById(id);
        return new MemberDto(list.get());
    }

    public MemberDto update(MemberDto dto) {
        Optional<Member> byId = mr.findById(dto.getId());
        Member m = byId.get();
        m.setPwd(dto.getPwd());
        m.setAge(dto.getAge());
        m.setEmail(dto.getEmail());
        return new MemberDto(m);
    }

    public String find(String pwd, String email) {
        String id = mr.find(pwd, email);
        return id;
    }
}

