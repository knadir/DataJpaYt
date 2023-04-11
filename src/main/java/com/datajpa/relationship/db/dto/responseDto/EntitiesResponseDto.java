package com.datajpa.relationship.db.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class EntitiesResponseDto {
    private Long id;
    private String name;
    private List<String> countyNames;
}
