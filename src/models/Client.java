package models;

/**
 * Created by christiaan on 3/27/16.
 */
public class Client extends Model
{
  public static final String HEADER = "client_id|name|address";
  public static final String NAME = "clients.csv";

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

  @Override
  public String toString()
  {
    return clientId + "|" + name + "|" + address;
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
    String[] array = {String.valueOf(clientId), name, address};
    return array;
  }
}
