package dev.sarah.movies.Mapper;
import org.mapstruct.Mapper;

import dev.sarah.movies.Domain.Movies.MovieDTO;
import dev.sarah.movies.Domain.Movies.MovieResponseDTO;
import dev.sarah.movies.Domain.Movies.Entitie.Movie;
import dev.sarah.movies.repositorys.MovieRepository;

@Mapper(componenteModel = "spring")
public interface Mapper {

    Movie toEntity(MovieDTO dto);

    MovieResponseDTO toResponseDTO(Movie movie);

}
