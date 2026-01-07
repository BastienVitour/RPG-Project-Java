package main.java.rpg.decorator;

import main.java.rpg.core.ImprovedCharacter;

public abstract class CharacterDecorator implements ImprovedCharacter {

    protected ImprovedCharacter improvedCharacter;

    public CharacterDecorator(ImprovedCharacter improvedCharacter)
    {
        this.improvedCharacter = improvedCharacter;
    }

    @Override
    public int getPowerLevel() {
        return improvedCharacter.getPowerLevel();
    }

    @Override
    public String getDescription() {
        return improvedCharacter.getDescription();
    }
}
