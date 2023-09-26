package GL_.EmpMngmtApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import GL_.EmpMngmtApp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
