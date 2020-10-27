package io.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.project.controller.Controller;
import io.project.view.view;



public class UserDataDAO  {
    Connection connection;
    Statement statement;
    ResultSet result;
    private String user;
    private String password;
    private String url;
    private String Driver;

    public static String Name;
    public static String User;
    public static String Email;
    public static String Pswd;

    public String getName(){
        return Name;
    }
    
    
    // Setter 
    public String setUser( String user){
        return this.user = user;
    }
    public String setPassword( String password){
        return this.password = password;
    }
    public String setUrl(String url){
        return this.url = url;
    }
    public String setDriver( String driver){
        return this.Driver = driver;
    }
    
    public void connect(){
        try {
            connection= DriverManager.getConnection(url, user, password);
            System.err.println("DB Nyambung");
        } catch (final SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void input( String name,  String userID,  String email,  String Password){
        try{
            String sql ="insert into UserData(name,userID,email,password) values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, userID);
            ps.setString(3, email);
            ps.setString(4, Password);
            ps.executeUpdate();
            
        }catch(final SQLException e){
            e.printStackTrace();
        }
    
    }
        
    public boolean authentiated( String userID, String password){
        boolean status =false;
        String sql;
            try{
                 sql = "select * from UserData where userID= ? and password = ?";
                 String hash = Controller.Encrypt(password);
                 PreparedStatement ps = connection.prepareStatement(sql);
                 ps.setString(1, userID);
                 ps.setString(2, hash);
                 result = ps.executeQuery();
                 
                 while (result.next()) {
                    status = true;
                    Name  = result.getString("name");
                    User   = result.getString("userID");
                    Email  = result.getString("email");
                    Pswd   = result.getString("password"); 
                    
                 }
                 
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            
            return status;
            
    }
    

    }

   

;