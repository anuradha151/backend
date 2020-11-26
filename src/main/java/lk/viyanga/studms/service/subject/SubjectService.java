package lk.viyanga.studms.service.subject;

import lk.viyanga.studms.dto.subject.SubjectDTO;
import lk.viyanga.studms.repository.subject.SubjectRepository;
import lk.viyanga.studms.service.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Service
public class SubjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);

    private final SubjectRepository subjectRepository;
    private final MailSender mailSender;

    public SubjectService(SubjectRepository subjectRepository, MailSender mailSender) {
        this.subjectRepository = subjectRepository;
        this.mailSender = mailSender;
    }

    public List<SubjectDTO> findAll() {
        return subjectRepository.findAllSubjects();
    }


}
