package TurtleController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TurtleRoutine {

    public static void sendLuaScript(Turtle turtle,String s){
        turtle.SendFunction(s);
    }
    public static void sendLuaScriptFromFile(Turtle turtle,File f) throws IOException {
        turtle.SendFunction(Files.readString(f.toPath()));
    }
    public static void sendLuaScriptFromFile(Turtle turtle,String directory) throws IOException {
        turtle.SendFunction(Files.readString(Path.of(directory)));
    }

    public static void Dance(Turtle turtle,int loop){
        for (int i = 0; i < loop; i++) {
            turtle.turnRight();
            turtle.forward();
            turtle.back();
            turtle.turnLeft();
            turtle.turnLeft();
            turtle.forward();
            turtle.back();
            turtle.turnRight();
        }
    }
}
