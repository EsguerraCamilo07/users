package com.samtel.usuarios.utils;

import com.samtel.usuarios.entity.Usuario;
import com.samtel.usuarios.gen.type.UsuarioTypeInput;
import com.samtel.usuarios.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UsuarioMapper {
//---------------------Mapeo para pasar un usuarioTypeInput a la entidad Usuario---------------------
    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, Usuario.class);
    }
//---------------------Mapeo para pasar una entidad Usuario a UsuarioTypeResponse---------------------
    public UsuarioTypeResponse usuarioEntityToType(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }
}