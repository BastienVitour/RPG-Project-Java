package main.java.rpg.dao;

import main.java.rpg.core.CharacterClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO implements DAO<CharacterClass> {

    private Connection connection;

    public CharacterDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(CharacterClass character) {
        String sql = "INSERT INTO public.character(name, strength, agility, intelligence) VALUES (?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, character.getName());
            stmt.setInt(2, character.getStrength());
            stmt.setInt(3, character.getAgility());
            stmt.setInt(4, character.getIntelligence());
            int rowCreated = stmt.executeUpdate();
            if(rowCreated == 1) {
                System.out.println("Character successfully inserted");
            }
            else {
                System.out.println("The character was not inserted");
            }
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public CharacterClass findByName(String name) {
        String sql = "SELECT * FROM public.character WHERE name = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new CharacterClass.CharacterBuilder(rs.getString("name"))
                        .setStrength(rs.getInt("strength"))
                        .setAgility(rs.getInt("agility"))
                        .setIntelligence(rs.getInt("intelligence"))
                        .build();
            }
        }
        catch(SQLException e) {

        }
        return null;
    }

    @Override
    public List<CharacterClass> findAll() {
        List<CharacterClass> characters = new ArrayList<>();
        String sql = "SELECT * FROM public.character;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                characters.add(new CharacterClass.CharacterBuilder(rs.getString("name"))
                        .setStrength(rs.getInt("strength"))
                        .setAgility(rs.getInt("agility"))
                        .setIntelligence(rs.getInt("intelligence"))
                        .build());
            }
            return characters;
        }
        catch(SQLException e) {

        }
        return null;
    }
}
