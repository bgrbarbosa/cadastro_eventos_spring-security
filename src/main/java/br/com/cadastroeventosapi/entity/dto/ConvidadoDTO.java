package br.com.cadastroeventosapi.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConvidadoDTO {

    private Long idConvidado;
    @NotBlank
    @Size(min = 3, max = 50)
    private String nomeConvidado;

    @NotBlank
    @Size(min = 9, max = 14)
    private String rgConvidado;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpfConvidado;

    @NotBlank
    @Size(min = 10, max = 13)
    private String telConvidado;

    @NotBlank
    @Email
    @Size(max = 50)
    private String emailConvidado;
}
