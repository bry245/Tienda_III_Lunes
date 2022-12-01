
package com.Tienda_3QL.service;

import com.Tienda_3QL.dao.CategoriaDao;
import com.Tienda_3QL.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var Lista= (List<Categoria>) categoriaDao.findAll();
        if(activos){ // si es falso retonar la lista completa y si es verdadero que queire solo los activos
            Lista.removeIf(e -> !e.isActivo()); // se remueve de la lista que no es activos... Por cada elemento si no es activo lo remueve
        } 
        return Lista;
    }

    @Override
     @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
      
    }

    @Override
     @Transactional
    public void delete(Categoria categoria) {
      categoriaDao.delete(categoria);
    }

    @Override
     @Transactional
    public Categoria getCategoria(Categoria categoria) {
        
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    
    
}
