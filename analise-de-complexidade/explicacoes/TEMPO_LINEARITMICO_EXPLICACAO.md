# Análise de Complexidade: O(n log n) - Tempo Linearítmico

## O que é Tempo Linearítmico O(n log n)?

**Tempo Linearítmico (O(n log n))** é uma complexidade intermediária em análise de algoritmos. Significa que **o tempo de execução é o produto** de um componente linear (n) e um logarítmico (log n).

### Característica Principal:
> **O crescimento é mais rápido que O(n), mas muito mais lento que O(n²).**

**Intuição:** Processamos n elementos, mas cada processamento envolve uma operação logarítmica (como divisão repetida ou navegação em árvore).

---

## Nome: Por Que "Linearítmico"?

A palavra **"linearítmico"** (ou "log-linear" em inglês) combina:

- **Linear** (n) + **Logarítmico** (log n) = **Linearítmico** (n log n)

É o **produto** dessas duas complexidades!

---

## Crescimento Linearítmico: Entendendo os Números

### Tabela de Crescimento Comparativo

| n | O(n) | O(n log n) | O(n²) | Proporção (n log n) / (n) |
|---|------|------------|-------|---------------------------|
| 2 | 2 | 2 | 4 | 1.0× |
| 4 | 4 | 8 | 16 | 2.0× |
| 8 | 8 | 24 | 64 | 3.0× |
| 16 | 16 | 64 | 256 | 4.0× |
| 32 | 32 | 160 | 1.024 | 5.0× |
| 64 | 64 | 384 | 4.096 | 6.0× |
| 128 | 128 | 896 | 16.384 | 7.0× |
| 1.000 | 1.000 | ~10.000 | 1.000.000 | ~10× |
| 10.000 | 10.000 | ~130.000 | 100.000.000 | ~13× |
| 1.000.000 | 1.000.000 | ~20.000.000 | 1.000.000.000.000 | ~20× |

**Observe:**
- O(n log n) cresce **mais devagar** que O(n²)
- O(n log n) cresce **mais rápido** que O(n)
- O fator de diferença entre O(n log n) e O(n) é o próprio log(n)!

### Visualização Gráfica

```
Operações
    |                           
    |                      O(n²) ──────────→
    |                    /
    |               O(n log n) ──→  ← Curva suave
    |            /
    |       O(n) ─────→  ← Linha reta
    |     /
    |O(log n) →
O(1)├─────────────────────────────────
    |___________________________________ Tamanho (n)
    0    10    20    30    40    50
```

**O(n log n) forma uma curva** entre a linha reta (O(n)) e a parábola (O(n²)).

---

## Características de Algoritmos O(n log n)

Um algoritmo tem complexidade **O(n log n)** quando:

1. ✅ **Loop linear O(n)** contendo operações O(log n)
2. ✅ **Divisão e conquista** que divide o problema em partes iguais
3. ✅ **Somatório de logaritmos**: Σ log(i) para i de 1 até n
4. ✅ **Algoritmos de ordenação eficientes** (merge, heap, quick)

### Padrões Comuns de O(n log n):

#### Padrão 1: Loop O(n) com Operação O(log n) Aninhada
```java
for (int i = 1; i <= n; i++) {
    int temp = i;
    while (temp > 1) {
        temp = temp / 2;  // O(log i)
    }
}
// Total: Σ log(i) ≈ n log(n)
```

#### Padrão 2: Divisão e Conquista (Merge Sort)
```java
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);      // T(n/2)
        mergeSort(arr, mid + 1, right); // T(n/2)
        merge(arr, left, mid, right);   // O(n)
    }
}
// Recorrência: T(n) = 2T(n/2) + O(n) = O(n log n)
```

#### Padrão 3: Construção de Heap
```java
for (int i = 0; i < n; i++) {
    heapInsert(heap, elementos[i]);  // O(log n) cada inserção
}
// Total: n × O(log n) = O(n log n)
```

#### Padrão 4: Ordenação de Arrays
```java
Arrays.sort(array);  // Usa Dual-Pivot Quicksort
// Complexidade garantida: O(n log n)
```

