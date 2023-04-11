package com.datajpa.relationship.db.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class MunicipalityResponseDto {
    private Long id;
    private String name;
    private Long countyId;
    private String countyName;
}
