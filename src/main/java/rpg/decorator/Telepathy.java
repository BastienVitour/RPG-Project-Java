package main.java.rpg.decorator;

import main.java.rpg.core.ImprovedCharacter;

public class Telepathy extends CharacterDecorator {
    public Telepathy(ImprovedCharacter improvedCharacter) {
        super(improvedCharacter);
    }

    @Override
    public int getPowerLevel() {
        return super.getPowerLevel();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "; Ce personnage a des pouvoirs télépathiques";
    }
}
