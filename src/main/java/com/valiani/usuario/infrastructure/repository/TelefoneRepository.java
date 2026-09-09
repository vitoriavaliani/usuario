package com.valiani.usuario.infrastructure.repository;


import com.valiani.usuario.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Usuario,Long> {
}
