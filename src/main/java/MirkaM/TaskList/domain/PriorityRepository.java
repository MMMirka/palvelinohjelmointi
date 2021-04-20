package MirkaM.TaskList.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PriorityRepository  extends CrudRepository<Priority, Long>{
    List<Priority> findByName(String name);
	
}
