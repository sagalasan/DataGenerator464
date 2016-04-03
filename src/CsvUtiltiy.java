import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import models.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christiaan on 3/27/16.
 */
public class CsvUtiltiy
{
  public static String DIR_OUT = "./csv-out";
  public static char DELIMETER = '|';

  public static void refresh()
  {
    File dir = new File(DIR_OUT);
    if(dir.isDirectory())
    {
      deleteDir(dir);
    }
    dir.mkdir();
  }

  public static void writeCsv(List<Model> models, String fileName, String header)
  {
    CSVWriter writer;
    String[] headerArray = header.split("\\" + String.valueOf(DELIMETER));
    try
    {
      writer = new CSVWriter(new FileWriter(DIR_OUT + "/" + fileName), DELIMETER);
      writer.writeNext(headerArray, false);
      for(Model model : models)
      {
        writer.writeNext(model.getArray(), false);
      }
      writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static boolean deleteDir(File dir)
  {
    if(dir.isDirectory())
    {
      String[] children = dir.list();
      for(int i = 0; i < children.length; i++)
      {
        boolean success = deleteDir(new File(dir, children[i]));
        if(!success) return false;
      }
    }
    return dir.delete();
  }

  public static List<Model> readEmployees()
  {
    List<Model> employees = new ArrayList<>();
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

  public static List<Model> readClients()
  {
    List<Model> clients = new ArrayList<>();
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

  public static List<Model> readGroups()
  {
    List<Model> groups = new ArrayList<>();
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

  public static List<Model> readItems()
  {
    List<Model> items = new ArrayList<>();
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

  public static List<Model> readCategories()
  {
    List<Model> categories = new ArrayList<>();
    String path = "./lib/categories.csv";

    List<String[]> strings = readCsv(path);

    for(String[] array : strings)
    {
      String groupName = array[0];
      long itemId = Integer.parseInt(array[1]);

      categories.add(new Category(groupName, itemId));
    }
    return categories;
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
