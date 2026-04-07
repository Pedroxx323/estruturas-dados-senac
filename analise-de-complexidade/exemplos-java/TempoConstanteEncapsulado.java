/**
 * Exemplo: TEMPO CONSTANTE ENCAPSULADO - O(1).
 *
 * <p>Demonstra o mesmo conceito de {@link TempoConstante}, agora com encapsulamento:
 * atributos privados, getters e setters. O número de operações continua fixo.
 *
 * <p>T(n) = 3 → O(1)
 */
public class TempoConstanteEncapsulado {

    // Atributos privados (encapsulamento)
    private int valorA;
    private int valorB;
    private int resultado;
    private int contadorOperacoes;

    /** Inicializa a instância com os dois operandos. */
    public TempoConstanteEncapsulado(int valorA, int valorB) {
        this.valorA = valorA;
        this.valorB = valorB;
        this.resultado = 0;
        this.contadorOperacoes = 0;
    }

    // Getters
    public int getValorA()            { return valorA; }
    public int getValorB()            { return valorB; }
    public int getResultado()         { return resultado; }
    public int getContadorOperacoes() { return contadorOperacoes; }

    // Setters
    public void setValorA(int valorA) { this.valorA = valorA; }
    public void setValorB(int valorB) { this.valorB = valorB; }

    /**
     * Realiza a soma dos atributos em tempo constante - O(1).
     *
     * <p>Contagem de operações:
     * <pre>
     *   reinicialização + soma aritmética + incremento = 3 ops
     *   T(n) = 3 → regras de Big O → O(1)
     * </pre>
     *
     * <p>Por que é O(1)? Idêntico a {@link TempoConstante#calcularSoma},
     * mas opera em atributos em vez de parâmetros. Número de operações fixo.
     */
    public void calcularSoma() {
        contadorOperacoes = 0;         // O(1)
        resultado = valorA + valorB;   // O(1) - operação aritmética
        contadorOperacoes++;           // O(1)
    }

    /** Exibe os valores e resultado formatados no console. */
    public void exibirResultado() {
        System.out.println("Valores: " + valorA + " + " + valorB);
        System.out.println("Resultado: " + resultado);
        System.out.println("Operações realizadas: " + contadorOperacoes);
        System.out.println("Complexidade: O(1) - TEMPO CONSTANTE");
    }

    public static void main(String[] args) {
        // Ambas as instâncias executam calcularSoma() em O(1)

        // Primeira instância
        TempoConstanteEncapsulado tempo1 = new TempoConstanteEncapsulado(5, 3);
        tempo1.calcularSoma();
        System.out.println("--- Instância 1 ---");
        tempo1.exibirResultado();

        System.out.println();

        // Segunda instância
        TempoConstanteEncapsulado tempo2 = new TempoConstanteEncapsulado(100, 200);
        tempo2.calcularSoma();
        System.out.println("--- Instância 2 ---");
        tempo2.exibirResultado();

        System.out.println();

        // Setters também são O(1): apenas atribuição de valor
        System.out.println("--- Modificando valores da Instância 1 ---");
        tempo1.setValorA(50);
        tempo1.setValorB(75);
        tempo1.calcularSoma();
        tempo1.exibirResultado();
    }
}
