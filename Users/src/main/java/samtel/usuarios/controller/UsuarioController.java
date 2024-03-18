package samtel.usuarios.controller;

import jakarta.inject.Inject;
import samtel.usuarios.gen.contract.V1UsuarioApi;
import samtel.usuarios.gen.type.UsuarioTypeInput;
import samtel.usuarios.gen.type.UsuarioTypeResponse;
import samtel.usuarios.service.implemt.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UsuarioController implements V1UsuarioApi {
    private  static  final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioServiceImpl usuarioServiceImpl;
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA CREAR USUARIO----------------------------------------
    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Termino el proceso Crear ususario");
        return usuarioServiceImpl.crearUsuario(usuarioTypeInput);
    }
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA EDITAR USUARIO---------------------------------------
    @Override
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Termino el proceso Editar usuario");
        return usuarioServiceImpl.editarUsuario(idtblUser, usuarioTypeInput);
    }
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA ELIMINAR USUARIO-------------------------------------
    @Override
    public void eliminarUsuario(Integer idtblUser) {
        usuarioServiceImpl.eliminarUsuario(idtblUser);
    }

}