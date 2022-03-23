package lab5.entity;

public class Coordinates {
    private int x;
    private int y; //Максимальное значение поля: 884

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public String toString(){
        return getX() +","+getY();
    }
}
