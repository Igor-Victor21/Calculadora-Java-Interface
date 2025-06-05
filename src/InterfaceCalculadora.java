import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InterfaceCalculadora {
    //vetor que armazena os valores dos calculados
    static double[] vetorCalculo = new double[3];
    //recebe os operadores matematicos
    static String operadorMatematico;
    //variavel para auxiliar no aramazenamento do historico
    static String auxCalc;

    //um vetor de lista que armazena os calculos
    static ArrayList<String> historicoCalculos = new ArrayList<>();

    public void interfaceCalc(){
        //Criando frame e instaciando ele com o nome de calculadora
        JFrame janela = new JFrame("Calculadora");

        //tamanho janela
        janela.setSize(338,460);

        //colocando o botão de fechar, quando fechar a janela o código vai parar de rodar
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //desativando a opção de aumentar a tela da calculadora
        janela.setResizable(false);

        //Jpanel serve para organizar a interface grafica
        JPanel panel = new JPanel();

        //setando layout nulo para poder colocar os objetos da calculadora em qualquer posição
        panel.setLayout(null);

        //adicionando uma caixa de texto e instanciando-o com uma string vazio para não haver nenhum texto dentro
        JTextField texto = new JTextField("");

        //setando a fonte
        texto.setFont(new Font("Arial", Font.PLAIN,18));

        //setando as bordas da caixa de texto e a cor
        texto.setBorder(BorderFactory.createLineBorder(Color.black));

        //setando o tamanho da caixa de texto
        texto.setSize(300,60);

        //desativando o teclado
        texto.setFocusable(false);

        //add botões
        //JButton botao1 =new JButton("√Δ");
        JButton botao1 =new JButton("%");
        JButton botao2 =new JButton("CE");
        JButton botao3 =new JButton("C");
        JButton botao4 =new JButton("REMOV");
        JButton botao5 =new JButton("7");
        JButton botao6 =new JButton("8");
        JButton botao7 =new JButton("9");
        JButton botao8 =new JButton("X");
        JButton botao9 =new JButton("4");
        JButton botao10 =new JButton("5");
        JButton botao11 =new JButton("6");
        JButton botao12 =new JButton("-");
        JButton botao13 =new JButton("1");
        JButton botao14 =new JButton("2");
        JButton botao15 =new JButton("3");
        JButton botao16 =new JButton("+");
        JButton botao17 =new JButton("÷");
        JButton botao18 =new JButton("0");
        JButton botao19 =new JButton(",");
        JButton botao20 =new JButton("=");
        JButton botao21 =new JButton("HISTÓRICO");

        //setando os tamanhos dos botões
        botao1.setBounds(0,60,80,60);
        botao2.setBounds(80,60,80,60);
        botao3.setBounds(160,60,80,60);
        botao4.setBounds(240,60,80,60);
        botao5.setBounds(0,120,80,60);
        botao6.setBounds(80,120,80,60);
        botao7.setBounds(160,120,80,60);
        botao8.setBounds(240,120,80,60);
        botao9.setBounds(0,180,80,60);
        botao10.setBounds(80,180,80,60);
        botao11.setBounds(160,180,80,60);
        botao12.setBounds(240,180,80,60);
        botao13.setBounds(0,240,80,60);
        botao14.setBounds(80,240,80,60);
        botao15.setBounds(160,240,80,60);
        botao16.setBounds(240,240,80,60);
        botao17.setBounds(0,300,80,60);
        botao18.setBounds(80,300,80,60);
        botao19.setBounds(160,300,80,60);
        botao20.setBounds(240,300,80,60);
        botao21.setBounds(0,360,320,60);
        texto.setSize(320,60);

        //add todos os Botões no JPanel, é importante alertar que *TEM QUE SER NO JPanel*
        //Pois se não havera bugs visuais na interface se adicionar os itens no JFrame
        //Add Primeiro no JPanel para depois adcionar o JPanel no JFrame para não ocorrer bugs
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
        panel.add(botao14);
        panel.add(botao15);
        panel.add(botao16);
        panel.add(botao17);
        panel.add(botao18);
        panel.add(botao19);
        panel.add(botao20);
        panel.add(botao21);
        panel.add(texto);

        //IMPORTANTE
        //SEMPRE ADICIONE POR ULTIMO O JFRAME COM O JPANEL
        //PARA NÃO ROLAR BUGS VISUAIS
        janela.add(panel);

        //tornando os botões visiveis
        janela.setVisible(true);

        //ADD FUNÇÕES AOS BOTÕES

        //%
        botao1.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "%";
            auxCalc = texto.getText();

            texto.setText("");
        });

        //CE
        botao2.addActionListener(e -> {
            System.exit(0);
        });

        //C
        botao3.addActionListener(e -> {
            texto.setText("");
        });

        //REMOV
        botao4.addActionListener(e -> {
            String correnteTexto = texto.getText();

            if (correnteTexto.length() > 0){
                texto.setText(correnteTexto.substring(0, correnteTexto.length() - 1));
            }
        });

        //7
        botao5.addActionListener(e -> {
            texto.setText(texto.getText() + "7");
        });

        //8
        botao6.addActionListener(e -> {
            texto.setText(texto.getText() + "8");

        });

        //9
        botao7.addActionListener(e -> {
            texto.setText(texto.getText() + "9");
        });

        //x (vezes)
        botao8.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "X";
            auxCalc = texto.getText();

            texto.setText("");
        });

        //4
        botao9.addActionListener(e -> {
            texto.setText(texto.getText() + "4");
        });

        //5
        botao10.addActionListener(e -> {
            texto.setText(texto.getText() + "5");
        });

        //6
        botao11.addActionListener(e -> {
            texto.setText(texto.getText() + "6");
        });

        //-
        botao12.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "-";
            auxCalc = texto.getText();

            texto.setText("");


        });

        //1
        botao13.addActionListener(e -> {
            texto.setText(texto.getText() + "1");
        });

        //2
        botao14.addActionListener(e -> {
            texto.setText(texto.getText() + "2");
        });

        //3
        botao15.addActionListener(e -> {
            texto.setText(texto.getText() + "3");
        });

        //+
        botao16.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "+";
            auxCalc = texto.getText();

            texto.setText("");
        });

        //÷ (divisão)
        botao17.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "/";
            auxCalc = texto.getText();

            texto.setText("");
        });

        //0
        botao18.addActionListener(e -> {
            texto.setText(texto.getText() + "0");
        });

        //,
        botao19.addActionListener(e -> {
            texto.setText(texto.getText() + ".");
        });

        //= (VERIFICA QUANDO OPERAÇÃO MATEMATICA FOI REALIZADA, ATRAVES DO IF OU ELSE IF)
        botao20.addActionListener(e -> {
            double calculo;
            String historico;
            vetorCalculo[1] = Double.parseDouble(texto.getText());

            // VERIFICADORES DE QUAL OPERAÇÃO FAZER
            // se o operadorMatematico for igual a "+"(mais)
            if (operadorMatematico == "+"){

                //então
                //variavel calculo recebe vetor no indice [0] +
                //vetor no indice [1]
                calculo = vetorCalculo[0]+vetorCalculo[1];

                //vetorCalculo recebe o resultado da operação no indece[2]
                vetorCalculo[2]=calculo;

                //historico recebe o valor da variavel auxiliar mais o operador matematico
                //mais o que esta armazenado no JTextField e mais o resultado da operação
                historico = auxCalc+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];

                //JTextField recebendo o valor do resultado da opração matematica
                //atraves de texto
                //ps: foi transformada de double para String com String.valueOf(vetorCalculo[2]
                texto.setText(String.valueOf(vetorCalculo[2]));

            }
            //segue o mesmo padrão para todos
            else if (operadorMatematico == "-"){
                calculo = vetorCalculo[0]-vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalc+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            else if (operadorMatematico == "%"){
                calculo = vetorCalculo[0]%vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalc+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            //alerta de dividir por 0
            else if (vetorCalculo[1] == 0){
                JOptionPane.showMessageDialog(null, "Não é possível dividir por 0");
            }

            else if (operadorMatematico == "/"){
                calculo = vetorCalculo[0]/vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalc+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            else if (operadorMatematico == "X"){
                calculo = vetorCalculo[0]*vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalc+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }

            auxCalc = vetorCalculo[0]+" "+operadorMatematico+" "+vetorCalculo[1]+" = "+texto.getText();
            //adicionando em um arrayList global o resultado das operações
            //em formato de texto com a variavel auxCalculoExibir
            historicoCalculos.add(auxCalc);

            //Salvando o Historico em um arquivo .txt
            //criando uma variavel para colocar o nome do arquivo dentro dela
            String nomeArquivo = "Arquivo.txt";

            //fazendo um try catch para caso ocorra algum erro na hora de salvar
            //os arquivos ele trate este erro na hora e rode o código mesmo assim
            try{
                //Classe FileWriter Responsavel pot salvar em um arquivo txt
                FileWriter escritor = new FileWriter(nomeArquivo,true);

                //metodo write serve para escrever um texto em um arquivo
                //aki tive que adaptar utilizando o variavel auxiliar
                //como tudo que aparecia pro usuario final era com a variavel
                //auxiliar então eu so utilizei ela ao invés do JTextField igual
                //o professor fez, e dei uma quebra de linha para ficar certinho
                //um em baixo do outro no Arquivo.txt
                escritor.write(auxCalc+"\n");

                //fechando o arquivo após a escrita
                escritor.close();
            }catch (IOException ex){
                //metodo printStackTrace serve para exibir o erro no ***CONSOLE***
                //quando algo da errado
                ex.printStackTrace();
            }
        });

        //HISTÓRICO
        botao21.addActionListener(e -> {

            HistoricoSalvar historicoSalvar = new HistoricoSalvar();
            //chamando a função para exibir a tela de historico
            janela.dispose();
            HistoricoSalvar.historico(historicoCalculos);

        });


        }
}
