import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Animal {

    private final Type type;
    private final int pawNumber;
    private final FeedType feedType;
    private String name;
    private Color color;
    private Habitat habitat;

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
    public String toString() {
        return "Животное{" +
                "тип=" + type +
                ", число лап=" + pawNumber +
                ", тип корма=" + feedType +
                ", имя='" + name + '\'' +
                ", цвет=" + color +
                ", ареол обитания=" + habitat +
                '}';
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


