package dev.sarah.movies.domain.movies.dtos;

import jakarta.validation.constraints.NotBlank;

public record MovieDTO(
    @NotBlank(message = "O ID é obrigatório")
    String imdbId
) {
}