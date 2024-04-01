import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        // Criação da Lista (por ArrayList) para armazenar as reclamações
        ArrayList<String> ListaOuvidoria = new ArrayList<>();

        // Opções que serão exibidas ao usuário
        String msg = """
                Selecione a opção desejada:
                1) Listar Reclamações
                2) Adicionar Reclamações
                3) Pesquisar Reclamação por ID
                4) Remover Reclamação
                5) Sair
                """;
        int opcoes = 0;
        do{
            // Input para o usuário escolher qual opção deseja
            opcoes =  Integer.parseInt(
                    JOptionPane.showInputDialog(null,msg));
            switch(opcoes) {
                case 1:
                    // Listar as reclamações existentes. Se não houver nenhuma, printa "Lista vazia"
                    if (ListaOuvidoria.size() > 0) {
                        int conta = 1;
                        String reclamacao = "";

                        // Construção para a string de reclamações
                        for (String item : ListaOuvidoria) {
                            reclamacao += conta + " -  " + item + "\n";
                            conta++;
                        }
                        JOptionPane.showMessageDialog(null, reclamacao);

                    } else {
                        JOptionPane.showMessageDialog(null, "Lista Vazia");
                    }
                    break;
                case 2:
                    // Adicionar uma nova reclamação à lista
                    String adicionar = JOptionPane.showInputDialog(null, "Insira sua reclamação");
                    ListaOuvidoria.add(adicionar);
                    JOptionPane.showMessageDialog(null, "Reclamação adicionada com sucesso!");
                    break;
                case 3:
                    // Pesquisar uma reclamação por ID na lista
                    int indice = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Digite o ID que deseja: "));
                    String index = ListaOuvidoria.get(indice - 1);
                    if (index == null) {
                        JOptionPane.showMessageDialog(null, "Não há reclamações com esse ID");

                    } else {
                        JOptionPane.showMessageDialog(null, "Reclamação encontrada: \n - " + index);
                    }
                    break;
                case 4:
                    // Remover uma reclamação da lista
                    if (ListaOuvidoria.size() > 0) {
                        String mensagem = "Qual reclamação deseja remover?  \n";

                        // Construção da lista de reclamações para exibição (usando append)
                        StringBuilder listaReclamacoes = new StringBuilder();
                        for (int i = 0; i < ListaOuvidoria.size(); i++) {
                            listaReclamacoes.append((i + 1)).append(" - ").append(ListaOuvidoria.get(i)).append("\n");
                        }

                        // Mostrar a lista e deixar o usuario escolher qual deseja removr
                        int opcaoRemover = Integer.parseInt(JOptionPane.showInputDialog(null,
                                mensagem + listaReclamacoes));

                        // Verificar se removeu mesmo e printar a confirmação
                        if (opcaoRemover > 0 && opcaoRemover <= ListaOuvidoria.size()) {
                            ListaOuvidoria.remove(opcaoRemover - 1);
                            JOptionPane.showMessageDialog(null, "Reclamação Removida com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista vazia");
                    }
                    break;
                case 5:
                    break;
                default:
                    // Se a opção não estiver dentro das apresentadas, qualquer outro número será inválido
                    JOptionPane.showMessageDialog(null,"Opção Inválida");
            }
        } while (opcoes != 5);
    }
}
