package br.com.tamanhofamilia.democonfig.demoservice.model.entities;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@Entity
@Table(name = "field_configs", schema = "configs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"institution_id","contract_id","country_code", "field_id"})
        })
public class FieldConfig {
    @Id
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "bigint", name = "institution_id")
    private InstitutionEntity institution;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "bigint", name = "contract_id")
    private ContractEntity contract;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "char(3)", name = "country_code")
    private CountryEntity country;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "bigint", name = "field_id")
    @Comment("Related field")
    private FieldEntity field;

    @Column(name = "field_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Comment("Field type")
    private FieldTypeEnum type;

    @Column(name = "default_value")
    @Comment("Default value for the field")
    private String defaultValue;

    @Column(name = "possible_values", columnDefinition = "text")
    @Comment("Possible values for the field")
    private String possibleValues;

    private boolean editable;

}
