package com.javarush.island.cooper.constants;

import java.util.Map;
import java.util.HashMap;

public class AnimalConstants {
    public static final float WEIGHT_CHANGE_COEFFICIENT = 0.1f; // коэффициент снижения/увеличения веса на каждом ходе
    public static final float WEIGHT_MIN_COEFFICIENT = 0.5f; // коэффициент минимального веса животного
    public static final float FOOD_CHANGE_COEFFICIENT = 0.2f; // коэффициент изменения уровня насыщения
    public static final float FOOD_START_COEFFICIENT = 0.5f; // стартовый коэффициент насыщения

    public static final Map<String, Integer> ANIMAL_START_COUNT = new HashMap<>();
    static {
        ANIMAL_START_COUNT.put("Bear", 50);
        ANIMAL_START_COUNT.put("Boa", 300);
        ANIMAL_START_COUNT.put("Boar", 500);
        ANIMAL_START_COUNT.put("Buffalo", 100);
        ANIMAL_START_COUNT.put("Caterpillar", 10000);
        ANIMAL_START_COUNT.put("Deer", 200);
        ANIMAL_START_COUNT.put("Duck", 2000);
        ANIMAL_START_COUNT.put("Eagle", 200);
        ANIMAL_START_COUNT.put("Fox", 300);
        ANIMAL_START_COUNT.put("Goat", 1400);
        ANIMAL_START_COUNT.put("Horse", 200);
        ANIMAL_START_COUNT.put("Mouse", 5000);
        ANIMAL_START_COUNT.put("Rabbit", 1500);
        ANIMAL_START_COUNT.put("Sheep", 1400);
        ANIMAL_START_COUNT.put("Wolf", 300);
        ANIMAL_START_COUNT.put("Plant", 2000);
    }

    public static final Map<String, Integer> ANIMAL_MAX_COUNT = new HashMap<>();
    static {
        ANIMAL_MAX_COUNT.put("Bear", 5);
        ANIMAL_MAX_COUNT.put("Boa", 30);
        ANIMAL_MAX_COUNT.put("Boar", 50);
        ANIMAL_MAX_COUNT.put("Buffalo", 10);
        ANIMAL_MAX_COUNT.put("Caterpillar", 500);
        ANIMAL_MAX_COUNT.put("Deer", 20);
        ANIMAL_MAX_COUNT.put("Duck", 100);
        ANIMAL_MAX_COUNT.put("Eagle", 20);
        ANIMAL_MAX_COUNT.put("Fox", 20);
        ANIMAL_MAX_COUNT.put("Goat", 100);
        ANIMAL_MAX_COUNT.put("Horse", 20);
        ANIMAL_MAX_COUNT.put("Mouse", 300);
        ANIMAL_MAX_COUNT.put("Rabbit", 100);
        ANIMAL_MAX_COUNT.put("Sheep", 100);
        ANIMAL_MAX_COUNT.put("Wolf", 30);
        ANIMAL_MAX_COUNT.put("Plant", 300);
    }

    public static final Map<String, Float> ANIMAL_MAX_WEIGHT = new HashMap<>();
    static {
        ANIMAL_MAX_WEIGHT.put("Bear", 500f);
        ANIMAL_MAX_WEIGHT.put("Boa", 15f);
        ANIMAL_MAX_WEIGHT.put("Boar", 400f);
        ANIMAL_MAX_WEIGHT.put("Buffalo", 700f);
        ANIMAL_MAX_WEIGHT.put("Caterpillar", 0.01f);
        ANIMAL_MAX_WEIGHT.put("Deer", 300f);
        ANIMAL_MAX_WEIGHT.put("Duck", 1f);
        ANIMAL_MAX_WEIGHT.put("Eagle", 6f);
        ANIMAL_MAX_WEIGHT.put("Fox", 8f);
        ANIMAL_MAX_WEIGHT.put("Goat", 60f);
        ANIMAL_MAX_WEIGHT.put("Horse", 400f);
        ANIMAL_MAX_WEIGHT.put("Mouse", 0.05f);
        ANIMAL_MAX_WEIGHT.put("Rabbit", 2f);
        ANIMAL_MAX_WEIGHT.put("Sheep", 70f);
        ANIMAL_MAX_WEIGHT.put("Wolf", 50f);
        ANIMAL_MAX_WEIGHT.put("Plant", 1f);
    }

