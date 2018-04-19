/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Calculator;
import es.albarregas.models.Divisor;
import es.albarregas.models.Multiplicador;
import es.albarregas.models.Restador;
import es.albarregas.models.Sumador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            LocalDate hoy = LocalDate.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            System.out.println(hoy.format(fmt));
            Calculator calculadora = new Calculator();
            
            
            int operando1;
            int operando2;
            String operacion;
            String url;
            boolean error;
            try {
                
                operando1 = Integer.parseInt(request.getParameter("operando1"));
                operando2 = Integer.parseInt(request.getParameter("operando2"));
                operacion = request.getParameter("operacion");
                error = false;

                Sumador sumador;
                Restador restador;
                Multiplicador multiplicador;
                Divisor divisor;
                
                switch (operacion) {
                    case "sumar":
                        System.out.println("Entro a sumar");
                        sumador = new Sumador();
                        calculadora.setResultado(sumador.sumar(operando1, operando2));
                        calculadora.setSigno("+");
                        break;
                    case "restar":
                        System.out.println("Entro a restar");
                        restador = new Restador();
                        calculadora.setResultado(restador.restar(operando1, operando2));
                        calculadora.setSigno("-");
                        break;
                    case "multiplicar":
                        System.out.println("Entro a multiplicar");
                        multiplicador = new Multiplicador();
                        calculadora.setResultado(multiplicador.multiplicar(operando1, operando2));
                        calculadora.setSigno("*");
                        break;
                    case "dividir":
                        System.out.println("Entro a dividir");
                        divisor = new Divisor();
                        calculadora.setResultado(divisor.dividir(operando1, operando2));
                        calculadora.setSigno("/");
                        if (calculadora.getResultado() == Integer.MAX_VALUE) {
                            error = true;
                        }

                }
                System.out.println(error);
                if (error) {
                    System.out.println("Se a dividido por 0");
                    calculadora.setError("El divisor es 0, operacion imposible!");
                    url = "JSP/error.jsp";
                } else {
                    
                    calculadora.setFecha(hoy.format(fmt));
                    calculadora.setOperando1(operando1);
                    calculadora.setOperando2(operando2);
                    url = "JSP/resultado.jsp";
                    System.out.println("LLego hasta aqui?");
                }
            } catch (NumberFormatException e) {
                calculadora.setError("Alguno de los operandos no es un número o contiene caracteres");
                url = "/JSP/error.jsp";

            }

            request.setAttribute("calculadora", calculadora);
            System.out.println("Y pongo la variable en sesion");
            System.out.println(url);
            request.getRequestDispatcher(url).forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
