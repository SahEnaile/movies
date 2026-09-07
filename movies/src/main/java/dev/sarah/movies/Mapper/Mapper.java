package dev.sarah.movies.mappers;

import org.mapstruct.Mapper;

import dev.sarah.movies.domain.movies.dtos.MovieDTO;
import dev.sarah.movies.domain.movies.dtos.MovieResponseDTO;
import dev.sarah.movies.domain.movies.entities.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie toEntity(MovieDTO dto);

    MovieResponseDTO toResponseDTO(Movie movie);

}