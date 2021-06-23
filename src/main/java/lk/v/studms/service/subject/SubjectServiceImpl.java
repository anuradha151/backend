package lk.v.studms.service.subject;

import lk.v.studms.repository.subject.SubjectRepository;
import lk.v.studms.service.subject.impl.SubjectService;
import lk.v.studms.dto.subject.SubjectDTO;
import lk.v.studms.service.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Service
public class SubjectServiceImpl implements SubjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);

    private final SubjectRepository subjectRepository;
    private final MailSender mailSender;

    public SubjectServiceImpl(SubjectRepository subjectRepository, MailSender mailSender) {
        this.subjectRepository = subjectRepository;
        this.mailSender = mailSender;
    }

    public List<SubjectDTO> findAll() {
        return subjectRepository.findAllSubjects();
    }

}
