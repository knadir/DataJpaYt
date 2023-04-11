package com.datajpa.relationship.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Entities")
@EntityListeners(AuditingEntityListener.class)
public class Entities extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entities")
    @SequenceGenerator(name = "seq_entities", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    @NotEmpty
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    @OneToMany(mappedBy = "entities", fetch = FetchType.EAGER)
    private List<County> counties = new ArrayList<>();

    // public Entities(String name, List<County> counties) {
    //     this.name = name;
    //     this.counties = counties;
    // }

    @CreatedBy
    private String userCreated;

    @CreatedDate
    private Date dateCreated;

    @LastModifiedBy
    private String userModified;

    @LastModifiedDate
    private Date dateModified;

    public void addCounty(County county) {
        counties.add(county);
        ((County) counties).setEntities(this);
    }

    public void removeCounty(County county) {
        counties.remove(county);
        ((County) counties).setEntities(null);
    }
}
