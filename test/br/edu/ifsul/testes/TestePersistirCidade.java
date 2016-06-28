package br.edu.ifsul.testes;

import br.edu.ifsul.modelos.Cidade;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author jorge
 */
public class TestePersistirCidade {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TA-SisClinicoPU");
        EntityManager em = emf.createEntityManager();
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        c.setEstado("Rio Grande do Sul");
        c.setUf("RS");
        c.setPais("Brasil");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Cidade>> erros = validador.validate(c);
        if (erros.size() > 0) {
            for (ConstraintViolation<Cidade> erro : erros){
                System.out.println("Erro: "+erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }
}
