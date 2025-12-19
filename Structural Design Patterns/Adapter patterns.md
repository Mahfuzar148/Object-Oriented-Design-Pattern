

---

# ✅ Steps of Adapter Design Pattern

---

## 🔹 Step 1: Identify the Incompatible Interfaces

Identify the existing interface and the incompatible interface.
প্রথমে বিদ্যমান ইন্টারফেস ও অসামঞ্জস্যপূর্ণ ইন্টারফেস শনাক্ত করা হয়।

One interface is expected by the client.
একটি ইন্টারফেস ক্লায়েন্ট ব্যবহার করতে চায়।

Another interface already exists but is incompatible.
আরেকটি ইন্টারফেস আছে কিন্তু তা সামঞ্জস্যপূর্ণ নয়।

---

## 🔹 Step 2: Create the Target Interface

Create an interface that the client expects.
ক্লায়েন্ট যে ইন্টারফেস আশা করে তা তৈরি করা হয়।

This interface defines the standard method.
এই ইন্টারফেস স্ট্যান্ডার্ড মেথড নির্ধারণ করে।

---

### Example

MediaPlayer interface.
MediaPlayer ইন্টারফেস।

---

## 🔹 Step 3: Create the Adaptee Interface

Create an interface that has incompatible methods.
যে ইন্টারফেসের মেথডগুলো অসামঞ্জস্যপূর্ণ তা তৈরি করা হয়।

This interface already exists or comes from third-party.
এই ইন্টারফেস সাধারণত আগে থেকেই থাকে বা থার্ড-পার্টি থেকে আসে।

---

### Example

AdvancedMediaPlayer interface.
AdvancedMediaPlayer ইন্টারফেস।

---

## 🔹 Step 4: Implement Adaptee Classes

Create concrete classes implementing the adaptee interface.
Adaptee ইন্টারফেস ইমপ্লিমেন্ট করে কংক্রিট ক্লাস তৈরি করা হয়।

Each class supports specific functionality.
প্রতিটি ক্লাস নির্দিষ্ট কার্যক্ষমতা সমর্থন করে।

---

### Example

VlcPlayer, Mp4Player.
VlcPlayer, Mp4Player ক্লাস।

---

## 🔹 Step 5: Create Adapter Class

Create a class that implements the target interface.
Target ইন্টারফেস ইমপ্লিমেন্ট করে একটি Adapter ক্লাস তৈরি করা হয়।

Adapter holds reference of adaptee.
Adapter ভেতরে adaptee–এর রেফারেন্স রাখে।

---

### Key Responsibility

Adapter converts target interface calls into adaptee calls.
Adapter target ইন্টারফেসের কলকে adaptee কল–এ রূপান্তর করে।

---

## 🔹 Step 6: Use Adapter in Client Class

Client uses only the target interface.
ক্লায়েন্ট কেবল target ইন্টারফেস ব্যবহার করে।

Adapter works internally without client knowing.
Adapter ভেতরে কাজ করে, ক্লায়েন্ট তা জানে না।

---

### Example

AudioPlayer uses MediaAdapter.
AudioPlayer, MediaAdapter ব্যবহার করে।

---

## 🔹 Step 7: Client Code Execution

Client interacts with adapter indirectly.
ক্লায়েন্ট পরোক্ষভাবে Adapter-এর সাথে কাজ করে।

Incompatible objects work together seamlessly.
অসামঞ্জস্যপূর্ণ অবজেক্ট সহজে একসাথে কাজ করে।

---

# 🧠 Easy Memory Trick

Target → Adapter → Adaptee
Target → Adapter → Adaptee

ক্লায়েন্ট → অ্যাডাপ্টার → আসল ক্লাস

---

# 🎯 One-Line Interview Answer

Adapter Pattern acts as a bridge between two incompatible interfaces.
Adapter Pattern দুটি অসামঞ্জস্যপূর্ণ ইন্টারফেসের মধ্যে সেতু হিসেবে কাজ করে।

---




---

# ✅ Adapter Design Pattern

## 🔹 Overview

Adapter pattern works as a bridge between two incompatible interfaces.
Adapter প্যাটার্ন দুটি অসামঞ্জস্যপূর্ণ (incompatible) ইন্টারফেসের মধ্যে সেতুবন্ধন হিসেবে কাজ করে।

