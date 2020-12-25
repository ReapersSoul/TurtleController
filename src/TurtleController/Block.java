package TurtleController;

import javafx.scene.paint.Color;

public class Block {
    int x,y,z;
    String ID;
    Color color;

    public void SetXYZ(int vx,int vy,int vz){
        x=vx;
        y=vy;
        z=vz;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

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
}
