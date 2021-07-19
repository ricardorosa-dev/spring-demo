package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
				.findStudentByEmail(student.getEmailString()); 
		
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
		
	}

	public void deleteStudent(Long studentId) {
		 boolean exists = studentRepository.existsById(studentId);
		 if (!exists) {
			 throw new IllegalStateException(
					 "student with id " + studentId + " does not exist.");
		 }
		 studentRepository.deleteById(studentId);
		
	}

	@Transactional
	public void updateStudent(long studentId,
							  String nameString,
							  String emailString) {
		 Student student = studentRepository.findById(studentId)
				 .orElseThrow(() -> new IllegalStateException(
						 "student with id " + studentId + " does not exist"));
		 
		 if (nameString != null &&
				 nameString.length() > 0 &&
				 !Objects.equals(student.getNameString(), nameString)) {
			 student.setNameString(nameString);
		 }
		 
		 if (emailString != null &&
				 emailString.length() > 0 &&
				 !Objects.equals(student.getEmailString(), emailString)) {
			 Optional<Student> studentOptional = studentRepository
					 .findStudentByEmail(emailString);
			 if (studentOptional.isPresent()) {
				 throw new IllegalStateException("email taken");
			 }
			 student.setEmailString(emailString);
		 }
		
	}

}
