package lk.v.studms.controller;

import lk.v.studms.dto.teacher.TeacherDTO;
import lk.v.studms.service.teacher.TeacherService;
import lk.v.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<?> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        LOGGER.info("request   - teacher | saveTeacher | payload : {}", teacherDTO);
        teacherService.saveTeacher(teacherDTO);
        LOGGER.info("response  - teacher | saveTeacher | success");
        return sendSuccessResponse("Teacher registered successfully");
    }
}
