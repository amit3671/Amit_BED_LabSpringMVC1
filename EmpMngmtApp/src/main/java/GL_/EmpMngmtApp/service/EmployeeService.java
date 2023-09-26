package GL_.EmpMngmtApp.service;

import java.util.List;

import GL_.EmpMngmtApp.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(long id);

	void deleteEmployeeById(long id);
}
