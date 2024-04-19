package br.com.cadastroeventosapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_evento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long idEvento;

    @Column(name = "desc_evento", length = 50)
    private String descEvento;

    @Column(name = "hr_evento")
    private Timestamp hrEvento;

}
