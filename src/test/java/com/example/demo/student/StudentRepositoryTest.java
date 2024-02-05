package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {

    }

    @BeforeEach
    void setUp() {
        underTest.deleteAll();
    }

    @Test
    void selectExistsEmail() {

        String email = "jamila@gmail.com";
        Student student = new Student("jamila", "jamila@gmail.com", Gender.FEMALE);

        underTest.save(student);

        Boolean  exists = underTest.selectExistsEmail(email);

        assertThat(exists).isTrue();
    }

    @Test
    void selectedEmailNotExists() {

        String email = "jamila1@gmail.com";
        Student student = new Student("jamila", "jamila@gmail.com", Gender.FEMALE);

        underTest.save(student);

        Boolean  exists = underTest.selectExistsEmail(email);

        assertThat(exists).isFalse();
    }
}