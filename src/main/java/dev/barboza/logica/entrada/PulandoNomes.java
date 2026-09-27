package dev.barboza.logica.entrada;

import java.util.Scanner;

/**
 * Lê 10 nomes (um por linha, sem espaços) e imprime o 3º, o 7º e o 9º.
 */
public class PulandoNomes {

    private static final int TOTAL = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[TOTAL];

        for (int i = 0; i < TOTAL; i++) {
            nomes[i] = sc.next();
        }

        // Posições 3, 7 e 9 da lista (o vetor começa em 0).
        System.out.println(nomes[2]);
        System.out.println(nomes[6]);
        System.out.println(nomes[8]);
    }
}
