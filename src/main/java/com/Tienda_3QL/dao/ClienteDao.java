
package com.Tienda_3QL.dao;

import com.Tienda_3QL.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


/*Esta interfaz se ua como puente para extraer metodos del crudRepository*/
public interface ClienteDao extends CrudRepository<Cliente, Long>{
  
    
    
    
}
