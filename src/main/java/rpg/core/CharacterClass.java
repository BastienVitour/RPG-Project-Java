package main.java.rpg.core;

public class CharacterClass implements ImprovedCharacter {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    private CharacterClass(CharacterBuilder characterBuilder) {
        this.name = characterBuilder.name;
        this.strength = characterBuilder.strength;
        this.agility = characterBuilder.agility;
        this.intelligence = characterBuilder.intelligence;
    }

    @Override
    public int getPowerLevel() {
        return this.strength + this.agility + this.intelligence;
    }

    @Override
    public String getDescription() {
        return "Personnage " + this.name + "; Force: " + this.strength + "; Agilité: " + this.agility + "; Intelligence: " + this.intelligence + "; Puissance totale: " + this.getPowerLevel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static class CharacterBuilder {
        private String name;
        private int strength;
        private int agility;
        private int intelligence;

        public CharacterBuilder(String name) {
            this.name = name;
        }

        public CharacterBuilder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public CharacterBuilder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public CharacterBuilder setIntelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public CharacterClass build() {
            return new CharacterClass(this);
        }

    }
}
