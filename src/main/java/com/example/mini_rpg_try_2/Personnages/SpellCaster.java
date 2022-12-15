package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;

;

public abstract class SpellCaster extends Hero {

    protected int manaBase = 90;
    protected int PM;
    protected int diminuerMana;

    public SpellCaster() {
        this.PM = manaBase;
        this.diminuerMana = 12;
    }

    public int getMana() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public abstract boolean attaque(Monstre monstre);


    @Override
    public void augmenteManaOuFlèche() {
        manaBase+=20;
    }

    public void resetMana() {
        PM = manaBase;
    }
}
