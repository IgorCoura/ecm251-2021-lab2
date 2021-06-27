package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Horarios;

public interface IPostarMensagem {
    /**
     * Este metodo devolve o assinatura atual de trabalha de acordo com o horario passado.
     * @param horario Horarios - horarios de trabalho.
     * @return
     */
    String getMessage(Horarios horario);
    /**
     * Este metodo devolve o post atual de trabalha de acordo com o horario passado.
     * @param horario Horarios - horarios de trabalho.
     * @return
     */
    void postMessage(Horarios horario);
}
