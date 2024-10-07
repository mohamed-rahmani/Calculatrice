/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.devavance.calculatrice.controller;

import fr.devavance.calculatrice.metiers.Calculator;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author moham
 */
@WebServlet(name = "calculate", urlPatterns = {"/calculate"})
public class CalculatorController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        String operation = request.getParameter("operation");
        String operande1 = request.getParameter("operande1");
        String operande2 = request.getParameter("operande2");
        
        String res;
        
        switch (operation) {
            case "+":
                {
                    res = String.valueOf(Calculator.addition(operande1,operande2));
                    break;
                }
            case "-":
                {
                    res = String.valueOf(Calculator.soustraction(operande1,operande2));
                    break;
                }
            case "/":
                {
                    res = String.valueOf(Calculator.division(operande1,operande2));
                    break;
                }
            case "*":
                {
                    res = String.valueOf(Calculator.multiplication(operande1,operande2));
                    break;
                }
            default:
                res = "<p>Wrong operation !</p>";
                break;
        }
        
        String reponse = "";
        
        if (operation!=null || operande1!=null || operande2!=null) {
            reponse += "<p><span>valeur de l'opérande 1 : </span><strong>" + operande1 + "</strong></p>";
            reponse += "<p><span>valeur de l'opérande 2 : </span><strong>" + operande2 + "</strong></p>";
            reponse += "<p><span>l'opération : </span><strong>" + operation + "</strong></p>";
            reponse += "<p><span>le resultat : </span><strong>" + res + "</strong></p>";
        } else {
            reponse = "<p>les valeurs manquantes";
        }
        
        out.print(reponse);
    }

}
