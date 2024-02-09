package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("L002", "Asus");
        Student student = new Student("S002", "Kamal", "Galle",laptop);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(laptop);

        transaction.commit();
        session.close();
    }
}