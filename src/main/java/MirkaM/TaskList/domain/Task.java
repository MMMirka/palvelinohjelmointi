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
	private String todo, dl;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "priorityid")
    private Priority priority;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "username")
    private User user;
    
    
	public Task () {}
	
	
	public Task(String todo, User user, String dl, Priority priority) {
		super();
		this.todo = todo;
		this.user = user;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
		return "Task [id=" + id + ", todo=" + todo + ", User=" + user + ", dl=" + dl + ", priority=" + priority
				+ "]";
	}}

