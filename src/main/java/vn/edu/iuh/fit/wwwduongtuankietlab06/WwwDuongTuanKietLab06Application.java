package vn.edu.iuh.fit.wwwduongtuankietlab06;

import at.favre.lib.crypto.bcrypt.BCrypt;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.Post;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.PostComment;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.models.User;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.PostRepository;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.UserRepository;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WwwDuongTuanKietLab06Application {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostCommentRepository postCommentRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(WwwDuongTuanKietLab06Application.class, args);
	}

//	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			String password = "123456";
			String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
			System.out.println(hashedPassword + " " +  hashedPassword.length());

			System.out.println(hashedPassword);

			String passwordUser = "123456";

			if(BCrypt.verifyer().verify(passwordUser.toCharArray(), hashedPassword).verified){
				System.out.println("Password verification successful");
			}else{
				System.out.println("Password verification failed");
			}
			Faker faker = new Faker();
			// Add User
			for (int i = 0; i < 10; i++){
				User user = User.builder()
						.email(faker.internet().emailAddress())
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.middleName(faker.name().firstName())
						.intro(faker.lorem().sentence())
						.lastLogin(Instant.now().minus(faker.number().numberBetween(1, 365), TimeUnit.DAYS.toChronoUnit()))
						.mobile(faker.phoneNumber().cellPhone())
						.passwordHash(hashedPassword)
						.profile(faker.lorem().paragraph())
						.registeredAt(Instant.now().minus(faker.number().numberBetween(1, 365), TimeUnit.DAYS.toChronoUnit()))
						.build();
				userRepository.save(user);
			}
			// Add Post
			for (int i = 0; i < 10; i++){
				Post post = Post.builder()
						.createdAt(faker.date().past(365, TimeUnit.DAYS).toInstant())
						.metaTitle(faker.lorem().sentence())
						.published(faker.bool().bool())
						.publishedAt(faker.date().past(365, TimeUnit.DAYS).toInstant())
						.summary(faker.lorem().sentence())
						.title(faker.lorem().sentence())
						.updatedAt(faker.date().past(365, TimeUnit.DAYS).toInstant())
						.parent(Post.builder().id(3L).build())
						.author(User.builder().id(4L).build())
						.content(faker.lorem().paragraph())
						.build();
				postRepository.save(post);
			}

			// AddPostComment
			for (long i = 1; i <= 10; i++){
				PostComment postComment = PostComment.builder()
						.content(faker.lorem().paragraph())
						.createdAt(faker.date().past(365, TimeUnit.DAYS).toInstant())
						.published(faker.bool().bool())
						.publishedAt(faker.date().past(365, TimeUnit.DAYS).toInstant())
						.title(faker.name().fullName())
						.parent(PostComment.builder().id(1L).build())
						.post(Post.builder().id(3L).build())
						.user(User.builder().id(4L).build())
						.build();
				postCommentRepository.save(postComment);

			}
		};
	}

}
