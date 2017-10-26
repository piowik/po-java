package lab2.zad345;

public class Punkt3D extends Punkt2D {
    private int z;

    public Punkt3D(int _x, int _y, int _z){
        super(_x,_y);
        z = _z;
    }

    public double distance(Punkt3D point) {
        return Math.sqrt(Math.pow(point.getX()-this.getX(),2)+Math.pow(point.getY()-this.getY(),2)+Math.pow(point.getZ()-this.getZ(),2));
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

}
