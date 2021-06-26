package br.com.IgorCoura.Atividade01.Interface;

import br.com.IgorCoura.Atividade01.MembersSociety;

import java.util.List;

public interface IRepository {
    void insert(MembersSociety member);
    void delete(MembersSociety member);
    List<MembersSociety> selectList();
    MembersSociety select(int id);
}
