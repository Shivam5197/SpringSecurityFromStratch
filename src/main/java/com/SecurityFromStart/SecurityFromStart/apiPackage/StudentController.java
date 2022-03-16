package com.SecurityFromStart.SecurityFromStart.apiPackage;

import com.SecurityFromStart.SecurityFromStart.Modals.Students;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    private static  final List<Students> STUDENTS = Arrays.asList(
            new Students(1,"Ramesh Sharma"),
            new Students(2,"Rashmi Sharma"),
            new Students(3,"Shivam Sharma"),
            new Students(4,"Sakshi Sharma"),
            new Students(5,"Ankur Sharma")
);

    @GetMapping(path = "{studentId}")
    public Students getStudentById(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().
                filter(students -> studentId.equals(students.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student with "+studentId+" is not exist in the system"));
    }

}
