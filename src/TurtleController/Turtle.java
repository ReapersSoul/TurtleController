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
        for(int i=0;i<16;i++) {
            Object tmp =getItemDetail(i+1,true);
            if(tmp.getClass()==JSONArray.class) {
                if (((JSONArray)tmp).get(0).getClass() == JSONObject.class) {
                    JSONObject obj = (JSONObject) ((JSONArray)tmp).get(0);
                    inv.GetSlot(i).count=Math.toIntExact((long)obj.get("count"));
                    inv.GetSlot(i).item=new Item((String) obj.get("name"));
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

    JSONArray dig(Side side) {
        JSONArray ret =SendFunction("turtle.dig("+side.toString()+")");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray digUp(Side side) {
        JSONArray ret =SendFunction("turtle.digUp("+side.toString()+")");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray digDown(Side side) {
        JSONArray ret =SendFunction("turtle.digDown("+side.toString()+")");
        if (ret!=null) {
            UpdateInv();
            return ret;
        } else {
            return null;
        }
    }

    JSONArray place(String text) {
        JSONArray ret;
        if (text == null) {
            ret = SendFunction("place()");
        } else {
            ret = SendFunction("place(" + text + ")");
        }
        if (ret != null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray placeUp(String text) {
        JSONArray ret;
        if (text == null) {
            ret = SendFunction("placeUp()");
        } else {
            ret = SendFunction("placeUp(" + text + ")");
        }
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray placeDown(String text) {
        JSONArray ret;
        if (text == null) {
            ret = SendFunction("placeDown()");
        } else {
            ret = SendFunction("placeDown(" + text + ")");
        }
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray drop(int count) {
        JSONArray ret =SendFunction("drop("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray dropUp(int count) {
        JSONArray ret =SendFunction("dropUp("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray dropDown(int count) {
        JSONArray ret =SendFunction("dropDown("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray select(int slot) {
        JSONArray ret =SendFunction("select("+String.valueOf(slot)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getItemCount(int slot) {
        JSONArray ret =SendFunction("getItemCount("+String.valueOf(slot)+")");
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
        JSONArray ret =SendFunction("detect()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray detectUp() {
        JSONArray ret =SendFunction("detectUp()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray detectDown() {
        JSONArray ret =SendFunction("detectDown()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compare() {
        JSONArray ret =SendFunction("compare()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareUp() {
        JSONArray ret =SendFunction("compareUp()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareDown() {
        JSONArray ret =SendFunction("compareDown()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attack(Side side) {
        JSONArray ret =SendFunction("attack("+side.toString()+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attackUp(Side side) {
        JSONArray ret =SendFunction("attackUp("+side.toString()+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray attackDown(Side side) {
        JSONArray ret =SendFunction("attackDown("+side.toString()+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suck(int count) {
        JSONArray ret =SendFunction("suck("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suckUp(int count) {
        JSONArray ret =SendFunction("suckUp("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray suckDown(int count) {
        JSONArray ret =SendFunction("suckDown("+String.valueOf(count)+")");
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
        JSONArray ret =SendFunction("refuel("+String.valueOf(count)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray compareTo(int slot) {
        JSONArray ret =SendFunction("compareTo("+String.valueOf(slot)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray transferTo(int slot, int count) {
        JSONArray ret =SendFunction("transferTo("+String.valueOf(slot)+","+String.valueOf(count)+")");
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
        JSONArray ret =SendFunction("getFuelLimit()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray equipLeft() {
        JSONArray ret =SendFunction("equipLeft()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray equipRight() {
        JSONArray ret =SendFunction("equipRight()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspect() {
        JSONArray ret =SendFunction("inspect()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspectUp() {
        JSONArray ret =SendFunction("inspectUp()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray inspectDown() {
        JSONArray ret =SendFunction("inspectDown()");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray getItemDetail(int slot, boolean detailed) {
        JSONArray ret =SendFunction("turtle.getItemDetail("+String.valueOf(slot)+","+String.valueOf(detailed)+")");
        if (ret!=null) {
            return ret;
        } else {
            return null;
        }
    }

    JSONArray craft(int limit) {
        JSONArray ret =SendFunction("craft("+String.valueOf(limit)+")");
        if (ret!=null) {

            return ret;
        } else {
            return null;
        }
    }

    JSONArray SendFunction(String funct){
        try {
            if(!funct.isEmpty()) {
                session.getRemote().sendString("function");
                session.getRemote().sendString(funct);

                if (WaitTimeout(1000 * 3)) {
                    JSONArray tmp =new JSONArray();
                    tmp.add("Timed Out!");
                    return tmp;
                } else {
                    return messages.Pop();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    JSONArray SendScript(String script){
        try {
            if(!script.isEmpty()) {
                session.getRemote().sendString("script");
                session.getRemote().sendString(script);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    boolean TimeoutOccured=false;

    void WaitInf(){
        synchronized (this) {
            while (messages.Size() < 1) {
                try {
                    this.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    boolean WaitTimeout(int miliseconds){
        synchronized (this) {
            int loops=0;
            while (messages.Size() < 1 && loops<=miliseconds) {
                try {
                    this.wait(1);
                    loops++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (loops>=miliseconds){
                TimeoutOccured=true;
                return true;
            }else{
                return false;
            }
        }
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
        System.out.println("\n");
        JSONParser parser =new JSONParser();
        try {
            if (!TimeoutOccured) {
                messages.Push((JSONArray) parser.parse(message));
            }else{
                TimeoutOccured=false;
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        //SendFunction("Server: "+message);
    }
}
