package com.bibliotheque.API.Entity.Dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id;
    public String name ;
    public String email;
    public String password;
}
