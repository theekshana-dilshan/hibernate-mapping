package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

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

        /*NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM student");
        nativeQuery.addEntity(Student.class);

        List<Student>studentList= nativeQuery.list();
        for (Student s: studentList) {
            System.out.println(s.getName());
        }*/

        /*Query query = session.createQuery("from Student");
        List<Student>studentList=query.list();
        for (Student s: studentList) {
            System.out.println(s.getName());
        }*/

        /*Query query = session.createQuery("INSERT INTO Student (id,name,address");
        transaction.commit();
        session.close();*/

        /*Query query = session.createQuery("from Student where name=?1");
        query.setParameter(1, "saman");
        Student student1 = (Student) query.uniqueResult();
        System.out.println(student1.getName());*/

        /*Query query = session.createQuery("select id,name from Student where id=?1");
        query.setParameter(1,"S004");
        Object[] objects = (Object[]) query.uniqueResult();
        System.out.println(objects[0]);*/

        Query query = session.createQuery("select id,name from Student");
        List<Object[]>list = new ArrayList<>();
        list.add((Object[]) query.uniqueResult());
        for (Object[] objects: list) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }
    }
}