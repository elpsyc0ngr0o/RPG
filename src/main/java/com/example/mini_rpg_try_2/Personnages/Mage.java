package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;

;

public class Mage extends SpellCaster {
    public Mage() {
        path="Mage";
    }

    @Override
    public boolean attaque(Monstre monstre) {
        if(PM>diminuerMana){
            PM = PM - diminuerMana;
            monstre.réduitPV(dégatArme);
            return true;
        }
        else{
            System.out.println("Pas assez de mana !");
            return false;
        }
    }
}