This pattern comes under structural design pattern.
এই প্যাটার্নটি structural design pattern-এর অন্তর্ভুক্ত।

It combines functionality of two independent interfaces.
এটি দুটি স্বাধীন ইন্টারফেসের কার্যক্ষমতা একত্রিত করে।

---

## 🔹 Real Life Example

A card reader acts as an adapter between memory card and laptop.
একটি কার্ড রিডার মেমোরি কার্ড ও ল্যাপটপের মাঝে অ্যাডাপ্টার হিসেবে কাজ করে।

Laptop cannot read memory card directly.
ল্যাপটপ সরাসরি মেমোরি কার্ড পড়তে পারে না।

Card reader makes them compatible.
কার্ড রিডার তাদের সামঞ্জস্যপূর্ণ করে তোলে।

---

## 🔹 Problem Statement

AudioPlayer can play only mp3 files.
AudioPlayer শুধুমাত্র mp3 ফাইল চালাতে পারে।

Advanced players can play mp4 and vlc files.
Advanced player mp4 ও vlc ফাইল চালাতে পারে।

We want AudioPlayer to play all formats without changing it much.
আমরা AudioPlayer-কে খুব বেশি পরিবর্তন না করেই সব ফরম্যাট চালাতে চাই।

---

## 🔹 Solution Using Adapter Pattern

MediaAdapter works as a bridge.
MediaAdapter একটি সেতুর মতো কাজ করে।

AudioPlayer uses MediaAdapter to play advanced formats.
AudioPlayer advanced ফরম্যাট চালাতে MediaAdapter ব্যবহার করে।

---

# 🧱 Implementation Steps

---

## 🔹 Step 1: Create Interfaces

### MediaPlayer Interface

```java
public interface MediaPlayer {
   void play(String audioType, String fileName);
}
```

MediaPlayer defines common play method.
MediaPlayer একটি সাধারণ play মেথড নির্ধারণ করে।

---

### AdvancedMediaPlayer Interface

```java
public interface AdvancedMediaPlayer {
   void playVlc(String fileName);
   void playMp4(String fileName);
}
```

AdvancedMediaPlayer supports advanced formats.
AdvancedMediaPlayer উন্নত ফরম্যাট সমর্থন করে।

---

## 🔹 Step 2: Implement AdvancedMediaPlayer

### VlcPlayer

```java
public class VlcPlayer implements AdvancedMediaPlayer {
```

VlcPlayer can play vlc files only.
VlcPlayer শুধুমাত্র vlc ফাইল চালাতে পারে।

playMp4 method does nothing.
playMp4 মেথড এখানে কিছুই করে না।

---

### Mp4Player

```java
public class Mp4Player implements AdvancedMediaPlayer {
```

Mp4Player can play mp4 files only.
Mp4Player শুধুমাত্র mp4 ফাইল চালাতে পারে।

playVlc method does nothing.
playVlc মেথড কিছুই করে না।

---

## 🔹 Step 3: Create Adapter Class

### MediaAdapter

```java
public class MediaAdapter implements MediaPlayer {
```

MediaAdapter implements MediaPlayer interface.
MediaAdapter, MediaPlayer ইন্টারফেস ইমপ্লিমেন্ট করে।

It internally uses AdvancedMediaPlayer.
এটি ভিতরে AdvancedMediaPlayer ব্যবহার করে।

---

```java
public MediaAdapter(String audioType) {
```

Adapter decides which advanced player to use.
Adapter নির্ধারণ করে কোন advanced player ব্যবহার হবে।

---

```java
advancedMusicPlayer = new VlcPlayer();
```

If type is vlc, use VlcPlayer.
ফরম্যাট vlc হলে VlcPlayer ব্যবহার করা হয়।

---

```java
advancedMusicPlayer = new Mp4Player();
```

If type is mp4, use Mp4Player.
ফরম্যাট mp4 হলে Mp4Player ব্যবহার করা হয়।

---

## 🔹 Step 4: AudioPlayer Class

```java
public class AudioPlayer implements MediaPlayer {
```

AudioPlayer is the main client class.
AudioPlayer হলো প্রধান ক্লায়েন্ট ক্লাস।

---

```java
if(audioType.equalsIgnoreCase("mp3")) {
```

