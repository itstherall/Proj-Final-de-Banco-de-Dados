package bancoDeDados;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {
	 public static void main( String[] args ) throws SQLException{
		 ConexaoBD conect = new ConexaoBD();
		 
		 /*
		  * OPERAÇÕES DE INSERTS 
		  * */
		 
		 String inse1;
		 inse1 = "INSERT into Bairro (idBairro, nomeBairro, cidade) values (4 , 'Bela Vista II', 'Parnamirim')";
		 int resultado1;
		 resultado1 = conect.executaSQL(inse1);
		 funcionouOperacao(resultado1);
		 
		 String inse2;
		 inse2 = "INSERT into Bairro (idBairro, nomeBairro, cidade) values (5 , 'Tirol', 'Natal')";
		 int resultado2;
		 resultado2 = conect.executaSQL(inse2);
		 funcionouOperacao(resultado2);
		 
		 String inse3;
		 inse3 = "INSERT into Bairro (idBairro, nomeBairro, cidade) values (6 , 'Santa Tereza', 'Parnamirim')";
		 int resultado3;
		 resultado3 = conect.executaSQL(inse3);
		 funcionouOperacao(resultado3);
		 
		 
		 /*
		  * OPERAÇÃO DE REMOÇÃO
		  * */
		 
		 String remov1 = "DELETE FROM Bairro WHERE idBairro = 5";
		 int resultado4 = conect.executaSQL(remov1);
		 funcionouOperacao(resultado4);
		 
		 
		
		 /*
		  * REALIZANDO A 5 BUSCAS CITADAS NA ATIVIDADE
		  *
		  *conexaoBD conect
		  * */
		 
		//BUSCA 1:
		System.out.println("BUSCA 1:");
		System.out.println();
		 
		String busca = "SELECT nomeAluno, matricula, situacao FROM Aluno AS al JOIN Historico AS hi ON al.idAluno = hi.idAluno;";
		ResultSet res = conect.executaBusca(busca);
		 
		try {
			while(res.next()) {
			
				String nomeAluno = res.getString("nomeAluno");
				String matricula = res.getString("matricula");
				String situacao = res.getString("situacao");
			
				System.out.println(nomeAluno+" - "+matricula+" - "+situacao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		//BUSCA 2:
		System.out.println();
		System.out.println("BUSCA 2:");
		 
		String busca2 = "SELECT nomeProfessor, nomeDisciplina, cargaHoraria FROM Professor AS pf JOIN Disciplina AS dis ON pf.idProfessor = dis.idProfessor;";
		ResultSet res2 = conect.executaBusca(busca2);
		 
		try {
			while(res2.next()) {
			
				String nomeProfessor = res2.getString("nomeProfessor");
				String nomeDisciplina = res2.getString("nomeDisciplina");
				String cargaHoraria = res2.getString("cargaHoraria");
			
				System.out.println(nomeProfessor+" - "+nomeDisciplina+" - "+cargaHoraria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//BUSCA 3:
		System.out.println();
		System.out.println("BUSCA 3:");
				 
		String busca3 = "SELECT nomeBairro, cidade FROM Bairro WHERE cidade = 'Parnamirim';";
		ResultSet res3 = conect.executaBusca(busca3);
				 
		try {
			while(res3.next()) {
					
				String nomeBairro = res3.getString("nomeBairro");
				String cidade = res3.getString("cidade");
				
					
				System.out.println(nomeBairro+" - "+cidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//BUSCA 4:
		System.out.println();
		System.out.println("BUSCA 4:");
				 
		String busca4 = "SELECT nomeAluno, matricula FROM Aluno;";
		ResultSet res4 = conect.executaBusca(busca4);
				 
		try {
			while(res4.next()) {
					
				String nomeAluno = res4.getString("nomeAluno");
				String matricula = res4.getString("matricula");
				
					
				System.out.println(nomeAluno+" - "+matricula);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		//BUSCA 5:
		System.out.println();
		System.out.println("BUSCA 5:");
				 
		String busca5 = "SELECT localTurma, numeroTurma, horario FROM Turma;";
		ResultSet res5 = conect.executaBusca(busca5);
				 
		try {
			while(res5.next()) {
					
				String localTurma = res5.getString("localTurma");
				String numeroTurma = res5.getString("numeroTurma");
				String horario = res5.getString("horario");
					
				System.out.println(localTurma+" - "+numeroTurma+" - "+horario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conect.fechaBD();
		
	 }
	 
	 
	 static void funcionouOperacao (int resultado) {
		 if(resultado > 0 ) {
			 System.out.println("Operação realizada com sucesso!");
		 }
		 else {
			 System.out.println("Operação não realizada.");
		 }
	 }
}
