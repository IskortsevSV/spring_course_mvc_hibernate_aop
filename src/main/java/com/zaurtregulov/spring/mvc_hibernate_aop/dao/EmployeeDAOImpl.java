package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        //подключаемся к сессии БД
        Session session = sessionFactory.getCurrentSession();

      /*  Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> resultList = query.getResultList();*/

        return session.createQuery("from Employee"
                , Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        //если id = 0, будет создан новый объект, иначе объект будет обновлен учитывая его id
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");

        query.setParameter("employeeId", id);
        //отвечает как за update так и за delete
        query.executeUpdate();
    }
}
