import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog otherDog) {
        return size - otherDog.size;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }
}