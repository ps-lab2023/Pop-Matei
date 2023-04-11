package com.example.Carting;

import com.example.Carting.model.*;
import com.example.Carting.repository.AdminRepository;
import com.example.Carting.repository.CourseRepository;
import com.example.Carting.repository.InstructorRepository;
import com.example.Carting.repository.MemberRepository;
import com.example.Carting.service.implementation.MemberServiceImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static com.example.Carting.model.Categories.*;

@SpringBootApplication
public class CartingApplication {
	public static void main(String[] args) {
		SpringApplication.run(CartingApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MemberRepository memberRepository, AdminRepository adminRepository, InstructorRepository instructorRepository, CourseRepository courseRepository) {
		return args -> {

			MemberServiceImplementation memberServiceImplementation = new MemberServiceImplementation(memberRepository);

			List<Member> members = new ArrayList<>();
			List<Member> members2 = new ArrayList<>();
			List<Categories> member1Categories = new ArrayList<>();
			List<Categories> member2Categories = new ArrayList<>();
			List<Categories> member3Categories = new ArrayList<>();
			List<Categories> member4Categories = new ArrayList<>();

			member1Categories.add(cart);
			member1Categories.add(moto);
			member2Categories.add(cart);
			member3Categories.add(moto);
			member3Categories.add(gt);
			member4Categories.add(open);
			member4Categories.add(cart);

			Member member1=new Member();
			member1.setFirstName("Mihai");
			member1.setLastName("Diaconu");
			member1.setEmail("mihai_mail@gmail.com");
			member1.setPassword("123456789");
			member1.setCategories(member1Categories);
			memberRepository.save(member1);

			Member member2=new Member();
			member2.setFirstName("Vincentio");
			member2.setLastName("Arivabene");
			member2.setEmail("vincent@gmail.com");
			member2.setPassword("pasta");
			member2.setCategories(member2Categories);
			memberRepository.save(member2);

			Member member3=new Member();
			member3.setFirstName("Grigor");
			member3.setLastName("Aciobanitei");
			member3.setEmail("Aciobanitei@gmail.com");
			member3.setPassword("sheep");
			member3.setCategories(member3Categories);
			memberRepository.save(member3);

			Member member4=new Member();
			member4.setFirstName("Marcus");
			member4.setLastName("Aurelius");
			member4.setEmail("BestEmperor@gmail.com");
			member4.setPassword("SPQR");
			member4.setCategories(member4Categories);
			memberRepository.save(member4);

			members.add(member1);
			members.add(member2);
			members.add(member3);

			members2.add(member3);
			members2.add(member4);

			Admin admin = new Admin();
			admin.setUsername("Admin");
			admin.setEmail("admin@aplicatie.com");
			admin.setPassword("admin");
			adminRepository.save(admin);

			Admin admin2 = new Admin();
			admin2.setUsername("Admin2");
			admin2.setEmail("admin2@aplicatie.com");
			admin2.setPassword("admin2");
			adminRepository.save(admin2);

			Instructor instructor1 = new Instructor();
			instructor1.setFirstName("Nicolas");
			instructor1.setLastName("Belic");
			instructor1.setEmail("nicoBelic@gmail.com");
			instructor1.setPassword("GTA4");
			instructorRepository.save(instructor1);

			Instructor instructor2 = new Instructor();
			instructor2.setFirstName("Arthur");
			instructor2.setLastName("Morgan");
			instructor2.setEmail("ArthurMorgan1860@gmail.com");
			instructor2.setPassword("RDR2");
			instructorRepository.save(instructor2);

			Course course1 =new Course();
			course1.setCourseName("Karting Course");
			course1.setCourseDuration(4);
			course1.setCategory(Categories.cart);
			courseRepository.save(course1);

			Course course2 =new Course();
			course2.setCourseName("Riding Course");
			course2.setCourseDuration(4);
			course2.setCategory(Categories.moto);
			courseRepository.save(course2);

			course1.setInstructor(instructor1);
			course1.setMembers(members);
			courseRepository.save(course1);
			course2.setInstructor(instructor2);
			course2.setMembers(members2);
			courseRepository.save(course2);

			instructor1.setCourse(course1);
			instructorRepository.save(instructor1);
			instructor2.setCourse(course2);
			instructorRepository.save(instructor2);

			member1.setCourse(course1);
			memberServiceImplementation.updateMember(member1);
			member2.setCourse(course2);
			memberServiceImplementation.updateMember(member2);
			member3.setCourse(course1);
			memberServiceImplementation.updateMember(member3);
			member4.setCourse(course2);
			memberServiceImplementation.updateMember(member4);

			member1.setEmail("email@email.com");
			member1.setPassword("alo");
			memberServiceImplementation.updateMember(member1);

		};
	}
}
