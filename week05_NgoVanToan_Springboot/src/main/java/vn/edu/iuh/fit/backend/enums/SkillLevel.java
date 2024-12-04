package vn.edu.iuh.fit.backend.enums;

public enum SkillLevel {
    MASTER(5),

    PROFESSIONAL(4),

    ADVANCED(3),

    IMTERMEDIATE(2),

    BEGINER(1);

    private int value;

    SkillLevel(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static SkillLevel fromValue(int value) {
        for (SkillLevel level : SkillLevel.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "SkillLevel{" +
                "value=" + value +
                '}';
    }
}
