/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichadeclassesabstractastpc.modelohiber;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Toni Maunde
 */
public class TesteDeHibernate {
    
    
    
    private static void gravarDados(){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
        String nome=JOptionPane.showInputDialog("Nome: ");
        Date data= java.sql.Date.valueOf(JOptionPane.showInputDialog("Data de nascimento (Ano-Mes-Dia) "));
        String cadeira=JOptionPane.showInputDialog("Cadeira: ");
        String estadoCivil=JOptionPane.showInputDialog("Estado civil: ");
        Professor docente= new Professor(nome, estadoCivil, cadeira, data);
        sessao.save(docente);
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
    }
    
    private static void actualizar(){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
        int id =Integer.parseInt(JOptionPane.showInputDialog(null, "Id:"));
        Professor professor;
        professor = (Professor)sessao.get(Professor.class, id);
        JOptionPane.showMessageDialog(null,professor.toString());
        String nome=JOptionPane.showInputDialog("Nome: ");
        Date data= java.sql.Date.valueOf(JOptionPane.showInputDialog("Data de nascimento (Ano-Mes-Dia) "));
        String cadeira=JOptionPane.showInputDialog("Cadeira: ");
        String estadoCivil=JOptionPane.showInputDialog("Estado civil: ");
        professor.setCadeira(cadeira);
        professor.setDataDeNascimento(data);
        professor.setEstadoCivil(estadoCivil);
        professor.setNome(nome);
        sessao.update(professor);
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
        
    }
    
    private static void actualizarEstadoCivil(Long i, String estadoCivil){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
        Professor temp;
        temp=(Professor)sessao.get(Professor.class, i);
        temp.setEstadoCivil(estadoCivil);
        sessao.update(temp);
        
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
        
    }
    
    private static void actualizarCadeira(Long i, String cadeira){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
        Professor temp;
        temp=(Professor)sessao.get(Professor.class, i);
        temp.setCadeira(cadeira);
        sessao.update(temp);
        
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
        
    }
    
    private static void pesquisar(){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
        int id =Integer.parseInt(JOptionPane.showInputDialog(null, "Id:"));
        Professor temp;
        temp=(Professor)sessao.get(Professor.class, id);
        JOptionPane.showMessageDialog(null, temp.toString());
        sessao.update(temp);
        
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
    }
    
    private static void apagar(){
        SessionFactory s= NewHibernateUtil.getSessionFactory();
        Session sessao = s.openSession();
        sessao.beginTransaction();
        
            int id =Integer.parseInt(JOptionPane.showInputDialog(null, "Id: "));
            Professor professor = (Professor)sessao.get(Professor.class, id);
            sessao.delete(professor);
        
        sessao.getTransaction().commit();
        sessao.close();
//        s.close();
    }

        public static ArrayList<Professor> listar(){
        SessionFactory sessionFactory= NewHibernateUtil.getSessionFactory();
        Session sessao = sessionFactory.openSession();
        sessao = sessionFactory.openSession();
        sessao.beginTransaction();
        ArrayList<Professor> arrayList = new ArrayList();
        Criteria professor = sessao.createCriteria(Professor.class);
        arrayList.addAll((ArrayList) professor.list());
        sessao.close();
        return arrayList;
    }    
    
    public static void main(String[] args) {
        
       SessionFactory s= NewHibernateUtil.getSessionFactory();
        int resposta;
        do{
            resposta=Integer.parseInt(JOptionPane.showInputDialog("1.Registar \n2.Remover \n3.Actualizar \n4.Pesquisar \n5.Listar \n6.Sair"));
            
            switch(resposta){
                case 1:{
                    gravarDados();
                }break;
                
                case 2:{
                    apagar();
                }break;
                
                case 3:{
                    actualizar();
                }break;
                
                case 4:{
                    pesquisar();
                }break;
                
                case 5:{
                    listar();
                    for (Professor professor : listar()) 
                        JOptionPane.showMessageDialog(null, professor.toString());
                    }break;
            }
        }while(resposta!=6);
        
        s.close();
    }
    
}
