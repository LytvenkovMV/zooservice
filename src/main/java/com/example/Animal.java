package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Animal {

    private final Type type;
    private final int pawNumber;
    private final FeedType feedType;
    private String name;
    private Color color;
    private Habitat habitat;

    public enum Property {
        TYPE,
        FEED_TYPE,
        COLOR,
        HABITAT
    }

    public enum Type {
        WOLF("волк"),
        TIGER("тигр"),
        BEAR("медведь"),
        PENGUIN("пингвин"),
        KANGAROO("кенгуру");

        private final String str;

        Type(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    public enum FeedType {
        MEAT("хищник"),
        GRASS("травоядный");

        private final String str;

        FeedType(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    public enum Color {
        BLACK("черный"),
        GRAY("серый"),
        YELLOW("желтый"),
        WHITE("белый");

        private final String str;

        Color(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    public enum Habitat {
        EURASIA("Евразия"),
        NORTH_AMERICA("Северная Америка"),
        SOUTH_AMERICA("Южная Америка"),
        AFRICA("Африка"),
        AUSTRALIA("Австралия"),
        ANTARCTICA("Антарктида");

        private final String str;

        Habitat(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    @Override
    public String toString() {
        return "Животное{" +
                "тип=" + type.getStr() +
                ", число лап=" + pawNumber +
                ", тип корма=" + feedType.getStr() +
                ", имя='" + name + '\'' +
                ", цвет=" + color.getStr() +
                ", ареал обитания=" + habitat.getStr() +
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


