package lk.viyanga.studms.controller;

import lk.viyanga.studms.dto.student.StudentDTO;
import lk.viyanga.studms.service.student.StudentService;
import lk.viyanga.studms.util.AbstractController;
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

    @PostMapping("save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO) {
        LOGGER.info("request   - student/save | saveStudent | payload : {}", studentDTO);
        studentService.saveStudent(studentDTO);
        LOGGER.info("response  - student/save | saveStudent | success");
        return sendSuccessResponse("Student saved successfully");
    }

    @GetMapping("by")
    public ResponseEntity<?> findByStudentUUID(@Param("studentUUID") String studentUUID) {
        LOGGER.info("request   - student/by | findByStudentUUID | studentUUID : {}", studentUUID);
        StudentDTO byStudentId = studentService.findByStudentUUID(studentUUID);
        LOGGER.info("response  - student/by | findByStudentUUID | studentUUID : {} | payload : {}", studentUUID, byStudentId);
        return sendSuccessResponse(byStudentId);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        LOGGER.info("request   - student/findAll | findAll");
        List<StudentDTO> response = studentService.findAll();
        LOGGER.info("response  - student/findAll | findAll | payload size : {}", response.size());
        return sendSuccessResponse(response);
    }
}
