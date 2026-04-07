/**
 * Exemplo: TEMPO LINEAR - O(n).
 *
 * <p>O método {@code somarNumeros} percorre cada valor de 1 até {@code n} exatamente
 * uma vez. O número de operações cresce proporcionalmente à entrada.
 *
 * <p>T(n) = 2n + 4 → O(n)
 */
public class TempoLinear {

    /**
     * Soma os inteiros de 1 até n demonstrando complexidade O(n).
     *
     * <p>Contagem de operações:
     * <pre>
     *   - Inicializações:     2 × O(1) = 2        (termos de menor ordem)
     *   - Loop for: n iterações
     *       · soma += i       O(1) × n = n
     *       · contador++      O(1) × n = n
     *   - Print + return:     2 × O(1) = 2        (termos de menor ordem)
     *   T(n) = 2 + 2n + 2 = 2n + 4
     * </pre>
     *
     * <p>Aplicando Big O:
     * <ol>
     *   <li>Termo dominante: 2n</li>
     *   <li>Remove coeficiente: 2n → n</li>
     *   <li>Remove constante: n + 4 → n</li>
     * </ol>
     * Resultado: <b>O(n)</b>
     *
     * <p>Por que é linear? O loop executa exatamente n iterações. Se n dobra,
     * o tempo dobra (proporcionalidade direta: T(n) ∝ n).
     *
     * <p>Comparação:
     * <pre>
     *   O(1):      n=5 e n=10 → mesmo tempo
     *   O(log n):  n=5 → ~2 ops; n=10 → ~3 ops  (+1 apenas)
     *   O(n):      n=5 → 5 ops; n=10 → 10 ops   (dobra)  ← este caso
     *   O(n²):     n=5 → 25 ops; n=10 → 100 ops (4×)
     * </pre>
     *
     * @param n limite superior da soma (n ≥ 1)
     * @return soma de 1 + 2 + ... + n
     */
    public static int somarNumeros(int n) {
        int soma = 0;
        int contador = 0;

        // Loop executa n iterações - operação crítica que define O(n)
        for (int i = 1; i <= n; i++) {
            soma += i;   // O(1) × n iterações = O(n)
            contador++;  // O(1) × n iterações = O(n)
        }

        System.out.println("Operações: " + contador);
        return soma;
    }

    public static void main(String[] args) {
        System.out.println("Soma até 5: " + somarNumeros(5));   // 5 iterações
        System.out.println("Soma até 10: " + somarNumeros(10)); // 10 iterações
        // Dobramos n (5 → 10) e o número de operações dobrou - crescimento LINEAR
    }
}

