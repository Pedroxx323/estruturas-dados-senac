# Análise de Complexidade: O(log n) - Tempo Logarítmico

## O que é Tempo Logarítmico O(log n)?

**Tempo Logarítmico (O(log n))** é uma das complexidades mais eficientes em análise de algoritmos. Significa que **o tempo de execução cresce logaritmicamente** em relação ao tamanho da entrada.

### Característica Principal:
> **Cada vez que dobramos o tamanho da entrada (n → 2n), apenas UMA operação adicional é necessária.**

**Intuição:** Em vez de processar todos os elementos, **dividimos o problema pela metade** a cada passo.

---

## Crescimento Logarítmico: Entendendo os Números

### Tabela de Crescimento

| Tamanho (n) | Iterações O(log₂ n) | Iterações O(n) | Diferença |
|-------------|---------------------|----------------|-----------|
| 10 | ~3 | 10 | 3x menor |
| 100 | ~7 | 100 | 14x menor |
| 1.000 | ~10 | 1.000 | 100x menor |
| 10.000 | ~13 | 10.000 | 769x menor |
| 1.000.000 | ~20 | 1.000.000 | 50.000x menor! |
| 1.000.000.000 | ~30 | 1.000.000.000 | 33.333.333x menor! |

**Observe:** Para 1 bilhão de elementos, O(log n) executa apenas ~30 operações!

### Por Que é Tão Eficiente?

Porque **logaritmo é o inverso da exponenciação**:
- Se $2^{10} = 1024$, então $\log_2(1024) = 10$
- Se $2^{20} = 1.048.576$, então $\log_2(1.048.576) = 20$

Enquanto a exponencial **explode** rapidamente, o logaritmo **cresce muito devagar**.

---

## Características de Algoritmos O(log n)

Um algoritmo tem complexidade **O(log n)** quando:

1. ✅ **Divide o problema pela metade** (ou por uma constante) a cada iteração
2. ✅ **Elimina metade das possibilidades** a cada passo
3. ✅ **Reduz o espaço de busca exponencialmente**
4. ✅ **Não precisa processar todos os elementos**

### Padrões Comuns de O(log n):

#### Padrão 1: Divisão por 2 Repetida
```java
while (n > 1) {
    n = n / 2;  // Divide pela metade
}
```

#### Padrão 2: Busca Binária
```java
while (inicio <= fim) {
    int meio = (inicio + fim) / 2;
    if (alvo == array[meio]) return meio;
    else if (alvo < array[meio]) fim = meio - 1;
    else inicio = meio + 1;
}
```

#### Padrão 3: Árvores Balanceadas
```java
// Busca em árvore binária de busca balanceada
// Altura da árvore = log₂(n)
// A cada nível, escolhe esquerda OU direita
```

---

## Análise Matemática de O(log n)

### Função de Complexidade

Quando dividimos n por 2 repetidamente até chegar a 1:

$$
n \rightarrow \frac{n}{2} \rightarrow \frac{n}{4} \rightarrow \frac{n}{8} \rightarrow \cdots \rightarrow 1
$$

Quantas divisões são necessárias? A resposta é:

$$
k = \log_2(n)
$$

Onde $k$ é o número de iterações.

### Prova Matemática

Se dividimos $n$ por $2$, $k$ vezes até chegar a $1$:

$$
\frac{n}{2^k} = 1
$$

Resolvendo para $k$:

$$
n = 2^k
$$

$$
k = \log_2(n)
$$

### Exemplo Numérico

Para $n = 16$:

1. $16 \div 2 = 8$
2. $8 \div 2 = 4$
3. $4 \div 2 = 2$
4. $2 \div 2 = 1$

**Total:** 4 iterações = $\log_2(16) = 4$

---

## Aplicando as Regras de Big O

### Regra 1: Remover Constantes Multiplicativas

Se temos:
$$T(n) = 4 \cdot \log_2(n) + 10$$

