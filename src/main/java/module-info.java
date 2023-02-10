module org.games {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens org.games to javafx.fxml;
    exports org.games;
    exports org.games.controller;
    opens org.games.controller to javafx.fxml;
    exports org.games.service;
    opens org.games.service to javafx.fxml;
    exports org.games.domains;
    opens org.games.domains to javafx.fxml;
    exports org.games.win_validator;
    opens org.games.win_validator to javafx.fxml;
    exports org.games.draw;
    opens org.games.draw to javafx.fxml;
    exports org.games.enums.labels;
    opens org.games.enums.labels to javafx.fxml;
    exports org.games.stage;
    opens org.games.stage to javafx.fxml;
    exports org.games.enums.settings;
    opens org.games.enums.settings to javafx.fxml;
    exports org.games.enums.results;
    opens org.games.enums.results to javafx.fxml;
    exports org.games.service.game;
    opens org.games.service.game to javafx.fxml;
    exports org.games.service.result;
    opens org.games.service.result to javafx.fxml;
    exports org.games.service.start;
    opens org.games.service.start to javafx.fxml;
    exports org.games.computer;
    opens org.games.computer to javafx.fxml;
}