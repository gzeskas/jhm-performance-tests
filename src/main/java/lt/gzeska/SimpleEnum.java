package lt.gzeska;

import java.util.*;

/**
 * Created by gjurgo@gmail.com on 11/03/2017.
 */
public enum SimpleEnum {
    FIRST(1, "FIRST"),
    SECOND(2, "SECOND"),
    THIRD(3, "THIRD"),
    FOURTH(4, "FOURTH");

    public static final SimpleEnum DEFAULT = SimpleEnum.FIRST;
    private static final Map<String, SimpleEnum> NAMES_ID_TO_ENUM_MAP = new HashMap<>();
    private static final Map<Integer, SimpleEnum> INT_ID_TO_ENUM_MAP = new HashMap<>();

    private static final List<SimpleEnum> values = Arrays.asList(SimpleEnum.values());

    private final Integer id;
    private final String name;
    static {
        for (SimpleEnum type : EnumSet.allOf(SimpleEnum.class)) {
            NAMES_ID_TO_ENUM_MAP.put(type.getName(), type);
            if (type.getId() != null) {
                INT_ID_TO_ENUM_MAP.put(type.getId(), type);
            }
        }
    }
    SimpleEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SimpleEnum forId(Integer id) {
        return INT_ID_TO_ENUM_MAP.getOrDefault(id, DEFAULT);
    }

    public static SimpleEnum forName(String name) {
        SimpleEnum paymentPlanMapping =  NAMES_ID_TO_ENUM_MAP.get(name);
        if (paymentPlanMapping == null) {
            return DEFAULT;
        }
        return paymentPlanMapping;
    }

    public boolean isDefault() {
        return this.equals(DEFAULT);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void forIdStream(int randomIndex) {
        values.stream()
            .filter(v -> v.getId().equals(randomIndex))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(randomIndex + ""));
    }

    public static void forNameStream(String name) {
        values.stream()
                .filter(v -> v.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(name));
    }
}

