package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void selectExistsEmail() {

        String email = "jamila@gmail.com";
        Student student = new Student("jamila", "jamila@gmail.com", Gender.FEMALE);

        underTest.save(student);

        Boolean  exists = underTest.selectExistsEmail(email);

        assertThat(exists).isTrue();
    }
}