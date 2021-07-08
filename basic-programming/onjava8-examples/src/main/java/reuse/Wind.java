package reuse;// reuse/Wind.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Inheritance & upcasting

class Instrument {
  public void play() {
    System.out.println("Instrument");
  }
  static void tune(Instrument i) {
    // ...
    i.play();
  }
}

// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument {
  @Override
  public void play() {
    System.out.println("Wind");
  }

  public static void main(String[] args) {
    Wind flute = new Wind();
    Instrument.tune(flute); // Upcasting
    Wind.tune(flute);
  }
}
