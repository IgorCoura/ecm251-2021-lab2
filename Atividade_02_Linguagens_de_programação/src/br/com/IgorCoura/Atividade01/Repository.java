package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Interface.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Repository implements IRepository {
    private static int id = 0;
    private List<MembersSociety> list = new ArrayList<MembersSociety>();

    public void insert(MembersSociety member){
        member.setId(id);
        list.add(member);
        id++;
    }

    public void delete(MembersSociety member){
        list.remove(member);
    }

    public List<MembersSociety> selectList(){
        return list;
    }

    public MembersSociety select(int id){
        var member = getMember((m)->{return m.getId() == id;});
        return member;
    }

    private MembersSociety getMember(Function<MembersSociety, Boolean> pre){
        MembersSociety contaDestino = null;             //Criando contaDestino
        for(MembersSociety c : list){
            if(pre.apply(c)){                  //Procura a conta com a função passada como parametro
                contaDestino = c;
            }
        }
        return contaDestino;                    //Retorna a conta
    }

}
