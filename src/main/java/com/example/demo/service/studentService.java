package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.studentRepo;
import com.example.demo.entity.Student;

@Service
public class studentService {
    @Autowired
    private studentRepo studentrepo;

    public List<Student> getAllStudents() {
        return studentrepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentrepo.findById(id);
    }

    public Student saveStudent(Student Student) {
        return studentrepo.save(Student);
    }

    public void deleteStudent(Long id) {
        studentrepo.deleteById(id);
    }
    
    public Optional<Student> updateStudentDetails(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentrepo.findById(id);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();

            // Update the fields you want to update
            
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setCourse(updatedStudent.getCourse());

            // Save the updated student
            return Optional.of(studentrepo.save(existingStudent));
        } else {
            return Optional.empty(); // Student with given ID not found
        }
    }
}