Removemos o coeficiente 4:
$$O(\log_2(n))$$

### Regra 2: Remover Termos de Menor Ordem

Se temos:
$$T(n) = \log_2(n) + 100$$

O termo constante 100 é **irrelevante** quando $n \rightarrow \infty$:
$$O(\log_2(n))$$

Exemplo: para $n = 1.000.000$:
- $\log_2(1.000.000) \approx 20$
- Termo: $20 + 100 = 120$
- Mas quando $n$ cresce, o $+100$ se torna negligível

### Regra 3: Base do Logaritmo Não Importa

Em Big O, **a base não importa** porque:

$$
\log_a(n) = \frac{\log_b(n)}{\log_b(a)}
$$

Então $\log_2(n)$ e $\log_{10}(n)$ diferem apenas por uma **constante multiplicativa** que removemos!

Portanto:
$$\log_2(n) \equiv \log_{10}(n) \equiv \log(n)$$

Em Big O, escrevemos simplesmente **O(log n)** sem especificar a base.

---

## O Código Logaritmico.java e sua Análise

### Estrutura do Código

```java
public static int contarDivisoes(int n) {
    int divisoes = 0;       // Linha 9: Operação 1 - O(1)
    int contador = 0;       // Linha 13: Operação 2 - O(1)
    
    while (n > 1) {         // Linha 21: Loop - executa log₂(n) vezes
        n = n / 2;          // Linha 25: Divisão - O(1) × log₂(n)
        divisoes++;         // Linha 29: Incremento - O(1) × log₂(n)
        contador++;         // Linha 33: Incremento - O(1) × log₂(n)
        System.out.println(...); // Linha 37: Print - O(1) × log₂(n)
    }
    
    System.out.println(...); // Linha 43: Print final - O(1)
    return divisoes;         // Linha 47: Retorno - O(1)
}
```

### Contagem Detalhada de Operações

| Seção do Código | Operações | Custo Individual | Repetições | Custo Total |
|-----------------|-----------|------------------|------------|-------------|
| Inicialização `divisoes` (linha 9) | 1 | O(1) | 1 vez | O(1) |
| Inicialização `contador` (linha 13) | 1 | O(1) | 1 vez | O(1) |
| **Loop while (linha 21)** | - | - | **log₂(n)** | - |
| └─ Divisão `n/2` (linha 25) | 1 | O(1) | log₂(n) | **O(log n)** |
| └─ Incremento `divisoes++` (linha 29) | 1 | O(1) | log₂(n) | **O(log n)** |
| └─ Incremento `contador++` (linha 33) | 1 | O(1) | log₂(n) | **O(log n)** |
| └─ Print (linha 37) | 1 | O(1) | log₂(n) | **O(log n)** |
| Print final (linha 43) | 1 | O(1) | 1 vez | O(1) |
| Return (linha 47) | 1 | O(1) | 1 vez | O(1) |

### Cálculo da Complexidade Total

#### Forma Expandida:
$$
T(n) = 2 + 4 \cdot \log_2(n) + 2
$$

$$
T(n) = 4 \cdot \log_2(n) + 4
$$

#### Aplicando as Regras de Big O:

**Passo 1:** Remover constante multiplicativa (4):
$$
4 \cdot \log_2(n) + 4 \rightarrow \log_2(n) + 4
$$

**Passo 2:** Remover termo de menor ordem (+4):
$$
\log_2(n) + 4 \rightarrow \log_2(n)
$$

**Passo 3:** Base não importa:
$$
\log_2(n) \rightarrow \log(n)
$$

#### Resultado Final:
$$
\boxed{O(\log n)}
$$

---

## Por Que contarDivisoes() é O(log n)?

### Razões Fundamentais:

#### 1. **Divisão por 2 a Cada Iteração**
```java
n = n / 2;  // Reduz o problema pela metade!
```
- Iteração 1: $n$
- Iteração 2: $n/2$
- Iteração 3: $n/4$
- Iteração 4: $n/8$
- ...
- Iteração k: $n/2^k = 1$

