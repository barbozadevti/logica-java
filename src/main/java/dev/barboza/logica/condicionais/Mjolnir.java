package dev.barboza.logica.condicionais;

import java.util.Scanner;

/**
 * Mjölnir: só quem é digno (o Thor) levanta o martelo, não importa a força aplicada.
 * Lê C casos (nome e força) e imprime Y ou N para cada um.
 */
public class Mjolnir {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < casos; i++) {
            String nome = sc.next();
            sc.nextInt(); // a força é lida, mas não decide nada: o martelo não obedece à física
            saida.append(nome.equals("Thor") ? 'Y' : 'N').append('\n');
        }

        System.out.print(saida);
    }
}
