package models;

/**
 * Created by christiaan on 3/27/16.
 */
public class Employee extends Model
{
  public static final String HEADER = "employee_id|first_name|last_name|address";
  public static final String NAME = "employees.csv";

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
    return employeedId + "|" + firstName + "|" + lastName + "|" + address;
  }

  @Override
  public String getFileName()
  {
    return NAME;
  }

  @Override
  public String getHeader()
  {
    return HEADER;
  }

  @Override
  public String[] getArray()
  {
    String[] array = {String.valueOf(employeedId), firstName, lastName, address};
    return array;
  }
}
