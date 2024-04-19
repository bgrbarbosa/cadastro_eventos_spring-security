package br.com.cadastroeventosapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_convidado")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_convidado")
    private Long idConvidado;

    @Column(name = "nome_convidado", length = 100)
    private String nomeConvidado;

    @Column(name = "rg_convidado", length = 14)
    private String rgConvidado;

    @Column(name = "cpf_convidado", length = 14)
    private String cpfConvidado;

    @Column(name = "tel_convidado", length = 11)
    private String telConvidado;

    @Column(name = "email_convidado", length = 100)
    private String emailConvidado;
}