---

## Análise Matemática de O(n log n)

### Por Que Σ log(i) ≈ n log(n)?

Quando somamos logaritmos de 1 até n:

$$
\sum_{i=1}^{n} \log_2(i) = \log_2(1) + \log_2(2) + \log_2(3) + \cdots + \log_2(n)
$$

Usando propriedade de logaritmos (log(a) + log(b) = log(a×b)):

$$
\sum_{i=1}^{n} \log_2(i) = \log_2(1 \times 2 \times 3 \times \cdots \times n) = \log_2(n!)
$$

### Aproximação de Stirling para n!

A fórmula de Stirling nos diz que:

$$
n! \approx \sqrt{2\pi n} \left(\frac{n}{e}\right)^n
$$

Aplicando logaritmo:

$$
\log_2(n!) \approx \log_2\left(\sqrt{2\pi n}\right) + n\log_2(n) - n\log_2(e)
$$

$$
\log_2(n!) \approx n\log_2(n) - 1.443n + \frac{1}{2}\log_2(n) + \text{constante}
$$

### Simplificação com Big O

Os termos dominantes são:
- $n \log_2(n)$ - **termo dominante**
- $-1.443n$ - termo de menor ordem (cresce mais devagar)
- $\frac{1}{2}\log_2(n)$ - termo de menor ordem

Aplicando as regras de Big O:

$$
\log_2(n!) = n\log_2(n) - 1.443n + O(\log n)
$$

Removendo termos de menor ordem:

$$
\boxed{\log_2(n!) = O(n \log n)}
$$

---

## Aplicando as Regras de Big O

### Exemplo: T(n) = n log₂(n) - 1.443n + 0.5 log₂(n) + 5

#### Regra 1: Identificar Termos

$$
T(n) = \underbrace{n\log_2(n)}_{\text{dominante}} + \underbrace{(-1.443n)}_{\text{menor}} + \underbrace{0.5\log_2(n)}_{\text{menor}} + \underbrace{5}_{\text{constante}}
$$

#### Regra 2: Comparar Crescimento dos Termos

Quando $n \rightarrow \infty$:

| n | n log₂(n) | 1.443n | 0.5 log₂(n) | Dominante? |
|---|-----------|--------|-------------|------------|
| 10 | 33 | 14 | 1.7 | n log n |
| 100 | 664 | 144 | 3.3 | n log n |
| 1.000 | 9.966 | 1.443 | 5.0 | n log n |
| 10.000 | 132.877 | 14.430 | 6.6 | n log n |

**Conclusão:** $n\log(n)$ cresce **muito mais rápido** que $n$, que por sua vez cresce mais rápido que $\log(n)$.

#### Regra 3: Remover Termos de Menor Ordem

$$
n\log_2(n) - 1.443n + 0.5\log_2(n) + 5 \rightarrow n\log_2(n)
$$

#### Regra 4: Base do Logaritmo Não Importa

$$
n\log_2(n) \equiv n\log_{10}(n) \equiv n\log(n)
$$

Porque: $\log_2(n) = \frac{\log_{10}(n)}{\log_{10}(2)} \approx 3.32 \times \log_{10}(n)$

E constantes são removidas em Big O.

#### Resultado Final:

$$
\boxed{O(n \log n)}
$$

---

## O Código TempoLinearitmico.java e sua Análise

### Estrutura do Código

```java
public static int operacaoComposta(int n) {
    int contador = 0;       // Linha 9: O(1)
    
    for (int i = 1; i <= n; i++) {           // Linha 18: Loop externo - n iterações
        int temp = i;       // Linha 21: O(1) × n
        
        while (temp > 1) {  // Linha 34: Loop interno - log₂(i) iterações
            temp = temp / 2;    // Linha 37: O(1)
            contador++;         // Linha 41: O(1)
        }
    }
    
    System.out.println(...);  // Linha 51: O(1)
    return contador;           // Linha 55: O(1)
}
```

