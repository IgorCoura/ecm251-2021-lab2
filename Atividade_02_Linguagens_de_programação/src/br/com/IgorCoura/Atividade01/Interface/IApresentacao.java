package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Horarios;

public interface IApresentacao {
    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo devolve um descricao completa do membro com id, nome, email, cargo, horarios de trabalho e mensagem
     * de acordo com o horarios passado como parametro.
     * @param horario Horarios - horario de trabalho.
     * @return String - descricao do membro.
     */
    public String getDescription(Horarios horario);
}
