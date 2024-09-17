package com.example.dao;

import com.example.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.List;

public class EmployeeDAO {
    private EntityManagerFactory emf;

    public EmployeeDAO() {
        // Викликаємо createEntityManagerFactory з ім'ям persistence unit
        emf = Persistence.createEntityManagerFactory("company_applications_persistence_unit");
    }
    public void addEmployee(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList();
        em.close();
        return employees;
    }

}