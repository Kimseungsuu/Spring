package com.sparta.project.service;

import com.sparta.project.models.Borard;
import com.sparta.project.models.BorardRepository;
import com.sparta.project.models.BorardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BorardService {
    private final BorardRepository borardRepository;

    @Transactional
    public Long update(Long id, BorardRequestDto requestDto) {
        Borard borard = borardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        // 비밀번호 일치시에만 게시물 수정가능
        if (!borard.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("일치하지 않습니다.");
        }

        borard.update(requestDto);

        return id;
    }
}
