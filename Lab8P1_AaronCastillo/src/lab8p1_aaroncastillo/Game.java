
package lab8p1_aaroncastillo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    ArrayList<String> coordenada = new ArrayList<>();
    
    int fila,columna;
    
    public Game(int fila, int columna) {
        this.fila = fila;
        this.columna = fila;
    }

    public int[][] llenar() {
        int temporal[][] = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = 0;
                if (i == 0 || i == fila - 1 || j == 0 || j == columna - 1) {
                    temporal[i][j] = 0;
                } else {
                    temporal[i][j] = random.nextInt(2);
                }
            }
        }
        return temporal;
    }

    public void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void print(int[][] matrices, ArrayList<String> coordenada) {
        for (int i = 0; i < matrices.length; i++) {
            for (int j = 0; j < matrices[i].length; j++) {
                if (matrices[i][j] == 1) {
                    coordenada.add(i + ":" + j);
                }
            }
        }
        System.out.println("Coordenadas de celdas vivas:");
        System.out.println(coordenada);
        System.out.println();
        coordenada.clear();

    }

    public void jugar(int rondas, int [][]matrices2, int [][]matrices) {
        for (int i = 1; i < rondas+1; i++) {
            System.out.println("Ronda " + i);
            matrices2 = nexGen(matrices, matrices2);
            imprimir(matrices2);
            print(matrices2, coordenada);
            matrices2=matrices2;
            System.out.println();
        }
    }

    public int[][] nexGen(int[][] matrices, int[][] matrices2) {
        int cont;
        for (int i = 0; i < matrices2.length; i++) {
            for (int j = 0; j < matrices2[i].length; j++) {
                if (i == 9 || j == 9 || i == 0 || j == 0) {
                } else {
                    if (matrices2[i][j] == 1) {
                        cont = 0;
                        if (matrices2[i + 1][j + 1] == 1) {
                            cont++;
                        }
                        if (matrices2[i - 1][j - 1] == 1) {
                            cont++;
                        }
                        if (matrices2[i][j + 1] == 1) {
                            cont++;
                        }
                        if (matrices2[i][j - 1] == 1) {
                            cont++;
                        }
                        if (matrices2[i + 1][j] == 1) {
                            cont++;
                        }
                        if (matrices2[i - 1][j] == 1) {
                            cont++;
                        }
                        if (matrices2[i - 1][j + 1] == 1) {
                            cont++;
                        }
                        if (matrices2[i + 1][j - 1] == 1) {
                            cont++;
                        }
                        if (cont < 2) {
                            matrices2[i][j] = 0;
                        }
                        if (cont > 3) {
                            matrices2[i][j] = 0;
                        }
                        if (cont == 2) {
                            matrices2[i][j] = 1;
                        }

                    }
                    if (matrices2[i][j] == 0) {
                        int cont2 = 0;
                        if (matrices2[i + 1][j + 1] == 1) {
                            cont2++;
                        }
                        if (matrices2[i - 1][j - 1] == 1) {
                            cont2++;
                        }
                        if (matrices2[i][j + 1] == 1) {
                            cont2++;
                        }
                        if (matrices2[i][j - 1] == 1) {
                            cont2++;
                        }
                        if (matrices2[i + 1][j] == 1) {
                            cont2++;
                        }
                        if (matrices2[i - 1][j] == 1) {
                            cont2++;
                        }
                        if (matrices2[i - 1][j + 1] == 1) {
                            cont2++;
                        }
                        if (matrices2[i + 1][j - 1] == 1) {
                            cont2++;
                        }
                        if (cont2 == 3) {
                            matrices2[i][j] = 1;
                        }
                    }
                }
            }
        }
        return matrices2;
    }
}
