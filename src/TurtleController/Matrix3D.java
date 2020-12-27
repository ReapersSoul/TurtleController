package TurtleController;

import java.util.ArrayList;

public class Matrix3D<T> {
    ArrayList<ArrayList<ArrayList<T>>> data;

   Matrix3D(){
       data=new ArrayList<>();
   }

   Matrix3D(int x,int y,int z,T baseClass){
       data=new ArrayList<>();
       setBaseClass(baseClass);
       Resize(x,y,z);
   }

    public T getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(T baseClass) {
        this.baseClass = baseClass;
    }

    T baseClass;

    int Mx;
    int My;
    int Mz;

    int getX() {
        return Mx;
    }
    int getY() {
        return My;
    }
    int getZ() {
        return Mz;
    }

    void ResizeX(int x) {
        data.ensureCapacity(x);
        int tmpDsize =data.size();
        if(x< tmpDsize) {
            for (int i = tmpDsize; i > x+1; i--) {
                data.remove(i-1);
            }
        }else{
            for (int i = 0; i < x- tmpDsize; i++) {
                data.add(new ArrayList<>());
            }
        }
        Mx = x;
        ResizeY(My);
    }

    void ResizeY(int y) {
        int tmpDsize =data.size();
        for (int i = 0; i < tmpDsize; i++)
        {
            data.get(i).ensureCapacity(y);
            int tmpDYsize=data.get(i).size();
            if(y< tmpDYsize) {
                for (int j = tmpDYsize; j > y+1; j--) {
                    data.get(i).remove(j-1);
                }
            }else{
                for (int j = 0; j < y- tmpDYsize; j++) {
                    data.get(i).add(new ArrayList<>());
                }
            }
        }
        My = y;
        ResizeZ(Mz);
    }

    void ResizeZ(int z){
        int tmpDsize =data.size();
        for (int i = 0; i < tmpDsize; i++) {
            int tmpDYsize=data.get(i).size();
            for (int j = 0; j < tmpDYsize; j++) {
                data.get(i).get(j).ensureCapacity(z);
                int tmpDZsize=data.get(i).get(j).size();
                if(z< tmpDZsize) {
                    for (int k = tmpDZsize; k > z+1; k--) {
                        data.get(i).get(j).remove(k-1);
                    }
                }else{
                    for (int k = 0; k < z- tmpDZsize; k++) {
                        T tmp;
                        data.get(i).get(j).add(baseClass);
                    }
                }
            }
        }
    }

    void Resize(int x, int y,int z) {
        ResizeX(x);
        ResizeY(y);
        ResizeZ(z);
    }

    //add at point if exists
    void SetAt(int x, int y,int z, T data_point) {
        data.get(x).get(y).set(z, data_point);
    }

    //add at point resize to point if dosent exist
    void RAddAt(int x, int y,int z, T data_point) {
        if (Mx < x+1) {
            ResizeX(x+1);
        }
        if (My < y+1) {
            ResizeY(y+1);
        }
        if(Mz< z+1){
            ResizeZ(z+1);
        }
        data.get(x).get(y).set(z, data_point);
    }

    //get point if exists
    T GetAt(int x, int y,int z) {
        return data.get(x).get(y).get(z);
    }
}
