# 👑 Problema de las 8 Reinas 👑

## 📋 Descripción General
Este programa implementa una solución interactiva al clásico problema de las 8 reinas. 
El objetivo es colocar ocho reinas en un tablero de ajedrez de 8×8 de manera que ninguna 
pueda atacar a otra (no puede haber dos reinas en la misma fila, columna o diagonal).

## 🏗️ Estructura del Programa
La aplicación sigue el patrón de arquitectura Modelo-Vista-Controlador (MVC):

### 📊 MODELO:
- **Tablero**: Representa el tablero de ajedrez y contiene la lógica de solución
- **Reina**: Representa una pieza de reina y sus reglas de amenaza

### 🖼️ VISTA:
- **TableroGUI**: Muestra la interfaz gráfica del tablero y gestiona los componentes visuales

### 🎮 CONTROLADOR:
- **TableroControlador**: Conecta el modelo y la vista, maneja las interacciones del usuario

## 🧩 Cómo Funciona el Algoritmo
El programa utiliza un algoritmo de backtracking para encontrar una solución:

1. El usuario coloca la primera reina en cualquier posición del tablero
2. El algoritmo intenta colocar las 7 reinas restantes en posiciones válidas
3. Si en algún momento no se puede colocar una reina, el algoritmo retrocede
4. El proceso continúa hasta encontrar una solución o determinar que no existe

## 🚀 Cómo Usar la Aplicación
1. Ejecute la aplicación a través de la clase **AplicacionOchoReinas**
2. Haga clic en cualquier casilla del tablero para colocar la primera reina
3. El algoritmo intentará resolver automáticamente el problema
4. Si existe solución, se mostrarán todas las reinas en el tablero
5. Si no hay solución desde esa posición inicial, se mostrará un mensaje de error
6. Para reiniciar, pulse el botón "Nueva Partida"

## 🧱 Componentes Principales
- **AplicacionOchoReinas**: Punto de entrada del programa
- **Tablero**: Contiene la lógica del juego y el algoritmo de resolución
- **Reina**: Define comportamiento y reglas de movimiento de cada reina
- **TableroGUI**: Interfaz gráfica con tablero interactivo
- **TableroControlador**: Gestiona la lógica entre el modelo y la vista

## 💡 Datos Interesantes
- El problema de las 8 reinas tiene 92 soluciones únicas
- La primera solución fue encontrada por Franz Nauck en 1850
- Es un ejemplo clásico para enseñar algoritmos de backtracking

## 🔧 Requisitos Técnicos
- Java Runtime Environment (JRE)
- Biblioteca Swing para la interfaz gráfica

## 🔜 Posibles Mejoras
- 🖼️ Añadir imágenes de reinas en lugar de símbolos de texto
- 🔄 Mostrar múltiples soluciones cuando existan
- ⏱️ Añadir animación del proceso de resolución
- 🔢 Permitir cambiar el tamaño del tablero
- 📊 Añadir estadísticas sobre soluciones encontradas
