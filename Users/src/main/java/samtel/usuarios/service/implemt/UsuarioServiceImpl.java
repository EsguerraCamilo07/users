package samtel.usuarios.service.implemt;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import samtel.usuarios.controller.UsuarioController;
import samtel.usuarios.dao.UsuarioDao;
import samtel.usuarios.entity.Usuario;
import samtel.usuarios.gen.type.UsuarioTypeInput;
import samtel.usuarios.gen.type.UsuarioTypeResponse;
import samtel.usuarios.service.contrat.IUsuarioService;
import samtel.usuarios.utils.ApplicationException;
import samtel.usuarios.utils.UsuarioMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import samtel.usuarios.constant.Constant;

import java.util.Collections;
import java.util.List;

@ApplicationScoped //Comvierte la clase en BIN
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioMapper usuarioMapper;
    @Inject
    UsuarioDao usuarioDao;
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA CREAR USUARIO----------------------------------------
    @Transactional
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia crearUsuarioImpl");
        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToType(usuario);
            LOG.info("Persis usuario");
            return Collections.singletonList(response);
        }catch (ApplicationException e){
            LOG.error("Error al crear usuario");
            throw new ApplicationException(Constant.ERROR_SERVICIO + e.getMessage());
        }
    }
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA OBTENER USUARIO----------------------------------
    @Transactional
    public List<UsuarioTypeResponse> listarUsuario(Integer idtblUser){
        LOG.info("Inicia listarUsuarioImpl");
        try {
            Usuario user = usuarioDao.findById(idtblUser.longValue());
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToType(user);
            LOG.info("Finaliza listar usuario por id");
            return  Collections.singletonList(response);
        }catch (ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(Constant.ERROR_SERVICIO + e.getMessage());
        }
    }
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA ELIMINAR USUARIO-------------------------------------
   @Transactional
    public void eliminarUsuario(Integer idtblUser){
       LOG.info("Inicia eliminacion de usuario");
       try {
           Long id = Long.valueOf(idtblUser);
           usuarioDao.deleteById(id);
           LOG.info("Termina eliminar usuario");
       }catch(ApplicationException e){
           LOG.error("Se presento un error al elimianr usuario"+ e.getMessage());
           throw new ApplicationException(Constant.ERROR_SERVICIO + e.getMessage());
       }
   }
//------------------------------------------------------------------------------------------------
//-------------------------------METODO PARA EDITAR USUARIO---------------------------------------
   @Transactional
    public List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia edicion del usuario");
        try{
            Usuario usuario = usuarioDao.findById(idtblUser.longValue());
            Usuario usuarioCambio = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);

            usuario.setName(usuarioCambio.getName());
            usuario.setLastname(usuarioCambio.getLastname());
            usuario.setCreateat(usuarioCambio.getCreateat());

            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToType(usuarioCambio);
            LOG.info("Finaliza listar usuario por id");
            return  Collections.singletonList(response);

        }catch(ApplicationException e){
            LOG.error("Se presento un error al listar usuario por id"+ e.getMessage());
            throw new ApplicationException(Constant.ERROR_SERVICIO + e.getMessage());
        }
    }
}