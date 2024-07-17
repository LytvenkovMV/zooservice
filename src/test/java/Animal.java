import java.util.Objects;

public class Animal {

    private final Type type;
    private final int pawNumber;
    private final FeedType feedType;
    private String name;
    private Color color;
    private Habitat habitat;

    public Animal(Type type, String name, int pawNumber, FeedType feedType) {
        this.type = type;
        this.name = name;
        this.pawNumber = pawNumber;
        this.feedType = feedType;
    }

    public enum Type {
        WOLF,
        TIGER,
        BEAR,
        PENGUIN,
        KANGAROO
    }

    public enum FeedType {
        MEAT,
        GRASS
    }

    public enum Color {
        BLACK,
        GRAY,
        YELLOW,
        WHITE
    }

    public enum Habitat {
        EURASIA,
        NORTH_AMERICA,
        SOUTH_AMERICA,
        AFRICA,
        AUSTRALIA,
        ANTARCTICA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return pawNumber == animal.pawNumber && Objects.equals(type, animal.type) && Objects.equals(name, animal.name) && feedType == animal.feedType && color == animal.color && habitat == animal.habitat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, pawNumber, feedType, color, habitat);
    }
}


