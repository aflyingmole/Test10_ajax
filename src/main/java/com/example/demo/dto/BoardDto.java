package com.example.demo.dto;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDto {
    private Long num;
    private String title;
    private String id;
    private String content;
    private LocalDateTime regdate;


    public BoardDto(Board board) {
        this.num = board.getNum();
        this.title = board.getTitle();
        this.id = board.getMember().getId();
        this.content = board.getContent();
        this.regdate = board.getRegdate();
    }
    //Board 객체를 Builder 패턴으로 생성하여 반환하는 메서드
    public Board toEntity(Member member) {
        return Board.builder()
                .num(this.num)
                .title(this.title)
                .member(member)
                .content(this.content)
                .regdate(this.regdate)
                .build();
    }
}
