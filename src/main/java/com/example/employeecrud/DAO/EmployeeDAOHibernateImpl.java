package com.example.employeecrud.DAO;

import com.example.employeecrud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection, we can use any type of injection not only constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public List<Employee> findAll(){

        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create query
            Query<Employee> theQuery =
                    currentSession.createQuery("from Employee", Employee.class);

        // execute query
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }
}
