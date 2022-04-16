package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	public static void main(String[] args) {
		
		//Criando uma fabrica de EntityManager (que contem encapsulada a conexao) especifico para uma unidade de persistencias
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("lesson-jpa"); // Passando o nome da unidade de persistencia (lesson-jpa) que esta no persistence.xml
		
		
		EntityManager em = emf.createEntityManager();
		
		//Criando obj Usuario
		Usuario novoUsuario = new Usuario("Pedro", "pedro@lanche.com.br");
		
		
		//Iniciando transação
		em.getTransaction().begin();
		//Salvando usuario no BD
		em.persist(novoUsuario);
		//efetivando transação
		em.getTransaction().commit();
		
		
		//Fechando o EntityManager
		em.close();
		
		//Fechando o EntityManagerFactory
		emf.close();
		
	} 

}
