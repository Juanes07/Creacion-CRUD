package com.sofka.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


/**
 * [Conectamos a la user, haciendo la identificacion de cada columna por la anotacion @Column, incluyendo setter y getter]
 *
 * @version [1.0.000 2022-03-12]
 *
 * @author [Juan Esteban, Velasquez Posada ]
 *
 * @since [1.0.000 2022-03-12]
 *
 */
@Data
@Entity
@Table(name = "user")


public class User implements Serializable {
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    
    @Column(name = "email_id")
    private String mail;
    
    
    @Column(name = "user_name")
    private String name;
    
    @Column(name = "user_lastname")
    private String lastName;
    
    @Column(name = "phonenumber")
    private String phoneNumber;
    
    @Column(name = "user_birthday")
    private Date Birthday;
    
    
    
    
    
    
}
