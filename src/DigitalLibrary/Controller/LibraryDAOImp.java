/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalLibrary.Controller;

import DigitalLibrary.Database.LibraryDatabase;
import DigitalLibrary.Model.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class LibraryDAOImp implements LibraryDAO{
    @Override
    public void Create(Book book) {
        
        try {
            Connection con = LibraryDatabase.getConnection();
            String sql = "INSERT INTO LibraryTable(judul,penulis,tahun,halaman,genre,penerbit) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getJudul());
            ps.setString(2, book.getPenulis());
            ps.setInt(3, book.getTahun());
            ps.setInt(4, book.getHalaman());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getPenerbit());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void Update(Book books) {
        try {
            Connection con = LibraryDatabase.getConnection();
            String sql = "UPDATE LibraryTable SET judul=?,penulis=?,tahun=?,halaman=?,genre=?,penerbit=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, books.getJudul());
            ps.setString(2, books.getPenulis());
            ps.setInt(3, books.getTahun());
            ps.setInt(4, books.getHalaman());
            ps.setString(5, books.getGenre());
            ps.setString(6, books.getPenerbit());
            ps.setInt(7, books.getID());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void Delete(Book book) {
        try {
            Connection con = LibraryDatabase.getConnection();
            String sql = "delete from LibraryTable WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book data Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }

    @Override
    public Book get(int ID) {
        Book bookObject = new Book();
        try {
            Connection con = LibraryDatabase.getConnection();
            String sql = "SELECT * FROM LibraryTable WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bookObject.setID(rs.getInt("ID"));
                bookObject.setJudul(rs.getString("judul"));
                bookObject.setPenulis(rs.getString("penulis"));
                bookObject.setTahun(rs.getInt("tahun"));
                bookObject.setHalaman(rs.getInt("halaman"));
                bookObject.setGenre(rs.getString("genre"));
                bookObject.setPenerbit(rs.getString("penerbit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return bookObject;
        }


    @Override
    public List<Book> list() {
        List<Book> list = new ArrayList<Book>();
        try {
            Connection con = LibraryDatabase.getConnection();
            String sql = "SELECT * FROM LibraryTable";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Book bookObject = new Book();
                bookObject.setID(rs.getInt("ID"));
                bookObject.setJudul(rs.getString("judul"));
                bookObject.setPenulis(rs.getString("penulis"));
                bookObject.setTahun(rs.getInt("tahun"));
                bookObject.setHalaman(rs.getInt("halaman"));
                bookObject.setGenre(rs.getString("genre"));
                bookObject.setPenerbit(rs.getString("penerbit"));
                list.add(bookObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
}
