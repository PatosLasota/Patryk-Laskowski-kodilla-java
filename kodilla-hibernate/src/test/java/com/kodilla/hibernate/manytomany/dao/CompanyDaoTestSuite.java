package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephaniClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephaniClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephaniClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //when

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(dataMaesters);
        int dataMaesterId = dataMaesters.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, greyMatterId);
        assertNotEquals(0, dataMaesterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(dataMaesterId);
        } catch (Exception e) {

        }
    }

    @Test
    void testRetrieveEmployeesByLastName() {
        //Given
        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Stephanie", "Clarkson");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        int id1 = employee1.getId();
        int id2 = employee2.getId();

        //When
        List<Employee> smithList = employeeDao.retrieveEmployeesByLastName("Smith")
                .stream()
                .filter(e -> e.getId() == id1 || e.getId() == id2)
                .toList();

        List<Employee> noResult = employeeDao.retrieveEmployeesByLastName("Nowak")
                .stream()
                .filter(e -> e.getId() == id1 || e.getId() == id2)
                .toList();

        //Then
        try {
            assertEquals(1, smithList.size());
            assertEquals("John", smithList.get(0).getFirstName());
            assertEquals("Smith", smithList.get(0).getLastName());
            assertEquals(0, noResult.size());
        } finally {
            employeeDao.deleteById((long) id1);
            employeeDao.deleteById((long) id2);
        }
    }

    @Test
    void testRetrieveCompaniesByFirstThreeLetters() {
        //Given
        Company company1 = new Company("Amazon");
        Company company2 = new Company("Google");
        Company company3 = new Company("Budimex");
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        int cId1 = company1.getId();
        int cId2 = company2.getId();
        int cId3 = company3.getId();

        //When
        List<Company> amazList = companyDao.retrieveByFirstThreeLetters("Ama")
                .stream()
                .filter(c -> c.getId() == cId1 || c.getId() == cId2 || c.getId() == cId3)
                .toList();

        List<Company> gooList = companyDao.retrieveByFirstThreeLetters("Goo")
                .stream()
                .filter(c -> c.getId() == cId1 || c.getId() == cId2 || c.getId() == cId3)
                .toList();

        List<Company> noResult = companyDao.retrieveByFirstThreeLetters("Xyz")
                .stream()
                .filter(c -> c.getId() == cId1 || c.getId() == cId2 || c.getId() == cId3)
                .toList();

        //Then
        try {
            assertEquals(1, amazList.size());
            assertEquals("Amazon", amazList.get(0).getName());
            assertEquals(1, gooList.size());
            assertEquals("Google", gooList.get(0).getName());
            assertEquals(0, noResult.size());
        } finally {
            companyDao.deleteById(cId1);
            companyDao.deleteById(cId2);
            companyDao.deleteById(cId3);
        }
    }
}


