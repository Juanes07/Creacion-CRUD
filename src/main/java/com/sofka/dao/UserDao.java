package com.sofka.dao;

/**
 * librerias
 */
import com.sofka.domain.User;
import java.sql.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * [la interfaz UserDao extiende de la libreria CrudRepository
 * ahorra lineas de codigos en la creacion del CRUD]
 *
 * @version [1.0.000 2022-03-12]
 *
 * @author [Juan Esteban, Velasquez Posada ]
 *
 * @since [1.0.000 2022-03-12]
 *
 */

/**
 * Long hace referencia al tipo de la llave primaria en la tabla game
 */
public interface UserDao extends CrudRepository<User, Long> {
    
    /**
     *
     * 
     * @Modifyn anotacion que hace referencia a una modificacion dentro de la base de datos
     * @Query anotacion de referencia para realizar la peticion a base datos
     */
    
    @Modifying
    @Query("update User usu set usu.name = :name where usu.id = :id")
    public void updateName(
            @Param(value = "id")Long id, 
            @Param(value = "name")String name
    );
   
       
}