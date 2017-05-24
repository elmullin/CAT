/* Dynamic Button
   Created by Erick Harris
   CPE 307
   CAT - Corral and Transfer

   Updated: 5/18/17
*/

public class Button {
  public int positionX;
  public int positionY;
  public int recHeight;
  public int recWidth;
  public int[] backgroundColor;
  public int[] highlightColor;
  public boolean rectOver;
  public boolean rectPressed;
  public String imageName;
  public String imageSmallName;
  public PImage image;
  public PImage imageSmall;
  
  public Button() {
    this.positionX = 640/2-100;
    this.positionY = 360/2-100/2;
    this.recHeight = 100;
    this.recWidth = 200;
    this.backgroundColor = new int[3];
    this.backgroundColor[0] = 77;
    this.backgroundColor[1] = 77;
    this.backgroundColor[2] = 77;
    this.highlightColor = new int[3];
    this.highlightColor[0] = 51;
    this.highlightColor[1] = 51;
    this.highlightColor[2] = 51;
    this.rectOver = false;
    this.rectPressed = false;
    this.imageName = "thumbs-up.png";
    this.imageSmallName = "thumbs-up-small.png";
    this.image = loadImage(imageName);
    this.imageSmall = loadImage(imageSmallName);
  }
  
  public Button(Button button) {
    this.positionX = button.positionX;
    this.positionY = button.positionY;
    this.recHeight = button.recHeight;
    this.recWidth = button.recWidth;
    this.backgroundColor = new int[3];
    this.backgroundColor[0] = button.backgroundColor[0];
    this.backgroundColor[1] = button.backgroundColor[1];
    this.backgroundColor[2] = button.backgroundColor[2];
    this.highlightColor = new int[3];
    this.highlightColor[0] = button.highlightColor[0];
    this.highlightColor[1] = button.highighlightColorhColor[1];
    this.highlightColor[2] = button.highlightColor[2];
    this.rectOver = button.rectOver;
    this.rectPressed = button.rectPressed;
    this.imageName = button.imageName;
    this.imageSmallName = button.imageSmallName;
    this.image = loadImage(button.image);
    this.imageSmall = loadImage(button.imageSmall);
  }
  
  public void drawButton() {  
     if (overRect(this.positionX, this.positionY, this.recWidth, this.recHeight)) {
        this.rectOver = true;
        fill(color(this.highlightColor[0], this.highlightColor[1], this.highlightColor[2]));
     } else {
        this.rectOver = false;
        fill(color(this.backgroundColor[0], this.backgroundColor[1], this.backgroundColor[2]));
     }
     
     stroke(255);
     if (this.rectPressed) {
        print("Pressed!\n");
        roundrect(this.positionX + 5, this.positionY + 5, this.recWidth - 10, this.recHeight - 10, 30);
        imageMode(CENTER);
        image(this.imageSmall, this.positionX + this.recHeight, this.positionY + (this.recHeight / 2));
        this.rectPressed = false;
      }
      else {
        roundrect(this.positionX, this.positionY, this.recWidth, this.recHeight, 30);
        imageMode(CENTER);
        image(this.image, this.positionX + this.recHeight, this.positionY + (this.recHeight / 2));
      }
  }
  
  public boolean overRect(int x, int y, int width, int height) {
    return mouseX >= x && mouseX <= x+width && mouseY >= y && mouseY <= y+height) {
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