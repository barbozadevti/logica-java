package dev.barboza.logica.matematica;

import java.util.Scanner;

/**
 * Lê dois inteiros e imprime a soma no formato {@code SOMA = X}.
 */
public class Soma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int soma = a + b;

        System.out.println("SOMA = " + soma);
    }
}
