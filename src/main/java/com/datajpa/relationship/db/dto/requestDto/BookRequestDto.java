package com.datajpa.relationship.db.dto.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class BookRequestDto {
    private String name;
    private List<Long> authorIds;
    private Long categoryId;
}
