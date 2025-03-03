package org.example.secondsemester.sixthlab;

public class Group {
    private int id;
    private int[] data;

    public Group(){
        id = 0;
        data = null;
    }

    public Group (int id, int ... data){
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getLength(){
        return data.length;
    }
}
