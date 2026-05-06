package com.testeSistemas.hikoki.Entity;

import com.testeSistemas.hikoki.Repository.VersionRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pecas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PecaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPeca;

    private String nomePeca;
    private Date dataCriacao;


}
