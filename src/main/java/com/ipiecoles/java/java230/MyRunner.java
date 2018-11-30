package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
