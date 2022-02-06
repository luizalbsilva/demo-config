package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode( of = "id")
@Table(name = "countries", schema = "configs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryEntity {
    @Id
    @Column(name = "country_code", columnDefinition = "char(3)", nullable = false)
    @JsonProperty("country-code")
    @JsonAlias("country-code")
    private String countryCode;

    @Version
    private long version;

    @Column(name = "name", length = 255, nullable = false)
    private String name;
}


