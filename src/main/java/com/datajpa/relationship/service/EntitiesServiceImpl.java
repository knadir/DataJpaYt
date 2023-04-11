package com.datajpa.relationship.service;

import com.datajpa.relationship.db.dto.mapper;
import com.datajpa.relationship.db.dto.requestDto.EntitiesRequestDto;
import com.datajpa.relationship.db.dto.responseDto.EntitiesResponseDto;
import com.datajpa.relationship.db.model.Entities;
import com.datajpa.relationship.db.repository.EntitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EntitiesServiceImpl implements EntitiesService {

    private final EntitiesRepository entitiesRepository;

    @Autowired
    public EntitiesServiceImpl(EntitiesRepository entitiesRepository) {
        this.entitiesRepository = entitiesRepository;
    }


    @Override
    public Entities getEntities(Long entitiesId) {
        return entitiesRepository.findById(entitiesId).orElseThrow(() ->
                new IllegalArgumentException("could not find entities with id: " + entitiesId));
    }

    @Override
    public EntitiesResponseDto addEntities(EntitiesRequestDto entitiesRequestDto) {
        Entities entities = new Entities();
        entities.setName(entitiesRequestDto.getName());
        entitiesRepository.save(entities);
        return mapper.entitiesToEntitiesResponseDto(entities);
    }

    @Override
    public EntitiesResponseDto getEntitiesById(Long entitiesId) {
        Entities entities = getEntities(entitiesId);
        return mapper.entitiesToEntitiesResponseDto(entities);
    }

    @Override
    public List<EntitiesResponseDto> getEntities() {
        List<Entities> entities = StreamSupport
                .stream(entitiesRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return mapper.entitiesToEntitiesResponseDtos(entities);
    }

    @Override
    public EntitiesResponseDto deleteEntities(Long entitiesId) {
        Entities entities = getEntities(entitiesId);
        entitiesRepository.delete(entities);
        return mapper.entitiesToEntitiesResponseDto(entities);
    }

    @Transactional
    @Override
    public EntitiesResponseDto editEntities(Long entitiesId, EntitiesRequestDto entitiesRequestDto) {
        Entities entitiesToEdit = getEntities(entitiesId);
        entitiesToEdit.setName(entitiesRequestDto.getName());
        return mapper.entitiesToEntitiesResponseDto(entitiesToEdit);
    }
}
