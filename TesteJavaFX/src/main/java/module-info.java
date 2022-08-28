module com.personal.testejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.personal.testejavafx to javafx.fxml;
    exports com.personal.testejavafx;
}