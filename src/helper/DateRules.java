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

  private int trackDay;

  private Random random;

  public DateRules()
  {
    start = new GregorianCalendar(2015, Calendar.JANUARY, 1, 9, 0, 0);
    end = new GregorianCalendar(2015, Calendar.DECEMBER, 31, 17, 0, 0);

    dayStart = new GregorianCalendar(2015, Calendar.JANUARY, 1, 9, 0, 0);
    dayEnd = new GregorianCalendar(2015, Calendar.JANUARY, 1, 17, 0, 0);

    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    trackDay = -1;

    random = new Random();
  }

  public GregorianCalendar getStart()
  {
    return start;
  }

  public GregorianCalendar getEnd()
  {
    return end;
  }

  public boolean nextDay()
  {
    increment();
    while(isWeekend(dayStart))
    {
      increment();
    }
    if(dayStart.getTimeInMillis() < end.getTimeInMillis())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public String getRandomDateTime()
  {
    long startTime = dayStart.getTimeInMillis();
    long endTime = dayEnd.getTimeInMillis();

    long time = random.nextInt((int) (endTime - startTime) + 1) + startTime;
    Date date = new Date(time);
    return format(date);
  }

  private boolean isWeekend(GregorianCalendar calendar)
  {
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    if(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)
    {
      return true;
    }
    return false;
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
    for(int i = 0; i < 100; i++)
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
  }

  public String format(GregorianCalendar calendar)
  {
    dateFormat.setCalendar(calendar);
    return dateFormat.format(calendar.getTime());
  }

  public String format(Date date)
  {
    return dateFormat.format(date);
  }

  public static void main(String[] args)
  {
    DateRules dateRules = new DateRules();
    dateRules.test();
  }
}
