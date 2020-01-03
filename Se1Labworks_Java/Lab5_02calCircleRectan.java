public class Circle 
{
    private double radius;
    private double circumference;
    private double area;
    public Circle(double radius)
    {
        this.radius = radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public double computeCircumference()
    {
        circumference = 2* Math.PI * radius;
        return circumference;
    }
    public double computArea()
    {
       area = Math.PI * radius * radius;
       return area;
    }
}
public class Rectangle 
{
    private double height;
    private double width;
    private double area;
    private double perimeter;
    
    //constructors
    public Rectangle()
    {
        height =  1;
        width = 1;
    }
    
    public Rectangle(double numH, double numW)
    {
        height =  numH;
        width = numW;
    }
    //get&set height
    public double getHeight()
    {
        return height;
    }
    public void setHeight(double numOfHeight)
    {
        if(numOfHeight > 0) height = numOfHeight;
        else height  = 1;
    }
     //get&set width
    public double getWidth()
    {
        return width;
    }
    public void setWidth(double numOfWidth)
    {
        if(numOfWidth > 0) width = numOfWidth;
        else width  = 1;
    }  
    
    public double computeArea()
    {
        area = height * width;
        return area;
    }
    
    public double computePerimeter()
    {
        perimeter = (2 * height) + (2 * width);
        return  perimeter;
    }
    
}
import java.util.*;

public class TestShapes 
{
    static Scanner keyboard = new Scanner(System.in);
    static Random r = new Random();
    public static void main(String[] args) 
    {
        System.out.println("Please enter a radius: ");
        double radius = keyboard.nextDouble();
        Circle circle = new Circle(radius);
        
        double height = r.nextDouble()*10;
        double width = r.nextDouble()*10;
        Rectangle rec = new Rectangle(height, width);
        
        double circumference = circle.computeCircumference();
        double perimeter = rec.computePerimeter();
        double areaCircle = circle.computArea();
        double areaRec = rec.computeArea();
        
        System.out.printf("The area of the circle is: %.2f\n", areaCircle);
        System.out.printf("The circumference of the circle is: %.2f\n", circumference);
        System.out.printf("The area of the rectangle is: %.2f\n", areaRec);
        System.out.printf("The perimeter of the rectangle is: %.2f\n", perimeter);
        
        double maxArea = areaCircle;
        String maxOb = "";
        if(areaCircle < areaRec)
        {
            maxArea = areaRec;
        }
        if(maxArea == areaRec)
        {
            maxOb = "Rectangle";
        }
        else 
        {
            maxOb = "Circle";
        }
        System.out.printf(maxOb + " has the biggest area, with the area of %.2f\n", maxArea);
        
        double maxPeri = circumference;
        String maxPeriOfOb = "";
        if(circumference < perimeter)
        {
            maxPeri = perimeter;
        }
        if(maxPeri == perimeter)
        {
            maxPeriOfOb = "rectangle";
        }
        else
        {
            maxPeriOfOb = "circle";
        }
        System.out.printf(maxPeriOfOb + " has the biggest perimeter/circumference, "
                + "with the perimeter/circumference of %.2f", maxPeri);
        System.out.println("\n--------------------------------------------------------");
        
        System.out.println("Please enter a new radius: ");
        double newRadius = keyboard.nextDouble();
        circle.setRadius(newRadius);
        double newAreaCircle = circle.computArea();
        
        double maxNewArea = newAreaCircle;
        String maxNewOb = "";
        if(newAreaCircle < areaRec)
        {
            maxNewArea = areaRec;
        }
        if(maxNewArea == areaRec)
        {
            maxNewOb = "Rectangle";
        }
        else 
        {
            maxNewOb = "new Circle";
        }
        System.out.printf(maxNewOb + " has the bigger area, with the area of %.2f", maxNewArea); 
    }
}
