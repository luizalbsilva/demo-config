package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "institutions", schema = "configs")
@ToString
@EqualsAndHashCode( of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Institution's data")
public class InstitutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Institution's ID", example = "12")
    private Long id;

    @Version
    private long version;

    @Schema(description = "Institution's name", example = "Daesong Bank")
    @Column(name = "inst_name", length = 255, nullable = false)
    private String name;
}
