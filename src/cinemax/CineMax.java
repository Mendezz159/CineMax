/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemax;

/**
 *
 * @author HP PORTATIL
 */
public class CineMax {
    public static void main(String[] args) {
        int[][] asistencia = new int[15][7]; // Matriz de asistencia

        // Inicialización de la matriz con valores aleatorios
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 7; j++) {
                asistencia[i][j] = (int) (Math.random() * 100); // Valores aleatorios entre 0 y 99
            }
        }

        // Cálculo de la cantidad total de personas que han visto cada película
        int[] totalAsistencia = new int[15]; // Arreglo para almacenar los totales de asistencia
        for (int i = 0; i < 15; i++) {
            int total = 0;
            for (int j = 0; j < 7; j++) {
                total += asistencia[i][j];
            }
            totalAsistencia[i] = total;
        }

        // Determinación de la película más vista
        int peliculaMasVista = 0;
        int maxAsistencia = totalAsistencia[0];
        for (int i = 1; i < 15; i++) {
            if (totalAsistencia[i] > maxAsistencia) {
                peliculaMasVista = i;
                maxAsistencia = totalAsistencia[i];
            }
        }

        // Determinación de la mejor combinación sala-película, más vista
        int salaMasVista = 0;
        maxAsistencia = asistencia[peliculaMasVista][0];
        for (int i = 1; i < 7; i++) {
            if (asistencia[peliculaMasVista][i] > maxAsistencia) {
                salaMasVista = i;
                maxAsistencia = asistencia[peliculaMasVista][i];
            }
        }

        // Impresión de resultados
        System.out.println(matrizToString(asistencia));
        System.out.println("La película más vista es la número " + (peliculaMasVista + 1));
        System.out.println("La mejor combinación sala-película, más vista, es la sala número " + (salaMasVista + 1) + " con la película número " + (peliculaMasVista + 1));
    }
    
    public static String matrizToString(int[][] matriz) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            sb.append(matriz[i][j]);
            sb.append("\t"); // \t para separar las columnas
        }
        sb.append("\n"); // Salto de línea para separar las filas
    }
    return sb.toString();
}
}
