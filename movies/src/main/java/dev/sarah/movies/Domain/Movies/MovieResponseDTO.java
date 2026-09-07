package dev.sarah.movies.domain.movies.dtos;

public record MovieResponseDTO(
    String imdbId,
    String title,
    String poster
) {
}