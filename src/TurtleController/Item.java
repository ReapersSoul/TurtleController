package TurtleController;

import javafx.scene.paint.Color;

public class Item {
    String ID;
    Color color;
    boolean IsBlock;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
