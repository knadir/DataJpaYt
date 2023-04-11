package com.datajpa.relationship.controller;

import com.datajpa.relationship.db.dto.requestDto.EntitiesRequestDto;
import com.datajpa.relationship.db.dto.responseDto.EntitiesResponseDto;
import com.datajpa.relationship.service.EntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/entities")
public class EntitiesController {

    private final EntitiesService entitiesService;

    @Autowired
    public EntitiesController(EntitiesService entitiesService) {
        this.entitiesService = entitiesService;
    }

    @PostMapping("/add")
    public ResponseEntity<EntitiesResponseDto> addEntities(
            @RequestBody final EntitiesRequestDto entitiesRequestDto) {
        EntitiesResponseDto entitiesResponseDto = entitiesService.addEntities(entitiesRequestDto);
        return new ResponseEntity<>(entitiesResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EntitiesResponseDto> getEntities(@PathVariable final Long id) {
        EntitiesResponseDto entitiesResponseDto = entitiesService.getEntitiesById(id);
        return new ResponseEntity<>(entitiesResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EntitiesResponseDto>> getEntities() {
        List<EntitiesResponseDto> entitiesResponseDtos = entitiesService.getEntities();
        return new ResponseEntity<>(entitiesResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EntitiesResponseDto> deleteEntities(@PathVariable final Long id) {
        EntitiesResponseDto entitiesResponseDto = entitiesService.deleteEntities(id);
        return new ResponseEntity<>(entitiesResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<EntitiesResponseDto> editEntities(
            @RequestBody final EntitiesRequestDto entitiesRequestDto,
            @PathVariable final Long id) {
        EntitiesResponseDto entitiesResponseDto = entitiesService.editEntities(id, entitiesRequestDto);
        return new ResponseEntity<>(entitiesResponseDto, HttpStatus.OK);
    }

}
