package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.Interface.IRepository;
import br.com.IgorCoura.Atividade01.Interface.IService;

import java.util.List;

public class Service implements IService {

    private Horarios horarios = Horarios.Normal;
    private IRepository repository;

    public Service(IRepository repository){
        this.repository = repository;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    public Horarios getHorarios() {
        return horarios;
    }

    public void createMember(String nome, String email, Cargos cargo){
        MembersSociety member = new MembersSociety(nome, email, cargo);
        repository.insert(member);
    }

    public List<MembersSociety> listMembers(){
        return repository.selectList();
    }

    public MembersSociety recoverMember(int id){
        return repository.select(id);
    }

    public void RemoveByID(int id){
        var member = repository.select(id);
        repository.delete(member);
    }

}
