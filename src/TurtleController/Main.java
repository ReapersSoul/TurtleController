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

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {

    public static int port = 9000;

    public static ArrayList<Turtle> turtles;
    public static int selectedTurtle;
    public static Server server;
    public static Controller controller;
    public static Scene scene;


    @Override
    public void start(Stage primaryStage) throws Exception{
        turtles =new ArrayList<>();
        selectedTurtle=0;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_Files/Main.fxml"));
        controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle("Turtle Controller");
        scene=new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        controller.init();
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
