package dev.sarah.movies.Domain.Movies;

import javax.validation.constraints.NotBlank;

public record MovieDTO() {
    @Notblanck(message = "O ID é obrigatório")
    String imdbId,

    

}