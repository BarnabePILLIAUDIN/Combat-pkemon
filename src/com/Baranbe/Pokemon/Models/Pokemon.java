package com.Baranbe.Pokemon.Models;

public class Pokemon {
    private String nom;
    private float hp;
    private float  atk;

    public Pokemon(String nom, float hp, float atk) {
        this.nom = nom;
        this.hp = hp;
        this.atk = atk;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public boolean isDead(){
        if (this.hp<=0){
            System.out.println(getNom()+" est incapable de se battre");
            return true;
        }else {
            return false;
        }
    }

    public void attack(Pokemon p){
        p.setHp(p.getHp()-this.atk);
        System.out.println("Attaque moyenne de la part de "+getNom());
        System.out.println(p.getNom()+" n'as plus que "+p.getHp()+" pv");
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nom='" + nom + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", type="+" normale"+
                '}';
    }
}
