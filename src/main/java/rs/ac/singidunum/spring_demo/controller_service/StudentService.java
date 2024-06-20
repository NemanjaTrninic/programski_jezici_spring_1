package rs.ac.singidunum.spring_demo.controller_service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import rs.ac.singidunum.spring_demo.entity.Student;
import rs.ac.singidunum.spring_demo.model.StudentModel;
import rs.ac.singidunum.spring_demo.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents(){

        return repository.findAllAndDeletedAtIsNull();
    }

    public Optional<Student> getStudentById(Integer Id){

        return repository.findByIdAndDeletedAtIsNull(Id);
    }

    public List<Student> getStudentByIndeks(String indeks){

        return repository.findByIndeksContainsAndDeletedAtIsNull(indeks);
    }

    public Student createStudent( StudentModel model){
        Student student = new Student();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setCreatedAt(LocalDateTime.now());

        return repository.save(student);
    }

    public Student updateStudent(Integer id,StudentModel model){
        Student student = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setName(model.getName());
        student.setSurname(model.getSurname());
        student.setIndeks(model.getIndeks());
        student.setId(id);
        student.setUpdatedAt(LocalDateTime.now());
        return  repository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        student.setDeletedAt(LocalDateTime.now());
        repository.save(student);
    }
}
