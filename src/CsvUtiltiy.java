import com.opencsv.CSVReader;
import models.Client;
import models.Employee;
import models.Group;
import models.Item;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiaan on 3/27/16.
 */
public class CsvUtiltiy
{
  public static char DELIMETER = '|';

  public static List<Employee> readEmployees()
  {
    List<Employee> employees = new ArrayList<>();
    String path = "./lib/employees.csv";

    List<String[]> lines = readCsv(path);

    for(String[] line : lines)
    {
      long employeeId = Long.parseLong(line[0]);
      String firstName = line[1];
      String lastName = line[2];
      String address = line[3];

      employees.add(new Employee(employeeId, firstName, lastName, address));
    }

    return employees;
  }

  public static List<Client> readClients()
  {
    List<Client> clients = new ArrayList<>();
    String path = "./lib/clients.csv";

    List<String[]> strings = readCsv(path);

    for(String[] array : strings)
    {
      long clientId = Long.parseLong(array[0]);
      String name = array[1];
      String address = array[2];

      clients.add(new Client(clientId, name, address));
    }

    return clients;
  }

  public static List<Group> readGroups()
  {
    List<Group> groups = new ArrayList<>();
    String path = "./lib/groups.csv";

    List<String[]> strings = readCsv(path);

    for(String[] array : strings)
    {
      String name = array[0];
      String description = array[1];

      groups.add(new Group(name, description));
    }

    return groups;
  }

  public static List<Item> readItems()
  {
    List<Item> items = new ArrayList<>();
    String path = "./lib/items.csv";

    List<String[]> strings = readCsv(path);

    for(String[] array : strings)
    {
      long itemId = Long.parseLong(array[0]);
      String name = array[1];
      String description = array[2];
      float price = Float.parseFloat(array[3]);

      items.add(new Item(itemId, name, description, price));
    }

    return items;
  }

  public static List<String[]> readCsv(String path)
  {
    CSVReader reader;
    try
    {
      reader = new CSVReader(new FileReader(path), DELIMETER);
      List<String[]> lines = reader.readAll();
      lines.remove(0);
      return lines;
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return null;
    }
  }
}
