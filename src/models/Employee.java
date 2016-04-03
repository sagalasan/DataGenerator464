package models;

/**
 * Created by christiaan on 3/27/16.
 */
public class Employee
{
  public static final String HEADER = "employee_id|first_name|last_name|address";

  private long employeedId;
  private String firstName;
  private String lastName;
  private String address;

  public Employee(long employeedId, String firstName, String lastName, String address)
  {
    this.employeedId = employeedId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public long getEmployeedId()
  {
    return employeedId;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getAddress()
  {
    return address;
  }

  @Override
  public String toString()
  {
    return "Employee: " + firstName + " " + lastName + ", " + address + " (" + employeedId + ")";
  }
}
