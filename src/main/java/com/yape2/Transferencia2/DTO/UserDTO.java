package com.yape2.Transferencia2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDTO {
    private Long id_user;
    private String Firstname;
    private String Lastname;
    private int cellphone;

    public UserDTO() {
    }

    public UserDTO(Long id_user, String firstname, String lastname, int cellphone) {
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
