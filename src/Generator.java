import helper.DateRules;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

  private DateRules dateRules;

  Random random = new Random();

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

    dateRules = new DateRules();

    generateUpdates();

    write();
  }

  private void generateUpdates()
  {
    while(dateRules.nextDay())
    {

      int numUpdate = random.nextInt(7);
      for (int i = 0; i < numUpdate; i++)
      {
        Item item = (Item) items.get(random.nextInt(items.size()));
        Employee employee = (Employee) employees.get(random.nextInt(employees.size()));
        String date = dateRules.getRandomDateTime();
        int change = random.nextInt(4) - 2;
        if(change == 0) change = 1;
        Update update = new Update(item, employee, date, change);
        updates.add(update);
      }
    }
  }



  private void write()
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
