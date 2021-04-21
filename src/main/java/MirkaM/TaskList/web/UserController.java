package MirkaM.TaskList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import MirkaM.TaskList.domain.UserRepository;
import MirkaM.TaskList.domain.User;
import MirkaM.TaskList.domain.SignupForm;

import javax.validation.Valid;


@Controller
public class UserController {
	@Autowired
    private UserRepository urepository; 
	
    @RequestMapping(value = "signup")
    public String addUser(Model model){
    	model.addAttribute("signupform", new SignupForm());
        return "signup";
    }	
    
  // New user
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { 
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check if password match		
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
		    	newUser.setRole("USER");
		    	newUser.setEmail(signupForm.getEmail());
		    	
		    	if (urepository.findByUsername(signupForm.getUsername()) == null) { // Check if user exists
		    		urepository.save(newUser);
		    	
	    			if(urepository.findByEmail(signupForm.getEmail()) == null) {
	    				urepository.save(newUser);
	    			}
		    		else {
		    			bindingResult.rejectValue("email", "err.email", "Email already in use");    	
		    			return "signup";
		    		
		    		}
		    	}
		    	
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
		    	
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    } 
    
    //Reset password
    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
        User user = urepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            urepository.save(user);
        } else {
            throw new UsernameNotFoundException("Could not find any user with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return urepository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPasswordHash(encodedPassword);
         
        user.setResetPasswordToken(null);
        urepository.save(user);
    }
    
  
}

    

