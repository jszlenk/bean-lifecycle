package com.kodilla.lifecycle.controller;

import com.kodilla.lifecycle.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.Map;

@RestController
public class StudentController {

    @GetMapping("/students")
    public Map<Integer, String> getStudents(
            @RequestParam(defaultValue = "20") int n,
            @RequestParam(defaultValue = "10") int z) {

        Student[] students = new Student[n];
        Map<Integer, String> result = new IdentityHashMap<>();

        for (int i = 0; i < n; i++) {
            students[i] = new Student(z);

            try {
                Field indexField = Student.class.getDeclaredField("indexNumber");
                indexField.setAccessible(true);
                String indexValue = (String) indexField.get(students[i]);

                int objectId = System.identityHashCode(students[i]);
                result.put(objectId, indexValue);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
