package helper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * All dates used will be from January 1, 2015 to December 31, 2015
 * Created by christiaan on 4/3/16.
 */
public class DateRules
{
  private GregorianCalendar start;
  private GregorianCalendar end;

  private GregorianCalendar dayStart;
  private GregorianCalendar dayEnd;

  private SimpleDateFormat dateFormat;

  public DateRules()
  {
    start = new GregorianCalendar(2015, Calendar.JANUARY, 1, 9, 0, 0);
    end = new GregorianCalendar(2015, Calendar.DECEMBER, 31, 17, 0, 0);

    dayStart = new GregorianCalendar(2015, Calendar.JANUARY, 1, 9, 0, 0);
    dayEnd = new GregorianCalendar(2015, Calendar.JANUARY, 1, 17, 0, 0);

    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }

  public GregorianCalendar getStart()
  {
    return start;
  }

  public GregorianCalendar getEnd()
  {
    return end;
  }

  private void addDay(GregorianCalendar calendar)
  {
    calendar.add(Calendar.DAY_OF_YEAR, 1);
  }

  private void increment()
  {
    addDay(dayStart);
    addDay(dayEnd);
  }

  public void test()
  {
    System.out.println(format(start));
    System.out.println(format(end));
    System.out.println(format(dayStart));
    System.out.println(format(dayEnd));

    addDay(dayStart);
    addDay(dayEnd);

    System.out.println(format(dayStart));
    System.out.println(format(dayEnd));
  }


  public String format(GregorianCalendar calendar)
  {
    dateFormat.setCalendar(calendar);
    return dateFormat.format(calendar.getTime());
  }

  public static void main(String[] args)
  {
    DateRules dateRules = new DateRules();
    dateRules.test();
  }
}
