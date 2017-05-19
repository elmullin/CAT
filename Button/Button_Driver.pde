/* Dynamic Button
   Created by Erick Harris
   CPE 307
   CAT - Corral and Transfer

   Updated: 5/18/17
*/

Button button;

void setup() {
  size(640, 360);
  background(color(255));
  button = new Button();
  ellipseMode(CENTER);
}

void draw() {
  button.drawButton();
}


void mousePressed() {
  if (button.rectOver) {
    button.rectPressed = true;
    print("Thumbs Up!\n");
  }
}