package GL_.EmpMngmtApp.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import GL_.EmpMngmtApp.model.Employee;
import GL_.EmpMngmtApp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public String viewhomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}

	@GetMapping("/employeesnew")
	public String employeesnew(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("employeesedit/{id}")
	public String employeesedit(@PathVariable(value = "id") long id, Model model) {

		Employee employee = employeeService.getEmployeeById(id);

		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		this.employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
