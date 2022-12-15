package com.example.mini_rpg_try_2.Personnages;

import com.example.mini_rpg_try_2.Ennemis.Monstre;
import com.example.mini_rpg_try_2.Objets.Nourriture;
import com.example.mini_rpg_try_2.Objets.Potion;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    final int pvBase = 70;
    boolean défense;
    protected int PV = pvBase;



    private int armure;
    protected String path;

    protected int dégatArme = 27;

    public void setDégatArme(int dégatArme) {
        this.dégatArme = dégatArme;
    }

    int pvMax = 100;
    final int addEffetConso = 20;
    int bonusConso;


    private List<Potion> potions = new ArrayList();
    private List<Nourriture> lembas = new ArrayList();
    private int nbConso = 3;
    private int armureMax = 40;


    public List<Potion> getPotions() {
        return potions;
    }

    public List<Nourriture> getNourriture() {
        return lembas;
    }

    public int getDégatArme() {
        return dégatArme;
    }

    public void setPV(int PV) {
        this.PV = Math.min(PV, pvMax);
    }

    public int getPV() {
        return PV;
    }

    public Hero() {
        resetConsommable();
    }

    public void resetConsommable() {

        potions = new ArrayList<>();
        lembas = new ArrayList<>();

        for(int i=0;i<nbConso;i++){
            potions.add(new Potion());
            lembas.add(new Nourriture());
        }
    }

    public void réduitPV(int n){
        PV = Math.max(PV - n, 0);

    }

    public void ajoutePV(int n){
        PV = Math.min(PV + n, pvMax);
    }

    public abstract boolean attaque(Monstre monstre);

    public void défend(){
        setDéfense(true);
    }

    public boolean utiliseConso(int choix){
        if(!potions.isEmpty() && choix==1){
            setPV(PV+potions.get(0).getValeur()+bonusConso);
            potions.remove(0);
            return true;
        }
        else if (!lembas.isEmpty() && choix==2){
            setPV(PV+lembas.get(0).getValeur()+bonusConso);
            lembas.remove(0);
            return true;
        }
        else{
            return false;
        }
    }

    public int getBonusConso() {
        return bonusConso;
    }

    public int getArmure() {
        return armure;
    }

    public void augmenteArmure() {
        armure = (armure >= armureMax ? armureMax : armure+10);
    }

    public void augmenteDégats() {
        dégatArme+=20;
    }


    public abstract void augmenteManaOuFlèche();

    public void augmenteNbConso() {
        nbConso +=1;
    }

    public void augmenteBonusConso() {
        bonusConso+=addEffetConso;
    }

    public void resetPV() {
        PV = pvBase;
    }

    public void resetDéfense() { défense = false; }

    public void setDéfense(boolean défense) {
        this.défense = défense;
    }

    public boolean seDéfend() {
        return défense;
    }

    public String getPath() {
        return path;
    }
}
