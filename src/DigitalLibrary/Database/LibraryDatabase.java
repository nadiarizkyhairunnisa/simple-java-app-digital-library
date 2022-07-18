/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalLibrary.Database;

/**
 *
 * @author User
 */
import java.sql.DriverManager;

public class LibraryDatabase {
    static java.sql.Connection con;
//    static String driver = "com.mysql.jdbc.Driver";
    static String driver = "org.sqlite.JDBC";
//    static String url = "jdbc:mysql://localhost/LibraryDB";
//    static String url = "jdbc:sqlite:" + Connect.theDB;
    static String url = "jdbc:sqlite:C:\\Users\\User\\Documents\\NetBeansProjects\\DigitalLibrary\\LibraryDB.db";


    public static java.sql.Connection getConnection() throws Exception{
        if(con == null){
            Class.forName(driver);
            con = DriverManager.getConnection(url);
        }
        return con;
    }
    
}
