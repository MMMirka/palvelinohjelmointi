package MirkaM.TaskList;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import MirkaM.TaskList.domain.Task;
import MirkaM.TaskList.domain.TaskRepository;
import MirkaM.TaskList.domain.Priority;
import MirkaM.TaskList.domain.PriorityRepository;
import MirkaM.TaskList.domain.User;
import MirkaM.TaskList.domain.UserRepository;


@SpringBootApplication
public class TaskListApplication {
	private static final Logger log = LoggerFactory.getLogger(TaskListApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TaskListApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(TaskRepository repository, PriorityRepository prepository, UserRepository urepository) {
		return (args) -> {
			
		prepository.deleteAll();

			
		prepository.save(new Priority("High"));
		prepository.save(new Priority("Medium"));
		prepository.save(new Priority("Low"));
		
			
		Task task1 = new Task ("Projektiraportti", urepository.findByUsername("admin"),"1.5.2021", prepository.findByName("Low").get(0));
		
		repository.save(task1);
		
		urepository.deleteAll();
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "sposti1");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN","sposti2");
		urepository.save(user1);
		urepository.save(user2);
	
		
		log.info("fetch all tasks");
		for (Task task : repository.findAll()) {
			log.info(task.toString());
		}

		};
	}
}
