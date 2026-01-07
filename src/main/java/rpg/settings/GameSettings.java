package main.java.rpg.settings;

import main.java.rpg.core.CharacterClass;

public class GameSettings {
    private static GameSettings gameSettings = new GameSettings(50);
    public int maxStatPoints;

    private GameSettings(int maxStatPoints) {
        this.maxStatPoints = maxStatPoints;
    }

    public static GameSettings getSettings() {
        return gameSettings;
    }

    public boolean isValid(CharacterClass c) {
        boolean isValidCharacter = c.getPowerLevel() <= gameSettings.maxStatPoints;
        if(!isValidCharacter) {
            System.out.println("Ce personnage n'est pas valide : Puissance totale " + c.getPowerLevel() + "; Puissance maximale autorisée : " + this.maxStatPoints);
        }
        return isValidCharacter;
    }
}
