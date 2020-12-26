package TurtleController;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IconGetter {

    public static Map<String,Image> icons;

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        IconGetter.path = path;
    }

    public static String path;
    static Random random;

    public static void Init(String pth) throws FileNotFoundException {
        icons=new HashMap();
        random = new Random();
        path =pth;
        icons.put("minecraft:arrow", new Image(new FileInputStream(path+"/items/arrow.png")));
        icons.put("minecraft:dirt", new Image(new FileInputStream(path+"/items/dirt.png")));
        icons.put("minecraft:grass_block", new Image(new FileInputStream(path+"/items/grass_block_side.png")));

        icons.put("empty",new Image(new FileInputStream(path+"/null/null.png")));
    }

    public static String getRandColor(){
        File directoryPath = new File(path+"/colors");
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
        return path+"/colors/"+filesList[random.nextInt(filesList.length)].getName();
    }

    public static Image GetIcon(String id){
        if(icons.containsKey(id)) {
            return icons.get(id);
        }else{
            Image tmp= null;
            try {
                tmp = new Image(new FileInputStream(getRandColor()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(icons.containsValue(tmp)){
                try {
                    tmp=new Image(new FileInputStream(getRandColor()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return tmp;
        }
    }

}
