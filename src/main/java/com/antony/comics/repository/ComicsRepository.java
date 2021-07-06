package com.antony.comics.repository;

import com.antony.comics.entity.ComicEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComicsRepository extends CrudRepository<ComicEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO USUARIO_COMICS(COMIC_ID, USUARIO_ID) " +
                   " VALUES( :idComic , :idUsuario ) ", nativeQuery = true)
    void cadastrarComicDoUsuario(Integer idUsuario, Integer idComic);
}
