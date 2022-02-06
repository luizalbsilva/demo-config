package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Schema(description = "Country information")
@Data
@Entity
@ToString
@EqualsAndHashCode( of = "id")
@Table(name = "countries", schema = "configs")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryEntity {
    @Schema(description = "ISO 3166-1 alfa-3 Code", example = "BFA")
    @Id
    @Column(name = "country_code", columnDefinition = "char(3)", nullable = false)
    @JsonProperty("country-code")
    @JsonAlias("country-code")
    private String countryCode;

    @Version
    private long version;

    @Schema(description = "Country's name", example = "Burkina Faso")
    @Column(name = "name", length = 255, nullable = false)
    private String name;
}


