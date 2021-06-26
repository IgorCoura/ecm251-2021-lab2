package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Main {
    private static Service service = new Service(new Repository());
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
	    var repository = new Repository();
	    var member = new MembersSociety("Rola", "Emial@rola", Cargos.BigBrothers);
	    repository.insert(member);
	    repository.insert(new MembersSociety("Cola", "Emial@cola", Cargos.MobileMembers));
	    repository.delete(member);
        var list = repository.selectList();
    }

    public static void displayMain() throws IOException {

        String horarioTrabalho = "Extra";
        System.out.println("Bem - Vindo ao MAsK_S0c13ty");
        System.out.println("Horario de trabalho: "+ horarioTrabalho);
        System.out.println("1 - Listar membros");
        System.out.println("2 - Cadastrar membro");
        System.out.println("3 - Excluir membro");
        System.out.println("4 - Consultar membro");
        System.out.println("5 - Trocar horario de trabalho");
        System.out.println("0 - Sair");
        String op = br.readLine();
        switch (op){
            case "1": diplayListarMembros();
            break;
        }
    }

    public static void diplayListarMembros(){
        var list = service.listMembers();
        for (var member: list) {
            System.out.println(member.getDescription(service.getHorarios()));
        }
    }

    public static void displayCadastro() throws IOException {
        System.out.println("Nome: ");
        String nome = br.readLine();
        System.out.println("Email: ");
        String email = br.readLine();
        System.out.println("Cargos: 1 - MobileMembers, 2 - HeavyLifters, 3 - ScriptGuys, 4 - BigBrothers.");
        System.out.println("Cargo: ");
        
    }


}
