package ua.training.model;

/**
 * Defines precious stones names.
 * @author Andriy Zakurenyi.
 */
public enum PreciousStonesNames {
    DIAMOND("diamond"), RUBY("ruby"), SAPPHIRE("sapphire"), EMERALD("emerald");

    private String name;

    PreciousStonesNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
