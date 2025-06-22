
public class Square extends Rectangle{

	//Constructors
	public Square(double side) {
		super(side, side);
	}
	
	//Interface methods
	public String name() {
		return "Square";
	}
	
	//Other methods
	public double getSide(){
		return getWidth();
	}

	//Override Object methods, equals will be same as rectangle
	public String toString(){
		return "Square, side = " + getSide();
	}

}