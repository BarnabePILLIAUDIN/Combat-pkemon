package com.Baranbe.Pokemon.Models;

public class FireType extends Pokemon {

    public FireType(String nom, float hp, float atk) {
        super(nom, hp, atk);
    }

    public void attack(Pokemon p) {
        if (p.getClass().getSimpleName().equals("PlantType")) {
            p.setHp(p.getHp() - 2 * super.getAtk());
            System.out.println("L'attaque de "+getNom()+" est super efficace");
        } else if (p.getClass().getSimpleName().equals("WaterType") || p.getClass().getSimpleName().equals("FireType")) {
            System.out.println("Ce n'est pas trés efficace");
            p.setHp(p.getHp() - 0.5f * super.getAtk());
        } else {
            p.setHp(p.getHp() - super.getAtk());
            System.out.println("Attaque moyenne de la part de "+super.getNom());
        }
        System.out.println(p.getNom()+" n'as plus que "+p.getHp()+" pv");
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nom='" + super.getNom() + '\'' +
                ", hp=" + super.getHp() +
                ", atk=" + super.getAtk() +
                ", type="+" Feu"+
                '}';
    }
}
