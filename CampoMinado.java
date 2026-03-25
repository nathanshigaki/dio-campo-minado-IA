import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CampoMinado extends JFrame {
    private final int TAMANHO = 10; // Tabuleiro 10x10
    private final int MINAS = 15;   // Quantidade de bombas
    private JButton[][] botoes = new JButton[TAMANHO][TAMANHO];
    private boolean[][] temMina = new boolean[TAMANHO][TAMANHO];
    private int[][] vizinhos = new int[TAMANHO][TAMANHO];
    private boolean[][] revelado = new boolean[TAMANHO][TAMANHO];
    private int celulasReveladas = 0;

    public CampoMinado() {
        setTitle("Campo Minado Java");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(TAMANHO, TAMANHO));

        inicializarJogo();
        setVisible(true);
    }

    private void inicializarJogo() {
        // 1. Criar os botões e interface
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].setFont(new Font("Arial", Font.BOLD, 15));
                final int r = i;
                final int c = j;
                
                botoes[i][j].addActionListener(e -> clicarBotao(r, c));
                add(botoes[i][j]);
            }
        }

        // 2. Colocar as minas aleatoriamente
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < MINAS) {
            int r = rand.nextInt(TAMANHO);
            int c = rand.nextInt(TAMANHO);
            if (!temMina[r][c]) {
                temMina[r][c] = true;
                colocadas++;
            }
        }

        // 3. Calcular números de vizinhos
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if (!temMina[i][j]) {
                    vizinhos[i][j] = contarMinasVizinhas(i, j);
                }
            }
        }
    }

    private int contarMinasVizinhas(int r, int c) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO && temMina[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void clicarBotao(int r, int c) {
        if (revelado[r][c]) return;

        if (temMina[r][c]) {
            revelarTudo();
            JOptionPane.showMessageDialog(this, "BOOM! Perdeste.");
            System.exit(0);
        } else {
            revelarCelula(r, c);
            verificarVitoria();
        }
    }

    private void revelarCelula(int r, int c) {
        if (r < 0 || r >= TAMANHO || c < 0 || c >= TAMANHO || revelado[r][c]) return;

        revelado[r][c] = true;
        celulasReveladas++;
        botoes[r][c].setEnabled(false);
        botoes[r][c].setBackground(Color.LIGHT_GRAY);

        if (vizinhos[r][c] > 0) {
            botoes[r][c].setText(String.valueOf(vizinhos[r][c]));
        } else {
            // RECURSIVIDADE: Se for 0, revela os vizinhos automaticamente
            for (int i = r - 1; i <= r + 1; i++) {
                for (int j = c - 1; j <= c + 1; j++) {
                    revelarCelula(i, j);
                }
            }
        }
    }

    private void revelarTudo() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if (temMina[i][j]) {
                    botoes[i][j].setText("💣");
                    botoes[i][j].setBackground(Color.RED);
                }
            }
        }
    }

    private void verificarVitoria() {
        if (celulasReveladas == (TAMANHO * TAMANHO) - MINAS) {
            JOptionPane.showMessageDialog(this, "Parabéns! Limpaste o campo.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CampoMinado();
    }
}