
---

# ✅ Bridge Design Pattern

## 🔹 What is Bridge Pattern?

Bridge pattern is used to decouple abstraction from its implementation so that both can vary independently.
Bridge Pattern ব্যবহার করা হয় abstraction এবং implementation-কে আলাদা করার জন্য, যাতে দুটোই স্বাধীনভাবে পরিবর্তন করা যায়।

It belongs to the Structural Design Pattern category.
এটি Structural Design Pattern-এর অন্তর্ভুক্ত।

Bridge uses composition instead of inheritance.
Bridge inheritance-এর বদলে composition ব্যবহার করে।

---

## 🔹 Why Bridge Pattern is Needed?

Without bridge, changes in implementation affect abstraction.
Bridge না থাকলে implementation পরিবর্তনে abstraction-এ প্রভাব পড়ে।

With bridge, abstraction and implementation evolve independently.
Bridge থাকলে abstraction ও implementation আলাদাভাবে evolve করতে পারে।

---

## 🔹 Real-Life Example

Remote control (abstraction) and TV brands (implementation).
রিমোট কন্ট্রোল (abstraction) ও বিভিন্ন TV ব্র্যান্ড (implementation)।

Remote and TV can change independently.
রিমোট ও TV একে অপরের উপর নির্ভর না করেই পরিবর্তন হতে পারে।

---

# 🧱 Bridge Pattern – Full Code Example (Java)

---

## 🔹 Step 1: Bridge Implementer Interface (DrawAPI)

```java
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}
```

### Explanation

This is the **Implementer Interface**.
এটি হলো **Implementer Interface**।

It defines drawing functionality.
এটি drawing করার কাজ নির্ধারণ করে।

This interface acts as the bridge.
এই ইন্টারফেসটাই bridge হিসেবে কাজ করে।

---

## 🔹 Step 2: Concrete Implementer – RedCircle

```java
class RedCircle implements DrawAPI {

    public void drawCircle(int radius, int x, int y) {
        System.out.println(
            "Drawing Circle[ color: red, radius: " + radius +
            ", x: " + x + ", " + y + "]"
        );
    }
}
```

### Explanation

This is a **Concrete Implementer**.
এটি একটি **Concrete Implementer** ক্লাস।

It provides red color implementation.
এটি লাল রঙে circle আঁকার কাজ করে।

---

## 🔹 Step 3: Concrete Implementer – GreenCircle

```java
class GreenCircle implements DrawAPI {

    public void drawCircle(int radius, int x, int y) {
        System.out.println(
            "Drawing Circle[ color: green, radius: " + radius +
            ", x: " + x + ", " + y + "]"
        );
    }
}
```

### Explanation

Another **Concrete Implementer**.
আরেকটি **Concrete Implementer**।

Same abstraction, different implementation.
একই abstraction, ভিন্ন implementation।

---

## 🔹 Step 4: Abstraction Class (Shape)

```java
abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
```

### Explanation

This is the **Abstraction class**.
এটি হলো **Abstraction ক্লাস**।

It holds reference to DrawAPI.
এটি DrawAPI-এর রেফারেন্স ধরে রাখে।

This is composition, not inheritance.
এটি inheritance নয়, composition।

---

## 🔹 Step 5: Refined Abstraction (Circle)

```java
class Circle extends Shape {

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
```

### Explanation

This is a **Refined Abstraction**.
এটি একটি **Refined Abstraction**।

Circle does not care how drawing happens.
Circle জানে না কিভাবে drawing হচ্ছে।

It delegates work to DrawAPI.
এটি কাজ DrawAPI-কে delegate করে।

---

## 🔹 Step 6: Demo Class (Main)

```java
public class BridgePatternDemo {

    public static void main(String[] args) {

        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
```

### Explanation

Client uses Shape abstraction only.
Client শুধু Shape abstraction ব্যবহার করে।

Implementation is injected at runtime.
Implementation runtime-এ inject করা হয়।

---

## 🖨 Output

```
Drawing Circle[ color: red, radius: 10, x: 100, 100]
Drawing Circle[ color: green, radius: 10, x: 100, 100]
```

---

# 🔍 Key Components Summary

| Component              | Role                  |
| ---------------------- | --------------------- |
| Shape                  | Abstraction           |
| Circle                 | Refined Abstraction   |
| DrawAPI                | Implementer Interface |
| RedCircle, GreenCircle | Concrete Implementers |

---

# ✅ Advantages of Bridge Pattern

Decouples abstraction from implementation.
Abstraction ও implementation আলাদা করে।

Avoids class explosion.
অনেক subclass তৈরি হওয়া এড়ায়।

Supports Open/Closed Principle.
Open/Closed Principle অনুসরণ করে।

---

# ❌ Disadvantages

More classes increase complexity.
ক্লাস সংখ্যা বেড়ে যায়।

Not needed for small systems.
ছোট সিস্টেমে প্রয়োজন নেই।

---

# ⏰ When to Use Bridge Pattern (Interview)

When abstraction and implementation should vary independently.
যখন abstraction ও implementation আলাদাভাবে পরিবর্তন করতে হবে।

When multiple dimensions of variation exist.
যখন একাধিক দিক থেকে পরিবর্তন দরকার।

