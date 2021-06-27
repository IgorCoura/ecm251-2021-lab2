package br.com.IgorCoura.Atividade01;

import br.com.IgorCoura.Atividade01.Enum.Cargos;
import br.com.IgorCoura.Atividade01.Interface.IRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repository implements IRepository {
    /**
     * @author Igor de Brito Coura 19.00165-7
     * Arquivo onde todos os dados serão salvos e consultados.
     */
    private File file = new File("arquivo_super_Secreto_nao_abrir.csv");

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Construtor verifica se já existe um arquivo, caso não exista ele cria um.
     */
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

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo inseri no arquivo um membro novo.
     * @param member MembersSociety - Membro o qual sera inserido no arquivo.
     */
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

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo deleta do arquivo o membro o qual foi enviado como parametro.
     * @param member MembersSociety - Membro que sera deletado.
     */
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

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este membro busca todos os membro no arquivo e returna como um List<MembersSociety>.
     * @return List<MembersSociety> - Lista de todos os membros presente no arquivo.
     */
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

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este metodo busca no arquivo por id o membro desejado e returna como um objeto MembersSociety.
     * @param id int - Id do membro que deseja buscar.
     * @return MembersSociety - Membro buscado.
     */
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

    /**
     * @author Igor de Brito Coura 19.00165-7
     * Este membro returna um id disponivel para um novo membro.
     * @return id int - Id para um novo membro.
     */
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
