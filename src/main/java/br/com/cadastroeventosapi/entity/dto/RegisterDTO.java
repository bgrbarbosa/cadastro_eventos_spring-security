package br.com.cadastroeventosapi.entity.dto;

import br.com.cadastroeventosapi.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
