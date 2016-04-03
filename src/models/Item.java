package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Item extends Model
{
  public static final String HEADER = "item_id|name|description|price";
  public static final String NAME = "items.csv";

  private long itemId;
  private String name;
  private String description;
  private float price;

  public Item(long itemId, String name, String description, float price)
  {
    this.itemId = itemId;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public long getItemId()
  {
    return itemId;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public float getPrice()
  {
    return price;
  }

  @Override
  public String toString()
  {
    return itemId + "|" + name + "|" + description + "|" + price;
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
    String[] array = {String.valueOf(itemId), name, description, String.format("%.2f", price)};
    return array;
  }
}
