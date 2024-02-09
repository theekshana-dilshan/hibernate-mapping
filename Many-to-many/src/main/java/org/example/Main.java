package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Student student2 = new Student();
        Laptop laptop = new Laptop();
        Laptop laptop2 = new Laptop();

        laptop.setLId("L001");
        laptop.setModel("Asus");

        laptop2.setLId("l002");
        laptop2.setModel("Asus");

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop);
        laptops.add(laptop2);

        student.setId("S001");
        student.setName("Kamal");
        student.setAddress("Galle");
        student.setLaptop(laptops);

        student2.setId("S002");
        student2.setName("Amal");
        student2.setAddress("Galle");
        student2.setLaptop(laptops);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);

        laptop.setStudent(studentList);
        laptop2.setStudent(studentList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(student2);
        session.save(laptop);
        session.save(laptop2);

        transaction.commit();
        session.close();
    }
}