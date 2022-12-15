package com.example.mini_rpg_try_2;

import com.example.mini_rpg_try_2.Personnages.Hero;
import com.example.mini_rpg_try_2.Personnages.Hunter;
import com.example.mini_rpg_try_2.Personnages.SpellCaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.example.mini_rpg_try_2.Game.heros;
import static com.example.mini_rpg_try_2.Game.remiseRecompenses;
import static com.example.mini_rpg_try_2.HelloController.heroRecompensesCompteur;

public class RecompensesController {
    @FXML
    private Label labelHero;

    @FXML
    private ImageView heroImage;
    HelloController controller;

    public void setMainController(HelloController controller){
        this.controller = controller;
    }

    public void initialize(){
        heroImage.setImage(new Image(getClass().getResourceAsStream("/img/"+Game.heros.get(heroRecompensesCompteur).getPath()+".png")));
        labelHero.setText("Hero actuel : "+heroRecompensesCompteur);
    }

    @FXML
    protected void addArmure(ActionEvent event) {
        remiseRecompenses(heros.get(heroRecompensesCompteur),"A");
        heroRecompensesCompteur+=1;

        loadImageHeroRecompenses();


    }
    @FXML
    protected void addDégats(ActionEvent event) {
        remiseRecompenses(heros.get(heroRecompensesCompteur),"B");
        heroRecompensesCompteur+=1;

        loadImageHeroRecompenses();


    }
    @FXML
    protected void addConsommable(ActionEvent event) {
        remiseRecompenses(heros.get(heroRecompensesCompteur),"D");
        heroRecompensesCompteur+=1;

        loadImageHeroRecompenses();


    }
    @FXML
    protected void addBonusConso(ActionEvent event) {
        remiseRecompenses(heros.get(heroRecompensesCompteur),"C");
        heroRecompensesCompteur+=1;

        loadImageHeroRecompenses();



    }
    @FXML
    protected void addManaouFlèche(ActionEvent event) {
        Hero hero = heros.get(heroRecompensesCompteur);
        if(hero.getClass()== Hunter.class || SpellCaster.class.isAssignableFrom(hero.getClass())){
            remiseRecompenses(heros.get(heroRecompensesCompteur),"E");
            heroRecompensesCompteur+=1;

            loadImageHeroRecompenses();
        }

    }


    private void loadImageHeroRecompenses() {
        if(heroRecompensesCompteur<heros.size()){
            heroImage.setImage(new Image(getClass().getResourceAsStream("/img/"+Game.heros.get(heroRecompensesCompteur).getPath()+".png")));
            labelHero.setText("Hero actuel : "+heroRecompensesCompteur);
        }
        else{
            controller.generationJeuUI();
        }
    }

}
