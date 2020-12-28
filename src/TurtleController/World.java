package TurtleController;


import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.ArrayList;

public class World {
    ArrayList<Block> WorldData;

    World() {
        WorldData = new ArrayList<>();
    }

    public Integer BlockIndex(int x,int y,int z){
            for (int i = 0; i < WorldData.size(); i++) {
                if (WorldData.get(i).getX() == x && WorldData.get(i).getY() == y && WorldData.get(i).getZ() == z) {
                    return i;
                }
            }
        return null;
    }

    public void setAddBlock(Block b){
        Integer blockPos = BlockIndex(b.x,b.y,b.z);
        if (blockPos==null) {
            WorldData.add(b);
        }else{
            WorldData.remove(blockPos);
            WorldData.add(b);
        }
    }
    public void removeBlockAt(int x,int y,int z){

    }
    public Block getBlockAt(int x,int y,int z){
        Integer blockPos = BlockIndex(x,y,z);
        return WorldData.get(blockPos);
    }

    public ArrayList<Box> getWorld(){
        ArrayList<Box> ret=new ArrayList<>();

        for (Block b: WorldData) {
            Box box=new Box();
            box.setDepth(1);
            box.setHeight(1);
            box.setWidth(1);

            box.setTranslateX(b.x);
            box.setTranslateY(b.y);
            box.setTranslateZ(b.z);

            PhongMaterial mat =new PhongMaterial(b.color);
            mat.setDiffuseMap(b.getTex());

            box.setMaterial(mat);

            ret.add(box);
        }

        return  ret;
    }
}
