/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.devavance.calculatrice.controller;

import fr.devavance.calculatrice.metiers.Calculator;
import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            case "add":
                {
                    res = String.valueOf(Calculator.addition(operande1,operande2));
                    operation = "addition";
                    break;
                }
            case "sub":
                {
                    res = String.valueOf(Calculator.soustraction(operande1,operande2));
                    operation = "soustracton";
                    break;
                }
            case "div":
                {
                    res = String.valueOf(Calculator.division(operande1,operande2));
                    operation = "division";
                    break;
                }
            case "mul":
                {
                    res = String.valueOf(Calculator.multiplication(operande1,operande2));
                    operation = "multiplication";
                    break;
                }
            default:
                res = "<strong>Wrong operation !</strong>";
                operation = "incorrect";
                break;
        }
        
        String reponse = "";
        
        if (operande1!=null && operande2!=null) {
            reponse += "<p><span>valeur de l'opérande 1 : </span><strong>" + operande1 + "</strong></p>";
            reponse += "<p><span>valeur de l'opérande 2 : </span><strong>" + operande2 + "</strong></p>";
            reponse += "<p><span>l'opération : </span><strong>" + operation + "</strong></p>";
            reponse += "<p><span>le resultat : </span><strong>" + res + "</strong></p>";
        } else {
            reponse = "<p>les valeurs manquantes";
        }
        
        reponse += "<button><a href='/calculatrice_frontend-1.0-SNAPSHOT/form_saisies_operation.html'>Home Page</a></button>";
        
        out.print(reponse);
    }

}
