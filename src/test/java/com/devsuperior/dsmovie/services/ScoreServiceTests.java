package com.devsuperior.dsmovie.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.MovieEntity;
import com.devsuperior.dsmovie.entities.ScoreEntity;
import com.devsuperior.dsmovie.entities.UserEntity;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.MovieFactory;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import com.devsuperior.dsmovie.tests.UserFactory;

@ExtendWith(SpringExtension.class)
public class ScoreServiceTests {
	
	@InjectMocks
	private ScoreService service;
	
	@Mock
	private UserService userService;
	
	@Mock
	private MovieRepository movieRepository;
	
	@Mock
	private ScoreRepository scoreRepository;
	
	private UserEntity user;
	private MovieEntity movieEntity;
	private ScoreEntity scoreEntity;
	private Long existingMovieId, nonExistingMovieId;
	private ScoreDTO scoreDTOWithExistingMovieId, scoreDTOWithNonExistingMovieId;
	
	@BeforeEach
	void setUp() throws Exception {
		user = UserFactory.createUserEntity();
		movieEntity = MovieFactory.createMovieEntity(); 
		scoreEntity = ScoreFactory.createScoreEntity();
		existingMovieId = 1L;
		nonExistingMovieId = 2L;
		scoreDTOWithExistingMovieId = new ScoreDTO(existingMovieId, scoreEntity.getValue());
		scoreDTOWithNonExistingMovieId = new ScoreDTO(nonExistingMovieId, scoreEntity.getValue());
		
		Mockito.when(userService.authenticated()).thenReturn(user);		
		Mockito.when(movieRepository.findById(existingMovieId)).thenReturn(Optional.of(movieEntity));
		Mockito.when(scoreRepository.saveAndFlush(any())).thenReturn(scoreEntity);
		Mockito.when(movieRepository.save(any())).thenReturn(movieEntity);
		
		Mockito.when(movieRepository.findById(nonExistingMovieId)).thenThrow(ResourceNotFoundException.class);
	}
	
	@Test
	public void saveScoreShouldReturnMovieDTO() {
		
		MovieDTO result = service.saveScore(scoreDTOWithExistingMovieId);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(movieEntity.getId(), result.getId());
		Assertions.assertEquals(scoreDTOWithExistingMovieId.getScore(), result.getScore());
	}
	
	@Test
	public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.saveScore(scoreDTOWithNonExistingMovieId);
		});
	}
}
