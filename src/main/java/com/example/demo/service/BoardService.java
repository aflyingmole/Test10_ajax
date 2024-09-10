package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageResultDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardRepository br;
    @Autowired
    private MemberRepository mr;

    public BoardDto insert(BoardDto dto) {
        Optional<Member> byId = mr.findById(dto.getId());
        Member member = byId.get();
        Board save = br.save(new Board(0L, member, dto.getTitle(), dto.getContent(), null));
        return new BoardDto(save);
    }

    //글목록
    public PageResultDto list(Pageable pageable) {
        Page<Board> page = br.findAll(pageable);

//        Function<Board, BoardDto> f = new Function<Board, BoardDto>(){
//            @Override
//            public BoardDto apply(Board t) {
//                return new BoardDto(t);
//            }
//        };
//        Function<Board, BoardDto> f = (Board t) ->{
//            return new BoardDto(t);
//        };
//        Function<Board,BoardDto> f=b-> new BoardDto(b);
//        page.stream().map(f);

//        List<BoardDto> dtoList = page.stream().map(b->new BoardDto(b)).toList();
        List<BoardDto> dtoList = page.stream().map(BoardDto::new).toList();
        PageResultDto pageDto = new PageResultDto(dtoList, page.getNumber(), page.getTotalPages(), 3);

        return pageDto;
    }
    //num으로 조회
    public BoardDto select(Long num) {
        Optional<Board> byId = br.findById(num);
        return new BoardDto(byId.get());
    }
    //수정
    public BoardDto update(BoardDto dto) {
        Optional<Board> byId = br.findById(dto.getNum());
        Board board = byId.get();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        return new BoardDto(board);
    }


}






