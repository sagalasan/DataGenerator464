package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Category extends Model
{
  public final static String HEADER = "group_name|item_id";
  public final static String NAME = "categories.csv";

  private String groupName;
  private long itemId;

  public Category(String groupName, long itemId)
  {
    this.groupName = groupName;
    this.itemId = itemId;
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
    String[] array = {groupName, String.valueOf(itemId)};
    return array;
  }
}
