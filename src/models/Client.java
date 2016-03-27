package models;

/**
 * Created by christiaan on 3/27/16.
 */
public class Client
{
  private long clientId;
  private String name;
  private String address;

  public Client(long clientId, String name, String address)
  {
    this.clientId = clientId;
    this.name = name;
    this.address = address;
  }

  public long getClientId()
  {
    return clientId;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }
}