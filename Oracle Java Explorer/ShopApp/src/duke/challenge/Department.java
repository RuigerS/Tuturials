package duke.challenge;


import java.util.ArrayList;
import java.util.List;

public class Department {
  private String name;
  private List<Integer> employees = new ArrayList<>();

  public Department(String name) {
    setName(name);
  }

  public Department(String name, List<Integer> employees) {
    setName(name);
    setEmployees(employees);
  }

  public Department() {

  }

  public Employee addNewEmployee(Integer ID, String name, double salary) {
    employees.add(ID);
    return new Employee(ID, name, salary);
  }
  public void addEmployee(Integer ID){
    employees.add(ID);
  }

  public boolean removeEmployee(Integer ID){
    return employees.remove(ID);
  }

  public String getName() {
    return name;
  }

  public List<Integer> getEmployees() {
    return employees;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmployees(List<Integer> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return getName();
  }

  public int numberOfEmployees(){
    return employees.size();
  }

}
