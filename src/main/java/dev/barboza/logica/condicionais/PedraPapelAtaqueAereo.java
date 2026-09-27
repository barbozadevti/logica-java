package dev.barboza.logica.condicionais;

import java.util.Scanner;

/**
 * Pedra, Papel, Ataque Aéreo: lê N partidas (dois sinais cada) e informa o resultado de cada uma.
 * Ataque vence Pedra e Papel; Pedra vence Papel; sinais iguais têm resultados especiais.
 */
public class PedraPapelAtaqueAereo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next().trim());
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String jogador1 = sc.next().trim().toLowerCase();
            String jogador2 = sc.next().trim().toLowerCase();
            saida.append(resultado(jogador1, jogador2)).append('\n');
        }

        System.out.print(saida);
    }

    static String resultado(String jogador1, String jogador2) {
        if (jogador1.equals(jogador2)) {
            return switch (jogador1) {
                case "papel" -> "Ambos venceram";
                case "pedra" -> "Sem ganhador";
                default -> "Aniquilacao mutua";
            };
        }
        return vence(jogador1, jogador2) ? "Jogador 1 venceu" : "Jogador 2 venceu";
    }

    /** Sinais diferentes: o ataque vence tudo e a pedra vence o papel. */
    private static boolean vence(String sinal, String outro) {
        return sinal.equals("ataque") || (sinal.equals("pedra") && outro.equals("papel"));
    }
}
