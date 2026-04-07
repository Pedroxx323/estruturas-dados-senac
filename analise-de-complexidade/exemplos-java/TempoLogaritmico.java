/**
 * Exemplo: TEMPO LOGARÍTMICO - O(log n).
 *
 * <p>O método {@code contarDivisoes} divide {@code n} por 2 repetidamente até atingir 1.
 * A cada iteração, o tamanho do problema é reduzido à metade.
 *
 * <p>T(n) = 4·log₂(n) + 4 → O(log n)
 */
public class TempoLogaritmico {

    /**
     * Conta quantas vezes n pode ser dividido por 2 - demonstra O(log n).
     *
     * <p>Contagem de operações:
     * <pre>
     *   - Inicializações:     2 × O(1) = 2             (termos de menor ordem)
     *   - Loop while: log₂(n) iterações
     *       · n = n / 2       O(1) × log₂(n)  ← operação crítica (divide problema)
     *       · divisoes++      O(1) × log₂(n)
     *       · contador++      O(1) × log₂(n)
     *       · println         O(1) × log₂(n)
     *       · Total: 4 × log₂(n)
     *   - Print + return:     2 × O(1) = 2             (termos de menor ordem)
     *   T(n) = 4·log₂(n) + 4
     * </pre>
     *
     * <p>Aplicando Big O:
     * <ol>
     *   <li>Remove coeficiente: 4·log₂(n) → log₂(n)</li>
     *   <li>Remove constante: log₂(n) + 4 → log₂(n)</li>
     *   <li>Base do log é irrelevante em Big O: log₂(n) ≡ log(n)</li>
     * </ol>
     * Resultado: <b>O(log n)</b>
     *
     * <p>Por que é logarítmico? A cada iteração o problema é dividido por 2.
     * Se n dobra (8 → 16), apenas 1 iteração é adicionada (3 → 4).
     * Para n = 1.000.000, apenas ~20 iterações!
     *
     * <p>Comparação:
     * <pre>
     *   O(n):      n=8 → 8 ops;  n=16 → 16 ops (dobra)
     *   O(log n):  n=8 → 3 ops;  n=16 → 4 ops  (+1 apenas!)  ← este caso
     * </pre>
     *
     * @param n valor a ser dividido (n ≥ 1)
     * @return número de divisões por 2 até chegar a 1
     */
    public static int contarDivisoes(int n) {
        int divisoes = 0;
        int contador = 0;

        // Loop executa log₂(n) iterações - operação crítica que define O(log n)
        while (n > 1) {
            n = n / 2;   // divide o problema pela metade a cada passo
            divisoes++;
            contador++;
            System.out.println("Passo " + contador + ": n = " + n);
        }

        System.out.println("Total de operações: " + contador);
        return divisoes;
    }

    public static void main(String[] args) {
        System.out.println("n=8:");
        contarDivisoes(8);   // log₂(8) = 3 iterações

        System.out.println("\nn=16:");
        contarDivisoes(16);  // log₂(16) = 4 iterações (+1 apenas!)

        // Dobramos n (8 → 16) e apenas 1 operação foi adicionada - crescimento LOGARÍTMICO
    }
}

