package TurtleController;

import java.util.ArrayList;

public class Inventory {
    int size;
    ArrayList<ItemSlot> items;

    public Inventory(){
        size=0;
    }

    public Inventory(int slots){
        size=slots;
        items = new ArrayList<>();
        for (int i=0;i<size;i++){
            items.add(new ItemSlot());
        }
    }

    public void SetSlot(int slot, int amount, String id){
        items.set(slot,new ItemSlot(amount,id));
    }
    public void SetSlot(int slot, ItemSlot itemSlot){
        items.set(slot,itemSlot);
    }

    public ItemSlot GetSlot(int slot){
        return items.get(slot);
    }

}
