import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculos {
    int cont = 0;
    static ArrayList<String> historicoCalculos = new ArrayList<>();

    public void calcTriangulos() {
        double[] vetorTriangulo = new double[3];

        JFrame janela = new JFrame("Descubra os Triângulos");
        janela.setSize(338, 460);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel mensagem = new JLabel("Informe o lado:");
        mensagem.setFont(new Font("Arial", Font.PLAIN, 16));
        mensagem.setBounds(0, 5, 338, 20);

        JTextField texto = new JTextField();
        texto.setFont(new Font("Arial", Font.PLAIN, 18));
        texto.setBorder(BorderFactory.createLineBorder(Color.black));
        texto.setSize(300, 60);
        texto.setFocusable(false);
        texto.setBounds(0, 30, 338, 60);

        JButton botao1 = new JButton("REMOV");
        JButton botao2 = new JButton("7");
        JButton botao3 = new JButton("8");
        JButton botao4 = new JButton("9");
        JButton botao5 = new JButton("4");
        JButton botao6 = new JButton("5");
        JButton botao7 = new JButton("6");
        JButton botao8 = new JButton("1");
        JButton botao9 = new JButton("2");
        JButton botao10 = new JButton("3");
        JButton botao11 = new JButton("0");
        JButton botao12 = new JButton("ENVIAR");
        JButton botao13 = new JButton("HISTÓRICO");

        botao1.setBounds(0, 100, 84, 60);
        botao2.setBounds(84, 100, 84, 60);
        botao3.setBounds(168, 100, 84, 60);
        botao4.setBounds(252, 100, 84, 60);
        botao5.setBounds(0, 160, 84, 60);
        botao6.setBounds(84, 160, 84, 60);
        botao7.setBounds(168, 160, 84, 60);
        botao8.setBounds(252, 160, 84, 60);
        botao9.setBounds(0, 220, 84, 60);
        botao10.setBounds(84, 220, 84, 60);
        botao11.setBounds(168, 220, 84, 60);
        botao12.setBounds(252, 220, 84, 60);
        botao13.setBounds(0, 280, 338, 60);

        panel.add(mensagem);
        panel.add(texto);
        panel.add(botao1);
        panel.add(botao2);
        panel.add(botao3);
        panel.add(botao4);
        panel.add(botao5);
        panel.add(botao6);
        panel.add(botao7);
        panel.add(botao8);
        panel.add(botao9);
        panel.add(botao10);
        panel.add(botao11);
        panel.add(botao12);
        panel.add(botao13);

        janela.add(panel);

        // Função para adicionar número ao texto
        ActionListener addNumero = e -> {
            JButton botao = (JButton) e.getSource();
            texto.setText(texto.getText() + botao.getText());
        };

        botao2.addActionListener(addNumero);
        botao3.addActionListener(addNumero);
        botao4.addActionListener(addNumero);
        botao5.addActionListener(addNumero);
        botao6.addActionListener(addNumero);
        botao7.addActionListener(addNumero);
        botao8.addActionListener(addNumero);
        botao9.addActionListener(addNumero);
        botao10.addActionListener(addNumero);
        botao11.addActionListener(addNumero);

        // REMOV
        botao1.addActionListener(e -> {
            String atual = texto.getText();
            if (!atual.isEmpty()) {
                texto.setText(atual.substring(0, atual.length() - 1));
            }
        });

        // ENVIAR
        botao12.addActionListener(e -> {
            String entrada = texto.getText().trim();
            if (!entrada.matches("\\d+(\\.\\d+)?")) {
                texto.setText("Número inválido!");
                return;
            }
            vetorTriangulo[cont] = Double.parseDouble(entrada);
            cont++;
            texto.setText("");

            if (cont == 3) {
                if (vetorTriangulo[0] == vetorTriangulo[1] && vetorTriangulo[1] == vetorTriangulo[2]) {
                    texto.setText("Triângulo equilátero");
                    //historicoCalculos = "Base: "+ String.valueOf(vetorTriangulo[0])  + " Lado A: "+ String.valueOf(vetorTriangulo[1])+ " Lado B: " + String.valueOf(vetorTriangulo[2]) + " = Triângulo equilátero";
                } else if (vetorTriangulo[0] != vetorTriangulo[1] && vetorTriangulo[0] != vetorTriangulo[2] && vetorTriangulo[1] != vetorTriangulo[2]) {
                    texto.setText("Triângulo escaleno");
                } else {
                    texto.setText("Triângulo isósceles");
                }
                cont = 0;
            }
        });

        // HISTÓRICO
        botao13.addActionListener(e -> {
            // implementar se quiser
        });

        janela.setVisible(true);
    }
}
