package view;

import controller.AlunoJpaDAO;
import model.Aluno;

public class App
{
    public static void main( String[] args )
    {
    	 Aluno aluno = new Aluno();
    	 aluno.setId_aluno(1);
    	 aluno.setNome("Layssa Martins");
    	 aluno.setEndereco("Av. Águia de Haia");
         AlunoJpaDAO.getInstance().merge(aluno);
         System.out.println("Objetos salvos com sucesso!");
    }
}