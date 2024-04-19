package br.com.cadastroeventosapi.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventoDTO {


    private Long idEvento;

    @NotBlank
    private String descEvento;

    private Timestamp hrEvento;
}
