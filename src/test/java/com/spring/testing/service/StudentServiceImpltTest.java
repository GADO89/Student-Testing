package com.spring.testing.service;

import com.spring.testing.model.Student;
import com.spring.testing.model.StudentDto;
import com.spring.testing.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImpltTest {

    @Mock
    private StudentService studentService;
    @Mock
    private StudentRepo studentRepo;

    @Test
    public void createStudent_thenValidate(){
        studentService =new StudentServiceImpl(studentRepo);
        Student student=createStudent();
        Mockito.when(studentRepo.save(student)).thenReturn(createStudentWithID());

       StudentDto studentDto= studentService.createStudent(student);
        Assertions.assertEquals(1,studentDto.getId());
        Assertions.assertEquals("gado",studentDto.getName());
        Assertions.assertEquals(34,studentDto.getAge());
        Assertions.assertEquals("01125589989",studentDto.getPhone());
        Assertions.assertTrue(studentDto.isActive());


    }

    private Student createStudent(){
        return new Student("gado",34,"01125589989",true);
    }
   private Student createStudentWithID(){
        return new Student(1,"gado",34,"01125589989",true);
    }
}
