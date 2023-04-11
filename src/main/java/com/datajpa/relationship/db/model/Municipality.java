package com.datajpa.relationship.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Municipality")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_municipality")
    @SequenceGenerator(name = "seq_municipality", allocationSize = 1)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "county_id", foreignKey = @ForeignKey(name = "FK_COUNTY_MUNICIPALITY"))
    private County county;

    public Municipality(String name, County county) {
        this.name = name;
        this.county = county;
    }
}
