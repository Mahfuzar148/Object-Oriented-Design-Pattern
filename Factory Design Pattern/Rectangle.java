public class Rectangle implements Shape{
    public void draw(){
        System.out.println("Inside Rectangle : draw() method.");
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.draw();
    }
    
}
