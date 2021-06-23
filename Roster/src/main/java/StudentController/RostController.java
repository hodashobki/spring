package StudentController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Hoda.roster.models.Student;
import com.Hoda.roster.serveses.ApisService;

@Controller
public class RostController {
	private final ApisService apisService;
	public RostController(ApisService apisService) {
		super();
		this.apisService = apisService;
	}

	@RequestMapping("/students")
	public String main (Model model) {
		model.addAttribute("students,apisService.allstud");
		return "index.jsp";
	}
	@RequestMapping("/students")
public String newstudent(@Valid@ModelAttribute() Student student) {
		
		return "newst.jsp";
		
	}
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
	public String creatstudent(@Valid@ModelAttribute() Student student, BindingResult result) {
			if (result.hasErrors()) {
			return "newst.jsp";
	}
			apisService.createStudent(student);
			return "redirect:/students";
		}
	 

}
