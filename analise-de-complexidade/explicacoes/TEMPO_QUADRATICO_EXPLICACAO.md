# Análise de Complexidade: O(n²) - Tempo Quadrático

## O que é Tempo Quadrático O(n²)?

**Tempo Quadrático (O(n²))** é uma complexidade comum em algoritmos com loops aninhados. Significa que **o tempo de execução é proporcional ao quadrado** do tamanho da entrada.

### Característica Principal:
> **Se dobramos o tamanho da entrada (n → 2n), o tempo de execução QUADRUPLICA (4×).**

**Intuição:** Processamos cada elemento contra todos os outros elementos (ou similar), criando uma "matriz" de operações.

---

## Crescimento Quadrático: O Problema da Explosão

### Tabela de Crescimento Alarmante

| n | O(n) | O(n log n) | **O(n²)** | Proporção n²/n |
|---|------|------------|-----------|----------------|
| 1 | 1 | 0 | **1** | 1× |
| 2 | 2 | 2 | **4** | 2× |
| 5 | 5 | 12 | **25** | 5× |
| 10 | 10 | 33 | **100** | 10× |
| 20 | 20 | 86 | **400** | 20× |
| 50 | 50 | 282 | **2.500** | 50× |
| 100 | 100 | 664 | **10.000** | 100× |
| 1.000 | 1.000 | 9.966 | **1.000.000** | 1.000× |
| 10.000 | 10.000 | 132.877 | **100.000.000** | 10.000× |

**Observe:** 
- Para n=1.000, O(n²) realiza **1 MILHÃO** de operações!
- Para n=10.000, O(n²) realiza **100 MILHÕES** de operações!
- O crescimento é **explosivo** e rapidamente se torna inviável

### Visualização do Crescimento

```
Operações
    |                           
    |             O(n²) ━━━━━━━━━━━━━━━━→ Parábola ascendente
    |           /
    |      O(n log n) ──→  
    |    /
    | O(n) ──→ 
    |O(log n)
O(1)├─────────────────────────────────
    |___________________________________ Tamanho (n)
    0    10    20    30    40    50
```

**O(n²) cresce como uma parábola** - aceleração constante!

---

## Características de Algoritmos O(n²)

Um algoritmo tem complexidade **O(n²)** quando:

1. ✅ **Dois loops aninhados** dependentes do tamanho da entrada
2. ✅ **Cada elemento é comparado** com todos os outros
3. ✅ **Processamento de matriz** onde cada célula é visitada
4. ✅ **Algoritmos de ordenação simples** (bubble, selection, insertion)

### Padrões Comuns de O(n²):

#### Padrão 1: Dois Loops Aninhados Simples
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // Operação O(1)
    }
}
// Total: n × n = n² iterações
```

#### Padrão 2: Comparar Todos os Pares
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {  // Começa de i+1
        // Compara arr[i] com arr[j]
    }
}
// Total: n(n-1)/2 ≈ n²/2 = O(n²)
```

