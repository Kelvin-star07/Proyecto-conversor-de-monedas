/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.conversor.de.monedas;

import Poryecto.conversor.de.monedas.tasaCambio.CalculadoraCambio;
import Poryecto.conversor.de.monedas.tasaCambio.ManejadorTasaCambio;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Principal {

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        ManejadorTasaCambio manejadorTasa = new ManejadorTasaCambio();
        CalculadoraCambio calculadora = new CalculadoraCambio();
        ManejadorMenu menu = new ManejadorMenu();
        boolean mostrar = true;

        while (mostrar) {
            menu.menu();
            int opcion = entrada.nextInt();
            double monto, tasa, resultado;

            switch (opcion) {
                case 1:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("USD", "ARS");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "USD", resultado, "ARS");
                    break;
                case 2:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("ARS", "USD");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "ARS", resultado, "USD");
                    break;
                case 3:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("USD", "BRL");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "USD", resultado, "BRL");
                    break;
                case 4:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("BRL", "USD");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "BRL", resultado, "USD");
                    break;
                case 5:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("USD", "COP");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "USD", resultado, "COP");
                    break;
                case 6:
                    System.out.println("Digita el valor que deseas convertir:");
                    monto = entrada.nextDouble();
                    tasa = manejadorTasa.obtenerTasaDeCambios("COP", "USD");
                    resultado = calculadora.convertirMoneda(monto, tasa);
                    imprimirResultado(monto, "COP", resultado, "USD");
                    break;
                case 7:
                    mostrar = false;
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción de conversión no válida.");
            }

            System.out.println();
        }
    }

    
    private static void imprimirResultado(double monto, String monedaBase, double resultado, String monedaDestino) {
        System.out.println("El valor " + monto + " " + monedaBase + " Corresponde al valor final de "
                + resultado + " " + monedaDestino);
    }
}
