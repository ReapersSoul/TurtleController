package TurtleController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

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
    public SubScene worldView;
    @FXML
    public AnchorPane anchorPane;

    ArrayList<ImageView> slotsIcons;
    ArrayList<Text> slotsText;

    public static boolean CTRLPRESSED;
    public static boolean SHIFTPRESSED;
    public static boolean SPACEPRESSED;

    World world;

    Group group;
    Camera camera;
    Rotate yRotate;
    Rotate xRotate;
    Rotate zRotate;
    Translate pivot;
    Translate camOffset;

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

        world=new World();

        group=new Group();
        worldView =new SubScene(group,anchorPane.getWidth(),anchorPane.getHeight(),true,
                SceneAntialiasing.BALANCED);
        camera =new PerspectiveCamera(true);
        pivot = new Translate(0,0,0);
        camOffset=new Translate(0,0,-20);
        yRotate = new Rotate(0, Rotate.Y_AXIS);
        xRotate = new Rotate(camOffset.getZ(), Rotate.X_AXIS);
        zRotate = new Rotate(0, Rotate.Z_AXIS);
        camera.getTransforms().addAll (
                pivot,
                yRotate,
                xRotate,
                zRotate,
                camOffset
        );
        worldView.setId("wv");
        worldView.setCamera(camera);
        anchorPane.getChildren().add(worldView);
        //worldView.translateXProperty().setValue(anchorPane.getWidth()/2);
        //worldView.translateYProperty().setValue(anchorPane.getHeight()/2);

        Main.scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                //if (!Main.turtles.isEmpty()) {
                    switch (event.getCode()) {
                        case W:
                            RemoveTurtle();
                            Main.turtles.get(Main.selectedTurtle).forward();
                            AddTurtle();
                            BlockCheck();
                            UpdateWorldView();
                            break;
                        case S:
                            RemoveTurtle();
                            Main.turtles.get(Main.selectedTurtle).back();
                            AddTurtle();
                            BlockCheck();
                            UpdateWorldView();
                            break;
                        case A:
                            Main.turtles.get(Main.selectedTurtle).turnLeft();
                            BlockCheck();
                            UpdateWorldView();
                            break;
                        case D:
                            Main.turtles.get(Main.selectedTurtle).turnRight();
                            BlockCheck();
                            UpdateWorldView();
                            break;
                        case SHIFT:
                            SHIFTPRESSED = true;
                            if (!CTRLPRESSED) {
                                RemoveTurtle();
                                Main.turtles.get(Main.selectedTurtle).down();
                                AddTurtle();
                                BlockCheck();
                                UpdateWorldView();
                            }
                            break;
                        case SPACE:
                            SPACEPRESSED = true;
                            if (!CTRLPRESSED) {
                                RemoveTurtle();
                                Main.turtles.get(Main.selectedTurtle).up();
                                AddTurtle();
                                BlockCheck();
                                UpdateWorldView();
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
                            BlockCheck();
                            UpdateWorldView();
                            UpdateInv();
                            break;
                        case L:
                            TurtleRoutine.Dance(Main.turtles.get(Main.selectedTurtle));
                            break;
                        case G:
                            addRotateCamera(0,2f,0);
                            break;
                    }
               // }
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
                    UpdateWorldView();
                }else if(newTab.equals(interfaceTab)){
                    UpdateInv();
                }else if(newTab.equals(scriptsTab)){
                    UpdateScriptList();
                }
            }
        });

//        Block b1 =new Block();
//        b1.SetXYZ(0,0,0);
//        b1.setColor(Color.WHITE);
//        b1.setTex(IconGetter.GetIcon("minecraft:dirt"));
//        Block b2 =new Block();
//        b2.SetXYZ(-1,0,0);
//        b2.setColor(Color.WHITE);
//        b2.setTex(IconGetter.GetIcon("minecraft:dirt"));
//        Block b3 =new Block();
//        b3.SetXYZ(1,0,0);
//        b3.setColor(Color.WHITE);
//        b3.setTex(IconGetter.GetIcon("minecraft:dirt"));
//
//        world.setAddBlock(b1);
//        world.setAddBlock(b2);
//        world.setAddBlock(b3);

        setCamPivot(0,0,0);
        camera.setNearClip(.1);
        camera.setFarClip(1000);
        UpdateWorldView();
    }

    public void UpdateWorldView(){
        group.getChildren().clear();
        for (Box b: world.getWorld()) {
            group.getChildren().add(b);
        }
    }

    public void RemoveTurtle(){
        world.removeBlockAt(Main.turtles.get(Main.selectedTurtle).getX(),Main.turtles.get(Main.selectedTurtle).getY(),Main.turtles.get(Main.selectedTurtle).getZ());
    }

    public void AddTurtle(){
        pivot.setX(Main.turtles.get(Main.selectedTurtle).getX());
        pivot.setY(Main.turtles.get(Main.selectedTurtle).getY());
        pivot.setZ(Main.turtles.get(Main.selectedTurtle).getZ());

        Block b=new Block();
        b.setColor(Color.YELLOW);
        b.SetXYZ(Main.turtles.get(Main.selectedTurtle).getX(),Main.turtles.get(Main.selectedTurtle).getY(),Main.turtles.get(Main.selectedTurtle).getZ());
        world.setAddBlock(b);
    }

    public void BlockCheck(){
        Object obj=Main.turtles.get(Main.selectedTurtle).inspect().get(1);
        if (obj.getClass()==JSONObject.class){
        JSONObject blockDat =(JSONObject)obj;
        Block b=new Block();
        b.setColor(Color.WHITE);
        b.setTex(IconGetter.GetIcon(blockDat.get("name").toString()));
        b.SetXYZ(Main.turtles.get(Main.selectedTurtle).getBlockInFront().getX(),Main.turtles.get(Main.selectedTurtle).getBlockInFront().getY(),Main.turtles.get(Main.selectedTurtle).getBlockInFront().getZ());
        world.setAddBlock(b);
        }
    }

    public void setCamPivot(int x,int y,int z){
        pivot.setX(x);
        pivot.setY(y);
        pivot.setZ(z);
    }

    public void setCamOffset(double x,double y, double z){
        camOffset.setX(x);
        camOffset.setY(y);
        camOffset.setZ(z);
        xRotate.setAngle(camOffset.getZ());
    }

    public void rotateCamera(float x,float y,float z){
        xRotate.angleProperty().setValue(x);
        yRotate.angleProperty().setValue(y);
        zRotate.angleProperty().setValue(z);
    }

    public void addRotateCamera(float x,float y,float z){
        xRotate.angleProperty().setValue(xRotate.angleProperty().get()+x);
        yRotate.angleProperty().setValue(yRotate.angleProperty().get()+y);
        zRotate.angleProperty().setValue(zRotate.angleProperty().get()+z);
    }




    public void UpdateInv(){
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
            UpdateInv();
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
