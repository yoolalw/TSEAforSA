package com.testeSistemas.hikoki.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "versoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idVersao;

    private Double versao;
    private String urlDoc;

    @ManyToOne
    @JoinColumn(name="nome_peca", nullable = false)
    @JsonIgnore
    private PecaEntity pecaEntity;



}
