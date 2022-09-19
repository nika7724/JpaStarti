/*package com.example.jpastarti;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.reposidory.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class JpaStartiApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Annex");
        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now());
        std2.setName("Viggo");
        studentRepository.save(std2);

        List<Student> lst = studentRepository.findAll();
        assertEquals(2, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();
        assertEquals(1, lst.size());


    }

}*/

package com.example.jpastarti;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.reposidory.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaStartiApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Anne");
        studentRepository.save(std1);

        List<Student> lst = studentRepository.findAll(); //find all students
        assertEquals(1, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();
        assertEquals(0, lst.size());

        //find by ID
        Optional<Student> opt3 = studentRepository.findById(1);
        if(opt3.isPresent()) {
            Student std3 = opt3.get();
            assertEquals(std3.getName(), "Anne");
        }

        //find by name
        opt3 = studentRepository.findByName("Kurt");
        if(opt3.isPresent()) {
            Student std3 = opt3.get();
            assertEquals(std3.getName(), "Kurt");
        }

    }

}
