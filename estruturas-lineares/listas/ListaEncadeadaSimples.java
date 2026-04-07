import java.util.NoSuchElementException;

/**
 * Implementacao de lista encadeada simples (singly linked list).
 *
 * Sobre o generico T:
 * - T e um "placeholder" para tipo.
 * - Quando alguem cria ListaEncadeadaSimples<Integer>, T vira Integer.
 * - Quando cria ListaEncadeadaSimples<String>, T vira String.
 *
 * Isso permite reaproveitar a mesma estrutura para diferentes tipos de dado.
 *
 * @param <T> tipo de dado armazenado na lista
 */
public class ListaEncadeadaSimples<T> {

    /**
     * No interno da lista. Fica privado para encapsular a implementacao.
     *
     * "private" significa que apenas esta classe pode acessar esse tipo.
     * Quem usa a lista nao manipula nos diretamente; usa os metodos publicos.
     */
    private static class No<T> {
        // Dado armazenado no no.
        private T valor;

        // Referencia para o proximo no da cadeia. Se for null, e o ultimo no.
        private No<T> proximo;

        private No(T valor) {
            this.valor = valor;
        }
    }

    // Ponteiro para o primeiro no da lista.
    private No<T> head;

    // Quantidade de elementos. Mantemos esse contador para consultar tamanho em O(1).
    private int size;

    /**
     * Verifica se a lista esta vazia.
     * Complexidade: O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna a quantidade de elementos da lista.
     * Complexidade: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Insere elemento no inicio da lista.
     *
     * Passos:
     * 1) novo no aponta para o antigo head
     * 2) head passa a ser o novo no
     *
     * Complexidade: O(1)
     */
    public void addFirst(T valor) {
        // Cria o novo no com o valor recebido.
        No<T> novo = new No<>(valor);

        // Novo no aponta para o antigo inicio.
        novo.proximo = head;

        // O novo no passa a ser o inicio da lista.
        head = novo;
        size++;
    }

    /**
     * Insere elemento no final da lista.
     *
     * Como esta implementacao nao guarda ponteiro para cauda,
     * precisamos percorrer ate o ultimo no.
     *
     * Complexidade: O(n)
     */
    public void addLast(T valor) {
        No<T> novo = new No<>(valor);

        if (head == null) {
            // Se a lista estiver vazia, inserir no fim e o mesmo que inserir no inicio.
            head = novo;
            size++;
            return;
        }

        No<T> atual = head;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        // Conecta o ultimo no existente ao novo no.
        atual.proximo = novo;
        size++;
    }

    /**
     * Busca um valor na lista.
     *
     * Percorre sequencialmente ate encontrar ou chegar ao fim.
     *
     * Complexidade: O(n)
     */
    public boolean contains(T valor) {
        No<T> atual = head;

        while (atual != null) {
            // Comparacao segura para valores nulos e nao nulos.
            if ((valor == null && atual.valor == null)
                    || (valor != null && valor.equals(atual.valor))) {
                return true;
            }
            atual = atual.proximo;
        }

        return false;
    }

    /**
     * Retorna o elemento do indice informado.
     *
     * Como nao existe acesso direto por indice na lista encadeada,
     * caminhamos no a no ate chegar ao indice.
     *
     * Complexidade: O(n)
     */
    public T get(int index) {
        validarIndice(index);

        // Caminha a partir do head ate o indice desejado.
        No<T> atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }

        return atual.valor;
    }

    /**
     * Remove o primeiro elemento da lista e retorna seu valor.
     *
     * Basta mover head para o proximo no.
     *
     * Complexidade: O(1)
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        T removido = head.valor;

        // O segundo no (se existir) vira o novo head.
        head = head.proximo;
        size--;
        return removido;
    }

    /**
     * Remove o ultimo elemento da lista e retorna seu valor.
     *
     * Precisamos encontrar o penultimo no para ajustar o ponteiro.
     *
     * Complexidade: O(n)
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Lista vazia");
        }

        if (head.proximo == null) {
            T removido = head.valor;
            head = null;
            size--;
            return removido;
        }

        No<T> atual = head;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        T removido = atual.proximo.valor;

        // Desconecta o ultimo no; 'atual' passa a ser o novo ultimo.
        atual.proximo = null;
        size--;
        return removido;
    }

    /**
     * Remove a primeira ocorrencia do valor informado.
     *
     * Retorna true se removeu, false se nao encontrou.
     *
     * Complexidade: O(n)
     */
    public boolean removeByValue(T valor) {
        if (isEmpty()) {
            return false;
        }

        if ((valor == null && head.valor == null)
                || (valor != null && valor.equals(head.valor))) {
            // Caso especial: valor esta no primeiro no.
            head = head.proximo;
            size--;
            return true;
        }

        No<T> atual = head;
        while (atual.proximo != null) {
            boolean encontrou = (valor == null && atual.proximo.valor == null)
                    || (valor != null && valor.equals(atual.proximo.valor));

            if (encontrou) {
                // "Pula" o no encontrado, removendo-o da cadeia.
                atual.proximo = atual.proximo.proximo;
                size--;
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    /**
     * Limpa a lista.
     *
     * Ajustar head para null e size para 0 torna os nos antigos
     * elegiveis para coleta de lixo.
     *
     * Complexidade: O(1)
     */
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No<T> atual = head;

        while (atual != null) {
            sb.append(atual.valor);
            if (atual.proximo != null) {
                sb.append(" -> ");
            }
            atual = atual.proximo;
        }

        sb.append("]");
        return sb.toString();
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Indice " + index + " fora do intervalo [0, " + (size - 1) + "]");
        }
    }
}
