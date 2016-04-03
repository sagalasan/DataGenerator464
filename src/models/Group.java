package models;

/**
 * Created by christiaan on 4/3/16.
 */
public class Group
{
  private String name;
  private String description;

  public Group(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  @Override
  public String toString()
  {
    return "Group: " + name + ", " + description;
  }
}
