package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testSaveMantToMany() {
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
        assertNotEquals(0,softwareMachineId);
        assertNotEquals(0,greyMatterId);
        assertNotEquals(0,dataMaesterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(dataMaesterId);
        } catch (Exception e) {

        }
    }
}
