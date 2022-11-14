package com.Baranbe.Pokemon;

import com.Baranbe.Pokemon.Models.FireType;
import com.Baranbe.Pokemon.Models.PlantType;
import com.Baranbe.Pokemon.Models.Pokemon;
import com.Baranbe.Pokemon.Models.WaterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

    public class Main {

        static List<Pokemon> pokemons;

        public static void main(String[] args) {
            pokemons = new ArrayList();
            Scanner scanner = new Scanner(System.in);
            String stringQuiSertAttendre;

            boolean exit = false;
            while (!exit) {
                System.out.println("Que voulez vous faire");
                System.out.println(" 1/ Ajouter un pokémon\n 2/Combattre");
                int choice = Integer.parseInt(scanner.next());
                switch (choice) {
                    case 1: {
                        System.out.println("Entrez le nom du pokémonon");
                        String name = scanner.next();
                        System.out.println("Entrez ses pv");
                        float pv = Float.parseFloat(scanner.next());
                        System.out.println("Entrez son attaque:");
                        float attaque = Float.parseFloat(scanner.next());
                        System.out.println("De quelle type est votre pokémon");
                        System.out.println(" 1/Normal\n 2/Feu\n 3/Eau\n 4/Plante");
                        int choicetype = Integer.parseInt(scanner.next());
                        switch (choicetype) {
                            case 1: {
                                Pokemon pokemon = new Pokemon(name, pv, attaque);
                                pokemons.add(pokemon);
                            }
                            break;
                            case 2: {
                                Pokemon pokemon = new FireType(name, pv, attaque);
                                pokemons.add(pokemon);
                            }
                            break;
                            case 3: {
                                Pokemon pokemon = new WaterType(name, pv, attaque);
                                pokemons.add(pokemon);
                            }
                            break;
                            case 4: {
                                Pokemon pokemon = new PlantType(name, pv, attaque);
                                pokemons.add(pokemon);
                            }
                            break;
                            default: {
                                System.err.println("Entrée invalide merci d'entrer un nombre entre 1 et 4");
                            }
                        }
                    }
                    break;
                    case 2: {
                        if (pokemons.size() == 0) {
                            System.err.println("La liste est vide il ne peut y  avoir de combats. " +
                                    "Merci d'ajouter au moins deux pokémons");
                        } else if (pokemons.size() == 1) {
                            System.err.println("Il n'est pas interressant de faire un combat avec un seul pokémon."
                                    + "Merci d'en ajouter au moins un autre");
                        } else {
                            System.out.println("Les combatants sont");
                            for (Pokemon pokemon : pokemons) {
                                System.out.println(pokemon.toString());
                            }
                            System.out.println("Appuyez sur entrer pour continuer");
                            stringQuiSertAttendre = scanner.next();
                            int tour = 0;
                            while (pokemons.size() > 1) {
                                tour++;
                                combat();
                            }
                            System.out.println("Combat terminé le vaiquer est " + pokemons.get(0).getNom());
                            System.out.println("Le combat aura duré " + tour + " tours");

                        }
                    }
                    break;
                    default: {
                        System.err.println("Entrée invalide! " +
                                "Merci d'enter soit 1 pour ajouter un nouveau pokémon soit 2 pour lancer le combat");
                    }
                }
            }


        }

        static void combat() {
            Random random = new Random();

            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemonAttaquant = pokemons.get(i);
                int randomIndex = random.nextInt(0, pokemons.size() - 1);
                Pokemon pokemonAttaque = pokemons.get(randomIndex);
                pokemonAttaquant.attack(pokemonAttaque);
                if (pokemonAttaque.isDead()) {
                    pokemons.remove(randomIndex);
                }
            }
        }
    }


