package lk.v.studms.service.student.impl;

import lk.v.studms.dto.student.GuardianDTO;
import lk.v.studms.dto.student.StudentDTO;
import lk.v.studms.model.student.Guardian;
import lk.v.studms.model.subject.Batch;
import lk.v.studms.repository.student.StudentRepository;
import lk.v.studms.repository.subject.BatchRepository;
import lk.v.studms.repository.subject.StudentBatchRepository;
import lk.v.studms.repository.subject.SubjectRepository;
import lk.v.studms.service.student.StudentService;
import lk.v.studms.exception.StudMSException;
import lk.v.studms.model.student.Student;
import lk.v.studms.model.subject.StudentBatch;
import lk.v.studms.repository.student.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final SubjectRepository subjectRepository;
    private final StudentBatchRepository studentBatchRepository;
    private final BatchRepository batchRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GuardianRepository guardianRepository, SubjectRepository subjectRepository, StudentBatchRepository studentBatchRepository, BatchRepository batchRepository) {
        this.studentRepository = studentRepository;
        this.guardianRepository = guardianRepository;
        this.subjectRepository = subjectRepository;
        this.studentBatchRepository = studentBatchRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        try {
            Optional<Student> byNic = studentRepository.findByNic(studentDTO.getNic());
            if (byNic.isPresent())throw new StudMSException("Existing NIC number");
            Student student = toStudent(studentDTO);
            if (studentDTO.getGuardian() != null) {
                Optional<Guardian> byUUID = guardianRepository.findByUUID(studentDTO.getGuardian().getGuardianUUID());
                if (byUUID.isPresent()) {
                    student.setGuardian(byUUID.get());
                } else {
                    student.setGuardian(guardianRepository.save(toGuardian(studentDTO.getGuardian())));
                }
            }
            studentRepository.save(student);
            if (studentDTO.getBatchIds() != null) {
                for (String batchUUID : studentDTO.getBatchIds()) {
                    Optional<Batch> byUUID = batchRepository.findByUUID(batchUUID);
                    byUUID.ifPresent(value -> studentBatchRepository.save(new StudentBatch(student, byUUID.get())));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new StudMSException(e);
        }
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Optional<Student> byUUID = studentRepository.findByUUID(studentDTO.getStudentUUID());
        if (!byUUID.isPresent()) throw new StudMSException("Student not found");
        Student student = byUUID.get();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setContactNumber(studentDTO.getContactNumber());
        student.setGender(studentDTO.getGender());
        if (studentDTO.getGuardian() != null) {
            if (student.getGuardian() != null) {
                Guardian guardian = student.getGuardian();
                guardian.setName(studentDTO.getGuardian().getName());
                guardian.setContactNumber(studentDTO.getGuardian().getContactNumber());
                guardian.setNic(studentDTO.getGuardian().getNic());
                guardian.setEmail(studentDTO.getGuardian().getEmail());
                guardianRepository.save(guardian);
            }
        }
        studentRepository.save(student);
    }

    @Override
    public StudentDTO findByStudentUUID(String studentUUID) {
        try {
            Optional<Student> byId = studentRepository.findByUUID(studentUUID);
            if (!byId.isPresent()) throw new StudMSException("Student not found");
            return toStudent(byId.get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new StudMSException(e);
        }
    }


    @Override
    public List<StudentDTO> findAll() {
        List<Student> all = studentRepository.findAll();
        return all.stream().map(this::toStudent).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findByStudentName(String name) {
        List<Student> all = studentRepository.findByName(name);
        return all.stream().map(this::toStudent).collect(Collectors.toList());

    }

    @Override
    public List<StudentDTO> findByStudentNic(String nic) {
        List<Student> all = studentRepository.findByNicLike(nic);
        return all.stream().map(this::toStudent).collect(Collectors.toList());
    }


    private StudentDTO toStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentUUID(student.getStudentUUID());
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setContactNumber(student.getContactNumber());
        studentDTO.setNic(student.getNic());
        studentDTO.setGender(student.getGender());
        if (student.getGuardian() != null) {
            studentDTO.setGuardian(toGuardian(student.getGuardian()));
        }
        studentDTO.setBatches(studentBatchRepository.findByStudentId(student.getStudentId()));
        return studentDTO;
    }


    private Student toStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setContactNumber(studentDTO.getContactNumber());
        student.setNic(studentDTO.getNic());
        student.setGender(studentDTO.getGender());
        return student;
    }

    private Guardian toGuardian(GuardianDTO guardianDTO) {
        Guardian guardian = new Guardian();
        guardian.setName(guardianDTO.getName());
        guardian.setContactNumber(guardianDTO.getContactNumber());
        guardian.setNic(guardianDTO.getNic());
        guardian.setEmail(guardianDTO.getEmail());
        return guardian;
    }

    private GuardianDTO toGuardian(Guardian guardian) {
        GuardianDTO guardianDTO = new GuardianDTO();
        guardianDTO.setGuardianUUID(guardian.getGuardianUUID());
        guardianDTO.setName(guardian.getName());
        guardianDTO.setContactNumber(guardian.getContactNumber());
        guardianDTO.setNic(guardian.getNic());
        guardianDTO.setEmail(guardian.getEmail());
        return guardianDTO;
    }

}