AudioPlayer directly plays mp3 files.
AudioPlayer সরাসরি mp3 ফাইল চালায়।

---

```java
mediaAdapter = new MediaAdapter(audioType);
mediaAdapter.play(audioType, fileName);
```

For other formats, AudioPlayer uses adapter.
অন্য ফরম্যাটের জন্য AudioPlayer অ্যাডাপ্টার ব্যবহার করে।

---

## 🔹 Step 5: Demo Class

```java
audioPlayer.play("mp3", "song.mp3");
audioPlayer.play("mp4", "song.mp4");
audioPlayer.play("vlc", "song.vlc");
```

AudioPlayer plays different formats seamlessly.
AudioPlayer সহজেই বিভিন্ন ফরম্যাট চালায়।

---

```java
audioPlayer.play("avi", "song.avi");
```

Unsupported format is rejected.
অসমর্থিত ফরম্যাট বাতিল করা হয়।

---

## 🔹 Output Explanation

```
Playing mp3 file...
Playing mp4 file...
Playing vlc file...
Invalid media format
```

Adapter enables format compatibility.
Adapter ফরম্যাটের সামঞ্জস্য নিশ্চিত করে।

---

## ✅ Advantages of Adapter Pattern

### 1️⃣ Compatibility

Adapter makes incompatible interfaces work together.
Adapter অসামঞ্জস্যপূর্ণ ইন্টারফেসকে একসাথে কাজ করতে দেয়।

---

### 2️⃣ Reusability

Existing classes can be reused.
বিদ্যমান ক্লাস পুনরায় ব্যবহার করা যায়।

---

### 3️⃣ Open/Closed Principle

New formats can be added without changing AudioPlayer.
AudioPlayer পরিবর্তন না করেই নতুন ফরম্যাট যোগ করা যায়।

---

## ❌ Disadvantages of Adapter Pattern

### 1️⃣ Extra Class

Introduces additional classes.
অতিরিক্ত ক্লাস যুক্ত হয়।

---

### 2️⃣ Increased Complexity

Design becomes slightly complex.
ডিজাইন কিছুটা জটিল হয়।

---

## ⏰ When to Use Adapter Pattern

Use when interfaces are incompatible.
যখন ইন্টারফেসগুলো অসামঞ্জস্যপূর্ণ হয় তখন ব্যবহার করা উচিত।

Use when you want to reuse existing code.
বিদ্যমান কোড পুনরায় ব্যবহার করতে চাইলে ব্যবহার করা উচিত।

---

## 🎯 One-Line Interview Answer

Adapter Pattern converts one interface into another expected by the client.
Adapter Pattern একটি ইন্টারফেসকে ক্লায়েন্ট প্রত্যাশিত অন্য ইন্টারফেসে রূপান্তর করে।

---




---

# ✅ Adapter Design Pattern – Full Example (Java)

---

## 🔹 Problem Statement

AudioPlayer can play only MP3 files.
AudioPlayer শুধুমাত্র MP3 ফাইল চালাতে পারে।

But we want it to play MP4 and VLC also.
কিন্তু আমরা চাই এটি MP4 ও VLC ফাইলও চালাক।

Interfaces are incompatible.
ইন্টারফেসগুলো একে অপরের সাথে সামঞ্জস্যপূর্ণ নয়।

---

## 🔹 Solution

Use Adapter Pattern to act as a bridge.
Adapter Pattern ব্যবহার করে একটি সেতু তৈরি করা হবে।

---

# 🧱 STEP 1: MediaPlayer Interface

```java
interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

MediaPlayer is the client expected interface.
MediaPlayer হলো ক্লায়েন্ট যে ইন্টারফেসটি আশা করে।

AudioPlayer will use this interface only.
AudioPlayer কেবল এই ইন্টারফেসই ব্যবহার করবে।

---

# 🧱 STEP 2: AdvancedMediaPlayer Interface

```java
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

AdvancedMediaPlayer supports advanced formats.
AdvancedMediaPlayer উন্নত ফরম্যাট সমর্থন করে।

AudioPlayer cannot use it directly.
AudioPlayer এটি সরাসরি ব্যবহার করতে পারে না।

---

# 🧱 STEP 3: Concrete Advanced Players

## 🔸 VlcPlayer

```java
class VlcPlayer implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
        // do nothing
    }
}
```

