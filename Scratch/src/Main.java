import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;

public class Main {

  public static class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {

      return DayOfWeek.from(temporal) == DayOfWeek.FRIDAY
             || DayOfWeek.from(temporal) == DayOfWeek.SATURDAY ?
             temporal.with(TemporalAdjusters.next(DayOfWeek.MONDAY)) :
             temporal.plus(1, ChronoUnit.DAYS);

    }
  }


  public static void main1(String[] args) {
    for (LocalDate i = LocalDate.of(2016, 01, 01); i.getDayOfMonth() < 10; i = i.plusDays(1)) {
      LocalDate nextWorkingDay = i.with(new NextWorkingDay());
      System.out.printf("%s(%s);nextWorkingDay=%s(%s)\n",
                        i, i.getDayOfWeek(), nextWorkingDay, nextWorkingDay.getDayOfWeek());
    }
  }

  public static void main(String[] args) {
    System.out.println(ZoneId.getAvailableZoneIds());
  }
}
