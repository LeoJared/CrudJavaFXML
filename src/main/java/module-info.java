module com.mycompany.crudjavafxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.crudjavafxml to javafx.fxml;
    exports com.mycompany.crudjavafxml;
}
