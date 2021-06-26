package br.com.IgorCoura.Atividade01;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<MembersSociety> list = ArrayList<MembersSociety>();
    public void insert(MembersSociety member){
        list.add(member);
    }

    public void remove(MembersSociety member){
        list.remove(member);
    }

    
}
