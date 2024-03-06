package com.cl.sodexo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cl.sodexo.model.Favorite;

/**
 * The Interface UserRepository.
 */
@Transactional
@Repository
public interface NewsRepository extends JpaRepository<Favorite, Long> {

	@Query(value = "SELECT COUNT(*) =1 FROM FAVORITE WHERE ID_USER=:idUser AND ID_NEWS=:idNews", nativeQuery = true)
	boolean findByFavorite(Long idUser, Long idNews);

	@Modifying
	@Query(value = "DELETE FROM FAVORITE WHERE ID_USER=:idUser AND ID_NEWS=:idNews", nativeQuery = true)
	void deleteByFavorite(Long idUser, Long idNews);

	@Query(value = "SELECT ID_NEWS FROM FAVORITE WHERE ID_USER=:idUser", nativeQuery = true)
	List<Long> getAllFavoritesById(Long idUser);

	@Query(value = "SELECT COUNT(*) =1 FROM USER WHERE UUID=:idUser", nativeQuery = true)
	boolean findByUserId(Long idUser);

}
