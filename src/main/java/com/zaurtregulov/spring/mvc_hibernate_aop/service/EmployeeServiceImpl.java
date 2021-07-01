package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // отмечает класс, содержащий бизнес-логику, соединительное звено между Controller and DAO
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional // аннотация для открытия и закрытия транзакции
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        //получаем Id у БД через ДАО
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {

        employeeDAO.deleteEmployee(id);
    }
}
