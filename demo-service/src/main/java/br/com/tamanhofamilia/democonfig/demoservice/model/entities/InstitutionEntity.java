package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

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
public class InstitutionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private long version;

    @Column(name = "inst_name", length = 255, nullable = false)
    private String name;
}