VlcPlayer can play only VLC files.
VlcPlayer শুধুমাত্র VLC ফাইল চালাতে পারে।

Other method is ignored.
অন্য মেথডটি এখানে উপেক্ষা করা হয়।

---

## 🔸 Mp4Player

```java
class Mp4Player implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        // do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```

Mp4Player can play only MP4 files.
Mp4Player শুধুমাত্র MP4 ফাইল চালাতে পারে।

---

# 🧱 STEP 4: Adapter Class (MOST IMPORTANT)

```java
class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;
```

MediaAdapter implements MediaPlayer.
MediaAdapter, MediaPlayer ইন্টারফেস ইমপ্লিমেন্ট করে।

It internally uses AdvancedMediaPlayer.
ভেতরে এটি AdvancedMediaPlayer ব্যবহার করে।

---

```java
    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }
```

Adapter decides which advanced player to use.
Adapter নির্ধারণ করে কোন advanced player ব্যবহার হবে।

This is adaptation logic.
এটাই মূল adaptation লজিক।

---

```java
    public void play(String audioType, String fileName) {

        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

Adapter converts MediaPlayer call to AdvancedMediaPlayer call.
Adapter, MediaPlayer কলকে AdvancedMediaPlayer কলে রূপান্তর করে।

---

# 🧱 STEP 5: AudioPlayer (Client Class)

```java
class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;
```

AudioPlayer is the client.
AudioPlayer হলো ক্লায়েন্ট ক্লাস।

---

```java
    public void play(String audioType, String fileName) {

        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
```

AudioPlayer supports MP3 directly.
AudioPlayer সরাসরি MP3 চালাতে পারে।

---

```java
        else if(audioType.equalsIgnoreCase("vlc") || 
                audioType.equalsIgnoreCase("mp4")) {

            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
```

For other formats, AudioPlayer uses adapter.
অন্য ফরম্যাটের জন্য AudioPlayer অ্যাডাপ্টার ব্যবহার করে।

AudioPlayer does not know real player class.
AudioPlayer জানে না আসল প্লেয়ার কোনটি।

---

```java
        else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

Unsupported formats are rejected.
অসমর্থিত ফরম্যাট বাতিল করা হয়।

---

# 🧱 STEP 6: Demo Class

```java
public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("vlc", "music.vlc");
        audioPlayer.play("avi", "video.avi");
    }
}
```

Client uses AudioPlayer only.
ক্লায়েন্ট শুধু AudioPlayer ব্যবহার করে।

Adapter works silently behind the scene.
Adapter নীরবে ভিতরে কাজ করে।

---

# 🖨 Output

```
Playing mp3 file. Name: song.mp3
Playing mp4 file. Name: movie.mp4
Playing vlc file. Name: music.vlc
Invalid media. avi format not supported
```

Adapter enables compatibility.
Adapter সামঞ্জস্য নিশ্চিত করে।

---

# ✅ Advantages of Adapter Pattern

Adapter allows incompatible interfaces to work together.
Adapter অসামঞ্জস্যপূর্ণ ইন্টারফেসকে একসাথে কাজ করতে দেয়।

Existing code remains unchanged.
পুরোনো কোড পরিবর্তন করতে হয় না।

Improves reusability and flexibility.
পুনঃব্যবহারযোগ্যতা ও নমনীয়তা বাড়ায়।

---

# ❌ Disadvantages

Extra classes are introduced.
অতিরিক্ত ক্লাস যুক্ত হয়।

Design becomes slightly complex.
ডিজাইন কিছুটা জটিল হয়।

---

# ⏰ When to Use Adapter Pattern

When existing interface cannot be changed.
যখন বিদ্যমান ইন্টারফেস পরিবর্তন করা যায় না।

When integrating third-party libraries.
থার্ড-পার্টি লাইব্রেরি যুক্ত করার সময়।

---

# 🎯 One-Line Interview Answer

Adapter Pattern converts one interface into another expected by the client.
Adapter Pattern একটি ইন্টারফেসকে ক্লায়েন্টের প্রত্যাশিত অন্য ইন্টারফেসে রূপান্তর করে।

---

---

## 🔹 1️⃣ MediaPlayer Interface

```java
interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

### Explanation

This is the **Target Interface**.
এটি হলো **Target Interface**।

Client (AudioPlayer) এই ইন্টারফেসের উপর নির্ভর করে।
Client (AudioPlayer) এই ইন্টারফেস ব্যবহার করেই কাজ করে।

play() মেথডটি সব ধরনের মিডিয়া প্লেয়ারের জন্য সাধারণ নিয়ম নির্ধারণ করে।
play() মেথডটি বলে দেয় – কীভাবে মিডিয়া চালানো হবে, কিন্তু কীভাবে বাস্তবায়ন হবে তা নয়।

---

## 🔹 2️⃣ AdvancedMediaPlayer Interface

```java
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
```

### Explanation

This is the **Adaptee Interface**.
এটি হলো **Adaptee Interface**।

এই ইন্টারফেসটি উন্নত ফরম্যাট (vlc, mp4) চালানোর জন্য তৈরি।
এই ইন্টারফেসের মেথডগুলো MediaPlayer-এর সাথে সরাসরি মিল নেই।

এই কারণে AudioPlayer এটি সরাসরি ব্যবহার করতে পারে না।
এই অসামঞ্জস্য দূর করার জন্য Adapter দরকার হয়।

---

## 🔹 3️⃣ VlcPlayer Class

```java
class VlcPlayer implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
        // do nothing
    }
}
```

### Explanation

This is a **Concrete Adaptee Class**.
এটি একটি **Concrete Adaptee ক্লাস**।

এই ক্লাসটি শুধুমাত্র VLC ফাইল চালাতে পারে।
playMp4() মেথড এখানে কোনো কাজ করে না।

প্রতিটি concrete ক্লাস শুধুমাত্র নিজের ফরম্যাটের কাজ করে।
এটাই Adapter Pattern-এর বাস্তব ব্যবহার।

---

## 🔹 4️⃣ Mp4Player Class

```java
class Mp4Player implements AdvancedMediaPlayer {

