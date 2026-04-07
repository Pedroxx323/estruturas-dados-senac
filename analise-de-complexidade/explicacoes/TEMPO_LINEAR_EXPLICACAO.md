# Análise de Complexidade: O(n) - Tempo Linear

## O que é Tempo Linear O(n)?

**Tempo Linear (O(n))** é uma complexidade comum em análise de algoritmos. Significa que **o tempo de execução cresce proporcionalmente** ao tamanho da entrada.

### Característica Principal:
> **Se dobramos o tamanho da entrada (n → 2n), o tempo de execução também DOBRA.**

**Intuição:** Processamos cada elemento da entrada **exatamente uma vez** (ou um número constante de vezes).

---

## Crescimento Linear: Entendendo a Proporcionalidade

### Tabela de Crescimento

| Tamanho (n) | Operações O(n) | Operações O(log n) | Operações O(n²) |
|-------------|----------------|---------------------|-----------------|
| 10 | 10 | ~3 | 100 |
| 20 | 20 | ~4 | 400 |
| 50 | 50 | ~6 | 2.500 |
| 100 | 100 | ~7 | 10.000 |
| 1.000 | 1.000 | ~10 | 1.000.000 |
| 10.000 | 10.000 | ~13 | 100.000.000 |
| 100.000 | 100.000 | ~17 | 10.000.000.000 |

**Observe:** O(n) cresce de forma **diretamente proporcional** - dobrando n, dobram as operações.

### Visualização Gráfica

```
Operações
    |                               O(n²) ─────→
    |                             /
    |                           /
    |                    O(n) /  ← Linha reta
    |                      /
    |              O(log n) → 
    |        O(1) ─────────────────
    |___________________________________ Tamanho (n)
    0     10    20    30    40    50
```

**O(n) forma uma linha reta** - crescimento constante e previsível.

---

## Características de Algoritmos O(n)

Um algoritmo tem complexidade **O(n)** quando:

1. ✅ **Percorre todos os elementos** uma vez (ou número constante de vezes)
2. ✅ **Loop simples** de 0 até n (ou 1 até n)
3. ✅ **Operações constantes** dentro do loop
4. ✅ **Tempo proporcional ao tamanho** da entrada

### Padrões Comuns de O(n):

#### Padrão 1: Loop Simples de 0 a n
```java
for (int i = 0; i < n; i++) {
    // Operação O(1)
}
```

#### Padrão 2: Percorrer Array/Lista
```java
for (int elemento : array) {
    // Processa cada elemento uma vez
}
```

#### Padrão 3: While com Decremento Unitário
```java
while (n > 0) {
    n--;  // Decrementa 1 por vez
}
```

#### Padrão 4: Busca Linear
```java
for (int i = 0; i < array.length; i++) {
    if (array[i] == alvo) return i;
}
```

---

## Análise Matemática de O(n)

### Função de Complexidade

Quando temos um loop que executa n vezes com operações constantes:

$$
T(n) = c_1 + c_2 \cdot n + c_3
$$

Onde:
- $c_1$: inicializações (constante)
- $c_2 \cdot n$: operações dentro do loop
- $c_3$: operações finais (constante)

### Forma Geral

$$
T(n) = an + b
$$

Onde $a$ e $b$ são constantes.

### Exemplo do Código

Para o código `somarNumeros()`:

$$
T(n) = 2 + 2n + 2 = 2n + 4
$$

Detalhamento:
- **2**: duas inicializações (`soma = 0`, `contador = 0`)
- **2n**: duas operações no loop executadas n vezes (`soma += i`, `contador++`)
- **2**: print e return finais

---

## Aplicando as Regras de Big O

### Exemplo Completo: T(n) = 2n + 4

#### Regra 1: Identificar Termos

$$
T(n) = \underbrace{2n}_{\text{termo dominante}} + \underbrace{4}_{\text{termo constante}}
$$

#### Regra 2: Remover Constantes Multiplicativas

O coeficiente **2** em $2n$ não afeta a ordem de crescimento:

$$
2n \rightarrow n
$$

**Por quê?** Porque $2n$ e $n$ crescem na mesma taxa:
- Se $n = 100$: $2n = 200$ vs $n = 100$ (mesma ordem de magnitude)
- Big O se preocupa com a **forma do crescimento**, não com fatores constantes

#### Regra 3: Remover Termos de Menor Ordem

Quando $n \rightarrow \infty$, o termo constante se torna irrelevante:

$$
n + 4 \rightarrow n
$$

