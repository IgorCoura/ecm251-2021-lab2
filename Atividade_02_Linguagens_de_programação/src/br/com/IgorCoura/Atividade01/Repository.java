package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Interface.IRepository;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {

    private List<MembersSociety> list = new ArrayList<MembersSociety>();

    public void insert(MembersSociety member){
        list.add(member);
    }

    public void delete(MembersSociety member){
        list.remove(member);
    }

    public List<MembersSociety> selectList(){
        return list;
    }

}
