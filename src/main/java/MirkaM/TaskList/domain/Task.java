package MirkaM.TaskList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String todo, worker, dl;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "priorityid")
    private Priority priority;
    
    
	public Task () {}
	
	
	public Task(String todo, String worker, String dl, Priority priority) {
		super();
		this.todo = todo;
		this.worker = worker;
		this.dl = dl;
		this.priority = priority;
		

}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTodo() {
		return todo;
	}


	public void setTodo(String todo) {
		this.todo = todo;
	}


	public String getWorker() {
		return worker;
	}


	public void setWorker(String worker) {
		this.worker = worker;
	}


	public String getDl() {
		return dl;
	}


	public void setDl(String dl) {
		this.dl = dl;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
		
		
		
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", todo=" + todo + ", worker=" + worker + ", dl=" + dl + ", priority=" + priority
				+ "]";
	}}

