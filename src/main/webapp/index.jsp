<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@page import="io.project.controller.Controller"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Login</title>
    <style>
        body{
            background-image: linear-gradient(#0278ae,#51adcf);
        }
        .dialog-border{
            background-color: white;
            width: 400px;
            height: 400px;
            border: solid #a5ecd7;
            text-align: center;
            margin: 100 auto;
            border-radius: 5%;
            box-shadow: 5px 5px 5px rgba(124, 117, 117, 0.726)
            /* border: solid black 2px; */
        }
        .userID-text{
            background-color: white;
            width: 50px;
            height: 20px;
            right: 50%;
            margin: 2% 20%;
            letter-spacing: 1.5px;
            /* border: solid black 2px; */
        }
        
        .userID-input{
        background-color: white;
        width: 60%;
        height: 7%;
        margin: auto    ;
        padding-bottom: 4%;
        }

        .userPswd-text{
            width: 50px;
            height: 20px;
            right: 50%;
            margin: 2% 20%;
            letter-spacing: 1.5px;
        }
        
        .userPswd-input{
        width: 60%;
        height: 7%;
        margin: auto    ;
        position: relative;
        padding-bottom: 10%;
        }


        input[type=text]{
            border: solid purple 2px;
            border-radius: 10px ;
            outline: none;
            width: 100%;
            height: 100%;
            
        }

        input[type=password]{
            border: solid purple 2px;
            border-radius: 10px ;
            outline: none;
            width: 100%;
            height: 100%;
            
        }

        h2{
            padding-bottom: 10%;
            /* border: 2px solid black; */
            font-weight: lighter;
            color: gray;
        }
        input[type=submit]{
            background-color:#28abb9 ;
            color: white;
            border: solid #28abb9 2px;
            border-radius: 7%;
            width: 40%;
            height: 10%;
            font-size: large;
        }
       
        
    </style>
</head>
<body>
    <div class="dialog-border">
        <h2>Login</h2>
           <form action="/login" method="post">
            <%
                if(Controller.status == false){
                    %><p style="color: red;">Your UserID or Password Invalid</p>
                    <%
                }
                
            %>
            <div class="userID-text">
                <p>UserID</p>
            </div>
            <div class="userID-input">
               <input type="text" name="userID" id="" >
            </div>
            <div class="userPswd-text">
                <p>Password</p>
            </div>
            <div class="userPswd-input">
               <input type="password" name="password" id="" >
            </div>
            <input type="submit" value="Login">
           </form>
        </form>
        <a href="/register">Sign in</a>

        
    </div>
    <br>
    
</body>
</html>