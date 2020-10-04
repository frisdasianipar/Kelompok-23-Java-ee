package del.ac.id.demo.controller;

 import java.util.List;

 import org.springframework.ui.Model;
 import org.springframework.validation.BindingResult;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.servlet.ModelAndView;
 import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 import del.ac.id.demo.jpa.Role;
 import del.ac.id.demo.jpa.RoleRepository;
 import del.ac.id.demo.jpa.User;
 import del.ac.id.demo.jpa.UserRepository;

 @RestController
 public class RegistrationController {
	 private UserRepository userRepository;
	 private RoleRepository roleRepository;

	 public RegistrationController(UserRepository userRepository,
RoleRepository roleRepository) {
		 this.userRepository = userRepository;
		 this.roleRepository = roleRepository;
}
	 
 @GetMapping("/registration")
 public ModelAndView registration() {
	 List<Role> listRoles = roleRepository.findAll();
	 System.out.println(listRoles.size());

	 ModelAndView mv = new ModelAndView("registration");
	 mv.addObject("roles", listRoles);
	 mv.addObject("user", new User());
	 return mv;
}

 	@RequestMapping(value="/registration", method = RequestMethod.POST)
 	public String registrationSubmit(@ModelAttribute User user, BindingResult
bindingResult, Model model) {
 		if (bindingResult.hasErrors()) {
 			System.out.println("Error");
 }

 		model.addAttribute("user", user);
 		userRepository.save(user);
 		return "redirect:login";
}
}