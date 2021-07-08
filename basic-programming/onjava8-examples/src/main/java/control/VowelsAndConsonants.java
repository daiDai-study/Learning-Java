package control;// control/VowelsAndConsonants.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates the switch statement
import java.util.*;

public class VowelsAndConsonants {
  public static void main(String[] args) {
    Random rand = new Random(47);
    for(int i = 0; i < 100; i++) {
      int c = rand.nextInt(26) + 'a';
      System.out.print((char)c + ", " + c + ": ");
      switch(c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u': System.out.println("vowel");
                  break;
        case 'y':
        case 'w': System.out.println("Sometimes vowel");
                  break;
        default:  System.out.println("consonant");
      }

      // switch 适用哪些基本类型： char/int/short/byte， 不适用: boolean/float/double/long
      char c1 = 2;
      byte b1 = 2;
      short s1 = 2;
      int i1 = 2;
      long l1= 2;
      switch (c1){

      }
      switch (b1){

      }
      switch (s1){

      }
      switch (i1){

      }
//      switch (l1){
//
//      }
    }
  }
}
/* Output: (First 13 Lines)
y, 121: Sometimes vowel
n, 110: consonant
z, 122: consonant
b, 98: consonant
r, 114: consonant
n, 110: consonant
y, 121: Sometimes vowel
g, 103: consonant
c, 99: consonant
f, 102: consonant
o, 111: vowel
w, 119: Sometimes vowel
z, 122: consonant
                  ...
*/
