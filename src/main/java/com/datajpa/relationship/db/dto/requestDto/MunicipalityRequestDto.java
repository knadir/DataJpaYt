package com.datajpa.relationship.db.dto.requestDto;

import lombok.Data;

@Data
public class MunicipalityRequestDto {
    private String name;
    private Long countyId;
}
