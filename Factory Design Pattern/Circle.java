public class Circle implements Shape{
    public void draw(){
        System.out.println("Inside Circle : draw() method.");
    }
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw();
    }
}