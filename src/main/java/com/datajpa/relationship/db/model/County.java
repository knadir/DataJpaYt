package com.datajpa.relationship.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "County")
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_county")
    @SequenceGenerator(name = "seq_county", allocationSize = 1)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "county", fetch = FetchType.EAGER)
    private List<Municipality> municipalities = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entities_id", foreignKey = @ForeignKey(name = "FK_ENTITIES_COUNTY"))
    private Entities entities;

    public County(String name, List<Municipality> municipalities) {
        this.name = name;
        this.municipalities = municipalities;
    }

    public void addMunicipality(Municipality municipality) {
        municipalities.add(municipality);
        ((Municipality) municipalities).setCounty(this);
    }

    public void removeMunicipality(Municipality municipality) {
        municipalities.remove(municipality);
        ((Municipality) municipalities).setCounty(null);
    }
}
