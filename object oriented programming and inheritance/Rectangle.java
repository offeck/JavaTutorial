public class Rectangle implements Shape{

	//fields
	private double height;
	private double width;
	
	//Constructors
	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	//Interface methods
	public String name() {
		return "Rectangle";
	}
	public double area() {
		return getHeight() * getWidth();
	}
	public double perimeter() {
		return 2 * (getHeight() + getWidth());
	}

	//Other methods
	public double getHeight() {
		return this.height;
	}
	public double getWidth() {
		return this.width;
	}

	//Override Object methods
	public String toString(){
		return name() + ", height = " + height + ", width = " + width;
	}
	@Override
	public boolean equals(Object other) {
		boolean res = false;
		if(other instanceof Rectangle){
			Rectangle otherRec = (Rectangle) other;
			res = this.getHeight() == otherRec.getHeight()
					&& this.getWidth() == otherRec.getWidth();
		}
		return res;
	}


}