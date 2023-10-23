module com.derekwillyan.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

            
                            
    opens com.derekwillyan.biblioteca to javafx.fxml, javafx.controls, javafx.graphics, java.sql;
    exports com.derekwillyan.biblioteca;
    exports com.derekwillyan.biblioteca.Controllers;
    opens com.derekwillyan.biblioteca.Controllers to java.sql, javafx.controls, javafx.fxml, javafx.graphics;
    exports com.derekwillyan.biblioteca.Models;
    opens com.derekwillyan.biblioteca.Models to java.sql, javafx.controls, javafx.fxml, javafx.graphics;
}