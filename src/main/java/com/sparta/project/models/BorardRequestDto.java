package com.sparta.project.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BorardRequestDto {
    private String title;
    private String name;
    private String password;
    private String content;
}
