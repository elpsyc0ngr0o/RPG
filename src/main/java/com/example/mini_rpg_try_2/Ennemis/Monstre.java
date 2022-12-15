package com.example.mini_rpg_try_2.Ennemis;

import com.example.mini_rpg_try_2.Personnages.Hero;

public class Monstre {
    protected int PV;
    protected int dégatArme;
    protected String path;

    public int getPV() {return PV;}

    public void réduitPV(int n) {
        PV = PV - n < 0 ? 0 : PV - n;
    }

    public String getPath() {
        return path;
    }

    public boolean attaque(Hero hero) {
        int dégats = dégatArme * (1-(hero.getArmure()/100));

        if(hero.seDéfend()){
            dégats = (int) (dégatArme*0.7);
        }

        hero.réduitPV(dégats);
        return true;
    }
}