package com.zaurtregulov.spring.mvc_hibernate_aop.controller;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();

        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        //сохроняем в БД
        employeeService.saveEmployee(employee);

        //redirect - перенаправления
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
//с помощью @RequestParam
    public String updateEmployee(@RequestParam("empId") int id, Model model) {

        //с помощью ID получаем текущую форму, которую будем обновлять (получаем у employeeService)
        Employee employee = employeeService.getEmployee(id);
        // переводим всё в метод saveEmployee (через model.аттрибьют в employee-info.jsp)
        model.addAttribute("employee",employee);

        return "employee-info";

    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){

        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
