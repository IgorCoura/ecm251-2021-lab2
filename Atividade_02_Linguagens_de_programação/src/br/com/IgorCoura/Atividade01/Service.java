package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Enum.Horarios;
import br.com.IgorCoura.Atividade01.Interface.IRepository;
import br.com.IgorCoura.Atividade01.Interface.IService;

import java.util.List;

public class Service implements IService {

    private Horarios horario = Horarios.Normal;
    private IRepository repository;

    /**
     * Este contrutor recebe um repository onde os dados serão salvo e cunsultados.
     * @param repository
     */
    public Service(IRepository repository){
        this.repository = repository;
    }

    /**
     * Este metodo muda o horario de trabalho dos membros.
     * @param horario Horarios - horario para qual será alterando.
     */
    public void setHorarios(Horarios horario) {
        this.horario = horario;
    }

    /**
     * Este metodo returna o atual horario de trabalho dos membros.
     * @return Horarios - horarios atual de trabalho.
     */
    public Horarios getHorarios() {
        return horario;
    }

    /**
     * Este metodo cria um novo membro e inseri no repository.
     * @param nome String - Nome do membro.
     * @param email String - Email do membro.
     * @param cargo Cargos - Cargo a qual o membro ocupa.
     */
    public void createMember(String nome, String email, Cargos cargo){
        MembersSociety member = new MembersSociety(0, nome, email, cargo);
        repository.insert(member);
    }

    /**
     * Este metodo busca todos os membros cadastrados no repository.
     * @return List<MembersSociety> - Lista dos membros da sociedade.
     */
    public List<MembersSociety> listMembers(){
        return repository.selectList();
    }

    /**
     * Este metodo busca um membro no repository atraves do seu id.
     * @param id int - id do membro o qual deseja buscar
     * @return MembersSociety - membro da sociedade.
     */
    public MembersSociety recoverMember(int id){
        return repository.select(id);
    }

    /**
     * Este metodo remove um membro do repository atraves do seu id.
     * @param id int - Id do membro o qual sera removido.
     */
    public void RemoveByID(int id){
        var member = repository.select(id);
        repository.delete(member);
    }

}
