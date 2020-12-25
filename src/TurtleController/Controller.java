package TurtleController;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    public TextField ConsoleInput;
    @FXML
    public VBox Log;

    @FXML
    public Canvas worldView;

    @FXML
    public ImageView Slot0;
    @FXML
    public ImageView Slot1;
    @FXML
    public ImageView Slot2;
    @FXML
    public ImageView Slot3;
    @FXML
    public ImageView Slot4;
    @FXML
    public ImageView Slot5;
    @FXML
    public ImageView Slot6;
    @FXML
    public ImageView Slot7;
    @FXML
    public ImageView Slot8;
    @FXML
    public ImageView Slot9;
    @FXML
    public ImageView Slot10;
    @FXML
    public ImageView Slot11;
    @FXML
    public ImageView Slot12;
    @FXML
    public ImageView Slot13;
    @FXML
    public ImageView Slot14;
    @FXML
    public ImageView Slot15;
    @FXML
    public Text SlotText0;
    @FXML
    public Text SlotText1;
    @FXML
    public Text SlotText2;
    @FXML
    public Text SlotText3;
    @FXML
    public Text SlotText4;
    @FXML
    public Text SlotText5;
    @FXML
    public Text SlotText6;
    @FXML
    public Text SlotText7;
    @FXML
    public Text SlotText8;
    @FXML
    public Text SlotText9;
    @FXML
    public Text SlotText10;
    @FXML
    public Text SlotText11;
    @FXML
    public Text SlotText12;
    @FXML
    public Text SlotText13;
    @FXML
    public Text SlotText14;
    @FXML
    public Text SlotText15;

    public void ExecuteFunction(ActionEvent e) {
        if (!Main.turtles.isEmpty()) {
            Text tmp=new Text(Main.turtles.get(Main.selectedTurtle).SendFunction(ConsoleInput.getText()).toJSONString());
            tmp.setStyle("-fx-font: 24 arial;");
            Log.getChildren().addAll(tmp);
            try {
                UpdateUI();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    public void TabSwitch(Event e){
        try {
            if (!Main.turtles.isEmpty()) {
                UpdateUI();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public void UpdateUI() throws FileNotFoundException {
        //Creating an image
        Image image = new Image(new FileInputStream("src/TurtleController/assets/items/arrow.png"));

        Slot0.setImage(image);
        Slot1.setImage(image);
        Slot2.setImage(image);
        Slot3.setImage(image);
        Slot4.setImage(image);
        Slot5.setImage(image);
        Slot6.setImage(image);
        Slot7.setImage(image);
        Slot8.setImage(image);
        Slot9.setImage(image);
        Slot10.setImage(image);
        Slot11.setImage(image);
        Slot12.setImage(image);
        Slot13.setImage(image);
        Slot14.setImage(image);
        Slot15.setImage(image);

        SlotText0.setText(String.valueOf(Main.turtles.get(Main.selectedTurtle).GetInv().GetSlot(0).count));
        SlotText0.setStyle("-fx-font: 24 arial;");
        SlotText1.setText("0");
        SlotText1.setStyle("-fx-font: 24 arial;");
        SlotText2.setText("0");
        SlotText2.setStyle("-fx-font: 24 arial;");
        SlotText3.setText("0");
        SlotText3.setStyle("-fx-font: 24 arial;");
        SlotText4.setText("0");
        SlotText4.setStyle("-fx-font: 24 arial;");
        SlotText5.setText("0");
        SlotText5.setStyle("-fx-font: 24 arial;");
        SlotText6.setText("0");
        SlotText6.setStyle("-fx-font: 24 arial;");
        SlotText7.setText("0");
        SlotText7.setStyle("-fx-font: 24 arial;");
        SlotText8.setText("0");
        SlotText8.setStyle("-fx-font: 24 arial;");
        SlotText9.setText("0");
        SlotText9.setStyle("-fx-font: 24 arial;");
        SlotText10.setText("0");
        SlotText10.setStyle("-fx-font: 24 arial;");
        SlotText11.setText("0");
        SlotText11.setStyle("-fx-font: 24 arial;");
        SlotText12.setText("0");
        SlotText12.setStyle("-fx-font: 24 arial;");
        SlotText13.setText("0");
        SlotText13.setStyle("-fx-font: 24 arial;");
        SlotText14.setText("0");
        SlotText14.setStyle("-fx-font: 24 arial;");
        SlotText15.setText("0");
        SlotText15.setStyle("-fx-font: 24 arial;");

        GraphicsContext context = worldView.getGraphicsContext2D();
        context.setFill(Color.YELLOW);
        context.fillRect(
                0,
                0,
                worldView.getWidth(),
                worldView.getHeight());
    }
}
