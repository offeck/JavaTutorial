// this class represents a point in the R^2 space using two coordinates, x and y
public class Point {
	
    // Fields
    private double x;
    private double y;

    // Constructors
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Point(){
        this(0,0);
    }

    // Class Methods
    
     public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
    
    public double distance(Point other){
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    
    // returns the distance from the origin
    public double distance(){
        return this.distance(new Point());
    }
    
    public void move(double deltaX, double deltaY){
        this.x = this.x + deltaX;
        this.y = this.y + deltaY;
    }
    
	//Override Object methods
    
	//toString
    public String toString(){
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    //equals
    public boolean equals(Object other){
        boolean isEqual = false;
        if (other instanceof Point)
            isEqual = (this.getX() == ((Point)other).getX()) && (this.getY() == ((Point)other).getY());
        return isEqual;
    }
    
    public static void main(String[] aregs) {
    	Point p1 = new Point(2, 3.5);

    	System.out.println(p1.toString()); // (2.0, 3.5)

    	System.out.println(p1.getX()); // 2.0
    	
    	System.out.println(p1.distance()); // 4.031128874149275
    	
    	p1.move(1, -3);
    	System.out.println(p1.toString()); // (3.0, 0.5)
    	
    	Point p2 = new Point();

    	System.out.println(p1.distance(p2)); // 7.0178344238090995
    	
    }
}