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

    /**
     * Cria um novo membro com todos os parametros.
     * @param id int - id do membro
     * @param nome String - Nome do membro
     * @param email String - email do membro
     * @param cargo Cargos - cargo do membro
     */
    public MembersSociety(int id, String nome, String email, Cargos cargo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    /**
     * Metodo responsavel por mudar o id do membro.
     * @param id int - Novo id do membro.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este metodo devolve o atual id do membro.
     * @return id int - Id do membro.
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo devolve o assinatura atual de trabalha de acordo com o horario passado.
     * @param horario Horarios - horarios de trabalho.
     * @return
     */
    public String getMessage(Horarios horario){
        if(horario == Horarios.Normal){
            return cargo.getNormalMessage();
        }else {
            return  cargo.getExtraMessage();
        }
    }
    /**
     * Este metodo devolve o post atual de trabalha de acordo com o horario passado.
     * @param horario Horarios - horarios de trabalho.
     * @return
     */
    public void postMessage(Horarios horario){
        var m = getMessage(horario);
        System.out.println(m);
    }

    /**
     * Este metodo devolve um descricao completa do membro com id, nome, email, cargo, horarios de trabalho e mensagem
     * de acordo com o horarios passado como parametro.
     * @param horario Horarios - horario de trabalho.
     * @return String - descricao do membro.
     */
    public String getDescription(Horarios horario){
        return "Id: "+id + " - Nome: " + nome + " - Email: "+ email + " - Cargo: "+ cargo.toString() + " - Horario de Trabalho: "+ horario +" - Mensagem: "+ getMessage(horario);
    }

    /**
     * Este metodo devolve todas as informacoes do membro em um formato para ser inserido em um arquivo CSV.
     * @return String - Informacoes do membro em formato csv.
     */
    public String toCSV(){
        return id+";"+nome+";"+email+";"+cargo;
    }

}
