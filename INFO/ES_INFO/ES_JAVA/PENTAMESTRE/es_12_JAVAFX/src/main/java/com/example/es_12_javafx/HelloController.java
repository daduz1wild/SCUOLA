package com.example.es_12_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class HelloController {

    @FXML
    private Button btnLum;

    @FXML
    private Button btnNewLamp;

    @FXML
    private Button btnOff;

    @FXML
    private Button btnOn;

    @FXML
    private Button btnRGB;

    @FXML
    private Circle crcLamp;

    @FXML
    private Label lblError;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtLum;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtR;
    public void btnNewLampOnClick(){
            try {
                Lamp lamp = new Lamp(txtNome.getText());
                txtLum.setDisable(false);
                btnLum.setDisable(false);
                txtR.setDisable(false);
                txtG.setDisable(false);
                txtB.setVisible(false);
                btnRGB.setVisible(false);

            }catch(NullPointerException | IllegalStateException e){

            }
    }
}
