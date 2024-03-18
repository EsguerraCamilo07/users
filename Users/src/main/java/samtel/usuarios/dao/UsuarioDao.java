package samtel.usuarios.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import samtel.usuarios.entity.Usuario;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<Usuario>{
}
