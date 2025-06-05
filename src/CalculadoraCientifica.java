import javax.swing.*;
import java.awt.*;

public class CalculadoraCientifica {
    Calculos calculos = new Calculos();

    public void calcs() {
        // Criando janela
        JFrame janela = new JFrame("Calculadora Científica");

        // Setando o tamanho da janela
        janela.setSize(338, 300);

        // Botão de fechar, quando pressionar o programa será fechado
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Desativando o botão de expandir
        janela.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Criando os botões
        JButton botao7 = new JButton("Descubra os Triângulos");
        JButton botao8 = new JButton("Voltar");

        // Definindo a posição e o tamanho dos botões
        botao7.setBounds(0, 10, 338, 60);
        botao8.setBounds(0, 70, 338, 60);

        botao7.addActionListener(e -> {
            calculos.calcTriangulos();
        });

        botao8.addActionListener(e -> {
            InterfaceCalculadora interfaceC = new InterfaceCalculadora();
            interfaceC.interfaceCalc();
        });

        panel.add(botao7);
        panel.add(botao8);

        // Adicionando o painel ao JFrame
        janela.add(panel);

        // Tornando os botões visíveis
        janela.setVisible(true);
    }
}