#### 2. **Número de Iterações = log₂(n)**

Exemplos concretos:
- $n = 8$: 8 → 4 → 2 → 1 = **3 iterações** = $\log_2(8) = 3$
- $n = 16$: 16 → 8 → 4 → 2 → 1 = **4 iterações** = $\log_2(16) = 4$
- $n = 1024$: **10 iterações** = $\log_2(1024) = 10$

#### 3. **Crescimento Logarítmico**

Quando dobramos $n$:
- $n = 8$ → 3 iterações
- $n = 16$ → 4 iterações **(+1 apenas!)**
- $n = 32$ → 5 iterações **(+1 apenas!)**

**Padrão:** Dobrar a entrada adiciona apenas **1 operação**.

#### 4. **Não Processa Todos os Elementos**

Diferente de O(n), **não precisamos visitar cada valor**:
- O(n) com $n=1000$: 1000 operações
- O(log n) com $n=1000$: ~10 operações

---

## Comparação com Outras Complexidades

### Visual: Crescimento Relativo

```
Tempo
  |          
  |    O(n²) ────────────→ [parábola explosiva]
  |   /
  | O(n) ──────────→ [linha diagonal]
  |O(log n) →______ [curva quase plana]
O(1) ════════════ [linha horizontal]
  |________________________________ Tamanho (n)
```

### Tabela Comparativa Detalhada

| n | O(1) | O(log n) | O(n) | O(n log n) | O(n²) |
|---|------|----------|------|------------|-------|
| 1 | 1 | 0 | 1 | 0 | 1 |
| 10 | 1 | 3 | 10 | 30 | 100 |
| 100 | 1 | 7 | 100 | 700 | 10.000 |
| 1.000 | 1 | 10 | 1.000 | 10.000 | 1.000.000 |
| 10.000 | 1 | 13 | 10.000 | 130.000 | 100.000.000 |
| 1.000.000 | 1 | 20 | 1.000.000 | 20.000.000 | 1.000.000.000.000 |

### Ranking de Eficiência

| Complexidade | Eficiência | Uso |
|--------------|-----------|-----|
| **O(1)** | ⚡⚡⚡⚡⚡ Melhor | Acesso direto, operações simples |
| **O(log n)** | ⚡⚡⚡⚡ Excelente | Busca binária, árvores balanceadas |
| **O(n)** | ⚡⚡⚡ Bom | Percorrer array, busca linear |
| **O(n log n)** | ⚡⚡ Aceitável | Ordenação eficiente (merge sort) |
| **O(n²)** | ⚡ Ruim | Loops aninhados, bubble sort |
| **O(2ⁿ)** | 🔥 Péssimo | Força bruta, subconjuntos |
| **O(n!)** | 🔥🔥 Inviável | Permutações completas |

---

## Exemplos Práticos de O(log n)

### ✅ Busca Binária em Array Ordenado
```java
public int buscaBinaria(int[] arr, int alvo) {
    int inicio = 0, fim = arr.length - 1;
    
    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        if (arr[meio] == alvo) return meio;
        else if (arr[meio] < alvo) inicio = meio + 1;
        else fim = meio - 1;
    }
    return -1;  // Não encontrado
}
// O(log n) - divide o espaço de busca pela metade
```

### ✅ Calcular Potência Eficientemente (Exponenciação Rápida)
```java
public long potencia(int base, int exp) {
    if (exp == 0) return 1;
    long half = potencia(base, exp / 2);
    if (exp % 2 == 0) return half * half;
    else return half * half * base;
}
// O(log n) - divide o expoente pela metade
```

