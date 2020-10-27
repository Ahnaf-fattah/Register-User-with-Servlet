package io.project.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.project.model.UserData;
import io.project.model.UserDataDAO;


@WebServlet(urlPatterns = {"/register"})
public class controllerRegister extends HttpServlet {
    UserDataDAO userDataDAO = new UserDataDAO();
    Controller controller =new Controller();


        public void init(){
            userDataDAO.setDriver("com.mysql.cj.JDBC.Driver");
            userDataDAO.setUser("naf");
            userDataDAO.setPassword("m0nkey");
            userDataDAO.setUrl("jdbc:mysql://localhost:3306/registrasi");
            userDataDAO.connect();
            
        }
        public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
            resp.setContentType("text/html");
            PrintWriter  out = resp.getWriter();
            resp.sendRedirect("registerForm.html");
            
        }

        public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
            resp.setContentType("text/html");
            PrintWriter  out = resp.getWriter();
            try {
                
                UserData userData = new UserData();
                userData.setName(req.getParameter("name"));
                userData.setEmail(req.getParameter("email"));
                userData.setUserID(req.getParameter("userID"));
                String hash = controller.Encrypt(req.getParameter("password"));
                userData.setPassword(hash);
                userDataDAO.input(userData.getName(),  userData.getUserID(), userData.getEmail(),userData.getPassword());
                resp.sendRedirect("registerSuccessfully.html");
                
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        public void destroy(){
        }
        
    }

    
    

