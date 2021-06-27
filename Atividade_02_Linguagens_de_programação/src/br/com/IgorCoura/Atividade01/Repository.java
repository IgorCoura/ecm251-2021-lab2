package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Interface.IRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository implements IRepository {
    private File file = new File("arquivo_super_Secreto_nao_abrir.csv");

    Repository(){
        try {
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void insert(MembersSociety member) {
        member.setId(getId());
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(member.toCSV());
            conexao.newLine();
            conexao.close();
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete(MembersSociety member) {
        try{
            File tempFile = new File("tempFile.csv");
            if(!tempFile.exists()){
                tempFile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = member.toCSV();
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            file.delete();
            tempFile.renameTo(file);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public List<MembersSociety> selectList() {
        List<MembersSociety> list = new ArrayList<MembersSociety>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                var linha = scanner.nextLine().split(";");
                var member = new MembersSociety(Integer.parseInt(linha[0]), linha[1], linha[2], Cargos.valueOf(linha[3]));
                list.add(member);
            }
            scanner.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public MembersSociety select(int id) {
        MembersSociety resp = null;
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                var linha = scanner.nextLine().split(";");
                if(String.format("%d",id).contains(linha[0])){
                    resp = new MembersSociety(Integer.parseInt(linha[0]), linha[1], linha[2], Cargos.valueOf(linha[3]));
                    scanner.close();
                    return resp;
                }
            }
            scanner.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    public int getId(){
        try{
            Scanner scanner = new Scanner(file);
            String linha = "0";
            while (scanner.hasNextLine()){
                 linha = scanner.nextLine();
            }
            int id = Integer.parseInt(linha.split(";")[0]);
            id++;
            scanner.close();
            return id;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