### Contagem Detalhada de Operações

#### Iteração por Iteração:

| Valor de i | temp inicial | Iterações do while | Operações |
|------------|--------------|-------------------|-----------|
| i = 1 | 1 | 0 (não entra) | 0 |
| i = 2 | 2 | 2 → 1 | 1 |
| i = 3 | 3 | 3 → 1 (via 1.5≈1) | 2 |
| i = 4 | 4 | 4 → 2 → 1 | 2 |
| i = 5 | 5 | 5 → 2 → 1 | 2 |
| i = 6 | 6 | 6 → 3 → 1 | 2 |
| i = 7 | 7 | 7 → 3 → 1 | 2 |
| i = 8 | 8 | 8 → 4 → 2 → 1 | 3 |
| ... | ... | ... | ... |
| **i = n** | **n** | **log₂(n) passos** | **log₂(n)** |

#### Total de Operações:

$$
T(n) = \sum_{i=1}^{n} \lfloor\log_2(i)\rfloor
$$

Para valores específicos:
- **n = 4**: 0 + 1 + 1 + 2 = **4 operações**
- **n = 8**: 0 + 1 + 1 + 2 + 2 + 2 + 2 + 3 = **13 operações**
- **n = 16**: ≈ **40 operações**

### Análise Assintótica

$$
T(n) = \sum_{i=1}^{n} \log_2(i) = \log_2(n!) \approx n\log_2(n) - 1.443n
$$

Aplicando Big O:

$$
T(n) = n\log_2(n) - 1.443n \rightarrow n\log_2(n)
$$

**Resultado:**

$$
\boxed{O(n \log n)}
$$

---

## Por Que operacaoComposta() é O(n log n)?

### Razões Fundamentais:

#### 1. **Loop Externo é Linear: O(n)**
```java
for (int i = 1; i <= n; i++)  // Executa n vezes
```

Percorre todos os valores de 1 até n.

#### 2. **Loop Interno é Logarítmico: O(log i)**
```java
while (temp > 1) {
    temp = temp / 2;  // Divide pela metade!
}
```

Para cada i, executa log₂(i) iterações.

#### 3. **Somatório de Logaritmos**

O total **NÃO** é simplesmente n × log(n), mas o **somatório**:

$$
\sum_{i=1}^{n} \log_2(i) \neq n \times \log_2(n)
$$

Na verdade:

$$
\sum_{i=1}^{n} \log_2(i) = \log_2(n!) \approx n\log_2(n)
$$

**Nota:** A aproximação é válida assintoticamente!

#### 4. **Crescimento Intermediário**

Vamos verificar empiricamente:

| n | Operações Reais | n log₂(n) | n² |
|---|-----------------|-----------|-----|
| 4 | 4 | 8 | 16 |
| 8 | 13 | 24 | 64 |
| 16 | 40 | 64 | 256 |

**Observe:** As operações reais crescem de forma similar a $n\log_2(n)$ (não exatamente igual, mas mesma ordem).

---

## Comparação com Outras Complexidades

### Tabela Detalhada: Todas as Complexidades

| n | O(1) | O(log n) | O(n) | **O(n log n)** | O(n²) | O(n³) |
|---|------|----------|------|----------------|-------|-------|
| 1 | 1 | 0 | 1 | **0** | 1 | 1 |
| 2 | 1 | 1 | 2 | **2** | 4 | 8 |
| 4 | 1 | 2 | 4 | **8** | 16 | 64 |
| 8 | 1 | 3 | 8 | **24** | 64 | 512 |
| 16 | 1 | 4 | 16 | **64** | 256 | 4.096 |
| 32 | 1 | 5 | 32 | **160** | 1.024 | 32.768 |
| 64 | 1 | 6 | 64 | **384** | 4.096 | 262.144 |
| 128 | 1 | 7 | 128 | **896** | 16.384 | 2.097.152 |
| 1.000 | 1 | 10 | 1.000 | **10.000** | 1.000.000 | 1.000.000.000 |

### Crescimento Relativo

