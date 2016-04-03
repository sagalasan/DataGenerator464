import models.*;

import java.util.ArrayList;
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

  private List<Model> updates;
  private List<Model> transactions;

  public void generate()
  {
    CsvUtiltiy.refresh();

    clients = CsvUtiltiy.readClients();
    employees = CsvUtiltiy.readEmployees();
    groups = CsvUtiltiy.readGroups();
    items = CsvUtiltiy.readItems();
    categories = CsvUtiltiy.readCategories();

    updates = new ArrayList<>();
    transactions = new ArrayList<>();

    write();
  }

  public void write()
  {
    CsvUtiltiy.writeCsv(clients, Client.NAME, Client.HEADER);
    CsvUtiltiy.writeCsv(employees, Employee.NAME, Employee.HEADER);
    CsvUtiltiy.writeCsv(groups, Group.NAME, Group.HEADER);
    CsvUtiltiy.writeCsv(items, Item.NAME, Item.HEADER);
    CsvUtiltiy.writeCsv(categories, Category.NAME, Category.HEADER);
    CsvUtiltiy.writeCsv(updates, Update.NAME, Update.HEADER);
    CsvUtiltiy.writeCsv(transactions, Transaction.NAME, Transaction.HEADER);
  }

  public static void main(String[] args)
  {
    new Generator().generate();
  }
}
