package com.samtel.usuarios.controller;

import com.samtel.usuarios.gen.contract.V1UsuarioApi;
import com.samtel.usuarios.gen.type.UsuarioTypeInput;
import com.samtel.usuarios.gen.type.UsuarioTypeResponse;
import com.samtel.usuarios.service.implemt.UsuarioServiceImpl;
import jakarta.inject.Inject;

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

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser) {
        return null;
    }


}