#### Padrão 3: Bubble Sort (Exemplo Clássico)
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j+1]) {
            swap(arr, j, j+1);
        }
    }
}
// Pior caso: n² comparações
```

#### Padrão 4: Processamento de Matriz
```java
for (int i = 0; i < linhas; i++) {
    for (int j = 0; j < colunas; j++) {
        matriz[i][j] = calcular(i, j);
    }
}
// Total: linhas × colunas operações
// Se linhas = colunas = n: n² operações
```

---

## Análise Matemática de O(n²)

### Função de Complexidade

Para dois loops aninhados de tamanho n:

$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{n-1} c = c \times n \times n = cn^2
$$

Onde $c$ é o custo constante das operações dentro dos loops.

### Forma Geral

$$
T(n) = an^2 + bn + c
$$

Onde:
- $an^2$ = termo quadrático (dominante)
- $bn$ = termo linear (menor ordem)
- $c$ = termo constante (menor ordem)

### Exemplo do Código

Para `multiplicar(a, b)` com a=b=n:

$$
T(n) = 2 + 2n^2 + 2 = 2n^2 + 4
$$

Detalhamento:
- **2**: duas inicializações (`resultado = 0`, `contador = 0`)
- **2n²**: duas operações no loop interno executadas n² vezes
- **2**: print e return finais

---

## Aplicando as Regras de Big O

### Exemplo Completo: T(n) = 2n² + 5n + 10

#### Regra 1: Identificar Termos

$$
T(n) = \underbrace{2n^2}_{\text{quadrático}} + \underbrace{5n}_{\text{linear}} + \underbrace{10}_{\text{constante}}
$$

#### Regra 2: Comparar Crescimento

Quando $n \rightarrow \infty$:

| n | 2n² | 5n | 10 | Termo Dominante |
|---|-----|----|----|-----------------|
| 10 | 200 | 50 | 10 | 2n² |
| 100 | 20.000 | 500 | 10 | 2n² (97.6%) |
| 1.000 | 2.000.000 | 5.000 | 10 | 2n² (99.75%) |

**Conclusão:** $n^2$ **domina completamente** quando n é grande.

#### Regra 3: Remover Termos de Menor Ordem

$$
2n^2 + 5n + 10 \rightarrow 2n^2
$$

Porque quando $n \rightarrow \infty$:

$$
\lim_{n \to \infty} \frac{5n + 10}{2n^2} = 0
$$

#### Regra 4: Remover Constantes Multiplicativas

$$
2n^2 \rightarrow n^2
$$

A constante 2 não afeta a **ordem de crescimento**.

#### Resultado Final:

$$
\boxed{O(n^2)}
$$

---

## O Código TempoQuadratico.java e sua Análise

### Estrutura do Código

```java
public static int multiplicar(int a, int b) {
    int resultado = 0;    // Linha 9: O(1)
    int contador = 0;     // Linha 13: O(1)
    
    for (int i = 0; i < a; i++) {           // Linha 23: Loop externo - a iterações
        for (int j = 0; j < b; j++) {       // Linha 35: Loop interno - b iterações
            resultado++;    // Linha 39: O(1) × (a×b)
            contador++;     // Linha 44: O(1) × (a×b)
        }
    }
    
    System.out.println(...);  // Linha 54: O(1)
    return resultado;          // Linha 58: O(1)
}
```

### Contagem Detalhada de Operações

#### Iteração por Iteração (exemplo a=3, b=4):

| i | j | Operações nesta célula | Total acumulado |
|---|---|------------------------|-----------------|
| 0 | 0,1,2,3 | 2×4 = 8 | 8 |
| 1 | 0,1,2,3 | 2×4 = 8 | 16 |
| 2 | 0,1,2,3 | 2×4 = 8 | 24 |

**Total:** 3 × 4 × 2 = **24 operações**

#### Caso Geral:

$$
\text{Total de operações} = a \times b \times 2 = 2ab
$$

#### Caso Especial (a = b = n):

$$
\text{Total de operações} = n \times n \times 2 = 2n^2
$$

### Análise Assintótica

Para o caso $a = b = n$:

$$
T(n) = 2 + 2n^2 + 2 = 2n^2 + 4
$$

Aplicando Big O:

$$
T(n) = 2n^2 + 4 \rightarrow n^2
$$

**Resultado:**

$$
\boxed{O(n^2)}
$$

---

## Por Que multiplicar() é O(n²)?

### Razões Fundamentais:

#### 1. **Dois Loops Aninhados**
```java
for (int i = 0; i < a; i++) {        // Loop 1: a vezes
    for (int j = 0; j < b; j++) {    // Loop 2: b vezes (PARA CADA i)
        // ...
    }
}
```

**Total:** a × b iterações

#### 2. **Quando a = b = n (Caso Quadrático)**

Se a = b = n:
- Loop externo: n iterações
- Loop interno: n iterações **para cada** iteração externa
- **Total: n × n = n²**

#### 3. **Crescimento Quadrático Verificado**

| n | Operações (2n²) | Crescimento |
|---|-----------------|-------------|
| 5 | 50 | - |
| 10 | 200 | 4× |
| 20 | 800 | 4× (dobrou n) |
| 40 | 3.200 | 4× (dobrou n) |

**Padrão:** Dobrar n sempre **quadruplica** as operações!

#### 4. **Visualização como Matriz**

Processar todos os pares (i, j):

```
      j → 0   1   2   3   4  (b vezes)
i ↓
0        ■   ■   ■   ■   ■
1        ■   ■   ■   ■   ■
2        ■   ■   ■   ■   ■  (a vezes)
3        ■   ■   ■   ■   ■
4        ■   ■   ■   ■   ■

