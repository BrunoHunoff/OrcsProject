package com.orcs.orcamentos.models;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_orcs")
public class OrcModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orc_sequence_generator")
    @SequenceGenerator(name="orc_sequence_generator", sequenceName = "orc_sequence", allocationSize=1)
    private int idOrc;
    private String content;
    private BigDecimal value;

    public OrcModel(){}

    public OrcModel(String content, BigDecimal value){};

    public OrcModel(int id){}

    public int getIdOrc() {
        return idOrc;
    }

    public void setIdOrc(int idOrc) {
        this.idOrc = idOrc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
