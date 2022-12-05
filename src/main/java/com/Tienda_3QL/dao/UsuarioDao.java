
package com.Tienda_3QL.dao;

import com.Tienda_3QL.domain.Cliente;
import com.Tienda_3QL.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/*Esta interfaz se ua como puente para extraer metodos del crudRepository*/
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
  
    Usuario findByUsername(String username);/*Para agregar un metodo*/
    
    
}
