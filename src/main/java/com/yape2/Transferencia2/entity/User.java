package com.yape2.Transferencia2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "Firstname", unique = true, nullable = false)
    private String Firstname;

    @Column(name = "Lastname", unique = true, nullable = false)
    private String Lastname;

    @Column(name = "cellphone", unique = true, nullable = false)
    private int cellphone;

    public User() {
    }

    public User(Long id_user, String firstname, String lastname, int cellphone) {
        this.id_user = id_user;
        Firstname = firstname;
        Lastname = lastname;
        this.cellphone = cellphone;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }
}