Quando **dobramos** n:

| Complexidade | Fator de Crescimento |
|--------------|---------------------|
| O(1) | ×1 (constante) |
| O(log n) | +1 operação |
| O(n) | ×2 (dobra) |
| **O(n log n)** | **×2.x** (mais que dobra) |
| O(n²) | ×4 (quadruplica) |
| O(2ⁿ) | Quadrado do anterior |

**O(n log n) dobra "e um pouco mais"** - não tão ruim quanto O(n²)!

---

## Exemplos Práticos de O(n log n)

### ✅ Merge Sort (Ordenação por Intercalação)

```java
public void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        
        // Divide: T(n/2) + T(n/2)
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        // Conquista: O(n)
        merge(arr, left, mid, right);
    }
}

private void merge(int[] arr, int left, int mid, int right) {
    // Intercala as duas metades em O(n) tempo
    // ... código de intercalação
}
```

**Análise:**
- Recorrência: $T(n) = 2T(n/2) + O(n)$
- Resolução: $T(n) = O(n \log n)$

### ✅ Quick Sort (Caso Médio)

```java
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);  // O(n)
        
        quickSort(arr, low, pi - 1);   // T(n/2) em média
        quickSort(arr, pi + 1, high);  // T(n/2) em média
    }
}
```

**Complexidade:**
- **Melhor/Médio caso:** O(n log n)
- **Pior caso:** O(n²) (quando o pivot é sempre o menor/maior)

### ✅ Heap Sort

```java
public void heapSort(int[] arr) {
    int n = arr.length;
    
    // Construir heap: O(n) - na verdade!
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);  // O(log n)
    }
    
    // Extrair elementos: O(n log n)
    for (int i = n - 1; i > 0; i--) {
        swap(arr, 0, i);       // O(1)
        heapify(arr, i, 0);    // O(log n)
    }
}
// Total: O(n) + O(n log n) = O(n log n)
```

### ✅ Construir Árvore Binária de Busca Balanceada

```java
public TreeNode buildTree(int[] sortedArray) {
    return buildTreeHelper(sortedArray, 0, sortedArray.length - 1);
}

private TreeNode buildTreeHelper(int[] arr, int start, int end) {
    if (start > end) return null;
    
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    
    node.left = buildTreeHelper(arr, start, mid - 1);
    node.right = buildTreeHelper(arr, mid + 1, end);
    
    return node;
}
// Complexidade: O(n log n) - porém, na prática é O(n)!
// Mas se cada inserção fosse feita individualmente: O(n log n)
```

### ✅ Encontrar Todos os Pares com Distância k

```java
public void encontrarParesComDistanciaK(int[] arr, int k) {
    Arrays.sort(arr);  // O(n log n)
    
    // Busca de dois ponteiros: O(n)
    int left = 0, right = 1;
    while (right < arr.length) {
        int diff = arr[right] - arr[left];
        if (diff == k) {
            System.out.println("Par: " + arr[left] + ", " + arr[right]);
            left++;
            right++;
        } else if (diff < k) {
            right++;
        } else {
            left++;
        }
    }
}
// Total: O(n log n) + O(n) = O(n log n)
```

---

## Algoritmos de Ordenação: Comparação

### Tabela Comparativa

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | Espaço Extra | Estável? |
|-----------|-------------|------------|-----------|--------------|----------|
| **Merge Sort** | **O(n log n)** | **O(n log n)** | **O(n log n)** | O(n) | ✅ Sim |
| **Heap Sort** | **O(n log n)** | **O(n log n)** | **O(n log n)** | O(1) | ❌ Não |
| **Quick Sort** | **O(n log n)** | **O(n log n)** | O(n²) | O(log n) | ❌ Não |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ Sim |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ Sim |
| Tim Sort | O(n) | **O(n log n)** | **O(n log n)** | O(n) | ✅ Sim |

**Conclusão:** Os algoritmos eficientes de ordenação têm complexidade **O(n log n)**!

---

## Identificando Algoritmos O(n log n)

### Perguntas-Chave:

