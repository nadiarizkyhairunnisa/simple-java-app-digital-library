/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalLibrary.Controller;

import DigitalLibrary.Model.Book;
import java.util.List;

public interface LibraryDAO {
    public void Create (Book book);
    public void Update (Book book);
    public void Delete (Book book);
    public Book get(int ID);
    public List<Book> list();
}

