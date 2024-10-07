/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.metiers;

/**
 *
 * @author moham
 */
public class Calculator {
    
    public static double addition(String s_operande_1,String s_operande_2){
        return Double.valueOf(s_operande_1) + Double.valueOf(s_operande_2);
    }
    
    public static double soustraction(String s_operande_1,String s_operande_2){
        return Double.valueOf(s_operande_1) - Double.valueOf(s_operande_2);
    }
    
    public static double division(String s_operande_1,String s_operande_2){
        return Double.valueOf(s_operande_1) / Double.valueOf(s_operande_2);
    }
    
    public static double multiplication(String s_operande_1,String s_operande_2){
        return Double.valueOf(s_operande_1) * Double.valueOf(s_operande_2);
    }
}
