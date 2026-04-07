/**
 * Exemplo: TEMPO LINEARÍTMICO - O(n log n).
 *
 * <p>O método {@code operacaoComposta} combina um loop externo O(n) com um loop
 * interno O(log i): para cada um dos n valores, divide {@code temp} por 2 até 1.
 *
 * <p>T(n) = Σ(i=1..n) log₂(i) = log₂(n!) ≈ n·log₂(n) → O(n log n)
 */
public class TempoLinearitmico {

    /**
     * Demonstra complexidade O(n log n) com loops de ordens diferentes aninhados.
     *
     * <p>Estrutura dos loops:
     * <pre>
     *   Loop externo:   n iterações                        → O(n)
     *   Loop interno:   log₂(i) iterações para cada i     → O(log n) em média
     *   Combinado:      Σ(i=1..n) log₂(i) = log₂(n!)
     * </pre>
     *
     * <p>Análise via aproximação de Stirling:
     * <pre>
     *   log₂(n!) ≈ n·log₂(n) − n·log₂(e) + (1/2)·log₂(2πn)
     * </pre>
     * Aplicando Big O: descarta termos de menor ordem → <b>O(n log n)</b>
     *
     * <p>Por que é linearítmico? O resultado NÃO é simplesmente n × log n, mas
     * o somatório Σ log(i) ≈ n log n. Cresce mais rápido que O(n) e mais devagar
     * que O(n²).
     *
     * <p>Algoritmos clássicos O(n log n): Merge Sort, Quick Sort (caso médio),
     * Heap Sort, construção de árvores balanceadas.
     *
     * <p>Comparação:
     * <pre>
     *   O(n):      n=8 → 8 ops;  n=16 → 16 ops  (dobra)
     *   O(n log n): n=8 → 24 ops; n=16 → 64 ops  (2.67×)  ← este caso
     *   O(n²):     n=8 → 64 ops; n=16 → 256 ops (4×)
     * </pre>
     *
     * @param n tamanho da entrada
     * @return número total de iterações dos loops internos
     */
    public static int operacaoComposta(int n) {
        int contador = 0;

        // Loop externo: n iterações - primeira dimensão da complexidade
        for (int i = 1; i <= n; i++) {
            int temp = i;

            // Loop interno: log₂(i) iterações - segunda dimensão O(log i)
            // Σ(i=1..n) log₂(i) = log₂(n!) ≈ n log n
            while (temp > 1) {
                temp = temp / 2; // divide por 2 → garante log₂(i) iterações
                contador++;
            }
        }

        System.out.println("Operações: " + contador);
        return contador;
    }

    public static void main(String[] args) {
        System.out.println("n=4: " + operacaoComposta(4));
        // Σ log₂(i) de i=1 até 4 ≈ 5 operações

        System.out.println("n=8: " + operacaoComposta(8));
        // Σ log₂(i) de i=1 até 8 ≈ 15 operações

        // Dobramos n (4→8) e as operações triplicaram (5→15)
        // Não dobrou como O(n) nem quadruplicou como O(n²) → crescimento O(n log n)
    }
}

