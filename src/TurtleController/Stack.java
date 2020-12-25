package TurtleController;


import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> list;

    Stack(){
        list=new ArrayList<>();
    }

    void Push(T item){
        list.add(0,item);
    }

    T Pull(){
        T ret =list.get(0);
        list.remove(0);
        return ret;
    }

    T Pop(){
        T ret =list.get(list.size()-1);
        list.remove(0);
        return ret;
    }

    public int Size() {
        return list.size();
    }
}
