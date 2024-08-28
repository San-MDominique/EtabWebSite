package com.example.monwebetable;

import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.models.Student;
import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.models.User;
import com.example.monwebetable.services.StudentService;
import com.example.monwebetable.services.TeacherService;
import com.example.monwebetable.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.time.Instant;
import java.util.List;
@AllArgsConstructor
@SpringBootApplication
public class MonWebEtableApplication  implements CommandLineRunner {

	private UserService userService;
	private TeacherService teacherService;
	private StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MonWebEtableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
  	 // INFORMATION D'UN ETUDIANT
		Student student = new Student();
		student.setMatricule("12600W");
		student.setNom("John");
		student.setPrenom("Doe");
		student.setClasse("licence1");
		student.setTelephone("0707070707");
		student.setDateNaissance(java.sql.Date.valueOf("2000-01-01"));
		student.setVille("Paris");

			//  ****** INFORMATION D'UN ETUDIANT*****
		Student student1 = new Student();
		student1.setMatricule("12600W");
		student1.setNom("John");
		student1.setPrenom("Doe");
		student1.setClasse("master");
		student1.setDateNaissance(java.sql.Date.valueOf("2000-01-01"));
		student1.setVille("Paris");

		studentService.save(student);
		studentService.save(student1);


		//***************Création d'un nouvel teacher*******
		Teacher teacher = new Teacher();
		teacher.setNom("Smith");
		teacher.setPrenom("Jane");
		teacher.setVacant(true);
		teacher.setMatiereEnseigne("Mathematics");
		teacher.setProchainCours("Calculus");
		teacher.setSujetProchaineReunion("Curriculum Development");


		Teacher teacher2 = new Teacher();
		teacher2.setNom("AKE");
		teacher2.setPrenom("LOULOU");
		teacher2.setVacant(true);
		teacher2.setMatiereEnseigne("Mathematics");
		teacher2.setProchainCours("Calculus");
		teacher2.setSujetProchaineReunion("Curriculum Development");


		Teacher teacher3 = new Teacher();
		teacher3.setNom("Djenabou");
		teacher3.setPrenom("Diallo");
		teacher3.setVacant(true);
		teacher3.setMatiereEnseigne("Lv2");
		teacher3.setProchainCours("Physique");
		teacher3.setSujetProchaineReunion(" Development Personel");
		teacher3.setTelephone("0102030404");
		teacher3.setVille("Man");

		teacherService.save(teacher);
		teacherService.save(teacher2);
		teacherService.save(teacher3);





		//***************Création d'un nouvel utilisateur*****************
		User user = new User();
		user.setPseudo("Nogbou");
		user.setPassword("word123");
		user.setCreationDate(Instant.now());

		User user2 = new User();
		user2.setPseudo("Koffi");
		user2.setPassword("word12");
		user2.setCreationDate(Instant.now());

		User user3 = new User();
		user3.setPseudo("Ange");
		user3.setPassword("word12345");
		user3.setCreationDate(Instant.now());

		User user4 = new User();
		user4.setPseudo("dodo");
		user4.setPassword("word");
		user4.setCreationDate(Instant.now());

		userService.save(user);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);



		/*Création d'un nouvel teacher
		Teacher teacher = new Teacher();
		teacher.setNom("Smith");
		teacher.setPrenom("Jane");
		teacher.setVacant(true);
		teacher.setMatiereEnseigne("Mathematics");
		teacher.setProchainCours("Calculus");
		teacher.setSujetProchaineReunion("Curriculum Development");

		teacherService.save(teacher);/*
		 */



	}






	}