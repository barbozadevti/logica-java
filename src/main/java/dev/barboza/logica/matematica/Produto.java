package dev.barboza.logica.matematica;

import java.util.Scanner;

/**
 * Lê dois inteiros e imprime o produto no formato {@code PROD = X}.
 */
public class Produto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int prod = a * b;

        System.out.println("PROD = " + prod);
    }
}
