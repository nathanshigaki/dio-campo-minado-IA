# Campo Minado em Java

Este é um projeto simples de um jogo de **Campo Minado** desenvolvido em Java utilizando a biblioteca gráfica **Swing**. O jogo desafia o utilizador a revelar todas as células que não contêm minas num tabuleiro 10x10.

---

## 🚀 Funcionalidades

O projeto implementa as mecânicas clássicas do jogo:

* **Tabuleiro Dinâmico**: Uma grelha de 10x10 células.
* **Minas Aleatórias**: São posicionadas 15 minas de forma aleatória a cada novo jogo.
* **Cálculo de Vizinhos**: O sistema calcula automaticamente quantas minas existem em redor de cada célula.
* **Revelação Recursiva**: Ao clicar numa célula sem minas vizinhas (valor 0), o jogo revela automaticamente as células adjacentes.
* **Condições de Vitória e Derrota**:
    * **Derrota**: Se clicar numa mina, o jogo revela todas as bombas em vermelho e termina.
    * **Vitória**: Ao revelar todas as células seguras (85 células), o utilizador é notificado da vitória.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: Java.
* **Interface Gráfica**: Java Swing (JFrame, JButton, JOptionPane).
* **Lógica**: Recursividade para expansão de células vazias e manipulação de matrizes.

---

## 📋 Como Executar

Para correr este projeto, precisa de ter o **JDK (Java Development Kit)** instalado na sua máquina.

1.  **Descarregue ou copie** o ficheiro `CampoMinado.java`.
2.  **Abra o terminal** na pasta onde guardou o ficheiro.
3.  **Compile o código**:
    ```bash
    javac CampoMinado.java
    ```
4.  **Execute o jogo**:
    ```bash
    java CampoMinado
    ```

---

## 🕹️ Como Jogar

1.  Clique em qualquer botão para revelar o conteúdo da célula.
2.  **Números**: Indicam quantas minas existem nas 8 células vizinhas.
3.  **Células Cinzentas**: São áreas seguras já reveladas.
4.  **Objetivo**: Revelar todos os quadrados que não possuem a bomba 💣. Se clicar numa bomba, o jogo termina imediatamente.

---

> **Dica**: O jogo utiliza um sistema de cores para facilitar a visualização: cinzento para áreas seguras e vermelho para destacar as minas quando perde.
"""