    public static final Map<String, Integer> ANIMAL_MAX_STEPS = new HashMap<>();
    static {
        ANIMAL_MAX_STEPS.put("Bear", 2);
        ANIMAL_MAX_STEPS.put("Boa", 1);
        ANIMAL_MAX_STEPS.put("Boar", 2);
        ANIMAL_MAX_STEPS.put("Buffalo", 3);
        ANIMAL_MAX_STEPS.put("Caterpillar", 0);
        ANIMAL_MAX_STEPS.put("Deer", 4);
        ANIMAL_MAX_STEPS.put("Duck", 4);
        ANIMAL_MAX_STEPS.put("Eagle", 3);
        ANIMAL_MAX_STEPS.put("Fox", 2);
        ANIMAL_MAX_STEPS.put("Goat", 3);
        ANIMAL_MAX_STEPS.put("Horse", 4);
        ANIMAL_MAX_STEPS.put("Mouse", 1);
        ANIMAL_MAX_STEPS.put("Rabbit", 2);
        ANIMAL_MAX_STEPS.put("Sheep", 3);
        ANIMAL_MAX_STEPS.put("Wolf", 3);
        ANIMAL_MAX_STEPS.put("Plant", 0);
    }

    public static final Map<String, Float> ANIMAL_MAX_FOOD = new HashMap<>();
    static {
        ANIMAL_MAX_FOOD.put("Bear", 80f);
        ANIMAL_MAX_FOOD.put("Boa", 3f);
        ANIMAL_MAX_FOOD.put("Boar", 50f);
        ANIMAL_MAX_FOOD.put("Buffalo", 100f);
        ANIMAL_MAX_FOOD.put("Caterpillar", 0f);
        ANIMAL_MAX_FOOD.put("Deer", 50f);
        ANIMAL_MAX_FOOD.put("Duck", 0.15f);
        ANIMAL_MAX_FOOD.put("Eagle", 1f);
        ANIMAL_MAX_FOOD.put("Fox", 2f);
        ANIMAL_MAX_FOOD.put("Goat", 10f);
        ANIMAL_MAX_FOOD.put("Horse", 60f);
        ANIMAL_MAX_FOOD.put("Mouse", 0.01f);
        ANIMAL_MAX_FOOD.put("Rabbit", 0.45f);
        ANIMAL_MAX_FOOD.put("Sheep", 15f);
        ANIMAL_MAX_FOOD.put("Wolf", 8f);
        ANIMAL_MAX_FOOD.put("Plant", 0f);
    }

    public static final Map<String, String> ANIMAL_ICON = new HashMap<>();
    static {
        ANIMAL_ICON.put("Bear", "\uD83D\uDC3B");
        ANIMAL_ICON.put("Boa", "\uD83D\uDC0D");
        ANIMAL_ICON.put("Boar", "\uD83D\uDC17");
        ANIMAL_ICON.put("Buffalo", "\uD83D\uDC02");
        ANIMAL_ICON.put("Caterpillar", "\uD83D\uDC1B");
        ANIMAL_ICON.put("Deer", "\uD83E\uDD8C");
        ANIMAL_ICON.put("Duck", "\uD83E\uDD86");
        ANIMAL_ICON.put("Eagle", "\uD83E\uDD85");
        ANIMAL_ICON.put("Fox", "\uD83E\uDD8A");
        ANIMAL_ICON.put("Goat", "\uD83D\uDC10");
        ANIMAL_ICON.put("Horse", "\uD83D\uDC0E");
        ANIMAL_ICON.put("Mouse", "\uD83D\uDC01");
        ANIMAL_ICON.put("Rabbit", "\uD83D\uDC07");
        ANIMAL_ICON.put("Sheep", "\uD83D\uDC11");
        ANIMAL_ICON.put("Wolf", "\uD83D\uDC3A");
        ANIMAL_ICON.put("Plant", "\uD83C\uDF40");
    }

    private static final Map<String, Integer> BEAR_CAN_EAT = new HashMap<>();
    static {
        BEAR_CAN_EAT.put("Bear", 0);
        BEAR_CAN_EAT.put("Boa", 80);
        BEAR_CAN_EAT.put("Boar", 50);
        BEAR_CAN_EAT.put("Buffalo", 20);
        BEAR_CAN_EAT.put("Caterpillar", 0);
        BEAR_CAN_EAT.put("Deer", 80);
        BEAR_CAN_EAT.put("Duck", 10);
        BEAR_CAN_EAT.put("Eagle", 0);
        BEAR_CAN_EAT.put("Fox", 0);
        BEAR_CAN_EAT.put("Goat", 70);
        BEAR_CAN_EAT.put("Horse", 40);
        BEAR_CAN_EAT.put("Mouse", 90);
        BEAR_CAN_EAT.put("Rabbit", 80);
        BEAR_CAN_EAT.put("Sheep", 70);
        BEAR_CAN_EAT.put("Wolf", 0);
        BEAR_CAN_EAT.put("Plant", 0);
    }