Total de células = a × b
```

Se a = b = n, temos uma matriz **n × n** = **n² células**.

---

## Comparação com Outras Complexidades

### Tabela Comparativa Completa

| n | O(1) | O(log n) | O(n) | O(n log n) | **O(n²)** | O(n³) | O(2ⁿ) |
|---|------|----------|------|------------|-----------|-------|-------|
| 1 | 1 | 0 | 1 | 0 | **1** | 1 | 2 |
| 2 | 1 | 1 | 2 | 2 | **4** | 8 | 4 |
| 5 | 1 | 2 | 5 | 12 | **25** | 125 | 32 |
| 10 | 1 | 3 | 10 | 33 | **100** | 1.000 | 1.024 |
| 20 | 1 | 4 | 20 | 86 | **400** | 8.000 | 1.048.576 |
| 50 | 1 | 6 | 50 | 282 | **2.500** | 125.000 | 1.125×10¹⁵ |
| 100 | 1 | 7 | 100 | 664 | **10.000** | 1.000.000 | 1.267×10³⁰ |

### Crescimento Relativo

Quando **dobramos** n:

| Complexidade | Fator de Crescimento | Exemplo (5→10) |
|--------------|---------------------|----------------|
| O(1) | ×1 (constante) | 1 → 1 |
| O(log n) | +1 operação | 2 → 3 |
| O(n) | ×2 (dobra) | 5 → 10 |
| O(n log n) | ×2.x (pouco mais que dobra) | 12 → 33 |
| **O(n²)** | **×4 (quadruplica)** | **25 → 100** ← **CRÍTICO!** |
| O(n³) | ×8 (octuplica) | 125 → 1.000 |
| O(2ⁿ) | Ao quadrado | 32 → 1.024 |

---

## Exemplos Práticos de O(n²)

### ✅ Bubble Sort (Ordenação por Bolha)

```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {              // n iterações
        for (int j = 0; j < n - i - 1; j++) {  // (n-i-1) iterações
            if (arr[j] > arr[j+1]) {
                // Troca
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
// Total: n + (n-1) + (n-2) + ... + 1 = n(n-1)/2 ≈ n²/2 = O(n²)
```

### ✅ Selection Sort (Ordenação por Seleção)

```java
public void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {          // n-1 iterações
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {      // (n-i-1) iterações
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        // Troca arr[i] com arr[minIdx]
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
// Sempre O(n²) - mesmo no melhor caso!
```

### ✅ Insertion Sort (Ordenação por Inserção)

```java
public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {              // n-1 iterações
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {       // Até i iterações
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
// Pior caso: O(n²) - array em ordem reversa
// Melhor caso: O(n) - array já ordenado
```

### ✅ Encontrar Duplicatas (Força Bruta)

```java
public boolean temDuplicatas(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {              // n iterações
        for (int j = i + 1; j < n; j++) {      // (n-i-1) iterações
            if (arr[i] == arr[j]) {
                return true;
            }
        }
    }
    return false;
}
// Total: n(n-1)/2 = O(n²)
```

### ✅ Multiplicação de Matrizes (Algoritmo Ingênuo)

```java
public int[][] multiplicarMatrizes(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    
    for (int i = 0; i < n; i++) {              // n iterações
        for (int j = 0; j < n; j++) {          // n iterações
            for (int k = 0; k < n; k++) {      // n iterações
                C[i][j] += A[i][k] * B[k][j];
            }
        }
    }
    return C;
}
// Três loops aninhados: O(n³) - ainda pior que O(n²)!
```

---

## Loops Aninhados: Análise Detalhada

### Caso 1: Dois Loops Completos (n × n)

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        operacao();  // O(1)
    }
}
```

**Análise:**
- Loop externo: n iterações
- Loop interno: n iterações (sempre)
- **Total: n × n = n²**

$$T(n) = n^2 = O(n^2)$$

### Caso 2: Loop Interno Depende do Externo (Triângulo)

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {  // Apenas até i
        operacao();  // O(1)
    }
}
```

**Análise:**
- i=0: 0 iterações internas
- i=1: 1 iteração interna
- i=2: 2 iterações internas
- ...
- i=n-1: n-1 iterações internas

**Total:**
$$
T(n) = 0 + 1 + 2 + ... + (n-1) = \frac{n(n-1)}{2} = \frac{n^2 - n}{2}
$$

Aplicando Big O:
$$
\frac{n^2 - n}{2} = \frac{1}{2}n^2 - \frac{1}{2}n \rightarrow n^2
$$

**Resultado: O(n²)** - mesmo visitando apenas "metade" dos pares!

### Caso 3: Dois Loops Independentes (n + n)

```java
for (int i = 0; i < n; i++) {
    operacao1();  // O(1)
}

for (int j = 0; j < n; j++) {
    operacao2();  // O(1)
}
```

**Análise:**
- Primeiro loop: n iterações
- Segundo loop: n iterações
- **Total: n + n = 2n**

$$T(n) = 2n = O(n)$$

**NÃO é O(n²)!** - loops **sequenciais** somam, não multiplicam.

### Caso 4: Loop Externo n, Interno Constante

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 10; j++) {  // Constante!
        operacao();  // O(1)
    }
}
```

**Análise:**
- Loop externo: n iterações
- Loop interno: 10 iterações (constante)
- **Total: n × 10 = 10n**

$$T(n) = 10n = O(n)$$

**NÃO é O(n²)!** - constante não conta.

---

## Quando O(n²) é Bom, Aceitável ou Ruim?

### ✅ O(n²) é ACEITÁVEL quando:
- **Dados pequenos:** n < 100 elementos
- **Algoritmo simples é preferível:** código mais legível
- **Insertion Sort para quase ordenados:** pode ser O(n) no melhor caso
- **Não há alternativa mais simples** para o problema específico

### ⚠️ O(n²) é PROBLEMÁTICO quando:
- **Dados médios:** 100 < n < 10.000
- **Processamento repetido** ou em pipeline
- Há **alternativas O(n log n)** disponíveis (merge sort, quick sort)

### ❌ O(n²) é INACEITÁVEL quando:
- **Grandes volumes:** n > 10.000 elementos
- **Tempo real crítico**
- **Aplicações web/móveis** com UX exigente
- **Big Data** - completamente inviável

### Tabela de Tempo Real (assumindo 1μs por operação)

| n | Operações (n²) | Tempo |
|---|----------------|-------|
| 10 | 100 | 0.1 ms |
| 100 | 10.000 | 10 ms ✅ |
| 1.000 | 1.000.000 | 1 segundo ⚠️ |
| 10.000 | 100.000.000 | 100 segundos ❌ |
| 100.000 | 10.000.000.000 | 2.8 horas ❌❌ |
| 1.000.000 | 1.000.000.000.000 | 11.6 dias ❌❌❌ |

---

## Otimizando Algoritmos O(n²)

### 1. Early Termination (Retorno Antecipado)

**Antes:**
```java
public boolean temDuplicatas(int[] arr) {
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                // Continua verificando tudo...
            }
        }
    }
}
```

**Depois:**
```java
public boolean temDuplicatas(int[] arr) {
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                return true;  // Para imediatamente!
            }
        }
    }
    return false;
}
```

### 2. Usar Estruturas de Dados Apropriadas

**Antes (O(n²)):**
```java
public boolean temDuplicatas(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) return true;
        }
    }
    return false;
}
```

**Depois (O(n)):**
```java
public boolean temDuplicatas(int[] arr) {
    Set<Integer> vistos = new HashSet<>();
    for (int num : arr) {
        if (vistos.contains(num)) return true;  // O(1) lookup
        vistos.add(num);
    }
    return false;
}
```

### 3. Ordenar Primeiro (O(n log n) + O(n) < O(n²))

**Antes (O(n²)):**
```java
// Encontrar se dois números somam 'alvo'
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] + arr[j] == alvo) return true;
    }
}
```

**Depois (O(n log n)):**
```java
Arrays.sort(arr);  // O(n log n)
int left = 0, right = n - 1;
while (left < right) {  // O(n)
    int soma = arr[left] + arr[right];
    if (soma == alvo) return true;
    else if (soma < alvo) left++;
    else right--;
}
// Total: O(n log n) + O(n) = O(n log n) << O(n²)
```

### 4. Dividir e Conquistar

**Antes (O(n²)):**
```java
// Ordenação por seleção
for (int i = 0; i < n; i++) {
    for (int j = i+1; j < n; j++) {
        // Compara e troca
    }
}
```

**Depois (O(n log n)):**
```java
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);        // T(n/2)
        mergeSort(arr, mid + 1, right);   // T(n/2)
        merge(arr, left, mid, right);     // O(n)
    }
}
// T(n) = 2T(n/2) + O(n) = O(n log n)
```

---

## Identificando Algoritmos O(n²)

### Perguntas-Chave:

#### 1. **Há dois loops aninhados sobre n?**
- ✅ Sim → Provável O(n²)
- ❌ Não → Outra complexidade

#### 2. **Cada elemento é comparado com todos os outros?**
- ✅ Sim → É O(n²)
- ❌ Não → Outra complexidade

#### 3. **O tempo quadruplica quando n dobra?**
- ✅ Sim → É O(n²)
- ❌ Não → Outra complexidade

### Sinais Visuais de O(n²):

✅ **É O(n²):**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {  // Loop aninhado sobre n!
        // Operação O(1)
    }
}
```

✅ **É O(n²):**
```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {  // Triângulo, mas ainda O(n²)
        // Operação O(1)
    }
}
```

❌ **NÃO é O(n²) - É O(n):**
```java
for (int i = 0; i < n; i++) {
    // Operação O(1)
}
for (int j = 0; j < n; j++) {  // Sequencial, não aninhado!
    // Operação O(1)
}
```

❌ **NÃO é O(n²) - É O(n log n):**
```java
for (int i = 0; i < n; i++) {
    int temp = i;
    while (temp > 1) {
        temp /= 2;  // Loop logarítmico!
    }
}
```

---

## Variações de O(n²)

### O(n² / 2) - Triângulo Superior

```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        // Processa par (i,j)
    }
}
```

**Total:** $\frac{n(n-1)}{2} = \frac{n^2}{2} - \frac{n}{2} = O(n^2)$

### O(n² - n) - Excluindo Diagonal

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (i != j) {  // Exclui pares (i,i)
            // Processa
        }
    }
}
```

**Total:** $n^2 - n = O(n^2)$

### O(c · n²) - Múltiplos Loops Aninhados

```java
// Loop 1-2: O(n²)
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // ...
    }
}

// Loop 3-4: O(n²)
for (int k = 0; k < n; k++) {
    for (int l = 0; l < n; l++) {
        // ...
    }
}
```

**Total:** $n^2 + n^2 = 2n^2 = O(n^2)$

---

## Conclusão

A função `multiplicar()` é um **exemplo de O(n²)** porque:

✅ **Dois loops aninhados** - externo (a vezes) e interno (b vezes)  
✅ **Quando a = b = n:** n × n = n² iterações  
✅ **Crescimento quadrático:** dobrar n quadruplica as operações  
✅ **Proporcional ao produto:** a × b operações totais  

Esta é uma das **complexidades mais problemáticas** para grandes conjuntos de dados!

---

## Resumo das Regras de Big O Aplicadas

### Função Analisada (a = b = n):

$$T(n) = 2n^2 + 4$$

### Aplicação das Regras:

| Regra | Operação | Resultado |
|-------|----------|-----------|
| **Identificar termos** | Dominante: $2n^2$; Menor: 4 | $2n^2 + 4$ |
| **Regra 1** | Remover constante multiplicativa (2) | $n^2 + 4$ |
| **Regra 2** | Remover termo de menor ordem (+4) | $n^2$ |

### Resultado Final:

$$\boxed{O(n^2)}$$

---

## Hierarquia de Complexidades

| Complexidade | Eficiência | Exemplo Típico | Para n=1.000 |
|--------------|-----------|----------------|--------------|
| O(1) | ⚡⚡⚡⚡⚡ Melhor | Acesso a array | 1 op |
| O(log n) | ⚡⚡⚡⚡ Excelente | Busca binária | ~10 ops |
| O(n) | ⚡⚡⚡ Bom | Busca linear | 1.000 ops |
| O(n log n) | ⚡⚡ Aceitável | Merge Sort | ~10.000 ops |
| **O(n²)** | **⚡ Ruim** | **Bubble Sort** | **1.000.000 ops** ← **ESTE CASO** |
| O(n³) | 🔥 Péssimo | Matriz 3D | 1.000.000.000 ops |
| O(2ⁿ) | 🔥🔥 Inviável | Subconjuntos | ~10³⁰⁰ ops |
| O(n!) | 🔥🔥🔥 Impossível | Permutações | ~10²⁵⁶⁷ ops |

**O(n²) deve ser evitado sempre que possível para dados grandes!**
