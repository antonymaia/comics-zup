package com.antony.comics.repository;

import com.antony.comics.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByCpf(String cpf);

    Optional<UsuarioEntity> findByEmail(String email);
}
