package com.studentmark.studentmark.service;

import com.studentmark.studentmark.dto.StudentDTO;
import com.studentmark.studentmark.entity.Student;
import com.studentmark.studentmark.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    public StudentDTO saveStudent(StudentDTO studentDTO){
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
        return studentDTO;
    }

    public List<StudentDTO> getAllStudent(){
        List<Student>studentList=studentRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<List<StudentDTO>>(){}.getType());
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
        return studentDTO;
    }

    public boolean deleteStudentById(Integer id) {
        Optional<Student> studentOptional = studentRepo.findById(id);

        if (studentOptional.isPresent()) {
            studentRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
