package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;

import java.util.List;

public class Healer extends SpellCaster {

    public Healer() {
        path="Healer";
    }

    @Override
    public boolean attaque(Monstre monstre) {
        return false;
    }

    public boolean heal(List<Hero> heros,int targets) {


        System.out.println(PM);
        if(PM>diminuerMana){
            PM = PM - diminuerMana;
            heros.get(targets).ajoutePV(dégatArme);
            return true;
        }
        else{
            System.out.println("Pas assez de mana !");
            return false;
        }
    }
}
