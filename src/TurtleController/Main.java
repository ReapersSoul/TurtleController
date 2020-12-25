package TurtleController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import java.util.ArrayList;

public class Main extends Application {

    public static int port = 9000;

    public static ArrayList<Turtle> turtles;
    public static int selectedTurtle;
    public static Server server;
    public static boolean CTRLPRESSED;
    public static boolean SHIFTPRESSED;
    public static boolean SPACEPRESSED;


    @Override
    public void start(Stage primaryStage) throws Exception{
        turtles =new ArrayList<>();
        selectedTurtle=0;

        Parent root = FXMLLoader.load(getClass().getResource("fxml_Files/Main.fxml"));
        primaryStage.setTitle("Turtle Controller");
        Scene scene=new Scene(root, 1280, 720);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                if (!turtles.isEmpty()) {
                    switch (event.getCode()) {
                        case W:
                            turtles.get(selectedTurtle).forward();
                            break;
                        case S:
                            turtles.get(selectedTurtle).back();
                            break;
                        case A:
                            turtles.get(selectedTurtle).turnLeft();
                            break;
                        case D:
                            turtles.get(selectedTurtle).turnRight();
                            break;
                        case SHIFT:
                            SHIFTPRESSED = true;
                            if (!CTRLPRESSED) {
                                turtles.get(selectedTurtle).down();
                            }
                            break;
                        case SPACE:
                            SPACEPRESSED = true;
                            if (!CTRLPRESSED) {
                                turtles.get(selectedTurtle).up();
                            }
                            break;
                        case CONTROL:
                            CTRLPRESSED = true;
                            break;
                        case R:
                            if (CTRLPRESSED) {
                                if (SHIFTPRESSED) {
                                    turtles.get(selectedTurtle).digDown();
                                } else if (SPACEPRESSED) {
                                    turtles.get(selectedTurtle).digUp();
                                }
                            } else {
                                turtles.get(selectedTurtle).dig();
                            }
                            break;
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
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
        primaryStage.setScene(scene);
        primaryStage.show();
        server = new Server(port);
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(Turtle.class);
            }
        };
        server.setHandler(wsHandler);
        server.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}