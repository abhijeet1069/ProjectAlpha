package vector;

public class Vector {
    public float x;
    public float y;
    public float z;

    public Vector(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void add(Vector b){
        this.x += b.x;
        this.y += b.y;
        this.z += b.z;
    }

    public void mult(int val){
        this.x *= val;
        this.y *= val;
        this.z *= val;
    }

    public Vector copy(){
        return new Vector(this.x,this.y,this.z);
    }
}
