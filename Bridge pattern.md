
---

# ✅ FULL CODE (Circle + Rectangle + Red + Green + Blue)

```java
package com.tutorialspoint;

public class BridgePatternDemo {
   public static void main(String[] args) {

      // Circle with different colors
      Shape redCircle = new Circle(100, 100, 10, new RedCircle());
      Shape greenCircle = new Circle(150, 150, 20, new GreenCircle());
      Shape blueCircle = new Circle(200, 200, 30, new BlueCircle());

      // Rectangle with different colors
      Shape redRectangle = new Rectangle(10, 20, 40, 30, new RedRectangle());
      Shape blueRectangle = new Rectangle(50, 60, 80, 40, new BlueRectangle());

      redCircle.draw();
      greenCircle.draw();
      blueCircle.draw();

      redRectangle.draw();
      blueRectangle.draw();
   }
}

// ================= Implementer Interface =================

interface DrawAPI {
   void draw(int a, int b, int c, int d);
}

// ================= Color Implementations =================

class RedCircle implements DrawAPI {
   public void draw(int radius, int x, int y, int unused) {
      System.out.println("Drawing Circle [Color: Red, Radius: " + radius +
              ", X: " + x + ", Y: " + y + "]");
   }
}

class GreenCircle implements DrawAPI {
   public void draw(int radius, int x, int y, int unused) {
      System.out.println("Drawing Circle [Color: Green, Radius: " + radius +
              ", X: " + x + ", Y: " + y + "]");
   }
}

class BlueCircle implements DrawAPI {
   public void draw(int radius, int x, int y, int unused) {
      System.out.println("Drawing Circle [Color: Blue, Radius: " + radius +
              ", X: " + x + ", Y: " + y + "]");
   }
}

class RedRectangle implements DrawAPI {
   public void draw(int width, int height, int x, int y) {
      System.out.println("Drawing Rectangle [Color: Red, Width: " + width +
              ", Height: " + height + ", X: " + x + ", Y: " + y + "]");
   }
}

class BlueRectangle implements DrawAPI {
   public void draw(int width, int height, int x, int y) {
      System.out.println("Drawing Rectangle [Color: Blue, Width: " + width +
              ", Height: " + height + ", X: " + x + ", Y: " + y + "]");
   }
}

// ================= Abstraction =================

abstract class Shape {
   protected DrawAPI drawAPI;

   protected Shape(DrawAPI drawAPI) {
      this.drawAPI = drawAPI;
   }

   public abstract void draw();
}

// ================= Refined Abstractions =================

class Circle extends Shape {
   private int x, y, radius;

   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;
      this.y = y;
      this.radius = radius;
   }

   public void draw() {
      drawAPI.draw(radius, x, y, 0);
   }
}

class Rectangle extends Shape {
   private int x, y, width, height;

   public Rectangle(int x, int y, int width, int height, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }

   public void draw() {
      drawAPI.draw(width, height, x, y);
   }
}
```

---

# 🖨️ OUTPUT (Demo Result)

```
Drawing Circle [Color: Red, Radius: 10, X: 100, Y: 100]
Drawing Circle [Color: Green, Radius: 20, X: 150, Y: 150]
Drawing Circle [Color: Blue, Radius: 30, X: 200, Y: 200]
Drawing Rectangle [Color: Red, Width: 40, Height: 30, X: 10, Y: 20]
Drawing Rectangle [Color: Blue, Width: 80, Height: 40, X: 50, Y: 60]
```

---

# 🔥 এখন Bridge Pattern একদম পরিষ্কার

## ✔️ কী কী আলাদা হলো

* **Shape hierarchy** → Circle, Rectangle
* **Color / Drawing hierarchy** → Red, Green, Blue

## ✔️ কীভাবে Bridge করা হলো

```java
protected DrawAPI drawAPI;
```

👉 Shape জানে **কি আঁকবে**
👉 DrawAPI জানে **কিভাবে আঁকবে**
👉 দুটো আলাদা, loosely coupled

---

# 🧠 Exam One-Line Killer Answer

> Bridge Pattern is used here to decouple shape abstraction from drawing implementation so that new shapes and new colors can be added independently without modifying existing code.

---


