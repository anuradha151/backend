package lk.v.studms.controller;


import lk.v.studms.dto.student.GuardianDTO;
import lk.v.studms.dto.student.StudentDTO;
import lk.v.studms.service.student.StudentService;
import lk.v.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("guardian")
public class GuardianController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuardianController.class);

    private final StudentService studentService;

    public GuardianController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("by/name")
    public ResponseEntity<?> findByName(@Param("query") String query) {
        LOGGER.info("request   - guardian/by/name | findByName | name : {}", query);
        List<GuardianDTO> all= studentService.findByGuardianName(query);
        LOGGER.info("response  - guardian/by/name | findByName | name : {} | payload : {}", query, all);
        return sendSuccessResponse(all);
    }

}
