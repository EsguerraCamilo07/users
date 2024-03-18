package samtel.usuarios.utils;

import samtel.usuarios.entity.Usuario;
import samtel.usuarios.gen.type.UsuarioTypeInput;
import samtel.usuarios.gen.type.UsuarioTypeResponse;
import org.modelmapper.ModelMapper;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

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