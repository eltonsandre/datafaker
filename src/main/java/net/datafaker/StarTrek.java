package net.datafaker;

public class StarTrek {
    private final Faker faker;

    protected StarTrek(Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return faker.fakeValuesService().resolve("star_trek.character", this, faker);
    }

    public String location() {
        return faker.fakeValuesService().resolve("star_trek.location", this, faker);
    }

    public String species() {
        return faker.fakeValuesService().resolve("star_trek.species", this, faker);
    }

    public String villain() {
        return faker.fakeValuesService().resolve("star_trek.villain", this, faker);
    }

    public String klingon() {
        return faker.fakeValuesService().resolve("star_trek.klingon", this, faker);
    }
}
