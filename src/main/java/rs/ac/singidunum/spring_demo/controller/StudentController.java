package rs.ac.singidunum.spring_demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.spring_demo.controller_service.StudentService;
import rs.ac.singidunum.spring_demo.entity.Student;
import rs.ac.singidunum.spring_demo.model.StudentModel;
import rs.ac.singidunum.spring_demo.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Integer Id) {
        return ResponseEntity.of(service.getStudentById(Id));
    }

    @GetMapping(path = "/indeks/{indeks}")
    public List<Student> getStudentByIndeks(@PathVariable String indeks) {
        return service.getStudentByIndeks(indeks);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentModel student ){
        return service.createStudent(student);
    }

    @PutMapping(path="/{id}")
    public  Student updateStudent(@PathVariable Integer id, @RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id){
        service.deleteStudent(id);
    }
}
