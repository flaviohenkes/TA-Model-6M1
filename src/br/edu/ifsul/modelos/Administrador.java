
package br.edu.ifsul.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "administrador")
public class Administrador extends Funcionario implements Serializable{
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14,message = "O CPF não deve ter {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)      
    private String cpf;
    
    public Administrador() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
