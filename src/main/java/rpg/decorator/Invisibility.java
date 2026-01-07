package main.java.rpg.decorator;

import main.java.rpg.core.ImprovedCharacter;

public class Invisibility extends CharacterDecorator {
    public Invisibility(ImprovedCharacter improvedCharacter) {
        super(improvedCharacter);
    }

    @Override
    public int getPowerLevel() {
        return super.getPowerLevel();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "; Ce personnage peut devenir invisible";
    }
}
