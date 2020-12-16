package com.spring;

import com.spring.dao.StudentDao;
import com.spring.entities.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static final Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
        Student student=new Student(5,"Tushar","Mevasa");
        //insert operation
        int result1=studentDao.insert(student);
        logger.info("insert data :"+result1);

        //read operation
        Student student1=studentDao.getStudent(2);
        logger.info("get student :"+student1.getStudentName()+" "+student1.getStudentCity());

        //read all data
        List<Student> students= studentDao.getAllStudent();
        for(Student student2:students){
            logger.info(student2.getStudentId()+" "+student2.getStudentName()+" "+student2.getStudentCity());
        }

        //update operation
        studentDao.updateStudent(new Student(5,"Nirav","Mevasa"));

        //delete operation
        studentDao.deleteStudent(4);


    }
}
