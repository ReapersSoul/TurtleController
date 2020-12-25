package TurtleController;

public class ItemSlot {
    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    Item item;
    int count;

    public ItemSlot(){
        item=new Item();
        count=0;
    }

    public ItemSlot(int vcount,Item vitem){
        item=vitem;
        count=vcount;
    }

    public Item getItem() {
        return item;
    }
}
