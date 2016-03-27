import com.opencsv.CSVReader;
import models.Client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by christiaan on 3/27/16.
 */
public class Generator
{
  public static char DELIMETER = '|';

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


  public static void main(String[] args)
  {
    List<Client> clients = readClients();
    for(Client client : clients)
    {
      System.out.println(client);
    }
  }
}
