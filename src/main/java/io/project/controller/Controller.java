package io.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.project.model.UserData;
import io.project.model.UserDataDAO;

// Controller yang Login
@WebServlet(urlPatterns = {"/login"})
public class Controller extends HttpServlet {
    UserDataDAO userDataDAO = new UserDataDAO();
   public static boolean status =true;
    public void init(){
        // Dibuat INIT agar lgsg jalan
        userDataDAO.setDriver("com.mysql.cj.JDBC.Driver");
        userDataDAO.setUser("naf");
        userDataDAO.setPassword("m0nkey");
        userDataDAO.setUrl("jdbc:mysql://localhost:3306/registrasi");
        userDataDAO.connect();
        
        
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
         UserData userData = new UserData();
        userData.setUserID(req.getParameter("userID"));
        userData.setPassword(req.getParameter("password"));
        
        if(userDataDAO.authentiated(userData.getUserID(), userData.getPassword())==false){
            resp.sendRedirect("index.jsp");
            this.status= false;
        }else{
            this.status=true;
            resp.sendRedirect("/login_inf");
        }
        
    }
    
    public boolean warning(){
        boolean status = this.status;
        return status;
    }

    

    public static String Encrypt(String input){
            String Hash =null;
        try {
            MessageDigest  md =  MessageDigest.getInstance("MD5");
            byte[] MessageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1,MessageDigest);
             Hash = number.toString(16);
            while(Hash.length()<32){
                Hash = "0" +Hash;
            }
        } catch (NoSuchAlgorithmException ex) {
            //TODO: handle exception
            ex.printStackTrace();
        }
        return Hash;
    }
    
    public void destroy(){

    }

    }


    