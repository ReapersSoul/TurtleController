package TurtleController;

import java.util.ArrayList;

public class Inventory {
    int x,y;
    ArrayList<ArrayList<ItemSlot>> items;

    public Inventory(){
        x=0;
        y=0;
    }

    public Inventory(int vx,int vy){
        x=vx;
        y=vy;
        items = new ArrayList<>();
        items.ensureCapacity(vx);
        for (ArrayList<ItemSlot> i:items) {
            i=new ArrayList<>();
            i.ensureCapacity(y);
            for (ItemSlot j:i) {
                j=new ItemSlot();
            }
        }
    }

    public void SetSlot(int x, int y, int amount, Item item){
        items.get(x).set(y,new ItemSlot(amount,item));
    }
    public void SetSlot(int x, int y, ItemSlot itemSlot){
        items.get(x).set(y,itemSlot);
    }

    public ItemSlot GetSlot(int x, int y){
        return items.get(x).get(y);
    }

}
