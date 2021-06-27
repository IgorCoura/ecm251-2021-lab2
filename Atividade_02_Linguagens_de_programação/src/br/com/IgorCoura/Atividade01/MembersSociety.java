package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.Interface.IApresentacao;
import br.com.IgorCoura.Atividade01.Interface.IPostarMensagem;

public class MembersSociety implements IPostarMensagem, IApresentacao {
    private int id;
    private String nome;
    private String email;
    private Cargos cargo;

    public MembersSociety(int id, String nome, String email, Cargos cargo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getMessage(Horarios horario){
        if(horario == Horarios.Normal){
            return cargo.getNormalMessage();
        }else {
            return  cargo.getExtraMessage();
        }
    }

    public void postMessage(Horarios horario){
        var m = getMessage(horario);
        System.out.println(m);
    }

    public String getDescription(Horarios horario){
        return "Id: "+id + " - Nome: " + nome + " - Email: "+ email + " - Cargo: "+ cargo.toString() + " - Horario de Trabalho: "+ horario +" - Mensagem: "+ getMessage(horario);
    }

    public String toCSV(){
        return id+";"+nome+";"+email+";"+cargo;
    }

}
