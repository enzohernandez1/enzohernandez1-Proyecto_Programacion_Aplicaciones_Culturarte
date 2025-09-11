package logic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class test {
	public static void main(String[] args) {
		 try {
	            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mi-proyecto");
	            EntityManager em = emf.createEntityManager();
	            System.out.println("✅ Conexión exitosa a MySQL!");
	            em.close();
	            emf.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
