package com.sofka.controller;

/**
 * librerias
 */
import com.sofka.domain.User;
import com.sofka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import com.sofka.service.UserService;

/**
 * [la clase GameController es quien nos permite realizar las peticiones a la base de datos]
 *
 * @version [1.0.000 2022-03-12]
 *
 * @author [Juan Esteban, Velasquez Posada ]
 *
 * @since [1.0.000 2022-03-12]
 *
 */
@Slf4j
@RestController
public class UserController {
   
    @Autowired
    private UserService userService;
    
    /**
     * funcion para obtener una lista de usuarios
     * @return lista de usuarios
     */
    @GetMapping(path = "/users")
    public List<User> list(){
        return userService.list();
    }
     
    /**
     *  funcion para agregar a base
     * @param user tipo del objeto User
     * @return un usuario creado en base de datos
     */
    @PostMapping(path = "/user")
    public ResponseEntity<User> create(User user){
        log.info("usuario a crear: {}", user);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    /**
     * funcion para eliminar usuario por medio de su ID
     * @param user tipo del objeto User
     * @return borrado del usuario seleccionado por su ID
     */
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<User> delete(User user){
        log.info("Usuario a borrar:{}", user);
        userService.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    /**
     * funcion para actualizar un usuario por medio de su id
     * @param user tipo del objeto User
     * @param id int del usuario 
     * @return 
     */
    @PutMapping(path = "/user/{id}")
    public ResponseEntity<User> update(User user,  @PathVariable("id") Long id){
        log.info("Usuario a actualizar: {}", user );
        userService.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    /**
     * funcion para actualizar nobmre del usuario por medio de su id
     * @param user tipo del objeto User
     * @param id int del usuar
     * @return 
     */
    @PatchMapping(path = "/user/name/{id}")
    public ResponseEntity<User> updateName(User user, @PathVariable("id") Long id){
        log.info("Usuario a actualizar name: {}", user );
        userService.updateName(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
          
}
