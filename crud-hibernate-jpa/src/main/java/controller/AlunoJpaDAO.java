package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;
 
public class AlunoJpaDAO {
 
         private static AlunoJpaDAO instance;
         protected EntityManager entityManager;
         
         public static AlunoJpaDAO getInstance(){
                   if (instance == null){
                            instance = new AlunoJpaDAO();
                   }
                   
                   return instance;
         }
 
         private AlunoJpaDAO() {
                   entityManager = getEntityManager();
         }
 
         private EntityManager getEntityManager() {
                   EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
                   if (entityManager == null) {
                            entityManager = factory.createEntityManager();
                   }
 
                   return entityManager;
         }
 
         public Aluno getById(final int id) {
                   return entityManager.find(Aluno.class, id);
         }
 
         @SuppressWarnings("unchecked")
         public List<Aluno> findAll() {
                   return entityManager.createQuery("FROM " + Aluno.class.getName()).getResultList();
         }
 
         public void persist(Aluno aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.persist(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void merge(Aluno aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            entityManager.merge(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void remove(Aluno aluno) {
                   try {
                            entityManager.getTransaction().begin();
                            aluno = entityManager.find(Aluno.class, aluno.getId_aluno());
                            entityManager.remove(aluno);
                            entityManager.getTransaction().commit();
                   } catch (Exception ex) {
                            ex.printStackTrace();
                            entityManager.getTransaction().rollback();
                   }
         }
 
         public void removeById(final int id) {
                   try {
                            Aluno aluno = getById(id);
                            remove(aluno);
                   } catch (Exception ex) {
                            ex.printStackTrace();
                   }
         }
 
}