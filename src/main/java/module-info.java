module me.trenchlive.vigenere.vigenerecipher {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.trenchlive.vigenere.vigenerecipher to javafx.fxml;
    exports me.trenchlive.vigenere.vigenerecipher;
}