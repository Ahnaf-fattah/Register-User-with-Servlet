package io.project.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.project.model.UserDataDAO;

@WebServlet(urlPatterns = "/login_inf")
public class view extends HttpServlet{ 
    public String name;
    public String email;
    public String user;
    public String hash;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    // public void retriveData(String name,String user,String email,String hash){
    //     this.name = name;
    //     System.err.println(this.name);
    UserDataDAO data = new UserDataDAO();

         
    //     }
    public void init(){
        
        
        
    }
    
    
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
      
        
        // head
        String css = "<link rel='stylesheet' href='css/style.css'>";
        out.println("<head>");
        out.println("<title>");
        out.println("Login Information");
        out.println("</title>");
        out.println(css);

        // body
        out.println("<body>");

        // div
        out.println("<div class='dialog-border'>");
        out.println("<h2>");
        out.println("Login Information");
        out.println("</h2>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<td>name</td>");
        out.println("<td>");
        out.println(data.Name);
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>email</td>");
        out.println("<td>");
        out.println(data.Email);
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>user</td>");
        out.println("<td>");
        out.println(data.User);
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>hash</td>");
        out.println("<td>");
        out.println(data.Pswd);
        out.println("</td>");
        out.println("</tr>");

        out.println("</table>");
        out.println("<form action='/' method='get'>");
        out.println("<input type='submit' value='Sign Out'>");
        out.println("</form>");
    
        out.println("</div>");

        out.println("</body>");
        
    }

    
    public void destroy(){

    }
}