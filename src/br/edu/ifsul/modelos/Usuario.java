
package br.edu.ifsul.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Flávio
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @NotBlank(message = "O nome de usuário deve ser informado")
    @Length(max = 15,message = "O nome de usuário não deve ter mais de {max} caracteres")
    @Column(name = "nome_usuario", length = 15, nullable = false)    
    private String nome_usuario;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPrimeiroAcesso")
    private Calendar dataPrimeiroAcesso;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataUltimoAcesso")
    private Calendar dataUltimoAcesso;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20,message = "A senha não deve ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)       
    private String senha;
    
    @NotBlank(message = "A permissao deve ser informada")
    @Length(max = 1,message = "A permissao não deve ter mais de {max} caracteres")
    @Column(name = "permissao", length = 1, nullable = false)      
    private String permissao;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public Calendar getDataPrimeiroAcesso() {
        return dataPrimeiroAcesso;
    }

    public void setDataPrimeiroAcesso(Calendar dataPrimeiroAcesso) {
        this.dataPrimeiroAcesso = dataPrimeiroAcesso;
    }

    public Calendar getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Calendar dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome_usuario;
    }
}