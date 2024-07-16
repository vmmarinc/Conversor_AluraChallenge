package com.conversor.conversormoneda.principal;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.source.util.SourcePositions;

import java.util.Scanner;
public class Conversor {
    public static void main(String[] args) {

        int opcion= 10;


        Scanner scanner = new Scanner(System.in);

        String saludo = "\033[1m\033[34m¡¡¡¡Bienvenido a ExchangeXpert !!!!! \033[0m";
        printCentered(saludo);

        System.out.println("\033[34m Convierte tus monedas de forma rápida y precisa con nuestro innovador conversor.\033[0m");
        System.out.println();
        System.out.print("\033[34m Por favor, introduce tu nombre: \033[0m");
        String nombre = scanner.nextLine();
        System.out.println("\033[1m\033[32m¡Un placer saludarte, " + nombre + "! Como podemos ayudarte.\033[0m");


        while (true) {
            // Mostrar el menú
            printMenu();

            // Leer la opción del usuario
            System.out.print("Elige una opción: ");
            //int opcion = scanner.nextInt();
            opcion = scanner.nextInt();

            if (opcion == 8) {
                System.out.println("\033[1m\033[31mGracias por usar el conversor de monedas. ¡Adiós!\033[0m");
                break;
            }
            if (opcion < 0 || opcion > 8) {
                System.out.println("\033[1m\033[31m Elige una opcion valida. ¡¡¡¡¡PORFIS !!!!!! \033[0m");
                continue;
            }
            System.out.print("Introduce la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            // Realizar la conversión
            double resultado = 0.0;
            String mensajeResultado = "";

            switch (opcion) {
                case 1:
                    resultado = convertirMoneda("USD", "EUR", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " USD son " + resultado + " EUR.\033[0m";
                    System.out.println();

                    break;
                case 2:
                    resultado = convertirMoneda("EUR", "USD", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " EUR son " + resultado + " USD.\033[0m";
                    System.out.println();
                    break;
                case 3:
                    resultado = convertirMoneda("USD", "COP", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " USD son " + resultado + " Pesos Colombianos.\033[0m";
                    System.out.println();
                    break;
                case 4:
                    resultado = convertirMoneda("COP", "USD", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " Pesos Colombianos son " + resultado + " USD.\033[0m";
                    System.out.println();
                    break;
                case 5:
                    resultado = convertirMoneda("USD", "BRL", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " USD son " + resultado + " Reales.\033[0m";
                    System.out.println();
                    break;
                case 6:
                    resultado = convertirMoneda("BRL", "USD", cantidad);
                    mensajeResultado = "\033[1m\033[32m" + cantidad + " Reales son " + resultado + " USD.\033[0m";
                    System.out.println();
                    break;
                default:
                    System.out.println("\033[1m\033[31m Elige una opcion valida. ¡¡¡¡¡PORFIS !!!!!! \033[0m");
                    System.out.println();
                    continue;
            }

            // Mostrar el resultado
            printCentered(mensajeResultado);
        }

    }

    private static double convertirMoneda(String fromCurrency, String toCurrency, double cantidad) {
        double tasaCambio = ExchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);
        return cantidad * tasaCambio;
    }

// Primera prueba con tasas estaticas no de API
//    private static double convertirRealToUSD(double cantidad) {
//        return cantidad /3;
//    }
//
//    private static double convertirUSDtoReal(double cantidad) {
//        return cantidad *3;
//
//    }
//
//    private static double convertirColtoUSD(double cantidad) {
//        return cantidad /4000;
//
//    }
//
//    private static double convertirUsdToColo(double cantidad) {
//        return cantidad * 4000;
//    }
//
//    private static double convertirEurToUsd(double cantidad) {
//
//        return cantidad * 1.18;
//    }
//
//    private static double convertirUsdToEur(double cantidad) {
//
//        return cantidad * 0.85;
//    }


    private static void printMenu () {
        String menu = "\033[1m\033[34m" +
                "\n"+
                "***************************\n" +
                "Elige una opcion:\n" +
                "1. Convertir USD a EUR\n" +
                "2. Convertir EUR a USD\n" +
                "3. Convertir USD a Peso Colombiano\n" +
                "4. Convertir Peso Colombiano a USD\n" +
                "5. Convertir USD a Real\n" +
                "6. Convertir Real a Dolar\n" +
                "8. Salir\n" +
                "***************************\n" +
                "\033[0m";
        printCentered(menu);
    }

    private static void printCentered(String message) {
        int consoleWidth = 90; // Ancho de la consola estimado
        int messageLength = message.length();
        int spaces = (consoleWidth - messageLength) / 2;

        if (spaces > 0) {
            String padding = " ".repeat(spaces);
            System.out.println(padding + message);
        } else {
            System.out.println(message);
        }
        //Método menu

    }
}

