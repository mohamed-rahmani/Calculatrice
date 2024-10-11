package fr.devavance.calculatrice.exceptions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorExceptionHandler", urlPatterns = {"/handleException"})
public class CalculatorExceptionHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleException(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleException(request, response);
    }

    private void handleException(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
        String exceptionType = (throwable != null) ? throwable.getClass().getName() : "Type d'exception inconnu";
        String exceptionMessage = (throwable != null) ? throwable.getMessage() : "Pas de message disponible";

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Détails de l'exception</title></head><body>");
            out.println("<h3>Une erreur s'est produite dans l'application</h3>");
            out.println("<p><strong>Type d'exception :</strong> " + exceptionType + "</p>");
            out.println("<p><strong>Message de l'exception :</strong> " + exceptionMessage + "</p>");
            out.println("<button><a href='/calculatrice_frontend-1.0-SNAPSHOT/form_saisies_operation.html'>Retour à la page d'accueil</a></button>");
            out.println("</body></html>");
        }
    }
}
