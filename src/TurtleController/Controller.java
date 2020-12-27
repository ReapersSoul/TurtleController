package TurtleController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    public TabPane tabs;

    @FXML
    public Tab worldViewTab;

    @FXML
    public Tab interfaceTab;

    @FXML
    public Tab scriptsTab;

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
    @FXML
    public VBox ScriptView;

    ArrayList<ImageView> slotsIcons;
    ArrayList<Text> slotsText;

    public static boolean CTRLPRESSED;
    public static boolean SHIFTPRESSED;
    public static boolean SPACEPRESSED;

    public static String path="src/TurtleController/assets";

    public void init(){
        try {
            IconGetter.Init("src/TurtleController/assets");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        slotsIcons = new ArrayList<>();
        slotsText = new ArrayList<>();

        slotsIcons.add(Slot0);
        slotsIcons.add(Slot1);
        slotsIcons.add(Slot2);
        slotsIcons.add(Slot3);
        slotsIcons.add(Slot4);
        slotsIcons.add(Slot5);
        slotsIcons.add(Slot6);
        slotsIcons.add(Slot7);
        slotsIcons.add(Slot8);
        slotsIcons.add(Slot9);
        slotsIcons.add(Slot10);
        slotsIcons.add(Slot11);
        slotsIcons.add(Slot12);
        slotsIcons.add(Slot13);
        slotsIcons.add(Slot14);
        slotsIcons.add(Slot15);

        slotsText.add(SlotText0);
        slotsText.add(SlotText1);
        slotsText.add(SlotText2);
        slotsText.add(SlotText3);
        slotsText.add(SlotText4);
        slotsText.add(SlotText5);
        slotsText.add(SlotText6);
        slotsText.add(SlotText7);
        slotsText.add(SlotText8);
        slotsText.add(SlotText9);
        slotsText.add(SlotText10);
        slotsText.add(SlotText11);
        slotsText.add(SlotText12);
        slotsText.add(SlotText13);
        slotsText.add(SlotText14);
        slotsText.add(SlotText15);

        Main.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                if (!Main.turtles.isEmpty()) {
                    switch (event.getCode()) {
                        case W:
                            Main.turtles.get(Main.selectedTurtle).forward();
                            break;
                        case S:
                            Main.turtles.get(Main.selectedTurtle).back();
                            break;
                        case A:
                            Main.turtles.get(Main.selectedTurtle).turnLeft();
                            break;
                        case D:
                            Main.turtles.get(Main.selectedTurtle).turnRight();
                            break;
                        case SHIFT:
                            SHIFTPRESSED = true;
                            if (!CTRLPRESSED) {
                                Main.turtles.get(Main.selectedTurtle).down();
                            }
                            break;
                        case SPACE:
                            SPACEPRESSED = true;
                            if (!CTRLPRESSED) {
                                Main.turtles.get(Main.selectedTurtle).up();
                            }
                            break;
                        case CONTROL:
                            CTRLPRESSED = true;
                            break;
                        case R:
                            if (CTRLPRESSED) {
                                if (SHIFTPRESSED) {
                                    Main.turtles.get(Main.selectedTurtle).digDown(Turtle.Side.Left);
                                } else if (SPACEPRESSED) {
                                    Main.turtles.get(Main.selectedTurtle).digUp(Turtle.Side.Left);
                                }
                            } else {
                                Main.turtles.get(Main.selectedTurtle).dig(Turtle.Side.Left);
                            }
                            updateInv();
                            break;
                        case L:
                            TurtleRoutine.Dance(Main.turtles.get(Main.selectedTurtle));
                            break;
                    }
                }
            }
        });
        Main.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                switch (event.getCode()) {
                    case SHIFT:
                        SHIFTPRESSED=false;
                        break;
                    case SPACE:
                        SPACEPRESSED=false;
                        break;
                    case CONTROL:
                        CTRLPRESSED = false;
                        break;
                }
            }
        });

        tabs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
                if(newTab.equals (worldViewTab)) {
                    GraphicsContext context = worldView.getGraphicsContext2D();
                    context.setFill(Color.YELLOW);
                    context.fillRect(
                            0,
                            0,
                            worldView.getWidth(),
                            worldView.getHeight());
                }else if(newTab.equals(interfaceTab)){
                    updateInv();
                }else if(newTab.equals(scriptsTab)){
                    UpdateScriptList();
                }
            }
        });
    }
    public void updateInv(){
        if (!Main.turtles.isEmpty()) {
            Main.turtles.get(Main.selectedTurtle).UpdateInv();

            for (int i = 0; i < 16; i++) {
                slotsIcons.get(i).setImage(Main.turtles.get(Main.selectedTurtle).GetInv().GetSlot(i).getItem().getIcon());

                slotsText.get(i).setText(String.valueOf(Main.turtles.get(Main.selectedTurtle).GetInv().GetSlot(i).count));
                slotsText.get(i).setStyle("-fx-font: 24 arial;");
            }
        }
    }

    public void ExecuteFunction(ActionEvent e) {
        if (!Main.turtles.isEmpty()) {
            Text tmp=new Text(Main.turtles.get(Main.selectedTurtle).SendFunction(ConsoleInput.getText()).toJSONString());
            tmp.setStyle("-fx-font: 24 arial;");
            Log.getChildren().addAll(tmp);
            updateInv();
        }
    }

    public void UpdateScriptList(){
        File directoryPath = new File(path+"/LuaScripts");
        FileFilter textFilefilter = new FileFilter(){
            public boolean accept(File file) {
                boolean isFile = file.isFile();
                if (isFile) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        //List of all the text files
        File filesList[] = directoryPath.listFiles(textFilefilter);

        ScriptView.getChildren().clear();
        for (int i = 0; i < filesList.length; i++) {
            HBox holder=new HBox();

            Text filename=new Text();
            filename.setText(filesList[i].getName());
            holder.getChildren().add(filename);
            Button btn=new Button();
            btn.setText("Execute");
            int finalI = i;
            btn.setOnAction(e->{
                try {
                    TurtleRoutine.sendLuaScriptFromFile(Main.turtles.get(Main.selectedTurtle),filesList[finalI]);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            holder.getChildren().add(btn);
            ScriptView.getChildren().add(holder);
        }

    }
}
