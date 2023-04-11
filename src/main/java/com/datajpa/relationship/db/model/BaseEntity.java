package com.datajpa.relationship.db.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // protected Long id;

    @CreatedBy
    private String userCreated;

    @CreatedDate
    private Date dateCreated;

    @LastModifiedBy
    private String userModified;

    @LastModifiedDate
    private Date dateModified;

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }
    // @JsonIgnore
    // public boolean isNew() {
    //     return this.id == null;
    // }

}
