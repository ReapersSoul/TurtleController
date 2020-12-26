package TurtleController;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Item {
    String ID;
    Image icon;
    boolean IsBlock;

    Item(String id){
            ID = id;
            icon = IconGetter.GetIcon(id);
            IsBlock = false;
    }

    public Image getIcon() {
            return icon;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
        this.icon=IconGetter.GetIcon(ID);
    }

    public boolean isBlock() {
        return IsBlock;
    }

    public void setBlock(boolean block) {
        IsBlock = block;
    }

    public Block ToBlock(){

        return new Block();
    }
}
