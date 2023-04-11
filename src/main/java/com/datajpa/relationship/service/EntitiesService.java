package com.datajpa.relationship.service;

import com.datajpa.relationship.db.dto.requestDto.EntitiesRequestDto;
import com.datajpa.relationship.db.dto.responseDto.EntitiesResponseDto;
import com.datajpa.relationship.db.model.Entities;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntitiesService {
    public Entities getEntities(Long entitiesId);
    public EntitiesResponseDto addEntities(EntitiesRequestDto entitiesRequestDto);
    public EntitiesResponseDto getEntitiesById(Long entitiesId);
    public List<EntitiesResponseDto> getEntities();
    public EntitiesResponseDto deleteEntities(Long entitiesId);
    public EntitiesResponseDto editEntities(Long entitiesId, EntitiesRequestDto entitiesRequestDto);
}
