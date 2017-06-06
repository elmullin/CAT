/* Dynamic Button
   Created by Erick Harris
   CPE 307
   CAT - Corral and Transfer

   Updated: 5/18/17
*/

public class Button {
  private int positionX;
  private int positionY;
  private int recHeight;
  private int recWidth;
  private int[] backgroundColor;
  private int[] highlightColor;
  private boolean rectOver;
  private boolean rectPressed;
  private boolean pauseState;
  
  public Button(int positionX, int positionY, int recHeight, int recWidth) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.recHeight = recHeight;
    this.recWidth = recWidth;
    backgroundColor = new int[3];
    backgroundColor[0] = 77;
    backgroundColor[1] = 77;
    backgroundColor[2] = 77;
    highlightColor = new int[3];
    highlightColor[0] = 51;
    highlightColor[1] = 51;
    highlightColor[2] = 51;
    rectOver = false;
    rectPressed = false;
    pauseState = false;
  }
  
  public Button(Button button) {
    this.positionX = button.getPositionX();
    this.positionY = button.getPositionY();
    this.recHeight = button.getRecHeight();
    this.recWidth = button.getRecWidth();
    this.backgroundColor = new int[3];
    this.backgroundColor[0] = button.getBackgroundColor(0);
    this.backgroundColor[1] = button.getBackgroundColor(1);
    this.backgroundColor[2] = button.getBackgroundColor(2);
    this.highlightColor = new int[3];
    this.highlightColor[0] = button.getHighlightColor(0);
    this.highlightColor[1] = button.getHighlightColor(1);
    this.highlightColor[2] = button.getHighlightColor(2);
    this.rectOver = button.rectOver;
    this.rectPressed = button.rectPressed;
    pauseState = false;
  }
  
  // ----------------------------------------------------------------------------
  
  public int getPositionX() {
    return positionX;   
  }
  
  public int getPositionY() {
    return positionY;   
  }
  
  public int getRecHeight() {
    return recHeight;   
  }
  
  public int getRecWidth() {
    return recWidth;   
  }
  
  public int getBackgroundColor(int i) {
    return backgroundColor[i];
  }
  
  public int getHighlightColor(int i) {
    return highlightColor[i];   
  }
  
  public boolean getRectPressed() {
    return rectPressed;   
  }
  
  public boolean getPauseState() {
    return pauseState;   
  }
  
  // ------------------------------------------------------------------------------
  
  public void display() {  
     if (overRect()) {
        this.rectOver = true;
        fill(color(highlightColor[0], highlightColor[1], highlightColor[2]), 128);
     } else {
        this.rectOver = false;
        fill(color(backgroundColor[0], backgroundColor[1], backgroundColor[2]), 128);
        
     }
     
     stroke(255);
     if (rectPressed) {
        roundrect(positionX + 5, positionY + 5, recWidth - 10, recHeight - 10, 30);
        rectPressed = false;
        pauseState = !pauseState;
      }
      else {
        roundrect(positionX, positionY, recWidth, recHeight, 30);
      }
      
      stroke(255);
      text("Pause", positionX + 10, positionY + 30); 
  }
  
  public void pressMouse() {
    rectPressed = true;   
  }
  
  public boolean overRect() {
    return mouseX >= positionX && mouseX <= positionX + recWidth && mouseY >= positionY && mouseY <= positionY + recHeight;
  }
  
  public void roundrect(int x, int y, int w, int h, int r) {
     noStroke();
     rectMode(CORNER);

     int  ax, ay, hr;

     ax=x+w-1;
     ay=y+h-1;
     hr = r/2;

     rect(x, y, w, h);
     arc(x, y, r, r, radians(180.0), radians(270.0));
     arc(ax, y, r,r, radians(270.0), radians(360.0));
     arc(x, ay, r,r, radians(90.0), radians(180.0));
     arc(ax, ay, r,r, radians(0.0), radians(90.0));
     rect(x, y-hr, w, hr);
     rect(x-hr, y, hr, h);
     rect(x, y+h, w, hr);
     rect(x+w,y,hr, h);
  } 
}