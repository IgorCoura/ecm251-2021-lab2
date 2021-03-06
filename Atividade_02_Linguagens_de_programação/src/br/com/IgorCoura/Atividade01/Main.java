package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.Interface.IService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Igor de Brito Coura 19.00165-7
 * @link https://github.com/IgorCoura/ecm251-2021-lab2/tree/main/Atividade_02_Linguagens_de_programa%C3%A7%C3%A3o
 */

public class Main {
    private static IService service = new Service(new Repository());
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try{
            displayMain();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo resposavel por mostra as opcoes possiveis no console.
     * @throws IOException
     * @throws InterruptedException
     */
    public static void displayMain() throws IOException, InterruptedException {
        boolean loop = true;
        while(loop){
            String horarioTrabalho = "Extra";
            System.out.println("Bem - Vindo ao MAsK_S0c13ty");
            System.out.println("Horario de trabalho: "+ horarioTrabalho);
            System.out.println("1 - Listar membros");
            System.out.println("2 - Cadastrar membro");
            System.out.println("3 - Excluir membro");
            System.out.println("4 - Consultar membro");
            System.out.println("5 - Trocar horario de trabalho");
            System.out.println("6 - Postar mensagem");
            System.out.println("7 - Postar todas as mensagens");
            System.out.println("0 - Sair");
            String op = br.readLine();
            switch (op){
                case "1": diplayListarMembros();
                    break;
                case "2": displayCadastro();
                    break;
                case "3": displayExcluir();
                    break;
                case "4": displayConsultarMembro();
                    break;
                case "5": displayTrocarHorario();
                    break;
                case "6": displayPostarMensagem();
                    break;
                case "7": displayPostarTodasMensagens();
                    break;
                default:
                    loop = false;
            }
        }

    }


    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo resposavel por lista os membros no console.
     * @throws IOException
     * @throws InterruptedException
     */
    public static void diplayListarMembros() throws IOException, InterruptedException {
        var list = service.listMembers();
        System.out.println("\nLista de Membros: ");
        for (var member: list) {
            System.out.println(member.getDescription(service.getHorarios()));
        }
        System.out.println();
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria um display para criar novos membros via console.
     * @throws IOException
     */
    public static void displayCadastro() throws IOException {
        System.out.println("\nCadastro de membros. \n");
        System.out.println("Nome: ");
        String nome = br.readLine();
        System.out.println("Email: ");
        String email = br.readLine();
        System.out.println("Cargos: 1 - MobileMembers, 2 - HeavyLifters, 3 - ScriptGuys, default - BigBrothers.");
        System.out.println("Cargo: ");
        String numCargo = br.readLine();
        Cargos cargo = Cargos.BigBrothers;
        switch (numCargo){
            case "1": cargo = Cargos.MobileMembers;
            break;
            case "2": cargo = Cargos.HeavyLifters;
            break;
            case "3": cargo = Cargos.ScriptGuys;
            break;
        }
        service.createMember(nome, email, cargo);
        System.out.println();
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria um display para deletar um membro via console.
     * @throws IOException
     */
    public static void displayExcluir() throws IOException {
        System.out.println("\nExcluir membro.\n");
        System.out.println("Digite o id do membro que deseja deletar: ");
        var id = Integer.parseInt(br.readLine());
        service.RemoveByID(id);
        System.out.println();
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria um display para consultar um membro via console.
     * @throws IOException
     */
    public static void displayConsultarMembro() throws IOException {
        System.out.println("\nConsultar Membro.");
        System.out.println("\nDigite o id do membro: ");
        var id = Integer.parseInt(br.readLine());
        var member = service.recoverMember(id);
        System.out.println(member.getDescription(service.getHorarios()));
        System.out.println();
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria um display para Trocar o horario de trabalho via console.
     * @throws IOException
     */
    public static void displayTrocarHorario() throws IOException {
        System.out.printf("\nTrocar Horario.");
        var horario = Horarios.Normal;
        System.out.println("\ndefault - Normal, 1 - Extra");
        System.out.println("Trocar horario para: ");
        try{
            var num = Integer.parseInt(br.readLine());
            if (num == 1){
                horario = Horarios.Extra;
            }
        }catch (Exception e) {
        }
        finally {
            service.setHorarios(horario);
            System.out.println();
        }
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria o display para Postar a mensagem de um membro via console.
     * @throws IOException
     */
    public static void displayPostarMensagem() throws IOException {
        System.out.println("\nPostar mensagem.");
        System.out.println("\nDigite o id do membro: ");
        var id = Integer.parseInt(br.readLine());
        var member = service.recoverMember(id);
        member.postMessage(service.getHorarios());
        System.out.println();
    }

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Metodo reposavel cria o display para Postar todas mensagens de todos membro via console.
     * @throws IOException
     */
    public static void displayPostarTodasMensagens(){
        System.out.println("\nPostar todas as mensagens:");
        var list = service.listMembers();
        for (var m: list) {
            m.postMessage(service.getHorarios());
        }
        System.out.println();
    }

}
