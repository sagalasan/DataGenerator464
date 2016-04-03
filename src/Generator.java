import models.*;

import java.util.List;

/**
 * Created by christiaan on 4/3/16.
 */
public class Generator
{
  private List<Model> clients;
  private List<Model> employees;
  private List<Model> groups;
  private List<Model> items;
  private List<Model> categories;

  public void generate()
  {
    CsvUtiltiy.refresh();

    clients = CsvUtiltiy.readClients();
    employees = CsvUtiltiy.readEmployees();
    groups = CsvUtiltiy.readGroups();
    items = CsvUtiltiy.readItems();
    categories = CsvUtiltiy.readCategories();

    CsvUtiltiy.writeCsv(clients, Client.NAME, Client.HEADER);
    CsvUtiltiy.writeCsv(employees, Employee.NAME, Employee.HEADER);
    CsvUtiltiy.writeCsv(groups, Group.NAME, Group.HEADER);
    CsvUtiltiy.writeCsv(items, Item.NAME, Item.HEADER);
    CsvUtiltiy.writeCsv(categories, Category.NAME, Category.HEADER);
  }

  public static void main(String[] args)
  {
    new Generator().generate();
  }
}
