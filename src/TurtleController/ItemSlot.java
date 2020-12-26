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
        item=new Item("empty");
        count=0;
    }

    public ItemSlot(int vcount,String id){
        item= new Item(id);
        count=vcount;
    }

    public Item getItem() {
        return item;
    }
}
