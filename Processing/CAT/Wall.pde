public class Wall{
    public final float left;
    public final float top;
    public final float right;
    public final float bottom;
    public final PVector center;
    
    PShape rect;
    
    public Wall(float x1, float y1, float x2, float y2){
        if(x1 < x2){
            left = x1;
            right = x2;
        }
        else{
            left = x2;
            right = x1;
        }
        if(y1 < y2){
            top = y1;
            bottom = y2;
        }
        else {
            top = y2;
            bottom = y1;
        }
        rect = createShape(RECT, left, top, right, bottom);
        center = new PVector((left + right) / 2, (top + bottom) / 2);
    }
    
    public void display(){
        shape(rect);
        resetMatrix();
    }
}