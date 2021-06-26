package br.com.IgorCoura.Atividade01;

public class Service {
    public void createMember(String nome, String email, Cargos cargo){
        MembersSociety member = new MembersSociety(nome, email, cargo);

    }
}
