//
package lab8p1_aaroncastillo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab8P1_AaronCastillo {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("*****Menu*****");
        System.out.println("1. Game of Life");
        System.out.println("Ingrese cualquier otro numero para salir");
        System.out.print("Ingrse su opcion: ");
        int opcion = leer.nextInt();
        while (opcion > 0 && opcion < 2) {
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de rondas: ");
                    int rondas = leer.nextInt();
                    int fila = 10;
                    int columna = fila;
                    Game xd= new Game(fila,columna);
                    int matrices[][] = new int[fila][columna];
                    matrices = xd.llenar();
                    ArrayList<String> coordenada = new ArrayList<>();
                    System.out.println("Coordenadas del tablero inicial:");
                    xd.imprimir(matrices);
                    xd.print(matrices, coordenada);
                    int matrices2[][] = new int[matrices.length][matrices[0].length];
                    matrices2 = matrices;
                    xd.jugar(rondas, matrices2, matrices);
                    break;
            }
            System.out.println();
            System.out.println("*****Menu*****");
            System.out.println("1. Game of Life");
            System.out.println("Ingrese cualquier otro numero para salir");
            System.out.print("Ingrse su opcion: ");
            opcion = leer.nextInt();
        }
    }

    

}
