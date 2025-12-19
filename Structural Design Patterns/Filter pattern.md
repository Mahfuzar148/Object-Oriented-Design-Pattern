
---

# ✅ Filter / Criteria Design Pattern

---

## 🔹 What is Filter (Criteria) Pattern?

Filter (Criteria) Pattern allows filtering a collection of objects using different criteria.
Filter (Criteria) Pattern বিভিন্ন শর্ত (criteria) ব্যবহার করে অবজেক্টের একটি তালিকা ফিল্টার করতে সাহায্য করে।

Criteria can be combined using logical operations like AND, OR.
AND, OR-এর মতো লজিক্যাল অপারেশন ব্যবহার করে criteria একত্র করা যায়।

It belongs to the Structural Design Pattern category.
এটি Structural Design Pattern-এর অন্তর্ভুক্ত।

---

# 🧱 Steps of Filter (Criteria) Pattern  ✅(IMPORTANT)

---

## 🔹 Step 1: Create a Model Class

Create a class on which filtering will be applied.
যে ক্লাসের উপর ফিল্টার করা হবে সেই ক্লাস তৈরি করা হয়।

📌 Example: `Person`

---

## 🔹 Step 2: Create Criteria Interface

Create an interface that defines filtering method.
একটি ইন্টারফেস তৈরি করা হয় যা ফিল্টার করার মেথড নির্ধারণ করে।

📌 Example: `Criteria`

---

## 🔹 Step 3: Create Concrete Criteria Classes

Create classes that implement Criteria interface.
Criteria ইন্টারফেস ইমপ্লিমেন্ট করে বিভিন্ন কংক্রিট ক্লাস তৈরি করা হয়।

📌 Example: `CriteriaMale`, `CriteriaFemale`, `CriteriaSingle`

---

## 🔹 Step 4: Create Composite Criteria

Create classes to combine multiple criteria using AND / OR.
একাধিক criteria একত্র করার জন্য AND / OR ক্লাস তৈরি করা হয়।

📌 Example: `AndCriteria`, `OrCriteria`

---

## 🔹 Step 5: Use Criteria in Client

Client applies different criteria to filter objects.
Client বিভিন্ন criteria ব্যবহার করে অবজেক্ট ফিল্টার করে।

📌 Example: `CriteriaPatternDemo`

---

# 🧱 Code + Explanation (Class-wise)

---

## 🔹 1️⃣ Person Class (Model)

```java
public class Person {

   private String name;
   private String gender;
   private String maritalStatus;

   public Person(String name, String gender, String maritalStatus){
      this.name = name;
      this.gender = gender;
      this.maritalStatus = maritalStatus;
   }

   public String getName() {
      return name;
   }
   public String getGender() {
      return gender;
   }
   public String getMaritalStatus() {
      return maritalStatus;
   }
}
```

### Explanation

This is the **model class**.
এটি হলো **model ক্লাস**।

Filtering will be applied on Person objects.
Person অবজেক্টের উপর ফিল্টার প্রয়োগ করা হবে।

---

## 🔹 2️⃣ Criteria Interface

```java
import java.util.List;

public interface Criteria {
   public List<Person> meetCriteria(List<Person> persons);
}
```

### Explanation

This interface defines filtering contract.
এই ইন্টারফেস ফিল্টার করার নিয়ম নির্ধারণ করে।

All criteria classes must implement this method.
সব criteria ক্লাসকে এই মেথড ইমপ্লিমেন্ট করতে হবে।

---

## 🔹 3️⃣ CriteriaMale Class

```java
import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> malePersons = new ArrayList<Person>();

      for (Person person : persons) {
         if(person.getGender().equalsIgnoreCase("MALE")){
            malePersons.add(person);
         }
      }
      return malePersons;
   }
}
```

### Explanation

This class filters male persons only.
এই ক্লাস শুধুমাত্র পুরুষদের ফিল্টার করে।

It implements Criteria interface.
এটি Criteria ইন্টারফেস ইমপ্লিমেন্ট করে।

---

## 🔹 4️⃣ CriteriaFemale Class

```java
import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> femalePersons = new ArrayList<Person>();

      for (Person person : persons) {
         if(person.getGender().equalsIgnoreCase("FEMALE")){
            femalePersons.add(person);
         }
      }
      return femalePersons;
   }
}
```

