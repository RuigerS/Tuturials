package duke.challenge;

public class Employee {

  private int ID;
  private String name;
  private double salary;

  public Employee(int ID, String name, double salary){
    setID(ID);
    setName(name);
    setSalary(salary);
  }
  public Employee(){

  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public int getID() {
    return ID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }
  public String toString(){
    return ("Employee: "+getID() + ", "+getName()+", "+getSalary());
  }
}
