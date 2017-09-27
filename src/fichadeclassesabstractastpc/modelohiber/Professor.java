/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichadeclassesabstractastpc.modelohiber;

import java.sql.Date;
import javax.persistence.*;


/**
 *
 * @author Toni Maunde
 */
@Entity
public class Professor {
    
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nome;
    @Column
    private String estadoCivil;
    @Column
    private String cadeira;
    @Column
    private Date dataDeNascimento;
     
    public Professor(){
        
    }
    public Professor(String nome, String estadoCivil, String cadeira, Date dataDeNascimento) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
        this.cadeira = cadeira;
        this.dataDeNascimento = dataDeNascimento;
    }

    
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCadeira() {
        return cadeira;
    }

    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public String toString() {
        return "ID " + id + "\nNome " + nome + "\nEstado Civil " + estadoCivil + "\nCadeira " + cadeira + "\nData De Nascimento " + dataDeNascimento;
    }
    
    
}
