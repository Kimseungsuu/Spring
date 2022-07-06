package com.sparta.project.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorardRepository extends JpaRepository<Borard, Long> {
    List<Borard> findAllByOrderByModifiedAtDesc();
    // 수정 날짜 순으로 내림차순정렬해주세요.
}
