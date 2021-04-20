 package MirkaM.TaskList.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MirkaM.TaskList.domain.Task;
import MirkaM.TaskList.domain.TaskRepository;
import MirkaM.TaskList.domain.PriorityRepository;



@Controller

public class TaskController {
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private PriorityRepository prepository;
	
	//Show tasklist
	@RequestMapping(value={"/", "/tasklist"})
	public String tasklist(Model model) {
		model.addAttribute("tasks", repository.findAll());
		return "tasklist";
	}
	
	//Add new task
	@RequestMapping(value="/add")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("priority", prepository.findAll());
		return "addtask";
	}
	
	//Save new task
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(Task task) {
		repository.save(task);
		return "redirect:tasklist";
		
	}
	
	//Delete 

	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTask(@PathVariable("id") Long taskId, Model model) {
		repository.deleteById(taskId);
		
		return "redirect:../tasklist";
	}
	
	//Edit
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String modifyTask(@PathVariable("id") Long taskId, Model model) {
		model.addAttribute("task", repository.findById(taskId));
		model.addAttribute("priority", prepository.findAll());
		return "modifytask";
	}
	
	// REST all tasks
    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> taskListRest() {	
        return (List<Task>) repository.findAll();
    }    

	// REST task by id
    @RequestMapping(value="/task/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Task> findTasktRest(@PathVariable("id") Long taskId) {	
    	return repository.findById(taskId);
    } 
    
    //log in
    @RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
	

}