**Demonstração:**
- $n = 10$: $n + 4 = 14$ (constante representa 28%)
- $n = 100$: $n + 4 = 104$ (constante representa 4%)
- $n = 1000$: $n + 4 = 1004$ (constante representa 0.4%)
- $n \rightarrow \infty$: constante se torna negligível

#### Resultado Final

$$
\boxed{O(n)}$$

---

## O Código TempoLinear.java e sua Análise

### Estrutura do Código

```java
public static int somarNumeros(int n) {
    int soma = 0;          // Linha 9: O(1) - inicialização
    int contador = 0;      // Linha 14: O(1) - inicialização
    
    for (int i = 1; i <= n; i++) {  // Linha 23: Loop executa n vezes
        soma += i;         // Linha 27: O(1) × n vezes
        contador++;        // Linha 32: O(1) × n vezes
    }
    
    System.out.println(...); // Linha 37: O(1) - print
    return soma;             // Linha 41: O(1) - retorno
}
```

### Contagem Detalhada de Operações

| Linha | Operação | Custo Individual | Repetições | Custo Total | Tipo |
|-------|----------|------------------|------------|-------------|------|
| 9 | Inicialização `soma` | O(1) | 1 vez | O(1) | Termo de menor ordem |
| 14 | Inicialização `contador` | O(1) | 1 vez | O(1) | Termo de menor ordem |
| **23** | **Loop for** | - | **n vezes** | - | **Operação crítica** |
| 27 | Adição `soma += i` | O(1) | n vezes | **O(n)** | **Termo dominante** |
| 32 | Incremento `contador++` | O(1) | n vezes | **O(n)** | **Termo dominante** |
| 37 | Print | O(1) | 1 vez | O(1) | Termo de menor ordem |
| 41 | Return | O(1) | 1 vez | O(1) | Termo de menor ordem |

### Análise Passo a Passo

#### Passo 1: Contar Operações Constantes

Fora do loop:
$$
\text{Inicializações} = 2 \times O(1) = 2
$$

$$
\text{Finalizações} = 2 \times O(1) = 2
$$

#### Passo 2: Contar Operações no Loop

Dentro do loop (executado n vezes):
$$
\text{Por iteração} = 2 \times O(1) = 2
$$

$$
\text{Total do loop} = 2 \times n = 2n
$$

#### Passo 3: Formar Equação Total

$$
T(n) = \underbrace{2}_{\text{inicializações}} + \underbrace{2n}_{\text{loop}} + \underbrace{2}_{\text{finalizações}}
$$

$$
T(n) = 2n + 4
$$

#### Passo 4: Aplicar Regras de Big O

**Remover constante multiplicativa:**
$$
2n + 4 \rightarrow n + 4
$$

**Remover termo de menor ordem:**
$$
n + 4 \rightarrow n
$$

#### Resultado Final:
$$
\boxed{O(n)}$$

---

## Por Que somarNumeros() é O(n)?

### Razões Fundamentais:

#### 1. **Loop Executa n Vezes**
```java
for (int i = 1; i <= n; i++)  // De 1 até n = n iterações
```

Exemplos concretos:
- `n = 5`: loop executa 5 vezes (i = 1, 2, 3, 4, 5)
- `n = 10`: loop executa 10 vezes (i = 1, 2, ..., 10)
- `n = 100`: loop executa 100 vezes

**Proporcionalidade direta!**

#### 2. **Operações Constantes Dentro do Loop**

Cada iteração faz **sempre o mesmo número de operações**:
```java
soma += i;      // 1 operação
contador++;     // 1 operação
// Total: 2 operações constantes
```

#### 3. **Crescimento Proporcional**

| n | Iterações | Operações no Loop | Total (2n + 4) |
|---|-----------|-------------------|----------------|
| 5 | 5 | 10 | 14 |
| 10 | 10 | 20 | 24 |
| 20 | 20 | 40 | 44 |
| 50 | 50 | 100 | 104 |

**Padrão:** Quando n dobra, o tempo **dobra** (crescimento linear).

#### 4. **Cada Elemento Processado Uma Vez**

O algoritmo visita cada número de 1 até n **exatamente uma vez**:
- Não pula elementos
- Não repete processamento
- Não divide o problema

Isso caracteriza **tempo linear**.

---

## Comparação com Outras Complexidades

### Tabela Comparativa: Tempo de Execução