---

# 🎯 Bridge vs Adapter (Interview Difference)

Bridge is designed upfront.
Bridge আগেই ডিজাইন করা হয়।

Adapter is used after system is built.
Adapter সিস্টেম তৈরি হওয়ার পরে ব্যবহৃত হয়।

---

# 🧠 One-Line Interview Answer

Bridge Pattern decouples abstraction from implementation using composition.
Bridge Pattern composition ব্যবহার করে abstraction ও implementation আলাদা করে।

---



---

## 🔹 1️⃣ DrawAPI Interface

```java
package com.tutorialspoint;

public interface DrawAPI {
   public void drawCircle(int radius, int x, int y);
}
```

### Explanation

This is the **Implementer Interface** in Bridge Pattern.
এটি Bridge Pattern-এর **Implementer Interface**।

This interface defines how drawing should be done.
এই ইন্টারফেস বলে দেয় কীভাবে drawing করা হবে।

Actual drawing logic is not written here.
আসল drawing লজিক এখানে লেখা নেই।

Different implementations (Red, Green) will implement this interface.
ভিন্ন ভিন্ন implementation (Red, Green) এই ইন্টারফেস ইমপ্লিমেন্ট করবে।

---

## 🔹 2️⃣ RedCircle Class

```java
package com.tutorialspoint;

public class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println(
        "Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]"
      );
   }
}
```

### Explanation

This is a **Concrete Implementer** class.
এটি একটি **Concrete Implementer** ক্লাস।

It provides drawing logic for red colored circle.
এটি লাল রঙের circle আঁকার লজিক দেয়।

It implements DrawAPI interface.
এটি DrawAPI ইন্টারফেস ইমপ্লিমেন্ট করে।

---

## 🔹 3️⃣ GreenCircle Class

```java
package com.tutorialspoint;

public class GreenCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println(
        "Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]"
      );
   }
}
```

### Explanation

This is another **Concrete Implementer** class.
এটি আরেকটি **Concrete Implementer** ক্লাস।

It draws a green colored circle.
এটি সবুজ রঙের circle আঁকে।

Same interface, different implementation.
একই ইন্টারফেস, ভিন্ন implementation।

---

## 🔹 4️⃣ Shape Abstract Class

```java
package com.tutorialspoint;

public abstract class Shape {
   protected DrawAPI drawAPI;
   
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }
   public abstract void draw();	
}
```

### Explanation

This is the **Abstraction** in Bridge Pattern.
এটি Bridge Pattern-এর **Abstraction**।

It contains a reference of DrawAPI.
এটি DrawAPI-এর একটি reference ধরে রাখে।

This is **composition**, not inheritance.
এটি inheritance নয়, composition।

Shape does not know which color is used.
Shape জানে না কোন রঙ ব্যবহার করা হচ্ছে।

---

## 🔹 5️⃣ Circle Class

```java
package com.tutorialspoint;

public class Circle extends Shape {
   private int x, y, radius;

   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;  
      this.y = y;  
      this.radius = radius;
   }

   public void draw() {
      drawAPI.drawCircle(radius,x,y);
   }
}
```

### Explanation

This is a **Refined Abstraction** class.
এটি একটি **Refined Abstraction** ক্লাস।

Circle extends Shape but does not care about color.
Circle, Shape এক্সটেন্ড করে কিন্তু রঙ নিয়ে চিন্তা করে না।

Drawing responsibility is delegated to DrawAPI.
Drawing-এর কাজ DrawAPI-কে delegate করা হয়েছে।

This allows abstraction and implementation to vary independently.
এতে abstraction ও implementation আলাদাভাবে পরিবর্তন করা যায়।

---

## 🔹 6️⃣ BridgePatternDemo Class

```java
package com.tutorialspoint;

public class BridgePatternDemo {
   public static void main(String[] args) {

      Shape redCircle =
         new Circle(100,100, 10, new RedCircle());

      Shape greenCircle =
         new Circle(100,100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
   }
}
```

### Explanation

This is the **Client / Demo class**.
এটি হলো **Client / Demo ক্লাস**।

Client works only with Shape abstraction.
Client কেবল Shape abstraction ব্যবহার করে।

Concrete implementation is injected at runtime.
Concrete implementation runtime-এ পাঠানো হয়।

This clearly shows Bridge Pattern in action.
এখানেই Bridge Pattern স্পষ্টভাবে বোঝা যায়।

---

## 🖨 Output

```
Drawing Circle[ color: red, radius: 10, x: 100, 100]
Drawing Circle[ color: green, radius: 10, x: 100, 100]
```

---

## 🧠 Interview Key Points (Very Important)

* Bridge separates **abstraction** and **implementation**
  Bridge abstraction ও implementation আলাদা করে

* Uses **composition over inheritance**
  inheritance নয়, composition ব্যবহার করে

* Prevents class explosion
  অপ্রয়োজনীয় subclass তৈরি হওয়া বন্ধ করে

---

## 🎯 One-Line Interview Answer

Bridge Pattern decouples abstraction from implementation so both can vary independently.
Bridge Pattern abstraction ও implementation আলাদা করে যাতে দুটোই স্বাধীনভাবে পরিবর্তন করা যায়।

---



