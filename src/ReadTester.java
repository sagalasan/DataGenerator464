import models.Client;
import models.Employee;
import models.Group;
import models.Item;

import java.util.List;

/**
 * Created by christiaan on 3/27/16.
 */
public class ReadTester
{
  public static void main(String[] args)
  {
    List<Client> clients = CsvUtiltiy.readClients();
    for(Client client : clients)
    {
      System.out.println(client);
    }

    List<Employee> employees = CsvUtiltiy.readEmployees();
    for(Employee employee : employees)
    {
      System.out.println(employee);
    }

    List<Group> groups = CsvUtiltiy.readGroups();
    for(Group group : groups)
    {
      System.out.println(group);
    }

    List<Item> items = CsvUtiltiy.readItems();
    for(Item item : items)
    {
      System.out.println(item);
    }
  }
}
