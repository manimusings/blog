package ctci.chap3;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Comparator;
import java.util.LinkedList;

public class AnimalShelter_3_7 {

  public static enum AnimalType {
    Cat, Dog;
  }

  public static final class Animal {

    private AnimalType myType;
    private LocalDateTime arrivalTime;

    public Animal(AnimalType myType, LocalDateTime arrivalTime) {
      this.myType = myType;
      this.arrivalTime = arrivalTime;
    }

    public AnimalType getMyType() {
      return myType;
    }

    public LocalDateTime getArrivalTime() {
      return arrivalTime;
    }

    @Override
    public String toString() {
      return "Animal{" +
             "myType=" + myType +
             ", arrivalTime=" + arrivalTime +
             '}';
    }
  }

  private LinkedList<Animal> dogs = new LinkedList<>();
  private LinkedList<Animal> cats = new LinkedList<>();

  private boolean isDogsSorted;
  private boolean isCatsSorted;

  public void enqueue(Animal item) {
    if (AnimalType.Dog == item.getMyType()) {
      dogs.add(item);
      dogs.sort(Comparator.comparing(Animal::getArrivalTime));
    }
    if (AnimalType.Cat == item.getMyType()) {
      cats.add(item);
      cats.sort(Comparator.comparing(Animal::getArrivalTime));
    }
  }

  public Animal dequeueAny() {
    Animal oldestDog = dogs.peekFirst();
    Animal oldestCat = cats.peekFirst();
    if (null == oldestDog) {
      return dequeueCat();
    }
    if (null == oldestCat) {
      return dequeueDog();
    }

    if (oldestDog.getArrivalTime().isBefore(oldestCat.getArrivalTime())) {
      return dequeueDog();
    } else {
      return dequeueCat();
    }
  }

  private Animal dequeueCat() {
    return cats.remove();
  }

  private Animal dequeueDog() {
    return dogs.remove();
  }

  public static void main(String[] args) {
    AnimalShelter_3_7 as = new AnimalShelter_3_7();
    as.enqueue(new Animal(AnimalType.Cat, LocalDateTime.of(2016, Month.JUNE, 10, 10, 20)));
    as.enqueue(new Animal(AnimalType.Cat, LocalDateTime.of(2016, Month.JUNE, 10, 9, 20)));
    as.enqueue(new Animal(AnimalType.Cat, LocalDateTime.of(2016, Month.JUNE, 10, 8, 20)));

    as.enqueue(new Animal(AnimalType.Dog, LocalDateTime.of(2016, Month.JUNE, 10, 9, 10)));
    as.enqueue(new Animal(AnimalType.Dog, LocalDateTime.of(2016, Month.JUNE, 10, 11, 20)));
    as.enqueue(new Animal(AnimalType.Dog, LocalDateTime.of(2016, Month.JUNE, 10, 7, 20)));

//    System.out.println(as.dequeueAny());
//    System.out.println(as.dequeueAny());
//    System.out.println(as.dequeueAny());

    System.out.println(as.dequeueCat());
    System.out.println(as.dequeueCat());
    System.out.println(as.dequeueCat());

  }
}
