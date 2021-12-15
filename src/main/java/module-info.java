module com.coding.labyrtintheteamaim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.coding.labyrtintheteamaim to javafx.fxml;
    exports com.coding.labyrtintheteamaim.controller;
    opens com.coding.labyrtintheteamaim.controller to javafx.fxml;
    exports com.coding.labyrtintheteamaim;
}