| Entrada (n) | O(1) | O(log n) | **O(n)** | O(n log n) | O(n²) |
|-------------|------|----------|----------|------------|-------|
| 1 | 1 | 0 | **1** | 0 | 1 |
| 10 | 1 | 3 | **10** | 33 | 100 |
| 100 | 1 | 7 | **100** | 664 | 10.000 |
| 1.000 | 1 | 10 | **1.000** | 9.966 | 1.000.000 |
| 10.000 | 1 | 13 | **10.000** | 132.877 | 100.000.000 |

### Quando Usar O(n)?

| Situação | Adequado? | Motivo |
|----------|-----------|--------|
| Processar todos os elementos | ✅ Sim | É o mínimo necessário |
| Buscar em lista não ordenada | ✅ Sim | Pode estar em qualquer posição |
| Calcular soma/média | ✅ Sim | Precisa ver todos os valores |
| Buscar em lista ordenada | ❌ Não | Pode usar busca binária O(log n) |
| Grandes volumes de dados | ⚠️ Depende | Considerar otimizações |

---

## Exemplos Práticos de O(n)

### ✅ Busca Linear em Array
```java
public int buscarElemento(int[] array, int alvo) {
    for (int i = 0; i < array.length; i++) {  // n iterações
        if (array[i] == alvo) return i;
    }
    return -1;  // Não encontrado
}
// O(n) - no pior caso, precisa verificar todos os elementos
```

### ✅ Encontrar Máximo em Array
```java
public int encontrarMaximo(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {  // n-1 iterações ≈ n
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}
// O(n) - deve verificar todos os elementos
```

### ✅ Copiar Array
```java
public int[] copiarArray(int[] original) {
    int[] copia = new int[original.length];
    for (int i = 0; i < original.length; i++) {  // n iterações
        copia[i] = original[i];
    }
    return copia;
}
// O(n) - copia cada elemento uma vez
```

### ✅ Imprimir Todos os Elementos
```java
public void imprimirArray(int[] array) {
    for (int elemento : array) {  // n iterações
        System.out.println(elemento);
    }
}
// O(n) - imprime cada elemento uma vez
```

### ✅ Contar Ocorrências
```java
public int contarOcorrencias(int[] array, int valor) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {  // n iterações
        if (array[i] == valor) count++;
    }
    return count;
}
// O(n) - deve verificar todo o array
```

---

## Identificando Algoritmos O(n)

### Perguntas-Chave:

#### 1. **Há um loop simples que percorre n elementos?**
- ✅ Sim → Provável O(n)
- ❌ Não → Outra complexidade

#### 2. **Cada elemento é processado um número constante de vezes?**
- ✅ Sim → É O(n)
- ❌ Não (múltiplas vezes) → Pode ser O(n²) ou pior

#### 3. **O tempo dobra quando a entrada dobra?**
- ✅ Sim → É O(n)
- ❌ Não → Outra complexidade

### Sinais Visuais de O(n):

✅ **É O(n):**
```java
for (int i = 0; i < n; i++) {
    // Operação O(1)
}
```

✅ **É O(n):**
```java
for (int elemento : lista) {
    // Operação O(1)
}
```

