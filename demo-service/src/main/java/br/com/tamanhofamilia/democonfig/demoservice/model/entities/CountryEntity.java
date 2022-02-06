package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode( of = "id")
@Table(name = "countries", schema = "configs")
public class CountryEntity {
    @Id
    @Column(name = "country_code", columnDefinition = "char(3)", nullable = false)
    private String countryCode;

    @Version
    private long version;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
}


