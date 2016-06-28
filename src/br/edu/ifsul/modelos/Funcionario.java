
package br.edu.ifsul.modelos;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Pessoa implements Serializable{
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14,message = "O CPF não deve ter mais que {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)      
    private String cpf;
    
    //@Past(message = "A data de admissao deve ser uma data no passado")
    @NotNull(message = "A data de admissao deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataAdmissao", nullable = false)
    private Calendar dataAdmissao;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataDemissao", nullable = true)
    private Calendar dataDemissao;
   
    @NotBlank(message = "A funçao deve ser informada")
    @Length(max = 100,message = "A funçao não deve ter mais que{max} caracteres")
    @Column(name = "funcao", length = 100, nullable = false)      
    private String funcao;
    
    @NotBlank(message = "O campo escolaridade deve ser informada")
    @Length(max = 50,message = "O campo escolaridade não deve ter mais que{max} caracteres")
    @Column(name = "escolaridade", length = 50, nullable = false)      
    private String escolaridade;


    public Funcionario() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Calendar getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Calendar dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    
}
