package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Update extends Model
{
  public static final String HEADER = "item_id|employee_id|date|quantity_change";
  public static final String NAME = "updates.csv";

  private Item item;
  private Employee employee;
  private String date;
  private int change;

  public Update(Item item, Employee employee, String date, int change)
  {
    this.item = item;
    this.employee = employee;
    this.date = date;
    this.change = change;
  }

  public Item getItem()
  {
    return item;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public String getDate()
  {
    return date;
  }

  public int getChange()
  {
    return change;
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
    String[] array = new String[5];
    array[0] = String.valueOf(item.getItemId());
    array[1] = String.valueOf(employee.getEmployeedId());
    array[2] = date;
    array[3] = String.valueOf(change);
    return array;
  }
}
