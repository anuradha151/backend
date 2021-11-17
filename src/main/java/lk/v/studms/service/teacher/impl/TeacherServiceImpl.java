package lk.v.studms.service.teacher.impl;

import lk.v.studms.dto.teacher.TeacherDTO;
import lk.v.studms.exception.StudMSException;
import lk.v.studms.model.teacher.Teacher;
import lk.v.studms.repository.teacher.TeacherRepository;
import lk.v.studms.service.teacher.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void saveTeacher(TeacherDTO teacherDTO) {
        Optional<Teacher> byEmail = teacherRepository.findByEmail(teacherDTO.getEmail());
        if (byEmail.isPresent()) throw new StudMSException("Existing email");
        Optional<Teacher> byNic = teacherRepository.findByNic(teacherDTO.getNic());
        if (byNic.isPresent()) throw new StudMSException("Existing NIC");
        teacherRepository.save(toTeacher(teacherDTO));
    }

    private Teacher toTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setNic(teacherDTO.getNic());
        teacher.setContactNumber(teacherDTO.getContactNumber());
        return teacher;
    }
}
