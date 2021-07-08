package operators;// operators/CastingNumbers.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// What happens when you cast a float
// or double to an integral value?

public class CastingNumbers {
  public static void main(String[] args) {
    double above = 0.7, below = 0.4;
    float fabove = 0.7f, fbelow = 0.4f;
    System.out.println("(int)above: " + (int)above);
    System.out.println("(int)below: " + (int)below);
    System.out.println("(int)fabove: " + (int)fabove);
    System.out.println("(int)fbelow: " + (int)fbelow);

    // int 转 char/byte/short 需要强制吗，需要的
    int a = 1;
    char c = (char) a;
    byte b = (byte) a;
    short s = (short) a;

    // 字面值常量（整数型，较大的） 赋值给 char/byte/short 需要强制吗，需要的
    char c1 = (char) 12345678;
    byte b1 = (byte) 12345678;
    short s1 = (short) 12345678;

    // 字面值常量（整数型，较小的） 赋值给 char/byte/short 需要强制吗，不需要的
    byte b2 = -128;
    byte b3 = (byte) -129;
    char c2 = 1;
    short s2 = 1;

    // 字面值常量（整数型），在 char/byte/short 的取值范围内的，给 char/byte/short 不需要强制，取值范围之外的需要强制
  }
}
/* Output:
(int)above: 0
(int)below: 0
(int)fabove: 0
(int)fbelow: 0
*/
