package dev.barboza.logica.matematica;

import java.util.Locale;
import java.util.Scanner;

/**
 * Lê duas notas (pesos 3.5 e 7.5) e imprime a média ponderada com 5 casas: {@code MEDIA = X.XXXXX}.
 * Usa {@link Locale#US} na leitura e na escrita para aceitar e exibir o ponto decimal
 * independentemente do idioma da máquina.
 */
public class MediaPonderada {

    private static final double PESO_A = 3.5;
    private static final double PESO_B = 7.5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double media = (a * PESO_A + b * PESO_B) / (PESO_A + PESO_B);

        System.out.println(String.format(Locale.US, "MEDIA = %.5f", media));
    }
}
