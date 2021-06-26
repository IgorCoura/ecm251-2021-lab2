package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.MembersSociety;

import java.util.List;

public interface IService {

    void setHorarios(Horarios horarios);
    Horarios getHorarios();
    void createMember(String nome, String email, Cargos cargo);
    List<MembersSociety> listMembers();
    MembersSociety recoverMember(int id);
    void RemoveByID(int id);
}
