package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Transaction extends Model
{
  public static final String HEADER = "item_id|client_id|employee_id|date|quantity|price|order_type";
  public static final String NAME = "transactions.csv";

  private Item item;
  private Client client;
  private Employee employee;
  private String date;
  private int quantity;
  private float price;
  private String orderType;

  public Transaction(Item item, Client client, Employee employee, String date, int quantity, float price, String orderType)
  {
    this.item = item;
    this.client = client;
    this.employee = employee;
    this.date = date;
    this.quantity = quantity;
    this.price = price;
    this.orderType = orderType;
  }

  public Item getItem()
  {
    return item;
  }

  public Client getClient()
  {
    return client;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public String getDate()
  {
    return date;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public float getPrice()
  {
    return price;
  }

  public String getOrderType()
  {
    return orderType;
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
    String[] array = new String[7];
    array[0] = String.valueOf(item.getItemId());
    array[1] = String.valueOf(client.getClientId());
    array[2] = String.valueOf(employee.getEmployeedId());
    array[3] = String.valueOf(date);
    array[4] = String.valueOf(quantity);
    array[5] = String.format("%.2f", price);
    array[6] = orderType;
    return array;
  }
}
