package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {


    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        Employe emp = employeRepository.findOne(15L);

        System.out.println(emp.toString());

        long cpt = employeRepository.count();

        System.out.println(" Il y a actuellement "+cpt+" employés dans l'enbtreprise");

        Page<Employe> listOrberByDateEmbaucheDesc = employeRepository.OrderByDateEmbaucheDesc(new PageRequest(0,20));

        listOrberByDateEmbaucheDesc.forEach(System.out::println);

        Page<Employe> employePage = employeRepository.findByNomIgnoreCase("pruvot", new PageRequest(0,10));

        employePage.forEach(System.out::println);

    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
