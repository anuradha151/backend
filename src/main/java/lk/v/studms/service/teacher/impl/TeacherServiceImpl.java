package lk.v.studms.service.teacher.impl;

import lk.v.studms.dto.teacher.TeacherDTO;
import lk.v.studms.model.teacher.Teacher;
import lk.v.studms.repository.teacher.TeacherRepository;
import lk.v.studms.service.teacher.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void saveTeacher(TeacherDTO teacherDTO) {

    }

    private Teacher toTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setContactNumber(teacherDTO.getContactNumber());
        return teacher;
    }
}
