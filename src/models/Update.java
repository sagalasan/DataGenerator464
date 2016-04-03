package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Update extends Model
{
  public static final String HEADER = "item_id|employee_id|date|quantity_before|quantity_after";
  public static final String NAME = "updates.csv";

  private Item item;
  private Employee employee;
  private long date;
  private int before;
  private int after;

  public Update(Item item, Employee employee, long date, int before, int after)
  {
    this.item = item;
    this.employee = employee;
    this.date = date;
    this.before = before;
    this.after = after;
  }

  public Item getItem()
  {
    return item;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public long getDate()
  {
    return date;
  }

  public int getBefore()
  {
    return before;
  }

  public int getAfter()
  {
    return after;
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
    array[2] = String.valueOf(date);
    array[3] = String.valueOf(before);
    array[4] = String.valueOf(after);
    return array;
  }
}
