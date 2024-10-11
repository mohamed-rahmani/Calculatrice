package fr.devavance.calculatrice.controller;

import fr.devavance.calculatrice.exceptions.CalculatorExceptionHandler;
import fr.devavance.calculatrice.metiers.Calculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculate", urlPatterns = {"/calculate"})
public class CalculatorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String operation = request.getParameter("operation");
        String operande1 = request.getParameter("operande1");
        String operande2 = request.getParameter("operande2");
        String res;

            
        
            switch (operation) {
            case "add":
                res = String.valueOf(Calculator.addition(operande1, operande2));
                operation = "addition";
                break;
            case "sub":
                res = String.valueOf(Calculator.soustraction(operande1, operande2));
                operation = "soustraction";
                break;
            case "div":
                if (Double.parseDouble(operande2) == 0) {
                     throw new ArithmeticException("Cannot divide by zero.");
                }
                res = String.valueOf(Calculator.division(operande1, operande2));
                operation = "division";
                break;
            case "mul":
                res = String.valueOf(Calculator.multiplication(operande1, operande2));
                operation = "multiplication";
                break;
            default:
                res = "<strong>Wrong operation!</strong>";
                operation = "incorrect";
                break;
            }
                
            String reponse = "";
                
            if (operande1 != null && operande2 != null) {
                reponse += "<p><span>Valeur de l'opérande 1 : </span><strong>" + operande1 + "</strong></p>";
                reponse += "<p><span>Valeur de l'opérande 2 : </span><strong>" + operande2 + "</strong></p>";
                reponse += "<p><span>Opération : </span><strong>" + operation + "</strong></p>";
                reponse += "<p><span>Résultat : </span><strong>" + res + "</strong></p>";
            } else {
                reponse = "<p>Les valeurs sont manquantes</p>";
            }

            reponse += "<button><a href='/calculatrice_frontend-1.0-SNAPSHOT/form_saisies_operation.html'>Home Page</a></button>";

            out.print(reponse);
        }
        catch (NumberFormatException | ArithmeticException | IOException e) {
            request.setAttribute("jakarta.servlet.error.exception", e);
            request.setAttribute("jakarta.servlet.error.message", e.getMessage());
            request.getRequestDispatcher("/handleException").forward(request, response);
        }
    }

}
