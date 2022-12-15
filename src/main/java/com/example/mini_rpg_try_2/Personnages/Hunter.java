package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;

;

public class Hunter extends Hero {


    private int baseFlèche = 10;
    private int flèche;


    public Hunter() {
        this.flèche = baseFlèche;
        path="Hunter";
    }

    public void setFlèche(int flèche) {
        this.flèche = flèche;
    }

    public void resetFlèche(){
        this.flèche = baseFlèche;
    }



    @Override
    public boolean attaque(Monstre monstre) {
        if(flèche>0){
            flèche-=1;

            monstre.réduitPV(dégatArme);
            return true;
        }
        else{
            System.out.println("Plus de flèches !");
            return false;
        }
    }



    public int getFlèche() {
        return flèche;
    }

    @Override
    public void augmenteManaOuFlèche() {
        baseFlèche+=10;
    }
}
