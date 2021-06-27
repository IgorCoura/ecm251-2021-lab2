package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.MembersSociety;

import java.util.List;

public interface IService {

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo muda o horario de trabalho dos membros.
     * @param horario Horarios - horario para qual será alterando.
     */
    void setHorarios(Horarios horario);

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo returna o atual horario de trabalho dos membros.
     * @return Horarios - horarios atual de trabalho.
     */
    Horarios getHorarios();

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo cria um novo membro e inseri no repository.
     * @param nome String - Nome do membro.
     * @param email String - Email do membro.
     * @param cargo Cargos - Cargo a qual o membro ocupa.
     */
    void createMember(String nome, String email, Cargos cargo);

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo busca todos os membros cadastrados no repository.
     * @return List<MembersSociety> - Lista dos membros da sociedade.
     */
    List<MembersSociety> listMembers();

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo busca um membro no repository atraves do seu id.
     * @param id int - id do membro o qual deseja buscar
     * @return MembersSociety - membro da sociedade.
     */
    MembersSociety recoverMember(int id);

    /**
     * Este metodo remove um membro do repository atraves do seu id.
     * @param id int - Id do membro o qual sera removido.
     */
    void RemoveByID(int id);
}
