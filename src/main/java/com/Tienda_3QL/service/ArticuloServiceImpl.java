
package com.Tienda_3QL.service;

import com.Tienda_3QL.dao.ArticuloDao;
import com.Tienda_3QL.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    ArticuloDao articuloDao;
    
    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var Lista= (List<Articulo>) articuloDao.findAll();
       if(activos){ // si es falso retonar la lista completa y si es verdadero que queire solo los activos
            Lista.removeIf(e -> !e.isActivo()); // se remueve de la lista que no es activos... Por cada elemento si no es activo lo remueve
        }
        
        
        return Lista;
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
      
    }

    @Override
     @Transactional
    public void delete(Articulo articulo) {
      articuloDao.delete(articulo);
    }

    @Override
     @Transactional
    public Articulo getArticulo(Articulo articulo) {
        
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
    
    
}
