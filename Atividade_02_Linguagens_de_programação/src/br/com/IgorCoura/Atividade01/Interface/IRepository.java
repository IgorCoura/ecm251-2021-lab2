package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.MembersSociety;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IRepository {
    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo inseri no arquivo um membro novo.
     * @param member MembersSociety - Membro o qual sera inserido no arquivo.
     */
    void insert(MembersSociety member);

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo deleta do arquivo o membro o qual foi enviado como parametro.
     * @param member MembersSociety - Membro que sera deletado.
     */
    void delete(MembersSociety member);

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este membro busca todos os membro no arquivo e returna como um List<MembersSociety>.
     * @return List<MembersSociety> - Lista de todos os membros presente no arquivo.
     */
    List<MembersSociety> selectList();

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo busca no arquivo por id o membro desejado e returna como um objeto MembersSociety.
     * @param id int - Id do membro que deseja buscar.
     * @return MembersSociety - Membro buscado.
     */
    MembersSociety select(int id);

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este membro returna um id disponivel para um novo membro.
     * @return id int - Id para um novo membro.
     */
    int getId();
}
