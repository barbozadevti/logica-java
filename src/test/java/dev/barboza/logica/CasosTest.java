package dev.barboza.logica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Juiz local: para cada pasta em {@code src/test/resources/casos/<classe>},
 * executa o {@code main} da classe com cada {@code N.in} como entrada padrão
 * e compara a saída com {@code N.out}.
 */
class CasosTest {

    @TestFactory
    Stream<DynamicContainer> casos() throws IOException, URISyntaxException {
        Path raiz = Path.of(getClass().getResource("/casos").toURI());
        return Files.list(raiz).sorted().map(pasta -> {
            String classe = pasta.getFileName().toString();
            return DynamicContainer.dynamicContainer(classe, casosDa(pasta, classe));
        });
    }

    private Stream<DynamicTest> casosDa(Path pasta, String classe) {
        try {
            return Files.list(pasta)
                    .filter(p -> p.toString().endsWith(".in"))
                    .sorted()
                    .map(entrada -> DynamicTest.dynamicTest(entrada.getFileName().toString(), () -> {
                        Path esperada = Path.of(entrada.toString().replaceFirst("\\.in$", ".out"));
                        assertEquals(normalizar(Files.readString(esperada)),
                                normalizar(executar(classe, Files.readString(entrada))));
                    }));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String executar(String classe, String entrada) throws Exception {
        InputStream inOriginal = System.in;
        PrintStream outOriginal = System.out;
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(saida, true, StandardCharsets.UTF_8));
            Method main = Class.forName(classe).getMethod("main", String[].class);
            main.invoke(null, (Object) new String[0]);
        } finally {
            System.setIn(inOriginal);
            System.setOut(outOriginal);
        }
        return saida.toString(StandardCharsets.UTF_8);
    }

    /** Ignora diferenças de fim de linha (CRLF/LF) e a quebra final, como os juízes online. */
    private static String normalizar(String texto) {
        return texto.replace("\r\n", "\n").stripTrailing();
    }
}
