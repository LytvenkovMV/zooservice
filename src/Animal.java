import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

public class Animal {

//    private final Enum type;
//    private String name;
//    private final int pawNumber;
//    private final FeedType feedType;
//    private final Color color;
//    private final Habitat habitat;

    private enum Type {
        WOLF,
        TIGER,
        BEAR,
        PENGUIN,
        KANGAROO
    }

    private enum FeedType {
        MEAT,
        GRASS
    }

    private enum Color {
        BLACK,
        GRAY,
        YELLOW,
        WHITE
    }

    private enum Habitat {
        EURASIA,
        NORTH_AMERICA,
        SOUTH_AMERICA,
        AFRICA,
        AUSTRALIA,
        ANTARCTICA
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return pawNumber == animal.pawNumber && Objects.equals(type, animal.type) && Objects.equals(name, animal.name) && feedType == animal.feedType && color == animal.color && habitat == animal.habitat;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(type, name, pawNumber, feedType, color, habitat);
//    }
}


