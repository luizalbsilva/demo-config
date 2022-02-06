package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contracts", schema = "configs")
@ToString
@EqualsAndHashCode( of = "id")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private long version;

    @Column(name = "description", length = 255, nullable = false)
    private String description;
}
