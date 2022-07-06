package com.sparta.project.controller;

import com.sparta.project.models.Borard;
import com.sparta.project.models.BorardRepository;
import com.sparta.project.models.BorardRequestDto;
import com.sparta.project.service.BorardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BorardController {
    public final BorardService borardService;
    public final BorardRepository borardRepository;

    //생성
    @PostMapping("/api/borards")
    public Borard createBorard(@RequestBody BorardRequestDto requestDto) {
        Borard borard = new Borard(requestDto);
        return borardRepository.save(borard);
    }

    //조회
    @GetMapping("/api/borards")
    public List<Borard> readborard() {
        return borardRepository.findAllByOrderByModifiedAtDesc();
    }

    //수정
    @PutMapping("/api/borards/{id}")
    public Long updateBorard(@PathVariable Long id, @RequestBody BorardRequestDto requestDto) {
        return borardService.update(id, requestDto);
    }

    //삭제
    @DeleteMapping("/api/borards/{id}")
    public Long deleteBorard(@PathVariable Long id, @RequestBody BorardRequestDto requestDto) {
        Borard borard = borardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하고 있지 않습니다.")
        );

        if (!borard.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }
        borardRepository.deleteById(id);
        return id;
    }
}
