module ru.nsu.ccfit.usoltsev.carfactory {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.ccfit.usoltsev.carfactory to javafx.fxml;
    exports ru.nsu.ccfit.usoltsev.carfactory;
}