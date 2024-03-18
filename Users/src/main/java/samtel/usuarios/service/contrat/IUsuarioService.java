package samtel.usuarios.service.contrat;

import samtel.usuarios.gen.type.UsuarioTypeInput;
import samtel.usuarios.gen.type.UsuarioTypeResponse;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    List<UsuarioTypeResponse> listarUsuario(Integer idtblUser);
    void eliminarUsuario(Integer idtblUser);
}
