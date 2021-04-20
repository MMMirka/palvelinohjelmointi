package MirkaM.TaskList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Priority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long priorityid;
	private String name;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "priority")
	private List<Task> tasks;
	
	public Priority() {}
	
	public Priority(String name) {
		super();
		this.name = name;
	}

	public Long getPriorityid() {
		return priorityid;
	}

	public void setPriorityid(Long priorityid) {
		this.priorityid = priorityid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	

}