#### 1. **Há um loop O(n) com operação O(log n) dentro?**
- ✅ Sim → Provável O(n log n)
- ❌ Não → Outra complexidade

#### 2. **O algoritmo usa divisão e conquista?**
- ✅ Divide em partes iguais + combina em O(n) → O(n log n)
- ❌ Não → Outra complexidade

#### 3. **É um algoritmo de ordenação eficiente?**
- ✅ Merge/Heap/Quick Sort → O(n log n)
- ❌ Bubble/Insertion Sort → O(n²)

### Sinais Visuais de O(n log n):

✅ **É O(n log n):**
```java
for (int i = 0; i < n; i++) {
    int temp = i;
    while (temp > 1) {
        temp /= 2;  // O(log i)
    }
}
```

✅ **É O(n log n):**
```java
void dividirConquistar(int[] arr, int inicio, int fim) {
    if (inicio < fim) {
        int meio = (inicio + fim) / 2;
        dividirConquistar(arr, inicio, meio);    // T(n/2)
        dividirConquistar(arr, meio+1, fim);     // T(n/2)
        combinar(arr, inicio, meio, fim);        // O(n)
    }
}
// T(n) = 2T(n/2) + O(n) = O(n log n)
```

❌ **NÃO é O(n log n) - É O(n²):**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {  // Loop linear aninhado!
        // ...
    }
}
```

---

## Teorema Mestre para Recorrências

Para analisar algoritmos de divisão e conquista, usamos o **Teorema Mestre**:

### Forma Geral:

$$
T(n) = aT(n/b) + f(n)
$$

Onde:
- $a$ = número de subproblemas
- $b$ = fator de divisão
- $f(n)$ = custo de dividir e combinar

### Casos:

#### Caso 1: $f(n) = O(n^c)$ onde $c < \log_b(a)$
$$
T(n) = O(n^{\log_b(a)})
$$

#### Caso 2: $f(n) = \Theta(n^c \log^k(n))$ onde $c = \log_b(a)$
$$
T(n) = O(n^c \log^{k+1}(n))
$$

#### Caso 3: $f(n) = \Omega(n^c)$ onde $c > \log_b(a)$
$$
T(n) = O(f(n))
$$

### Exemplo: Merge Sort

$$
T(n) = 2T(n/2) + O(n)
$$

- $a = 2$ (dois subproblemas)
- $b = 2$ (divide por 2)
- $f(n) = O(n)$
- $\log_b(a) = \log_2(2) = 1$
- $f(n) = n^1$ (igual a $\log_b(a)$)

**Aplicando Caso 2:**

$$
T(n) = O(n^1 \log^{0+1}(n)) = O(n \log n)
$$

✅ **Resultado: O(n log n)**

---

## Quando O(n log n) é Bom ou Ruim?

### ✅ O(n log n) é EXCELENTE quando:
- **Ordenação** de dados (melhor complexidade possível para ordenação por comparação)
- Grandes volumes de dados (até milhões de elementos)
- Precisa de garantia de desempenho (merge sort sempre O(n log n))
- Alternativa seria O(n²) (muito pior!)

### ⚠️ O(n log n) é ACEITÁVEL quando:
- Não há alternativa mais eficiente disponível
- Tamanho moderado dos dados (milhares a milhões)
- Desempenho não é crítico absoluto

### ❌ O(n log n) é PROBLEMÁTICO quando:
- Há alternativa O(n) disponível (ex: counting sort para pequenos ranges)
- Executado repetidamente em loop crítico
- Dados já quase ordenados (insertion sort O(n) seria melhor)
- Requisitos de tempo real muito estrito

---

## Limite Inferior de Ordenação por Comparação

### Teorema Fundamental:

> **Qualquer algoritmo de ordenação baseado em comparações tem complexidade mínima de Ω(n log n).**

### Prova (Intuição):

1. Para ordenar n elementos, há $n!$ permutações possíveis
2. Cada comparação divide o espaço de soluções em 2
3. Precisamos de árvore de decisão com $n!$ folhas
4. Altura mínima de árvore binária com $n!$ folhas:

$$
h \geq \log_2(n!) \approx n\log_2(n)
$$

**Conclusão:** Não existe algoritmo de ordenação por comparação mais rápido que O(n log n)!

**Nota:** Algoritmos como Counting Sort, Radix Sort e Bucket Sort podem ser O(n), mas **não usam comparações** - usam propriedades especiais dos dados.

---

## Melhorando Desempenho em O(n log n)

### 1. Escolha o Algoritmo Apropriado

| Situação | Melhor Escolha |
|----------|----------------|
| Dados aleatórios | Quick Sort (rápido na prática) |
| Garantia de O(n log n) | Merge Sort ou Heap Sort |
| Espaço limitado | Heap Sort (in-place) |
| Estabilidade necessária | Merge Sort ou Tim Sort |
| Dados quase ordenados | Tim Sort (híbrido) |

### 2. Otimizações de Quick Sort

```java
// Escolher pivot mediano (de 3 valores)
int medianaDeTres(int[] arr, int low, int high) {
    int mid = (low + high) / 2;
    if (arr[low] > arr[mid]) swap(arr, low, mid);
    if (arr[low] > arr[high]) swap(arr, low, high);
    if (arr[mid] > arr[high]) swap(arr, mid, high);
    return mid;
}

