package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;

;

public class Warrior extends Hero {

    public Warrior() {
        this.dégatArme = 12;
        path="warrior";
    }

    @Override
    public boolean attaque(Monstre monstre) {
        monstre.réduitPV(dégatArme);
        return true;
    }

    @Override
    public void augmenteManaOuFlèche() {
        augmenteDégats();
    }
}
