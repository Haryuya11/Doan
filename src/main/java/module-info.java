module com.doan {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    exports com.doan.application;
    exports com.doan.controllers; // Thêm dòng này
    opens com.doan.controllers to javafx.fxml; // Thêm dòng này
    opens com.doan.models to javafx.base;


}