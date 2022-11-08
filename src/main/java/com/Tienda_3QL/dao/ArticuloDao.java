
package com.Tienda_3QL.dao;

import com.Tienda_3QL.domain.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo,Long> {
    
}
