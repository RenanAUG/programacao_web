package br.unipar.programacaointernet.task.task.model;

import jakarta.ejb.Local;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column
    private String observacao;

    @Column
    private LocalDate dataPrevisao;

    @Column
    private String prioridade;

    @Column
    private String status;

    @Column
    private LocalDate dataInicio;

    @Column
    private LocalDate dataTermino;

    @Column
    @ManyToOne
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;


}
