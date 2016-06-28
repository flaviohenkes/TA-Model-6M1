package br.edu.ifsul.testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifsul.modelos.Cidade;
import br.edu.ifsul.modelos.Funcionario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Flávio
 */
public class TestePersistirFuncionario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TA-SisClinicoPU");
        EntityManager em = emf.createEntityManager();
        Cidade c = em.find(Cidade.class, 6);
        Funcionario f = new Funcionario();
        f.setNome("Joao");
        f.setSobrenome("da Silva");
        f.setEndereco("Rua Fredolino Chimango");
        f.setSexo("M");
        f.setDataNasc(new GregorianCalendar(1970, Calendar.JULY, 8));
        f.setTelefone("(54)9989-8899");
        f.setDataAdmissao(new GregorianCalendar(1999, Calendar.MARCH, 10));
        f.setFuncao("Médico");
        f.setCpf("343.369.654-39");
        f.setEscolaridade("Doutorado");
        f.setCidade(c);
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Funcionario>> erros = validador.validate(f);
        if (erros.size() > 0) {
            for (ConstraintViolation<Funcionario> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        } else {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }
}
