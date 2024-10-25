package me.trenchlive.vigenere.vigenerecipher;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import me.trenchlive.vigenere.vigenerecipher.services.FileGetter;
import me.trenchlive.vigenere.vigenerecipher.services.FileSaver;
import me.trenchlive.vigenere.vigenerecipher.services.Validation;
import static me.trenchlive.vigenere.vigenerecipher.services.VigenereCipher.encrypt;

import java.io.File;


public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private Label progressStateText;

    @FXML
    private TextField key;

    private String file = null;

    @FXML
    protected void onChooseFileButtonClick() {
        File selectedFile = FileGetter.getFile();
        if (selectedFile != null){
            file = selectedFile.toString();
            progressStateText.setText("Выбран входной и выходной файл");
        }
    }

    @FXML
    protected void onDecodeButtonClick() {
        if(file == null)
            return;

        if(!Validation.valid(key.getText())) {
            progressStateText.setText("not decoded, enter the key");
            return;
        }

        FileSaver.saveFile(file, encrypt(FileGetter.readFile(file), key.getText(), false));
        progressStateText.setText("Decoded!");
    }

    @FXML
    protected void onEncodeButtonClick() {
        if(file == null)
            return;

        if(!Validation.valid(key.getText())) {
            progressStateText.setText("not encoded, enter the key");
            return;
        }


        FileSaver.saveFile(file, encrypt(FileGetter.readFile(file), key.getText(), true));
        progressStateText.setText("Encoded!");
    }
}