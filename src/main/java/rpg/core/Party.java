package main.java.rpg.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Party {

    private List<CharacterClass> characters = new ArrayList<>();

    public List<CharacterClass> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterClass> characters) {
        this.characters = characters;
    }

    public void addToParty(CharacterClass character) {
        characters.add(character);
    }

    public void removeFromParty(CharacterClass character) {
        characters.removeIf(c -> Objects.equals(c.getName(), character.getName()));
    }

    public int totalPower() {
        int power = 0;
        for(CharacterClass character: characters) {
            power += character.getPowerLevel();
        }
        return power;
    }

    public void sortParty(String sortType) {
        if(Objects.equals(sortType, "name")) {
            this.characters.sort(Comparator.comparing(CharacterClass::getName));
        }
        else if (Objects.equals(sortType, "power")) {
            this.characters.sort(Comparator.comparing(CharacterClass::getPowerLevel));
        }
    }
}
