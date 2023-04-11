package com.datajpa.relationship.db.dto;

import com.datajpa.relationship.db.dto.responseDto.AuthorResponseDto;
import com.datajpa.relationship.db.dto.responseDto.BookResponseDto;
import com.datajpa.relationship.db.dto.responseDto.CategoryResponseDto;
import com.datajpa.relationship.db.dto.responseDto.CountyResponseDto;
import com.datajpa.relationship.db.dto.responseDto.EntitiesResponseDto;
import com.datajpa.relationship.db.dto.responseDto.MunicipalityResponseDto;
import com.datajpa.relationship.db.model.Author;
import com.datajpa.relationship.db.model.Book;
import com.datajpa.relationship.db.model.Category;
import com.datajpa.relationship.db.model.County;
import com.datajpa.relationship.db.model.Entities;
import com.datajpa.relationship.db.model.Municipality;

import java.util.ArrayList;
import java.util.List;

public class mapper {

    public static BookResponseDto bookToBookResponseDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setCategoryName(book.getCategory().getName());
        List<String> names = new ArrayList<>();
        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            names.add(author.getName());
        }
        bookResponseDto.setAuthorNames(names);
        return bookResponseDto;
    }

    public static List<BookResponseDto> booksToBookResponseDtos(List<Book> books) {
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book : books) {
            bookResponseDtos.add(bookToBookResponseDto(book));
        }
        return bookResponseDtos;
    }

    public static MunicipalityResponseDto municipalityToMunicipalityResponseDto(Municipality municipality) {
        MunicipalityResponseDto municipalityResponseDto = new MunicipalityResponseDto();
        municipalityResponseDto.setId(municipality.getId());
        municipalityResponseDto.setName(municipality.getName());
        municipalityResponseDto.setCountyId(municipality.getCounty().getId());
        municipalityResponseDto.setCountyName(municipality.getCounty().getName());
        return municipalityResponseDto;
    }

    public static List<MunicipalityResponseDto> municipalitiesToMunicipalityResponseDtos(
            List<Municipality> municipalities) {
        List<MunicipalityResponseDto> municipalityResponseDtos = new ArrayList<>();
        for (Municipality municipality : municipalities) {
            municipalityResponseDtos.add(municipalityToMunicipalityResponseDto(municipality));
        }
        return municipalityResponseDtos;
    }

    public static AuthorResponseDto authorToAuthorResponseDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setName(author.getName());
        List<String> names = new ArrayList<>();
        List<Book> books = author.getBooks();
        for (Book book : books) {
            names.add(book.getName());
        }
        authorResponseDto.setBookNames(names);
        return authorResponseDto;
    }

    public static List<AuthorResponseDto> authorsToAuthorResponseDtos(List<Author> authors) {
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author author : authors) {
            authorResponseDtos.add(authorToAuthorResponseDto(author));
        }
        return authorResponseDtos;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        List<String> names = new ArrayList<>();
        List<Book> books = category.getBooks();
        for (Book book : books) {
            names.add(book.getName());
        }
        categoryResponseDto.setBookNames(names);
        return categoryResponseDto;
    }

    public static List<CategoryResponseDto> categoriesToCategoryResponseDtos(List<Category> categories) {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryResponseDtos.add(categoryToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }

    public static CountyResponseDto countyToCountyResponseDto(County county) {
        CountyResponseDto countyResponseDto = new CountyResponseDto();
        countyResponseDto.setId(county.getId());
        countyResponseDto.setName(county.getName());
        countyResponseDto.setEntitiesId(county.getEntities().getId());
        countyResponseDto.setEntitiesName(county.getEntities().getName());
        List<String> names = new ArrayList<>();
        List<Municipality> municipalities = county.getMunicipalities();
        for (Municipality municipality : municipalities) {
            names.add(municipality.getName());
        }
        countyResponseDto.setMunicipalityNames(names);
        return countyResponseDto;
    }

    public static List<CountyResponseDto> countiesToCountyResponseDtos(List<County> counties) {
        List<CountyResponseDto> countyResponseDtos = new ArrayList<>();
        for (County county : counties) {
            countyResponseDtos.add(countyToCountyResponseDto(county));
        }
        return countyResponseDtos;
    }

    public static EntitiesResponseDto entitiesToEntitiesResponseDto(Entities entities) {
        EntitiesResponseDto entitiesResponseDto = new EntitiesResponseDto();
        entitiesResponseDto.setId(entities.getId());
        entitiesResponseDto.setName(entities.getName());
        List<String> names = new ArrayList<>();
        List<County> counties = entities.getCounties();
        for (County county : counties) {
            names.add(county.getName());
        }
        entitiesResponseDto.setCountyNames(names);
        return entitiesResponseDto;
    }

    public static List<EntitiesResponseDto> entitiesToEntitiesResponseDtos(List<Entities> entities) {
        List<EntitiesResponseDto> entitiesResponseDtos = new ArrayList<>();
        for (Entities entity : entities) {
            entitiesResponseDtos.add(entitiesToEntitiesResponseDto(entity));
        }
        return entitiesResponseDtos;
    }
}
