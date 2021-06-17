package br.com.gz.finance.apifinance.repository;

import br.com.gz.finance.apifinance.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