    private static final Map<String, Integer> BOA_CAN_EAT = new HashMap<>();
    static {
        BOA_CAN_EAT.put("Bear", 0);
        BOA_CAN_EAT.put("Boa", 0);
        BOA_CAN_EAT.put("Boar", 0);
        BOA_CAN_EAT.put("Buffalo", 0);
        BOA_CAN_EAT.put("Caterpillar", 0);
        BOA_CAN_EAT.put("Deer", 0);
        BOA_CAN_EAT.put("Duck", 10);
        BOA_CAN_EAT.put("Eagle", 0);
        BOA_CAN_EAT.put("Fox", 15);
        BOA_CAN_EAT.put("Goat", 0);
        BOA_CAN_EAT.put("Horse", 0);
        BOA_CAN_EAT.put("Mouse", 40);
        BOA_CAN_EAT.put("Rabbit", 20);
        BOA_CAN_EAT.put("Sheep", 0);
        BOA_CAN_EAT.put("Wolf", 0);
        BOA_CAN_EAT.put("Plant", 0);
    }

    private static final Map<String, Integer> BOAR_CAN_EAT = new HashMap<>();
    static {
        BOAR_CAN_EAT.put("Bear", 0);
        BOAR_CAN_EAT.put("Boa", 0);
        BOAR_CAN_EAT.put("Boar", 0);
        BOAR_CAN_EAT.put("Buffalo", 0);
        BOAR_CAN_EAT.put("Caterpillar", 90);
        BOAR_CAN_EAT.put("Deer", 0);
        BOAR_CAN_EAT.put("Duck", 0);
        BOAR_CAN_EAT.put("Eagle", 0);
        BOAR_CAN_EAT.put("Fox", 0);
        BOAR_CAN_EAT.put("Goat", 0);
        BOAR_CAN_EAT.put("Horse", 0);
        BOAR_CAN_EAT.put("Mouse", 50);
        BOAR_CAN_EAT.put("Rabbit", 0);
        BOAR_CAN_EAT.put("Sheep", 0);
        BOAR_CAN_EAT.put("Wolf", 0);
        BOAR_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> BUFFALO_CAN_EAT = new HashMap<>();
    static {
        BUFFALO_CAN_EAT.put("Bear", 0);
        BUFFALO_CAN_EAT.put("Boa", 0);
        BUFFALO_CAN_EAT.put("Boar", 0);
        BUFFALO_CAN_EAT.put("Buffalo", 0);
        BUFFALO_CAN_EAT.put("Caterpillar", 0);
        BUFFALO_CAN_EAT.put("Deer", 0);
        BUFFALO_CAN_EAT.put("Duck", 0);
        BUFFALO_CAN_EAT.put("Eagle", 0);
        BUFFALO_CAN_EAT.put("Fox", 0);
        BUFFALO_CAN_EAT.put("Goat", 0);
        BUFFALO_CAN_EAT.put("Horse", 0);
        BUFFALO_CAN_EAT.put("Mouse", 0);
        BUFFALO_CAN_EAT.put("Rabbit", 0);
        BUFFALO_CAN_EAT.put("Sheep", 0);
        BUFFALO_CAN_EAT.put("Wolf", 0);
        BUFFALO_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> CATERPILLAR_CAN_EAT = new HashMap<>();
    static {
        CATERPILLAR_CAN_EAT.put("Bear", 0);
        CATERPILLAR_CAN_EAT.put("Boa", 0);
        CATERPILLAR_CAN_EAT.put("Boar", 0);
        CATERPILLAR_CAN_EAT.put("Buffalo", 0);
        CATERPILLAR_CAN_EAT.put("Caterpillar", 0);
        CATERPILLAR_CAN_EAT.put("Deer", 0);
        CATERPILLAR_CAN_EAT.put("Duck", 0);
        CATERPILLAR_CAN_EAT.put("Eagle", 0);
        CATERPILLAR_CAN_EAT.put("Fox", 0);
        CATERPILLAR_CAN_EAT.put("Goat", 0);
        CATERPILLAR_CAN_EAT.put("Horse", 0);
        CATERPILLAR_CAN_EAT.put("Mouse", 0);
        CATERPILLAR_CAN_EAT.put("Rabbit", 0);
        CATERPILLAR_CAN_EAT.put("Sheep", 0);
        CATERPILLAR_CAN_EAT.put("Wolf", 0);
        CATERPILLAR_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> DEER_CAN_EAT = new HashMap<>();
    static {
        DEER_CAN_EAT.put("Bear", 0);
        DEER_CAN_EAT.put("Boa", 0);
        DEER_CAN_EAT.put("Boar", 0);
        DEER_CAN_EAT.put("Buffalo", 0);
        DEER_CAN_EAT.put("Caterpillar", 0);
        DEER_CAN_EAT.put("Deer", 0);
        DEER_CAN_EAT.put("Duck", 0);
        DEER_CAN_EAT.put("Eagle", 0);
        DEER_CAN_EAT.put("Fox", 0);
        DEER_CAN_EAT.put("Goat", 0);
        DEER_CAN_EAT.put("Horse", 0);
        DEER_CAN_EAT.put("Mouse", 0);
        DEER_CAN_EAT.put("Rabbit", 0);
        DEER_CAN_EAT.put("Sheep", 0);
        DEER_CAN_EAT.put("Wolf", 0);
        DEER_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> DUCK_CAN_EAT = new HashMap<>();
    static {
        DUCK_CAN_EAT.put("Bear", 0);
        DUCK_CAN_EAT.put("Boa", 0);
        DUCK_CAN_EAT.put("Boar", 0);
        DUCK_CAN_EAT.put("Buffalo", 0);
        DUCK_CAN_EAT.put("Caterpillar", 90);
        DUCK_CAN_EAT.put("Deer", 0);
        DUCK_CAN_EAT.put("Duck", 0);
        DUCK_CAN_EAT.put("Eagle", 0);
        DUCK_CAN_EAT.put("Fox", 0);
        DUCK_CAN_EAT.put("Goat", 0);
        DUCK_CAN_EAT.put("Horse", 0);
        DUCK_CAN_EAT.put("Mouse", 0);
        DUCK_CAN_EAT.put("Rabbit", 0);
        DUCK_CAN_EAT.put("Sheep", 0);
        DUCK_CAN_EAT.put("Wolf", 0);
        DUCK_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> EAGLE_CAN_EAT = new HashMap<>();
    static {
        EAGLE_CAN_EAT.put("Bear", 0);
        EAGLE_CAN_EAT.put("Boa", 0);
        EAGLE_CAN_EAT.put("Boar", 0);
        EAGLE_CAN_EAT.put("Buffalo", 0);
        EAGLE_CAN_EAT.put("Caterpillar", 0);
        EAGLE_CAN_EAT.put("Deer", 0);
        EAGLE_CAN_EAT.put("Duck", 80);
        EAGLE_CAN_EAT.put("Eagle", 0);
        EAGLE_CAN_EAT.put("Fox", 10);
        EAGLE_CAN_EAT.put("Goat", 0);
        EAGLE_CAN_EAT.put("Horse", 0);
        EAGLE_CAN_EAT.put("Mouse", 90);
        EAGLE_CAN_EAT.put("Rabbit", 90);
        EAGLE_CAN_EAT.put("Sheep", 0);
        EAGLE_CAN_EAT.put("Wolf", 0);
        EAGLE_CAN_EAT.put("Plant", 0);
    }

    private static final Map<String, Integer> FOX_CAN_EAT = new HashMap<>();
    static {
        FOX_CAN_EAT.put("Bear", 0);
        FOX_CAN_EAT.put("Boa", 0);
        FOX_CAN_EAT.put("Boar", 0);
        FOX_CAN_EAT.put("Buffalo", 0);
        FOX_CAN_EAT.put("Caterpillar", 40);
        FOX_CAN_EAT.put("Deer", 0);
        FOX_CAN_EAT.put("Duck", 60);
        FOX_CAN_EAT.put("Eagle", 0);
        FOX_CAN_EAT.put("Fox", 0);
        FOX_CAN_EAT.put("Goat", 0);
        FOX_CAN_EAT.put("Horse", 0);
        FOX_CAN_EAT.put("Mouse", 90);
        FOX_CAN_EAT.put("Rabbit", 70);
        FOX_CAN_EAT.put("Sheep", 0);
        FOX_CAN_EAT.put("Wolf", 0);
        FOX_CAN_EAT.put("Plant", 0);
    }

    private static final Map<String, Integer> GOAT_CAN_EAT = new HashMap<>();
    static {
        GOAT_CAN_EAT.put("Bear", 0);
        GOAT_CAN_EAT.put("Boa", 0);
        GOAT_CAN_EAT.put("Boar", 0);
        GOAT_CAN_EAT.put("Buffalo", 0);
        GOAT_CAN_EAT.put("Caterpillar", 0);
        GOAT_CAN_EAT.put("Deer", 0);
        GOAT_CAN_EAT.put("Duck", 0);
        GOAT_CAN_EAT.put("Eagle", 0);
        GOAT_CAN_EAT.put("Fox", 0);
        GOAT_CAN_EAT.put("Goat", 0);
        GOAT_CAN_EAT.put("Horse", 0);
        GOAT_CAN_EAT.put("Mouse", 0);
        GOAT_CAN_EAT.put("Rabbit", 0);
        GOAT_CAN_EAT.put("Sheep", 0);
        GOAT_CAN_EAT.put("Wolf", 0);
        GOAT_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> HORSE_CAN_EAT = new HashMap<>();
    static {
        HORSE_CAN_EAT.put("Bear", 0);
        HORSE_CAN_EAT.put("Boa", 0);
        HORSE_CAN_EAT.put("Boar", 0);
        HORSE_CAN_EAT.put("Buffalo", 0);
        HORSE_CAN_EAT.put("Caterpillar", 0);
        HORSE_CAN_EAT.put("Deer", 0);
        HORSE_CAN_EAT.put("Duck", 0);
        HORSE_CAN_EAT.put("Eagle", 0);
        HORSE_CAN_EAT.put("Fox", 0);
        HORSE_CAN_EAT.put("Goat", 0);
        HORSE_CAN_EAT.put("Horse", 0);
        HORSE_CAN_EAT.put("Mouse", 0);
        HORSE_CAN_EAT.put("Rabbit", 0);
        HORSE_CAN_EAT.put("Sheep", 0);
        HORSE_CAN_EAT.put("Wolf", 0);
        HORSE_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> MOUSE_CAN_EAT = new HashMap<>();
    static {
        MOUSE_CAN_EAT.put("Bear", 0);
        MOUSE_CAN_EAT.put("Boa", 0);
        MOUSE_CAN_EAT.put("Boar", 0);
        MOUSE_CAN_EAT.put("Buffalo", 0);
        MOUSE_CAN_EAT.put("Caterpillar", 90);
        MOUSE_CAN_EAT.put("Deer", 0);
        MOUSE_CAN_EAT.put("Duck", 0);
        MOUSE_CAN_EAT.put("Eagle", 0);
        MOUSE_CAN_EAT.put("Fox", 0);
        MOUSE_CAN_EAT.put("Goat", 0);
        MOUSE_CAN_EAT.put("Horse", 0);
        MOUSE_CAN_EAT.put("Mouse", 0);
        MOUSE_CAN_EAT.put("Rabbit", 0);
        MOUSE_CAN_EAT.put("Sheep", 0);
        MOUSE_CAN_EAT.put("Wolf", 0);
        MOUSE_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> PLANT_CAN_EAT = new HashMap<>();
    static {
        PLANT_CAN_EAT.put("Bear", 0);
        PLANT_CAN_EAT.put("Boa", 0);
        PLANT_CAN_EAT.put("Boar", 0);
        PLANT_CAN_EAT.put("Buffalo", 0);
        PLANT_CAN_EAT.put("Caterpillar", 0);
        PLANT_CAN_EAT.put("Deer", 0);
        PLANT_CAN_EAT.put("Duck", 0);
        PLANT_CAN_EAT.put("Eagle", 0);
        PLANT_CAN_EAT.put("Fox", 0);
        PLANT_CAN_EAT.put("Goat", 0);
        PLANT_CAN_EAT.put("Horse", 0);
        PLANT_CAN_EAT.put("Mouse", 0);
        PLANT_CAN_EAT.put("Rabbit", 0);
        PLANT_CAN_EAT.put("Sheep", 0);
        PLANT_CAN_EAT.put("Wolf", 0);
        PLANT_CAN_EAT.put("Plant", 0);
    }

    private static final Map<String, Integer> RABBIT_CAN_EAT = new HashMap<>();
    static {
        RABBIT_CAN_EAT.put("Bear", 0);
        RABBIT_CAN_EAT.put("Boa", 0);
        RABBIT_CAN_EAT.put("Boar", 0);
        RABBIT_CAN_EAT.put("Buffalo", 0);
        RABBIT_CAN_EAT.put("Caterpillar", 0);
        RABBIT_CAN_EAT.put("Deer", 0);
        RABBIT_CAN_EAT.put("Duck", 0);
        RABBIT_CAN_EAT.put("Eagle", 0);
        RABBIT_CAN_EAT.put("Fox", 0);
        RABBIT_CAN_EAT.put("Goat", 0);
        RABBIT_CAN_EAT.put("Horse", 0);
        RABBIT_CAN_EAT.put("Mouse", 0);
        RABBIT_CAN_EAT.put("Rabbit", 0);
        RABBIT_CAN_EAT.put("Sheep", 0);
        RABBIT_CAN_EAT.put("Wolf", 0);
        RABBIT_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> SHEEP_CAN_EAT = new HashMap<>();
    static {
        SHEEP_CAN_EAT.put("Bear", 0);
        SHEEP_CAN_EAT.put("Boa", 0);
        SHEEP_CAN_EAT.put("Boar", 0);
        SHEEP_CAN_EAT.put("Buffalo", 0);
        SHEEP_CAN_EAT.put("Caterpillar", 0);
        SHEEP_CAN_EAT.put("Deer", 0);
        SHEEP_CAN_EAT.put("Duck", 0);
        SHEEP_CAN_EAT.put("Eagle", 0);
        SHEEP_CAN_EAT.put("Fox", 0);
        SHEEP_CAN_EAT.put("Goat", 0);
        SHEEP_CAN_EAT.put("Horse", 0);
        SHEEP_CAN_EAT.put("Mouse", 0);
        SHEEP_CAN_EAT.put("Rabbit", 0);
        SHEEP_CAN_EAT.put("Sheep", 0);
        SHEEP_CAN_EAT.put("Wolf", 0);
        SHEEP_CAN_EAT.put("Plant", 100);
    }

    private static final Map<String, Integer> WOLF_CAN_EAT = new HashMap<>();
    static {
        WOLF_CAN_EAT.put("Bear", 0);
        WOLF_CAN_EAT.put("Boa", 0);
        WOLF_CAN_EAT.put("Boar", 15);
        WOLF_CAN_EAT.put("Buffalo", 10);
        WOLF_CAN_EAT.put("Caterpillar", 0);
        WOLF_CAN_EAT.put("Deer", 15);
        WOLF_CAN_EAT.put("Duck", 40);
        WOLF_CAN_EAT.put("Eagle", 0);
        WOLF_CAN_EAT.put("Fox", 0);
        WOLF_CAN_EAT.put("Goat", 60);
        WOLF_CAN_EAT.put("Horse", 10);
        WOLF_CAN_EAT.put("Mouse", 80);
        WOLF_CAN_EAT.put("Rabbit", 60);
        WOLF_CAN_EAT.put("Sheep", 70);
        WOLF_CAN_EAT.put("Wolf", 0);
        WOLF_CAN_EAT.put("Plant", 0);
    }

    public static final Map<String, Map<String, Integer>> CAN_EAT = new HashMap<>();
    static {
        CAN_EAT.put("Bear", BEAR_CAN_EAT);
        CAN_EAT.put("Boa", BOA_CAN_EAT);
        CAN_EAT.put("Boar", BOAR_CAN_EAT);
        CAN_EAT.put("Buffalo", BUFFALO_CAN_EAT);
        CAN_EAT.put("Caterpillar", CATERPILLAR_CAN_EAT);
        CAN_EAT.put("Deer", DEER_CAN_EAT);
        CAN_EAT.put("Duck", DUCK_CAN_EAT);
        CAN_EAT.put("Eagle", EAGLE_CAN_EAT);
        CAN_EAT.put("Fox", FOX_CAN_EAT);
        CAN_EAT.put("Goat", GOAT_CAN_EAT);
        CAN_EAT.put("Horse", HORSE_CAN_EAT);
        CAN_EAT.put("Mouse", MOUSE_CAN_EAT);
        CAN_EAT.put("Rabbit", RABBIT_CAN_EAT);
        CAN_EAT.put("Sheep", SHEEP_CAN_EAT);
        CAN_EAT.put("Wolf", WOLF_CAN_EAT);
        CAN_EAT.put("Plant", PLANT_CAN_EAT);
    }
}
