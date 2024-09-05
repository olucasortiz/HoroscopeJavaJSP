package com.example.horoscopo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email, password;
        email = request.getParameter("email");
        password = request.getParameter("password");

        if(isValidLogin(email,password)){
            HttpSession session = request.getSession();
            session.setAttribute("email",email);

            response.sendRedirect("horoscope-form.jsp");
        }
        else{
            response.sendRedirect("index.jsp?error=Invalid%20login");
        }
    }

    private boolean isValidLogin(String email, String password) {
        String parteEmail = email.split("@")[0];
        String inverteParteEmail = new StringBuilder(parteEmail).reverse().toString();

        return email.contains("@") && password.equals(inverteParteEmail);
        //aqui ele ta vendo se o email tem @ pra n dar bo de validação e verifica se a senha e igual ao inverteparteemail
    }
}
