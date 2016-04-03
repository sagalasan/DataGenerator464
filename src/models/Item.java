package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Item
{
  public static final String HEADER = "item_id|name|description|price";

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
    return "Item: " + name + ", " + price + ", " + description + " (" + itemId + ")";
  }
}
