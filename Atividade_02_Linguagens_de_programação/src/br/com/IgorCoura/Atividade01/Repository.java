package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Interface.IRepository;

import java.io.*;
import java.util.List;

public class Repository implements IRepository {
    private File file = new File("arquivo_super_Secreto_nao_abrir.csv");
    public void insert(MembersSociety member) {
        member.setId(getId());
        try{
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("member.toCSV()");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(MembersSociety member) {
    }


    public List<MembersSociety> selectList() {
        return null;
    }


    public MembersSociety select(int id) {
        return null;
    }

    private int getId(){
        return 0;
    }
}
