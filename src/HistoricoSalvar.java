import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistoricoSalvar {
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