// Usar insertion sort para subarrays pequenos
if (high - low < 10) {
    insertionSort(arr, low, high);  // Mais eficiente para pequenos
    return;
}
```

### 3. Híbrido: Tim Sort

Java usa **Tim Sort** (híbrido de Merge + Insertion):
- Arrays pequenos: Insertion Sort O(n) para quase ordenados
- Arrays grandes: Merge Sort O(n log n)
- **Resultado:** Melhor performance prática!

---

## Conclusão

A função `operacaoComposta()` é um **exemplo de O(n log n)** porque:

✅ **Loop externo linear O(n)** - itera de 1 até n  
✅ **Loop interno logarítmico O(log i)** - divide por 2 repetidamente  
✅ **Somatório de logaritmos:** Σ log(i) ≈ log(n!) ≈ n log(n)  
✅ **Crescimento intermediário:** mais rápido que O(n), mais lento que O(n²)  

Esta é a **complexidade dos algoritmos de ordenação eficientes**!

---

## Resumo das Regras de Big O Aplicadas

### Função Analisada:

$$
T(n) = \sum_{i=1}^{n} \log_2(i) = \log_2(n!)
$$

### Aplicação das Regras:

| Etapa | Operação | Resultado |
|-------|----------|-----------|
| **Aproximação** | Usar Stirling: $\log_2(n!) \approx n\log_2(n) - 1.443n$ | $n\log_2(n) - 1.443n$ |
| **Regra 1** | Identificar termo dominante | $n\log_2(n)$ (cresce mais rápido que $n$) |
| **Regra 2** | Remover termos de menor ordem (-1.443n) | $n\log_2(n)$ |
| **Regra 3** | Base do log não importa | $n\log(n)$ |

### Resultado Final:

$$
\boxed{O(n \log n)}
$$

---

## Hierarquia de Complexidades

| Complexidade | Eficiência | Exemplo Típico |
|--------------|-----------|----------------|
| O(1) | ⚡⚡⚡⚡⚡ Melhor | Acesso a array |
| O(log n) | ⚡⚡⚡⚡ Excelente | Busca binária |
| O(n) | ⚡⚡⚡ Bom | Busca linear |
| **O(n log n)** | **⚡⚡ Aceitável** | **Merge Sort** ← **ESTE CASO** |
| O(n²) | ⚡ Ruim | Bubble Sort |
| O(n³) | 🔥 Péssimo | Multiplicação de matrizes ingênua |
| O(2ⁿ) | 🔥🔥 Inviável | Subconjuntos |
| O(n!) | 🔥🔥🔥 Impossível | Permutações |

**O(n log n) é o "ponto ideal" para algoritmos de ordenação eficientes!**
