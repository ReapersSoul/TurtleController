package TurtleController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TurtleRoutine {

    public static void sendLuaScript(Turtle turtle,String s){
        turtle.SendScript(s);
    }
    public static void sendLuaScriptFromFile(Turtle turtle,File f) throws IOException {
        turtle.SendScript(Files.readString(f.toPath()));
    }
    public static void sendLuaScriptFromFile(Turtle turtle,String directory) throws IOException {
        turtle.SendScript(Files.readString(Path.of(directory)));
    }

    public static void sendFile(String path){

    }

    public static void Dance(Turtle turtle){
        try {
            sendLuaScriptFromFile(turtle,"src/TurtleController/assets/luaScripts/Dance.lua");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