❌ **NÃO é O(n) - É O(n²):**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {  // Loop aninhado!
        // Operação O(1)
    }
}
```

❌ **NÃO é O(n) - É O(log n):**
```java
while (n > 1) {
    n = n / 2;  // Divide pela metade!
}
```

---

## Múltiplos Loops Sequenciais

### Caso: Dois Loops Independentes

```java
public void processarDados(int[] array) {
    // Loop 1: O(n)
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
    
    // Loop 2: O(n)
    for (int i = 0; i < array.length; i++) {
        array[i] = array[i] * 2;
    }
}
```

**Análise:**
$$
T(n) = O(n) + O(n) = O(2n) = O(n)
$$

**Regra:** Loops sequenciais (não aninhados) **SOMAM**, mas somamos na mesma ordem:
- O(n) + O(n) = O(n)
- O(n) + O(n) + O(n) = O(3n) = O(n)

### Caso: Loop com Múltiplas Operações

```java
for (int i = 0; i < n; i++) {
    operacao1();  // O(1)
    operacao2();  // O(1)
    operacao3();  // O(1)
    operacao4();  // O(1)
    // 10 operações constantes mais...
}
```

**Análise:**
$$
T(n) = 10 \times O(1) \times n = 10n = O(n)
$$

**Conclusão:** Não importa quantas operações O(1) dentro do loop, ainda é **O(n)**.

---

## O(n) vs O(2n) vs O(5n) - Por Que Todos São O(n)?

### Análise Matemática

$$
O(2n) = O(n) \quad \text{porque} \quad 2 \text{ é constante}
$$

$$
O(5n) = O(n) \quad \text{porque} \quad 5 \text{ é constante}
$$

$$
O(100n) = O(n) \quad \text{porque} \quad 100 \text{ é constante}
$$

### Por Que Ignoramos Constantes?

Big O descreve **crescimento assintótico** - como o algoritmo se comporta quando $n \rightarrow \infty$.

#### Exemplo Prático:

| n | 2n | 5n | Diferença % |
|---|----|----|-------------|
| 10 | 20 | 50 | 150% |
| 100 | 200 | 500 | 150% |
| 1.000 | 2.000 | 5.000 | 150% |
| 10.000 | 20.000 | 50.000 | 150% |

**Observe:** A diferença percentual **permanece constante** (150%).

Ambos crescem na **mesma taxa** - a diferença é apenas um fator multiplicativo fixo.

---

## Quando O(n) é Bom ou Ruim?

### ✅ O(n) é EXCELENTE quando:
- Precisamos processar **todos** os elementos (inevitável)
- Operações simples: busca, contagem, cópia
- Tamanho moderado: até milhões de elementos
- Alternativa seria O(n²) ou pior

### ⚠️ O(n) é ACEITÁVEL quando:
- Não há algoritmo mais eficiente disponível
- Dados não estão ordenados
- Operações ocasionais (não em loop crítico)

### ❌ O(n) é PROBLEMÁTICO quando:
- Há alternativa O(log n) disponível (dados ordenados → busca binária)
- Executado repetidamente em loop externo → vira O(n²)
- Volumes muito grandes (bilhões de elementos)
- Requisitos de tempo real estrito

---

## Otimizações Comuns em O(n)

### 1. Early Return (Retorno Antecipado)

**Antes (sempre O(n)):**
```java
public boolean contemElemento(int[] array, int alvo) {
    boolean encontrado = false;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == alvo) encontrado = true;
    }
    return encontrado;
}
```

**Depois (melhor caso O(1), pior caso O(n)):**
```java
public boolean contemElemento(int[] array, int alvo) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == alvo) return true;  // Retorna imediatamente!
    }
    return false;
}
```

### 2. Evitar Operações Desnecessárias

**Antes:**
```java
for (int i = 0; i < n; i++) {
    int resultado = calcularAlgo();  // Calculado n vezes!
    array[i] = array[i] + resultado;
}
```

**Depois:**
```java
int resultado = calcularAlgo();  // Calculado UMA vez!
for (int i = 0; i < n; i++) {
    array[i] = array[i] + resultado;
}
```

### 3. Usar Estruturas de Dados Apropriadas

Se precisar de buscas frequentes, considere:
- **HashSet:** busca O(1) em vez de O(n)
- **HashMap:** acesso O(1) em vez de O(n)
- **Array ordenado:** busca binária O(log n) em vez de O(n)

---

## Conclusão

A função `somarNumeros()` é um **exemplo perfeito de O(n)** porque:

✅ **Loop executa n vezes** - proporcional à entrada  
✅ **Operações constantes dentro do loop** - 2 operações por iteração  
✅ **Crescimento linear:** dobrar n dobra o tempo  
✅ **Tempo proporcional:** T(n) = 2n + 4 → O(n)  

Esta é uma das **complexidades mais comuns** em algoritmos!

---

## Resumo das Regras de Big O Aplicadas

### Função Analisada:
$$T(n) = 2n + 4$$

### Aplicação das Regras:

| Regra | Operação | Resultado |
|-------|----------|-----------|
| **Identificar termos** | Termo dominante: 2n; Termo menor: 4 | $2n + 4$ |
| **Regra 1** | Remover constante multiplicativa (2) | $n + 4$ |
| **Regra 2** | Remover termo de menor ordem (+4) | $n$ |

### Resultado Final:
$$\boxed{O(n)}$$

---

## Hierarquia de Complexidades

| Complexidade | Eficiência | Exemplo Típico |
|--------------|-----------|----------------|
| O(1) | ⚡⚡⚡⚡⚡ Melhor | Acesso a array |
| O(log n) | ⚡⚡⚡⚡ Excelente | Busca binária |
| **O(n)** | **⚡⚡⚡ Bom** | **Busca linear** ← **ESTE CASO** |
| O(n log n) | ⚡⚡ Aceitável | Merge sort |
| O(n²) | ⚡ Ruim | Bubble sort |
| O(2ⁿ) | 🔥 Péssimo | Subconjuntos |
| O(n!) | 🔥🔥 Inviável | Permutações |

**O(n) é a complexidade da maioria dos algoritmos que precisam processar todos os dados!**
