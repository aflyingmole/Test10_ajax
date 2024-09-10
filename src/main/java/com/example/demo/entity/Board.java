package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(of={"num", "title", "content", "regdate"})
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Member member;
    private String title;
    @Lob
    private String content;
    @CreationTimestamp
    private LocalDateTime regdate;
}
