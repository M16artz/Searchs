# Taller 7: Implementación de Algoritmos de Búsqueda

Este proyecto implementa diversas estrategias de búsqueda (Secuencial, Binaria, Centinela) sobre Arreglos y Listas Enlazadas Simples (SLL) en Java. El objetivo es comparar el rendimiento, analizar el número de comparaciones y validar el comportamiento en casos borde.

## 📋 Información General

* **Universidad:** Universidad Nacional de Loja
* **Carrera:** Computación
* **Asignatura:** Estructura de Datos
* **Unidad:** 2
* **Integrantes:**
    * Miguel Armas (@M16artz)
    * Richard Cajas (@RichardC022)
    * Mateo Silva (@Mzero11)

---
## Requisitos
Java Development Kit (JDK) 8 o superior.

IDE de Java (NetBeans, Eclipse, IntelliJ) o terminal.

📄 Licencia
Este proyecto es de uso académico para la asignatura de Estructura de Datos.
## 🚀 Características del Proyecto

El sistema cuenta con un menú interactivo en consola que permite probar:

### 1. Búsqueda en Arreglos (`BusquedaArreglos.java`)
* **Secuencial (Lineal):**
    * `primeraOcurrencia`: Encuentra el índice del primer elemento coincidente.
    * `ultimaOcurrencia`: Encuentra el índice del último elemento coincidente.
    * `findAll`: Retorna una lista con todos los índices usando predicados (`IntPredicate`).
* **Optimización con Centinela:**
    * Implementación que elimina la verificación de límites (`i < n`) en el bucle principal.
    * Incluye contador de trazas para comparar rendimiento lógico vs secuencial estándar.
* **Búsqueda Binaria (Requiere Ordenamiento):**
    * `binarySearch`: Algoritmo iterativo clásico ($O(\log n)$).
    * `lowerBound`: Encuentra la primera posición donde se puede insertar un valor manteniendo el orden.
    * `upperBound`: Encuentra la primera posición mayor al valor buscado.

### 2. Búsqueda en Listas Enlazadas (`BusquedaLista.java`)
* Implementación sobre una SLL personalizada (`Nodo.java`).
* Métodos: `primeraOcurrencia`, `ultimaOcurrenciaSLL`, y `encontrarTodos` (usando Lambdas).

---

## 🧪 Datasets de Prueba

El proyecto utiliza los siguientes conjuntos de datos estandarizados para validación:

| Dataset | Contenido | Propósito |
| :--- | :--- | :--- |
| **A** | `{8, 3, 6, 3, 9}` | Arreglo desordenado (Caso promedio). |
| **B** | `{5, 4, 3, 2, 1}` | Arreglo invertido (Peor caso para ordenamientos). |
| **C** | `{1, 2, 3, 4, 5}` | Arreglo ordenado (Prueba de Búsqueda Binaria). |
| **D** | `{2, 2, 2, 2}` | Arreglo con duplicados (Prueba de Bounds). |

---

## 🛠️ Instalación y Ejecución

### Requisitos
* Java Development Kit (JDK) 11 o superior.
* IDE sugerido: Visual Studio Code (con Extension Pack for Java) o IntelliJ IDEA.

### Pasos
1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/M16artz/Searchs.git
    ```
2.  **Compilar el proyecto:**
    Abrir el proyecto en el IDE y permitir que indexe los archivos en `src/`.
3.  **Ejecutar:**
    Localizar la clase principal `ed.u2.searchs.view.SortingDemo.java` y ejecutarla.
---

## 🔍 Análisis de Resultados

### Comparativa: Secuencial vs Centinela
Se demostró que aunque ambos algoritmos realizan el mismo número de comparaciones de datos (`a[i] == key`) en el peor caso, el algoritmo del **Centinela** es más eficiente a nivel de instrucciones de CPU porque elimina la comprobación `i < n` en cada iteración del bucle.

### Casos Borde Detectados y Manejados
1.  **Arreglos/Listas Nulos:** Se implementaron validaciones `if (obj == null)` al inicio de cada método para evitar `NullPointerException`.
2.  **Binaria en Desorden:** Se identificó que la búsqueda binaria retorna falsos negativos si el arreglo no está ordenado. Se documentó la precondición de ordenamiento (usando `BubbleSort` o Arrays pre-ordenados como el **C**).

---

## 📂 Estructura del Proyecto

```text
src/
└── ed/u2/searchs/
    ├── algorithms/
    │   ├── BubbleSort.java       # Algoritmo de ordenamiento auxiliar
    │   ├── BusquedaArreglos.java # Lógica de búsqueda en arrays
    │   ├── BusquedaLista.java    # Lógica de búsqueda en SLL
    │   └── ListaEnlazada.java    # (Opcional) Wrapper de la lista
    ├── model/
    │   └── Nodo.java             # Estructura del nodo
    └── view/
        └── SortingDemo.java      # Main ejecutable con menú

