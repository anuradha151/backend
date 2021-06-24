package lk.v.studms.controller;

import lk.v.studms.service.student.StudentService;
import lk.v.studms.dto.student.StudentDTO;
import lk.v.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {
        LOGGER.info("request   - student | saveStudent | payload : {}", studentDTO);
        studentService.saveStudent(studentDTO);
        LOGGER.info("response  - student | saveStudent | success");
        return sendSuccessResponse("Student saved successfully");
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO) {
        LOGGER.info("request   - student | updateStudent | payload : {}", studentDTO);
        studentService.updateStudent(studentDTO);
        LOGGER.info("response  - student | updateStudent | success");
        return sendSuccessResponse("Student updated successfully");
    }

    @GetMapping("by/uuid")
    public ResponseEntity<?> findByStudentUUID(@Param("query") String query) {
        LOGGER.info("request   - student/by/uuid | findByStudentUUID | uuid : {}", query);
        StudentDTO byStudentId = studentService.findByStudentUUID(query);
        LOGGER.info("response  - student/by/uuid | findByStudentUUID | uuid : {} | payload : {}", query, byStudentId);
        return sendSuccessResponse(byStudentId);
    }

    @GetMapping("by/name")
    public ResponseEntity<?> findByStudentName(@Param("query") String query) {
        LOGGER.info("request   - student/by/name | findByStudentName | name : {}", query);
        List<StudentDTO> all = studentService.findByStudentName(query);
        LOGGER.info("response  - student/by/name | findByStudentName | name : {} | payload : {}", query, all);
        return sendSuccessResponse(all);
    }

    @GetMapping("by/nic")
    public ResponseEntity<?> findByStudentNic(@Param("query") String query) {
        LOGGER.info("request   - student/by/nic | findByStudentNic | nic : {}", query);
        List<StudentDTO> all= studentService.findByStudentNic(query);
        LOGGER.info("response  - student/by/nic | findByStudentNic | nic : {} | payload : {}", query, all);
        return sendSuccessResponse(all);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        LOGGER.info("request   - student | findAll");
        List<StudentDTO> all = studentService.findAll();
        LOGGER.info("response  - student | findAll | payload : {}", all);
        return sendSuccessResponse(all);
    }




}
