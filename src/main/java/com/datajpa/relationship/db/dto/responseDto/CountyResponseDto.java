package com.datajpa.relationship.db.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class CountyResponseDto {
    private Long id;
    private String name;
    private Long entitiesId;
    private String entitiesName;
    private List<String> municipalityNames;
}