### Explanation

This class filters female persons.
এই ক্লাস শুধুমাত্র মহিলা ব্যক্তিদের ফিল্টার করে।

---

## 🔹 5️⃣ CriteriaSingle Class

```java
import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> singlePersons = new ArrayList<Person>();

      for (Person person : persons) {
         if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
            singlePersons.add(person);
         }
      }
      return singlePersons;
   }
}
```

### Explanation

This class filters single persons.
এই ক্লাস অবিবাহিত ব্যক্তিদের ফিল্টার করে।

---

## 🔹 6️⃣ AndCriteria Class

```java
import java.util.List;

public class AndCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   public AndCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria;
   }

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
      return otherCriteria.meetCriteria(firstCriteriaPersons);
   }
}
```

### Explanation

This class combines two criteria using AND logic.
এই ক্লাস AND লজিক ব্যবহার করে দুটি criteria একত্র করে।

Person must satisfy both conditions.
ব্যক্তিকে দুইটি শর্তই পূরণ করতে হবে।

---

## 🔹 7️⃣ OrCriteria Class

```java
import java.util.List;

public class OrCriteria implements Criteria {

   private Criteria criteria;
   private Criteria otherCriteria;

   public OrCriteria(Criteria criteria, Criteria otherCriteria) {
      this.criteria = criteria;
      this.otherCriteria = otherCriteria;
   }

   @Override
   public List<Person> meetCriteria(List<Person> persons) {
      List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
      List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

      for (Person person : otherCriteriaItems) {
         if(!firstCriteriaItems.contains(person)){
            firstCriteriaItems.add(person);
         }
      }
      return firstCriteriaItems;
   }
}
```

### Explanation

This class combines criteria using OR logic.
এই ক্লাস OR লজিক ব্যবহার করে criteria একত্র করে।

Person can satisfy any one condition.
ব্যক্তি যেকোনো একটি শর্ত পূরণ করলেই হবে।

---

## 🔹 8️⃣ CriteriaPatternDemo (Client)

```java
import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {

   public static void main(String[] args) {

      List<Person> persons = new ArrayList<Person>();

      persons.add(new Person("Robert","Male", "Single"));
      persons.add(new Person("John", "Male", "Married"));
      persons.add(new Person("Laura", "Female", "Married"));
      persons.add(new Person("Diana", "Female", "Single"));
      persons.add(new Person("Mike", "Male", "Single"));
      persons.add(new Person("Bobby", "Male", "Single"));

      Criteria male = new CriteriaMale();
      Criteria female = new CriteriaFemale();
      Criteria single = new CriteriaSingle();

      Criteria singleMale = new AndCriteria(single, male);
      Criteria singleOrFemale = new OrCriteria(single, female);

      System.out.println("Males:");
      printPersons(male.meetCriteria(persons));

      System.out.println("\nFemales:");
      printPersons(female.meetCriteria(persons));

      System.out.println("\nSingle Males:");
      printPersons(singleMale.meetCriteria(persons));

      System.out.println("\nSingle Or Females:");
      printPersons(singleOrFemale.meetCriteria(persons));
   }

   public static void printPersons(List<Person> persons){
      for (Person person : persons) {
         System.out.println(
           "Person : [ Name : " + person.getName() +
           ", Gender : " + person.getGender() +
           ", Marital Status : " + person.getMaritalStatus() + " ]"
         );
      }
   }
}
```

### Explanation

This is the **client class**.
এটি হলো **client ক্লাস**।

Client applies different criteria combinations.
Client বিভিন্ন criteria একত্র করে ব্যবহার করে।

---

# 🧠 Interview Key Points

* Filter Pattern separates filtering logic
  Filter Pattern ফিল্টার লজিক আলাদা করে

* Supports Open/Closed Principle
  Open/Closed Principle অনুসরণ করে

* Criteria can be chained
  Criteria একত্র করা যায়

---

## 🎯 One-Line Interview Answer

Filter (Criteria) Pattern allows filtering objects using different criteria and their combinations.
Filter (Criteria) Pattern বিভিন্ন criteria ও তাদের সমন্বয় ব্যবহার করে অবজেক্ট ফিল্টার করতে সাহায্য করে।

---
