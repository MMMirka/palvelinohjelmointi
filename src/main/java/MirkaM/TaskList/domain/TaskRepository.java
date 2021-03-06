package MirkaM.TaskList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Long> {
	
	 List<Task> findById(String id);

}