    public void playVlc(String fileName) {
        // do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```

### Explanation

This is another **Concrete Adaptee Class**.
এটিও একটি **Concrete Adaptee ক্লাস**।

এই ক্লাসটি শুধুমাত্র MP4 ফাইল চালাতে পারে।
VLC সম্পর্কিত মেথড এখানে কাজ করে না।

---

## 🔹 5️⃣ MediaAdapter Class

```java
class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```

### Explanation

This is the **Adapter Class**.
এটাই হলো **Adapter ক্লাস**।

MediaAdapter, MediaPlayer ইন্টারফেস ইমপ্লিমেন্ট করে।
ভেতরে এটি AdvancedMediaPlayer ব্যবহার করে।

এটি MediaPlayer-এর play() কলকে
AdvancedMediaPlayer-এর playVlc() বা playMp4() এ রূপান্তর করে।

এখানেই আসল “bridge” তৈরি হয়।
এটাই Adapter Pattern-এর মূল কাজ।

---

## 🔹 6️⃣ AudioPlayer Class

```java
class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }

        else if (audioType.equalsIgnoreCase("vlc") ||
                 audioType.equalsIgnoreCase("mp4")) {

            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }

        else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

### Explanation

This is the **Client Class**.
এটি হলো **Client ক্লাস**।

AudioPlayer সরাসরি mp3 চালাতে পারে।
অন্যান্য ফরম্যাটের জন্য এটি Adapter ব্যবহার করে।

AudioPlayer জানে না আসলে কোন ক্লাস ফাইল চালাচ্ছে।
এটাই loose coupling-এর উদাহরণ।

---

## 🔹 7️⃣ Main / Demo Class

```java
public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("vlc", "music.vlc");
        audioPlayer.play("avi", "video.avi");
    }
}
```

### Explanation

This is the **Demo / Testing Class**.
এটি প্রোগ্রাম চালানোর জন্য ব্যবহৃত হয়।

Client শুধু AudioPlayer ব্যবহার করে।
Adapter ভিতরে ভিতরে কাজ করে, ক্লায়েন্ট জানেই না।

---

## 🧠 One-Line Summary (মনে রাখার জন্য)

Adapter Pattern অসামঞ্জস্যপূর্ণ ইন্টারফেসকে একসাথে কাজ করতে সাহায্য করে।
Adapter Pattern একটি সেতুর মতো কাজ করে।

---





