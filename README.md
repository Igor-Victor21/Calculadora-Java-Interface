 Calculadora em java finalizada Calculadora apenas com botões (teclado esta desativado), contendo histórico dos cálculos e armazenando em um arquivo.txt, feito no Intellij IDEA Community 

    //VETOR E SEUS INDICES [0] [1] [2] (Array)
    // vetor global armazena os 3 números da interface
    // no primeiro indice do vetor fica o número que o
    // usuario vai utilizar na primeira parte do calculo
    //o segundo indice é o segundo valor que irá utilizar
    // no calculo, e o terceiro indice é o resultado
    static double [] vetorCalculo = new double[3];

    // VARIAVEIS GLOBAIS

    // OPERADOR MATEMATICO
    // basicamente a variavel operadorMatematico recebe o sinal
    // da operação matematica realizada em forma de texto para exibir
    // para o usuario, basicamente quando o usuario clicar no botão
    // utilizando o metodo addActionListener juntamente com o metodo
    // lambda, o sistema irá entender que foi precionado o botão
    // ai que a variavel operadorMatematico recebe o valor dele normalmente
    // ex:
    // botão X (vezes) foi precionado
    // operadorMatematico = "X"
    // simples assim
    static String operadorMatematico;

    // AUX CALCULO EXIBIR
    // serve basicamente para quando precionar o botão de igual (=)
    // ele receber os valores convertido em forma de texto
    // do vetor no indice 1 , 2 e 3 juntamente com o operador
    // matematico apenas para exibir e mostra para o usuario
    // a conta final e quando precionar o botão de historico
    // para exibir as contas ja feitas pelo sistema
    // ps: botão de historico adiciona os valores da variavel
    // auxCalculoExibir dentro de um Arraylist para exibir em
    // forma de lista para os usuarios
    static String auxCalculoExibir;

    // ARRAYLIST
    // responsavel por receber o valor da variavel global auxCalculoExibir
    // para mostrar para o usuario o historico das contas do usuario
    // ps: explicando mais sobre no metodo de historico
    // responsavel por exibir um nova tela de historico para o usuario
    static ArrayList<String> historicoCalculos = new ArrayList<>();

    // metodo interface grafica da calculadora
    public static void calculadora(){

        //criando um frame
        //criando um objeto e instânciando ele
        //em outras palavra abrindo uma pagína nova com o nome "Calculadora"
        JFrame janela = new JFrame("Calculadora");

        //setando o tamanho da janela com janela.setBounds
        janela.setSize(338,460);

        //colocando o botão de fechar o programa no X da pagína
        //fechando no X o sistema para de rodar tanto na pagína quanto no programa
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //caso não tenha o código acima o sistema ao fechar no X ainda continuaria Rodando

        //FlowLayout para organizar os itens do contêiner da esquerda para direita
        //de baixo para cima
        //em outras palavras serve para organizar a pagína

        //JPanel utilizado para organizar a interface grafica da forma que quiser
        JPanel panel = new JPanel();
        //setando layout em nulo para poder colocar em qualquer posição
        //atraves do setBounds utilizando pixels como localização
        panel.setLayout(null);


        //adicionando uma caixa de texto instânciado como vazio para não ter nenhum texto
        JTextField texto = new JTextField("");

        //setando a Fonte que será utilizada
        texto.setFont(new Font("Arial", Font.PLAIN ,18));

        //Setando as bordas no texto, e sentando a cor do texto
        texto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //setando o tamanho do texto
        texto.setSize(300,60);

        //retirando  a função de teclado do usuario
        //so sera utilizado com os botões da calculadora
        texto.setFocusable(false);

        //adicionando os botões
        JButton botao1 = new JButton("%");
        JButton botao2 = new JButton("CE");
        JButton botao3 = new JButton("C");
        JButton botao4 = new JButton("REMOV");
        JButton botao5 = new JButton("7");
        JButton botao6 = new JButton("8");
        JButton botao7 = new JButton("9");
        JButton botao8 = new JButton("X");
        JButton botao9 = new JButton("4");
        JButton botao10 = new JButton("5");
        JButton botao11 = new JButton("6");
        JButton botao12 = new JButton("-");
        JButton botao13 = new JButton("1");
        JButton botao14 = new JButton("2");
        JButton botao15 = new JButton("3");
        JButton botao16 = new JButton("+");
        JButton botao17 = new JButton("/");
        JButton botao18 = new JButton("0");
        JButton botao19 = new JButton(",");
        JButton botao20 = new JButton("=");
        JButton botao21 = new JButton("HISTÓRICO");

        //setando localização e tamanho dos botões
        botao1.setBounds(0, 60, 80, 60);
        botao2.setBounds(80, 60, 80, 60);
        botao3.setBounds(160, 60, 80, 60);
        botao4.setBounds(240, 60, 80, 60);
        botao5.setBounds(0, 120, 80, 60);
        botao6.setBounds(80, 120, 80, 60);
        botao7.setBounds(160, 120, 80, 60);
        botao8.setBounds(240, 120,80, 60);
        botao9.setBounds(0, 180, 80, 60);
        botao10.setBounds(80, 180, 80, 60);
        botao11.setBounds(160, 180, 80, 60);
        botao12.setBounds(240, 180, 80, 60);
        botao13.setBounds(0, 240, 80, 60);
        botao14.setBounds(80, 240, 80, 60);
        botao15.setBounds(160, 240, 80, 60);
        botao16.setBounds(240, 240, 80, 60);
        botao17.setBounds(0, 300, 80, 60);
        botao18.setBounds(80, 300, 80, 60);
        botao19.setBounds(160, 300, 80, 60);
        botao20.setBounds(240, 300, 80, 60);
        botao21.setBounds(0,360,320,60);
        texto.setSize(320,60);

        //add todos os botões no panel
        //(importante adicionar tudo que for interface grafica no JPanel)
        //ps: pode até funcionar se colocar diretor JFrame porém pode ficar ruim
        // ou ocasionar em muitos bugs
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

        // IMPORTANTE
        // SEMPRE ADICIONE POR ULTIMO O JFRAME COM O JPANEL
        // PARA NAO ROLAR BUGS VISUAIS
        janela.add(panel);

        //tornando todos os botões ou opções GUI visiveis
        janela.setVisible(true);

        // ADICIONANDO FUNÇÕES NOS BOTÕES
        //%
        botao1.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "%";
            auxCalculoExibir = texto.getText();

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
            auxCalculoExibir = texto.getText();

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
            auxCalculoExibir = texto.getText();

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
            auxCalculoExibir = texto.getText();

            texto.setText("");
        });
        // / (divisão)
        botao17.addActionListener(e -> {
            vetorCalculo[0] = Double.parseDouble(texto.getText());

            operadorMatematico = "/";
            auxCalculoExibir = texto.getText();

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
        //= (VERIFICA QUANDO OPERAÇÃO MATEMATICA FOI REALIZADA)
        // ATRAVES DO IF OU ELSE IF
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
                historico = auxCalculoExibir+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];

                //JTextField recebendo o valor do resultado da opração matematica
                //atraves de texto
                //ps: foi transformada de double para String com String.valueOf(vetorCalculo[2]
                texto.setText(String.valueOf(vetorCalculo[2]));

            }
            //segue o mesmo padrão para todos
            else if (operadorMatematico == "-"){
                calculo = vetorCalculo[0]-vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalculoExibir+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            else if (operadorMatematico == "%"){
                calculo = vetorCalculo[0]%vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalculoExibir+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            else if (operadorMatematico == "/"){
                calculo = vetorCalculo[0]/vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalculoExibir+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }
            else if (operadorMatematico == "X"){
                calculo = vetorCalculo[0]*vetorCalculo[1];
                vetorCalculo[2]=calculo;
                historico = auxCalculoExibir+" " + operadorMatematico+ " "+texto.getText() + " = "+vetorCalculo[2];
                texto.setText(String.valueOf(vetorCalculo[2]));
            }

            auxCalculoExibir = vetorCalculo[0]+" "+operadorMatematico+" "+vetorCalculo[1]+" = "+texto.getText();
            //adicionando em um arrayList global o resultado das operações
            //em formato de texto com a variavel auxCalculoExibir
            historicoCalculos.add(auxCalculoExibir);

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
                escritor.write(auxCalculoExibir+"\n");

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

            // chamando a função para exibir a tela de historico
            historico(historicoCalculos);

        });


    }
    // metodo reponsavel por adicionar uma nova tela para exibir um historico
    // com interface grafica para o usuario
    public static void historico(ArrayList<String> historicoCalculos){

        // expliquei tudo isso ja la no topo do código
        JFrame tela = new JFrame("Histórico");
        tela.setSize(500,435);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);

        // vetor para armazenar os calculos (parte visual)
        String[] coluna = {"Calculos"};

        // vetor que recebe os dados das contas para exibir
        // inicializado com o arraylist
        String[][] dados = new String[historicoCalculos.size()][1];

        int i = 0;

        //passando os valores para o vetor de dados de dentro de um arraylist
        //com um for each
        for (String dado : historicoCalculos){
            dados[i][0] = dado;
            i++;
        }

        //criando um JTable para exbir os resultados com os valores dos dados
        //e das colunas (vetores ja criados anteriormente)
        JTable table = new JTable(dados,coluna);
        // setando null para poder colocar aonde eu quiser
        table.setLayout(null);
        // 5 pixels da borda com a altura de 5 pixels, com a largura de 260 pixels
        // e a grossura// altura de 390 pixels
        table.setBounds(5,5,260,390);

        //nao sei para que serve porém é importante
        //pesquisei e não sei explicar direito
        // por isso e melhor pesquisar
        table.setDefaultEditor(Object.class,null);

        // adiciona uma barra de rolagem para baixo
        // precisa disso pois se não irá bugar
        // não é necessariamente um bug porém e consideravel
        // a oracle fez isso não sei por qual motivo mas eles falam
        // que não é bug é assim mesmo :/
        JScrollPane scrollPane = new JScrollPane(table);

        //setando o local da barra de rolagem
        scrollPane.setBounds(5,5,260,390);

        // adicionando a barra de rolagem na tela
        tela.add(scrollPane);

        // deixando tudo visivel
        tela.setVisible(true);
        lerHistorico();

    }

    private static String[] lerHistorico() {
        String nomeArquivo = "Arquivo.txt";

        // fazendo um try catch caso ocorra algum erro,
        // IOException irá tratar este erro e irá exibir
        // no console
        try{
            //A classe BufferedReader responsavel por ler arquivos ou ler entradas
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));

            //variavel para contar o número de linhas
            int contadorLinhas = 0;

            //while que irá ler as linhas do arquivo
            //enquanto a linha do arquivo for diferente de nulo
            //ele irá contar quantidade de linhas do arquivo
            while (leitor.readLine() != null){
                contadorLinhas++;
            }
            // quando parar não ter mais nada para ler nas linhas do arquivo
            // o sistema irá parar de ler o arquivo .txt

            //parando de ler o arquivo .txt
            leitor.close();

            //fazendo um array (vetor) de linhas com a quantidade de casas
            //do tanto que o contador no while conseguiu captar
            String linhas[] = new String[contadorLinhas];

            //mais um objeto BufferedReader para ler os arquivos
            leitor = new BufferedReader(new FileReader(nomeArquivo));

            //passando para o array(vetor) oq o BufferedReader conseguir ler
            //dentro do arquivo salvo atraves de um for que começa no indice 0
            //e vai até o maximo que contadorLinhas conseguiu contar
            for (int i = 0; i < contadorLinhas; i++){
                linhas[i]= leitor.readLine();
            }

            //fechando o leitor de arquivo
            leitor.close();

            // retornando as linhas
            return linhas;

        //tratando o erro e mostrando a mensagem de erro
        }catch (IOException e){
            System.out.println("Erro ao ler o arquivo");
            e.printStackTrace();
            return null;
        }


    }
}

