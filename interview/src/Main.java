import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

  public static  class Box<T> {
    public static final AtomicInteger i = new AtomicInteger();
    public Box() {
      i.incrementAndGet();
    }
  }

  public static boolean rare(String s){
    return s.length() > 4;
  }
  public static void main(String[] args) {
    List<String> l = new ArrayList<>();
     l.add("a");
     l.add("an");
     l.add("ant");
     l.add("ante");
     l.add("antelope");

    
    System.out.println();

    System.out.println(l.stream().filter(Main::rare).collect(Collectors.toList()));


  }

}
