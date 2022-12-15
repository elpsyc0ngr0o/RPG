module com.example.mini_rpg_try_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.mini_rpg_try_2 to javafx.fxml;
    exports com.example.mini_rpg_try_2;
    exports com.example.mini_rpg_try_2.Personnages;
    opens com.example.mini_rpg_try_2.Personnages to javafx.fxml;
    exports com.example.mini_rpg_try_2.Objets;
    opens com.example.mini_rpg_try_2.Objets to javafx.fxml;
    exports com.example.mini_rpg_try_2.Ennemis;
    opens com.example.mini_rpg_try_2.Ennemis to javafx.fxml;
}