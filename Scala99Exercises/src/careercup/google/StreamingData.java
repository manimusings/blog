package careercup.google;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * Given a server that has requests coming in. Design a data structure such that you can
 * fetch the count of the number requests in the last second, minute and hour.
 */
interface RequestHandler {
    long numOfRequestsInLastSecond();

    long numOfRequestsInLastMinute();

    long numOfRequestsInLastHour();

    void count(LocalDateTime timestamp);
}

class RequestCounter implements RequestHandler {

    private AtomicInteger secondCounter = new AtomicInteger();
    private AtomicInteger minuteCounter = new AtomicInteger();
    private AtomicInteger hourCounter = new AtomicInteger();

    private static final DateTimeFormatter secondFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
    private static final DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmm");
    private static final DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("MMddyyyyHH");

    private String currentSecondKey;
    private String currentMinuteKey;
    private String currentHourKey;


    public long numOfRequestsInLastSecond() {
        return secondCounter.longValue();
    }

    public long numOfRequestsInLastMinute() {
        return minuteCounter.longValue();
    }

    public long numOfRequestsInLastHour() {
        return hourCounter.longValue();
    }

    private void countSeconds(LocalDateTime timestamp) {
        secondCounter.getAndUpdate(existingValue -> {
            String secondKey = secondFormatter.format(timestamp);
            if (secondKey.equals(currentSecondKey)) {
                return existingValue + 1;
            } else {
                currentSecondKey = secondKey;
                return 1;
            }
        });
    }

    private void countMinutes(LocalDateTime timestamp) {
        minuteCounter.getAndUpdate(existingValue -> {
            String minuteKey = minuteFormatter.format(timestamp);
            if (minuteKey.equals(currentMinuteKey)) {
                return existingValue + 1;
            } else {
                currentMinuteKey = minuteKey;
                return 1;
            }
        });
    }

    private void countHours(LocalDateTime timestamp) {
        hourCounter.getAndUpdate(existingValue -> {
            String hourKey = hourFormatter.format(timestamp);
            if (hourKey.equals(currentHourKey)) {
                return existingValue + 1;
            } else {
                currentHourKey = hourKey;
                return 1;
            }
        });
    }

    public void count(LocalDateTime timestamp) {
        countSeconds(timestamp);
        countMinutes(timestamp);
        countHours(timestamp);
    }
}

class RequestCounter4 implements RequestHandler {

    private LongAdder secondCounter = new LongAdder();
    private LongAdder minuteCounter = new LongAdder();
    private LongAdder hourCounter = new LongAdder();

    private static final DateTimeFormatter secondFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
    private static final DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmm");
    private static final DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("MMddyyyyHH");

    private static Map<String, LongAdder> lastSecondMap = new ConcurrentHashMap<>();
    private static Map<String, LongAdder> lastMinuteMap = new ConcurrentHashMap<>();
    private static Map<String, LongAdder> lastHourMap = new ConcurrentHashMap<>();


    public long numOfRequestsInLastSecond() {
        return secondCounter.longValue();
    }

    public long numOfRequestsInLastMinute() {
        return minuteCounter.longValue();
    }

    public long numOfRequestsInLastHour() {
        return hourCounter.longValue();
    }

    public void count(LocalDateTime timestamp) {
        String secondKey = secondFormatter.format(timestamp);
        String minuteKey = minuteFormatter.format(timestamp);
        String hourKey = hourFormatter.format(timestamp);

        lastSecondMap.computeIfAbsent(secondKey, key -> {
            secondCounter.reset();
            return secondCounter;
        });
        lastSecondMap.computeIfPresent(secondKey, (key, value) -> {
            value.increment();
            return value;
        });
        lastMinuteMap.computeIfAbsent(minuteKey, key -> {
            minuteCounter.reset();
            return minuteCounter;
        });
        lastMinuteMap.computeIfPresent(minuteKey, (key, value) -> {
            value.increment();
            return value;
        });
        lastHourMap.computeIfAbsent(hourKey, key -> {
            hourCounter.reset();
            return hourCounter;
        });
        lastHourMap.computeIfPresent(hourKey, (key, value) -> {
            value.increment();
            return value;
        });

    }
}

class RequestCounter2 implements RequestHandler {

    private LongAdder secondCounter = new LongAdder();
    private LongAdder minuteCounter = new LongAdder();
    private LongAdder hourCounter = new LongAdder();

    private static final DateTimeFormatter secondFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
    private static final DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("MMddyyyyHHmm");
    private static final DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("MMddyyyyHH");

    private String currentSecondKey;
    private String currentMinuteKey;
    private String currentHourKey;


    public long numOfRequestsInLastSecond() {
        return secondCounter.longValue();
    }

    public long numOfRequestsInLastMinute() {
        return minuteCounter.longValue();
    }

    public long numOfRequestsInLastHour() {
        return hourCounter.longValue();
    }

    private synchronized void countSeconds(String secondKey) {

        if (secondKey.equals(currentSecondKey)) {
            secondCounter.increment();
        } else {
            secondCounter.reset();
            secondCounter.increment();
            currentSecondKey = secondKey;
        }
    }

    private synchronized void countMinutes(String minuteKey) {

        if (minuteKey.equals(currentMinuteKey)) {
            minuteCounter.increment();
        } else {
            minuteCounter.reset();
            minuteCounter.increment();
            currentMinuteKey = minuteKey;
        }
    }

    private synchronized void countHours(String hourKey) {

        if (hourKey.equals(currentHourKey)) {
            hourCounter.increment();
        } else {
            hourCounter.reset();
            hourCounter.increment();
            currentHourKey = hourKey;
        }
    }

    public void count(LocalDateTime timestamp) {
        countSeconds(secondFormatter.format(timestamp));
        countMinutes(minuteFormatter.format(timestamp));
        countHours(hourFormatter.format(timestamp));
    }
}


public class StreamingData {


    private static final Stream<LocalDateTime> getDates() {
        return Arrays.asList(
                LocalDateTime.of(2016, 06, 30, 12, 10, 10)
                , LocalDateTime.of(2016, 06, 30, 12, 10, 10)
                , LocalDateTime.of(2016, 06, 30, 12, 10, 11)
                , LocalDateTime.of(2016, 06, 30, 12, 30, 11)
//                LocalDateTime.of(2016, 06, 30, 12, 11, 12)
//                LocalDateTime.of(2016, 06, 30, 13, 10, 11),
        ).stream();
    }


    public static void main(String[] args) {
        Stream<LocalDateTime> input = getDates();

        RequestHandler requestHandler = new RequestCounter();
        input.forEach(date -> {
            requestHandler.count(date);
        });

        System.out.println(requestHandler.numOfRequestsInLastSecond());
        System.out.println(requestHandler.numOfRequestsInLastMinute());
        System.out.println(requestHandler.numOfRequestsInLastHour());
    }
}
