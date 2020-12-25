package TurtleController;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.Socket;

@WebSocket
public class Turtle {
    enum Direction{
        North,
        East,
        South,
        West
    }

    enum Side{
        Top,
        Bottom,
        Left,
        Right,
        Front,
        Back
    }

    String label;
    int x,y,z;
    Direction dir;
    Inventory inv;
    Socket socket;
    Stack<JSONArray> messages;

    public Turtle(){
        inv = new Inventory(16);
        x=0;
        y=0;
        z=0;
        dir=Direction.North;
        messages=new Stack<>();
    }

    public Inventory GetInv(){
        return inv;
    }

    void UpdateInv(){
        for(int i=0;i<17;i++) {
            Object tmp =getItemDetail(i+1,true);
            if(tmp.getClass()==JSONArray.class) {
                if (((JSONArray)tmp).get(0).getClass() == JSONObject.class) {
                    JSONObject obj = (JSONObject) ((JSONArray)tmp).get(0);
                    System.out.println(obj);
                    //inv.GetSlot(i).item.ID= (String) tmp.get("name");
                }
            }

        }
    }

    JSONArray forward() {
        JSONArray ret =SendFunction("turtle.forward()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray back() {
        JSONArray ret =SendFunction("turtle.back()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray up() {
        JSONArray ret =SendFunction("turtle.up()");
        if (ret!=null) {
            z++;
            return ret;
        } else {
            return null;
        }
    }

    JSONArray down() {
        JSONArray ret =SendFunction("turtle.down()");
        if (ret!=null) {
            z--;
            return ret;
        } else {
            return null;
        }
    }

    JSONArray turnLeft() {
        JSONArray ret =SendFunction("turtle.turnLeft()");
        if (ret!=null) {
            switch (dir){
                case North:
                    dir=Direction.West;
                    break;
                case East:
                    dir=Direction.North;
                    break;
                case South:
                    dir=Direction.East;
                    break;
                case West:
                    dir=Direction.South;
                    break;
            }
            return ret;
        } else {
            return null;
        }
    }

    JSONArray turnRight() {
        JSONArray ret =SendFunction("turtle.turnRight()");
        if (ret!=null) {
            switch (dir){
                case North:
                    dir=Direction.East;
                    break;
                case East:
                    dir=Direction.South;
                    break;
                case South:
                    dir=Direction.West;
                    break;
                case West:
                    dir=Direction.North;
                    break;
            }
            return ret;
        } else {
            return null;
        }
    }

    JSONArray dig() {
        JSONArray ret =SendFunction("turtle.dig()");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray digUp() {
        JSONArray ret =SendFunction("turtle.digUp()");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray digDown() {
        JSONArray ret =SendFunction("turtle.digDown()");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray place(String text) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray placeUp(String text) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray placeDown(String text) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray drop(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray dropUp(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray dropDown(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray select(int slot) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getItemCount(int slot) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getItemSpace(int slot) {
        JSONArray ret =SendFunction("getItemSpace("+String.valueOf(slot)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray detect() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray detectUp() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray detectDown() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compare() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareUp() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareDown() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attack(Side side) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attackUp(Side side) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attackDown(Side side) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suck(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suckUp(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suckDown(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getFuelLevel() {
        return SendFunction("getFuelLevel()");
    }

    JSONArray refuel(int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareTo(int slot) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray transferTo(int slot, int count) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getSelectedSlot() {
        JSONArray ret =SendFunction("turtle.getSelectedSlot()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getFuelLimit() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray equipLeft() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray equipRight() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspect() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspectUp() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspectDown() {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getItemDetail(int slot, boolean detailed) {
        JSONArray ret =SendFunction("turtle.getItemDetail("+String.valueOf(slot)+","+String.valueOf(detailed)+")");
        if (ret!=null) {
            System.out.println(ret.toJSONString());
            return ret;
        } else {
            return null;
        }
    }

    JSONArray craft(int limit) {
        JSONArray ret =SendFunction("");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray SendFunction(String funct){
        try {
            if(!funct.isEmpty()) {
                session.getRemote().sendString(funct);

                synchronized (this) {
                    while (messages.Size() < 1) {
                        try {
                            this.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return messages.Pop();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    Session session;
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("Close: statusCode=" + statusCode + ", reason=" + reason);
        Main.turtles.remove(this);
    }

    @OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("Connect: " + session.getRemoteAddress().getAddress());
            Main.turtles.add(this);
            this.session=session;
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        System.out.println("Message: " + message);
        JSONParser parser =new JSONParser();
        try {
            messages.Push((JSONArray) parser.parse(message));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //SendFunction("Server: "+message);
    }
}
