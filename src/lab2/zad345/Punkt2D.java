package lab2.zad345;

public class Punkt2D {
    private int x,y;
    public Punkt2D(int _x, int _y){
        x = _x;
        y = _y;
    }

    public double distance(Punkt2D point) {
        return Math.sqrt(Math.pow(point.getX()-x,2)+Math.pow(point.getY()-y,2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



}
