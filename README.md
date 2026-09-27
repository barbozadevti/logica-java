# Lógica em Java

[![CI](https://github.com/barbozadevti/logica-java/actions/workflows/ci.yml/badge.svg)](https://github.com/barbozadevti/logica-java/actions/workflows/ci.yml)

Problemas de lógica de programação resolvidos em **Java 21**, no formato de juiz online: o programa lê a entrada padrão e escreve a resposta na saída padrão.

Cada solução é conferida por um **juiz local automatizado** (JUnit 5): o teste executa o `main` da classe com cada arquivo de entrada e compara a saída com a resposta esperada. O GitHub Actions roda todos os casos a cada push.

## Problemas

| # | Problema | Categoria | Conceitos | Solução | Casos |
|---|----------|-----------|-----------|---------|-------|
| 1 | Produto de dois inteiros (`PROD = X`) | Matemática | leitura com `Scanner`, operadores aritméticos, concatenação | [Produto.java](src/main/java/dev/barboza/logica/matematica/Produto.java) | [4 casos](src/test/resources/casos/dev.barboza.logica.matematica.Produto) |
| 2 | Soma de dois inteiros (`SOMA = X`) | Matemática | leitura com `Scanner`, operadores aritméticos, concatenação | [Soma.java](src/main/java/dev/barboza/logica/matematica/Soma.java) | [5 casos](src/test/resources/casos/dev.barboza.logica.matematica.Soma) |
| 3 | Média ponderada de duas notas (`MEDIA = X.XXXXX`) | Matemática | `double`, média ponderada, formatação com `String.format`, `Locale` | [MediaPonderada.java](src/main/java/dev/barboza/logica/matematica/MediaPonderada.java) | [6 casos](src/test/resources/casos/dev.barboza.logica.matematica.MediaPonderada) |
| 4 | Pedra, Papel, Ataque Aéreo (N partidas) | Condicionais | `switch` expression, regras de vitória, leitura de N casos, `StringBuilder` | [PedraPapelAtaqueAereo.java](src/main/java/dev/barboza/logica/condicionais/PedraPapelAtaqueAereo.java) | [3 casos (11 partidas)](src/test/resources/casos/dev.barboza.logica.condicionais.PedraPapelAtaqueAereo) |
| 5 | Pulando nomes (3º, 7º e 9º de 10) | Entrada e saída | vetor (`String[]`), índices começando em 0, leitura com `next()` | [PulandoNomes.java](src/main/java/dev/barboza/logica/entrada/PulandoNomes.java) | [3 casos](src/test/resources/casos/dev.barboza.logica.entrada.PulandoNomes) |

## Como rodar

Requer JDK 21 e Maven.

```bash
mvn test
```

Para executar uma solução manualmente:

```bash
mvn -q compile
echo "3 9" | java -cp target/classes dev.barboza.logica.matematica.Produto
```

## Como adicionar um problema

1. Crie a classe com `main` em `src/main/java/dev/barboza/logica/<categoria>/`.
2. Crie a pasta `src/test/resources/casos/<nome.completo.da.Classe>/` com pares `1.in` / `1.out`, `2.in` / `2.out`...
3. Rode `mvn test`. O juiz local descobre a pasta sozinho.

## Estrutura

```
src/
├── main/java/dev/barboza/logica/   soluções, separadas por categoria
└── test/
    ├── java/.../CasosTest.java      juiz local (testes dinâmicos)
    └── resources/casos/             entradas e saídas esperadas
```
