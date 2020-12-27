package TurtleController;

import java.util.ArrayList;

public class Matrix<T> {
   ArrayList<ArrayList<T>> data;

   Matrix(){
       data=new ArrayList<>();
   }

    int Mx;
    int My;

    int getX() {
        return Mx;
    }
    int getY() {
        return My;
    }

    void pushXVector(ArrayList<T> v) {
        if (v.size() == Mx) {
            for (int i = 0; i < data.size(); i++)
            {
                data.get(i).ensureCapacity(data.size() + 1);
                data.get(i).set(data.size() - 1, v.get(i));
            }
        }
    }
    void pushYVector(ArrayList<T> v) {
        if (v.size() == My) {
            data.add(v);
        }
    }

    void ResizeX(int x) {
        data.ensureCapacity(x);
        ResizeY(My);
        Mx = x;
    }

    void ResizeY(int y) {
        for (int i = 0; i < data.size(); i++)
        {
            data.get(i).ensureCapacity(y);
        }
        My = y;
    }

    void Resize(int x, int y) {
        ResizeX(x);
        ResizeY(y);
    }

    //add at point if exists
    void SetAt(int x, int y, T data_point) {
        data.get(x).set(y, data_point);
    }

    //add at point resize to point if dosent exist
    void RAddAt(int x, int y, T data_point) {
        if (Mx < x+1) {
            ResizeX(x+1);
        }
        if (My < y+1) {
            ResizeY(y+1);
        }
        data.get(x).set(y, data_point);
    }

    //get point if exists
    T GetAt(int x, int y) {
        return data.get(x).get(y);
    }

    ArrayList<T> GetYVector(int index) {
        return data.get(index);
    }

    ArrayList<T> GetXVector(int index) {
        ArrayList<T> ret = new ArrayList<>();
        for (int i = 0; i < Mx; i++)
        {
            ret.add(data.get(i).get(index));
        }
        return ret;
    }
}
