module com.personal.testejfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.personal.testejfx to javafx.fxml;
    exports com.personal.testejfx;
}