import main.java.rpg.core.CharacterClass;
import main.java.rpg.core.ImprovedCharacter;
import main.java.rpg.core.Party;
import main.java.rpg.dao.CharacterDAO;
import main.java.rpg.decorator.Invisibility;
import main.java.rpg.settings.DatabaseConnection;
import main.java.rpg.settings.GameSettings;

void main() {

    CharacterDAO dao = new CharacterDAO(DatabaseConnection.getConnection());

    CharacterClass character = new CharacterClass.CharacterBuilder("Basvit")
            .setStrength(0)
            .setAgility(18)
            .setIntelligence(30)
            .build();

//    System.out.println(character.getPowerLevel());
//    character.getDescription();
    ImprovedCharacter ic = new Invisibility(character);
    System.out.println(ic.getDescription());
    //dao.save(character);

    CharacterClass character2 = new CharacterClass.CharacterBuilder("Adam")
            .setStrength(15)
            .setAgility(15)
            .setIntelligence(15)
            .build();

    //dao.save(character2);

    List<CharacterClass> allCharacters = dao.findAll();
    for(CharacterClass c: allCharacters) {
        System.out.println(c.getDescription());
    }

    Party party = new Party();
    for(CharacterClass c: allCharacters) {
        party.addToParty(c);
    }

    System.out.println("Puissance totale de la party :" + party.totalPower());

    party.sortParty("name");
    for(CharacterClass c: party.getCharacters()) {
        System.out.println(c.getDescription());
    }

    GameSettings settings = GameSettings.getSettings();
    System.out.println("Puissance totale maximale autorisée : " + settings.maxStatPoints);
    settings.isValid(character);

    if(settings.isValid(party.getCharacters().get(0)) && settings.isValid(party.getCharacters().get(1))) {
        Random rand = new Random();
        int diceRollCharacter1 = rand.nextInt(1,7);
        int diceRollCharacter2 = rand.nextInt(1,7);

        int character1TotalScore = party.getCharacters().get(0).getPowerLevel() + diceRollCharacter1;
        int character2TotalScore = party.getCharacters().get(1).getPowerLevel() + diceRollCharacter2;

        if(character1TotalScore > character2TotalScore) {
            System.out.println("Victoire de " + party.getCharacters().get(0).getName());
        }
        else {
            System.out.println("Victoire de " + party.getCharacters().get(1).getName());
        }
    }
}
