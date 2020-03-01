package module2.lesson12;

public class Polygon {
    float [] x, y;

    public Polygon(float[] x, float[] y) {
        this.x = x;
        this.y = y;
    }

    public Polygon(Polygon p){
        float [] px = new float[p.x.length];
        if (p.x.length >= 0)
            System.arraycopy(p.x, 0, px, 0, p.x.length);
        float [] py = new float[p.y.length];
        if (p.y.length >= 0)
            System.arraycopy(p.y, 0, py, 0, p.y.length);
        x = px;
        y = py;
    }
}
