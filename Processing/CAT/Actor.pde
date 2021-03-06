public class Actor extends PhysObject{
	
	// -- variables --
	
	// world actor belongs to
	private World world;
	
	// sprite of actor
	protected PImage sprite;

	// deletion marker
	protected boolean deletionMark; 
	
	// -- constructors --

	// make actor in position with sprite
	public Actor(PImage sprite, float posX, float posY, float radius, boolean moveable) {
		super(posX, posY, 0, 0, radius, moveable);
      this.sprite = sprite;
		deletionMark = false;
	}

	public Actor(PImage sprite, float posX, float posY) {
		this(sprite, posX, posY, 0, false);
		deletionMark = false;
	}
	
	// -- methods --
	
	// display actor on screen
	public boolean display() {
		if (sprite != null) {
			image(sprite, position.x, position.y);
		}
		resetMatrix();
		return deletionMark;
	}
	
	// change sprite of actor
	void setImage(PImage sprite) {
		this.sprite = sprite;
	}
	
	// change sprite of actor to given size
	void scaleImage(int x, int y) {
		this.sprite.resize(x, y);
	}
	
	// scale sprite of actor by given factor
	void scaleImage(double factor) {
		scaleImage((int) Math.round(factor * width), (int) Math.round(factor * height));
	}
	
	// returns world of this actors as a World
	public World getWorld() {
		return this.world;
	}
	
	// sets the world this actor is in
	public void setWorld(World world) {
		this.world = world;
	}
	
	// removes actor from world
	public void remove() {
		world = null;
		getWorld().removeActor(this);
	}
	
	// returns x-value of actor
	float getX() {
		return position.x;
	}
	
	// returns y-value of actor
	float getY() {
		return position.y;
	}
	
	// returns width of actor
	int getWidth() {
		return width;
	}
	
	// returns height of actor
	int getHeight() {
		return height;
	}
	
	// returns sprite of actor
	public PImage getImage() {
		return sprite; 
	}

	public void markDelete() {
		deletionMark = true;
	}
}