package lk.v.studms.controller;

import lk.v.studms.service.subject.impl.SubjectService;
import lk.v.studms.dto.subject.SubjectDTO;
import lk.v.studms.util.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        LOGGER.info("request   - subject | findAll");
        List<SubjectDTO> all = subjectService.findAll();
        LOGGER.info("response  - subject | findAll | payload : {}", all);
        return sendSuccessResponse(all);
    }

}
