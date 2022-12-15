package com.example.mini_rpg_try_2;

import com.example.mini_rpg_try_2.Ennemis.Boss;
import com.example.mini_rpg_try_2.Ennemis.Monstre;
import com.example.mini_rpg_try_2.Ennemis.MonstreBasique;
import com.example.mini_rpg_try_2.Personnages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    public static List<Hero> heros = new ArrayList<>();
    public static List<Monstre> monstres;
    public static List<Hero> herosRestant;

    Monstre monstre;
    static int probaBoss = 10;

    public static void main(String[] args) {
        HelloApplication.main(args);
    }



    public static void updateHerosRestant(Hero heros) {
        herosRestant.remove(heros);
    }




    public static void remiseRecompenses(Hero heros, String choice) {
        int i=0;

        heros.resetPV();

        switch (choice) {
            case "A":
                heros.augmenteArmure();
                break;

            case "B":
                heros.augmenteDégats();
                break;

            case "C":
                heros.augmenteBonusConso();
                break;
            case "D":
                heros.augmenteNbConso();
                break;
            case "E":
                heros.augmenteManaOuFlèche();
                break;
        }

        if(heros.getClass()==Hunter.class){
            Hunter hunter = (Hunter) heros;
            hunter.resetFlèche();
        }
        if(SpellCaster.class.isAssignableFrom(heros.getClass())){
            SpellCaster spellCaster = (SpellCaster) heros;
            spellCaster.resetMana();
        }
        heros.resetConsommable();
    }

    public static void resetHerosRestant(){
        herosRestant = new ArrayList<>(heros);
    }


    private static void combat() {

        verifyPV();
        verifyPV();

        if(!monstres.isEmpty()){
            verifyPV();
            randomAttaque();
        }
    }

    public static void randomAttaque() {
        int aimed;
        Random random = new Random();

        for(int i=0; i<monstres.size();i++){

            aimed = random.nextInt(heros.size());


            monstres.get(i).attaque(heros.get(aimed));
        }
    }

    public static int actionChoix(Hero heroActuel, String choice) {
        return actionChoix(heroActuel, choice, -1);
    }

    public static int actionChoix(Hero heroActuel, String choice, int aimed) {

        heroActuel.resetDéfense();

        switch (choice) {
            case "Attaquer":

                if (heroActuel.getClass() == Healer.class) {
                    ((Healer) heroActuel).heal(heros,aimed);
                }
                else {
                    heroActuel.attaque(monstres.get(aimed));
                }

                verifyPV();
                break;


            case "Defendre":
                heroActuel.défend();
                break;

            case "Potion":
                heroActuel.utiliseConso(1);
                break;
            case "Bouffe":
                heroActuel.utiliseConso(2);
                break;
        }
        return 0;
    }

    public static void verifyPV() {

        for (int i=0;i<heros.size();i++){
            if (heros.get(i).getPV()==0){
                heros.remove(i);
            }
        }

        for (int j=0;j<monstres.size();j++){
            if (monstres.get(j).getPV()==0){
                monstres.remove(j);
            }
        }

        if(heros.isEmpty()){

        }
        else if(monstres.isEmpty()){

        }

    }

    public static void genererHeros(int nbHealer,int nbHunter, int nbWarrior, int nbMage) {
        heros = new ArrayList<>();

        List<Integer> listNumbers = List.of(nbHealer,nbHunter,nbWarrior,nbMage);

        for(int i=0;i<nbHealer;i++){
            heros.add(new Healer());
        }

        for(int i=0;i<nbHunter;i++){
            heros.add(new Hunter());
        }

        for(int i=0;i<nbWarrior;i++){
            heros.add(new Warrior());
        }

        for(int i=0;i<nbMage;i++){
            heros.add(new Mage());
        }

        Collections.shuffle(heros);
    }

    public static void genererMonstres() {
        genererMonstres(-1,0);
    }

    public static void genererMonstres(int taille,int round){
        List<Monstre> enemyArrayList  = new ArrayList<>();

        if(taille==-1){
            taille = heros.size()<=1 ? (int) probabilite(List.of(heros.size()+round,heros.size()+1+round),List.of(90,10)) : (int) probabilite(List.of(heros.size()-1+round,heros.size()+round,heros.size()+1+round),List.of(10,80,10));
        }


        for(int i=0;i<taille;i++){
            enemyArrayList.add((Monstre) probabilite(List.of(new MonstreBasique(),new Boss()),List.of(100-probaBoss,probaBoss)));
        }

        monstres = enemyArrayList;
    }

    public static Object probabilite(List<Object> contenu, List<Integer> probabilites) {

        Random random = new Random();
        int somme = 0;
        int borneDeFin;
        int randInt = random.nextInt(100);

        for(int i=0;i< contenu.size();i++){

            borneDeFin = somme+probabilites.get(i);

            if(randInt>=somme && randInt<=borneDeFin){
                return contenu.get(i);
            }
            somme=borneDeFin;
        }

        return -1;
    }
}
