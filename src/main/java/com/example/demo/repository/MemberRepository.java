package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, String> {
    public Page<Member> findAll(Pageable page);

    //limit : 몇개, offset : 몇페이지서부터
    @Query("select m from Member m where m.age>=:age order by m.age desc limit :a offset :b")
    public List<Member> findList(@Param("age") int age, @Param("a") int a, @Param("b") int b);

    // DML 작업할때는 반드시 어노테이션을 설정해야 함
    @Modifying
    @Query("update Member m set m.age=m.age+10 where m.id=:id")
    public int update(@Param("id") String id);

    @Query("select m.id from Member m where m.pwd=:pwd and m.email=:email")
    public String find(@Param("pwd") String pwd, @Param("email") String email);



}
