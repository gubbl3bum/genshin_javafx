module com.genshin_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires jbcrypt;
    requires java.sql;
    requires com.jfoenix;

    opens com.genshin_javafx.entities to org.hibernate.orm.core, javafx.fxml, javafx.base;
    opens com.genshin_javafx to javafx.fxml;
    exports com.genshin_javafx;
    exports com.genshin_javafx.controllers;
    opens com.genshin_javafx.controllers to javafx.fxml;
}
