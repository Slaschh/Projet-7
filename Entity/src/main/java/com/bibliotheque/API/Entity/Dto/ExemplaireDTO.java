package com.bibliotheque.API.Entity.Dto;

import com.bibliotheque.API.Entity.Book;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class ExemplaireDTO {

    public int id;
    public String edition;
    public boolean available;


    private Book book;

}
