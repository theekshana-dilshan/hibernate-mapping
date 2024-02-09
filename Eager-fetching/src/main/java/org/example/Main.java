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
        Laptop laptop = new Laptop();
        Laptop laptop2 = new Laptop();
        List<Laptop> laptops = new ArrayList<>();

        student.setId("S004");
        student.setName("Namal");
        student.setAddress("Galle");

        laptop.setLId("L004");
        laptop.setModel("Asus");
        laptop.setStudent(student);
        laptops.add(laptop);

        laptop2.setLId("L005");
        laptop2.setModel("ROG");
        laptop2.setStudent(student);
        laptops.add(laptop2);

        student.setLaptop(laptops);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*session.save(student);
        session.save(laptop);
        session.save(laptop2);*/

        Student student1 =session.get(Student.class, "S004");
        System.out.println(student1.getId());

        List<Laptop>laptopList=student1.getLaptop();
        for (Laptop laptop1: laptopList) {
            System.out.println(laptop1.getModel());
        }

        transaction.commit();
        session.close();
    }
}