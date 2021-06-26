package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Horarios;

public interface IPostarMensagem {
    String getMessage(Horarios horario);
    void postMessage(Horarios horario);
}