### ✅ Árvore Binária de Busca Balanceada
```java
// Busca em AVL ou Red-Black Tree
public Node buscar(Node raiz, int valor) {
    if (raiz == null || raiz.valor == valor) return raiz;
    if (valor < raiz.valor) return buscar(raiz.esquerda, valor);
    else return buscar(raiz.direita, valor);
}
// O(log n) - altura da árvore balanceada = log(n)
```

### ✅ Encontrar Raiz Quadrada (Método de Bisseção)
```java
public int raizQuadrada(int n) {
    int inicio = 0, fim = n, resultado = 0;
    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        if (meio * meio == n) return meio;
        if (meio * meio < n) {
            inicio = meio + 1;
            resultado = meio;
        } else {
            fim = meio - 1;
        }
    }
    return resultado;
}
// O(log n) - busca binária no intervalo [0, n]
```

---

## Identificando Algoritmos O(log n)

### Perguntas-Chave:

1. **O algoritmo divide o problema pela metade (ou por constante) em cada passo?**
   - ✅ Sim → Provável O(log n)
   - ❌ Não → Outra complexidade

2. **O tamanho do problema diminui exponencialmente?**
   - ✅ n → n/2 → n/4 → ... → Sim, é O(log n)
   - ❌ n → n-1 → n-2 → ... → Não, é O(n)

3. **O número de operações aumenta em 1 quando dobramos a entrada?**
   - ✅ Sim → É O(log n)
   - ❌ Não → Outra complexidade

### Sinais de Alerta (NÃO é O(log n)):

❌ Loop que percorre **todos** os elementos: `for (i = 0; i < n; i++)`
❌ Decremento unitário: `n--` (em vez de `n = n/2`)
❌ Dois loops independentes sobre n: O(n) + O(n) = O(n)

---

## Por Que O(log n) é Tão Importante?

### 1. **Escalabilidade**
Funciona bem mesmo com **bilhões** de elementos:
- Busca linear em 1 bilhão: ~1 bilhão de operações
- Busca binária em 1 bilhão: ~30 operações

### 2. **Aplicações Reais**
- **Bancos de dados:** Índices B-Tree para busca rápida
- **Sistemas de arquivos:** Busca em diretórios
- **Redes:** Roteamento hierárquico
- **Jogos:** Detecção de colisão em árvores espaciais

### 3. **Fundamento de Estruturas de Dados**
- Árvores balanceadas (AVL, Red-Black)
- Heaps (inserção e remoção)
- Skip Lists

---

## Conclusão

A função `contarDivisoes()` é um **exemplo perfeito de O(log n)** porque:

✅ **Divide o problema pela metade** a cada iteração (`n = n/2`)  
✅ **Número de iterações = log₂(n)** (provado matematicamente)  
✅ **Crescimento logarítmico:** dobrar n adiciona apenas 1 operação  
✅ **Extremamente eficiente:** 1 milhão de elementos → ~20 operações  

Esta é a **segunda melhor complexidade** em análise de algoritmos, perdendo apenas para O(1)!

---

## Resumo das Regras de Big O Aplicadas

### Função Analisada:
$$T(n) = 4 \cdot \log_2(n) + 4$$

### Aplicação das Regras:

| Regra | Operação | Resultado |
|-------|----------|-----------|
| **Regra 1** | Remover constante multiplicativa (4) | $\log_2(n) + 4$ |
| **Regra 2** | Remover termo de menor ordem (+4) | $\log_2(n)$ |
| **Regra 3** | Base do log não importa | $\log(n)$ |

### Resultado Final:
$$\boxed{O(\log n)}$$

---

## Referências e Complexidades Relacionadas

| Complexidade | Nome | Exemplo |
|--------------|------|---------|
| O(1) | Constante | Acesso a array |
| **O(log n)** | **Logarítmica** | **Busca binária** |
| O(n) | Linear | Busca linear |
| O(n log n) | Linearítmica | Merge sort |
| O(n²) | Quadrática | Bubble sort |
| O(2ⁿ) | Exponencial | Fibonacci recursivo |
