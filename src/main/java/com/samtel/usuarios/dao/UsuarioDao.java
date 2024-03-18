package com.samtel.usuarios.dao;

import com.samtel.usuarios.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioDao implements PanacheRepository<Usuario> {
}
