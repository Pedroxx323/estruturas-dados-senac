/**
 * Exemplo: TEMPO QUADRÁTICO - O(n²).
 *
 * <p>O método {@code multiplicar} simula a multiplicação {@code a × b} via incrementos
 * sucessivos com dois loops aninhados. Quando {@code a = b = n}, executa n² operações.
 *
 * <p>T(a,b) = 2ab + 4 → O(a×b) → O(n²) quando a = b = n
 */
public class TempoQuadratico {

    /**
     * Multiplica a × b por incrementos sucessivos - demonstra O(a×b) ≈ O(n²).
     *
     * <p>Contagem de operações:
     * <pre>
     *   - Inicializações:     2 × O(1) = 2        (termos de menor ordem)
     *   - Loop externo: a iterações
     *       · Loop interno: b iterações por iteração externa
     *           - resultado++  O(1) × (a×b)
     *           - contador++   O(1) × (a×b)
     *       · Total interno por iteração externa: 2b
     *   - Total dos loops: a × 2b = 2ab
     *   - Print + return:     2 × O(1) = 2        (termos de menor ordem)
     *   T(a,b) = 2ab + 4
     * </pre>
     *
     * <p>Caso especial a = b = n: T(n) = 2n² + 4<br>
     * Aplicando Big O: remove coeficiente (2n²→n²) e constante (+4) → <b>O(n²)</b>
     *
     * <p>Por que é quadrático? Loops aninhados onde ambos dependem da entrada.
     * Se n dobra (5→10), operações quadruplicam (25→100). Crescimento 4× para 2×n.
     *
     * <p>Algoritmos clássicos O(n²): Bubble Sort, Selection Sort, Insertion Sort,
     * multiplicação de matrizes (algoritmo ingênuo), comparação par a par.
     *
     * <p>Comparação:
     * <pre>
     *   O(n):      n=5 → 5 ops;   n=10 → 10 ops  (dobra)
     *   O(n log n): n=5 → ~12 ops; n=10 → ~33 ops (2.75×)
     *   O(n²):     n=5 → 25 ops;  n=10 → 100 ops (4×)  ← este caso
     * </pre>
     *
     * @param a linhas da "grade" (dimensão do loop externo)
     * @param b colunas da "grade" (dimensão do loop interno)
     * @return resultado de a × b
     */
    public static int multiplicar(int a, int b) {
        int resultado = 0;
        int contador = 0;

        // Loop externo: a iterações - primeira dimensão da complexidade quadrática
        for (int i = 0; i < a; i++) {
            // Loop interno: b iterações para CADA iteração externa
            // Total: a × b operações → O(n²) quando a = b = n
            for (int j = 0; j < b; j++) {
                resultado++;
                contador++;
            }
        }

        System.out.println("Operações: " + contador);
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("3 × 4 = " + multiplicar(3, 4));
        // a=3, b=4: 3 × 4 = 12 operações

        System.out.println("5 × 5 = " + multiplicar(5, 5));
        // a=5, b=5: 5 × 5 = 25 operações (quando a=b=n, caracteriza n²)

        // Dobramos ambos os valores (5→10): 25 → 100 operações (quadruplicou!) → O(n²)
    }
}
