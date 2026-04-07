/**
 * Exemplo: TEMPO CONSTANTE - O(1).
 *
 * <p>O método {@code calcularSoma} executa sempre o mesmo número fixo de operações,
 * independentemente dos valores da entrada.
 *
 * <p>T(n) = 5 → O(1)
 */
public class TempoConstante {

    /**
     * Soma dois inteiros em tempo constante.
     *
     * <p>Contagem de operações:
     * <pre>
     *   inicialização + soma aritmética + incremento + print + return = 5 ops
     *   T(n) = 5 → regras de Big O → O(1)
     * </pre>
     *
     * <p>Por que é O(1)? Nenhum loop ou recursão dependente da entrada.
     * Qualquer que seja o valor de {@code a} e {@code b}, sempre executa 5 operações.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return soma de a + b
     */
    public static int calcularSoma(int a, int b) {
        int contador = 0;                              // O(1)
        int resultado = a + b;                         // O(1) - operação aritmética
        contador++;                                    // O(1)
        System.out.println("Operações: " + contador); // O(1)
        return resultado;                              // O(1)
    }

    public static void main(String[] args) {
        // Ambas as chamadas executam exatamente 5 operações - comportamento O(1)
        System.out.println("Soma(5, 3): " + calcularSoma(5, 3));
        System.out.println("Soma(100, 200): " + calcularSoma(100, 200));
    }
}
