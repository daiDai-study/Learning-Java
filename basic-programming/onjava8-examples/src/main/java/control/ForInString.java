package control;// control/ForInString.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class ForInString {
  public static void main(String[] args) {
    for(char c : "An African Swallow".toCharArray())
      System.out.print(c + " ");

    // 无法对 string 类型直接进行 for-in 循环遍历其字符，需要先转为字符数组
    //for(char c : "An African Swallow")
    //  System.out.print(c + " ");
  }
}
/* Output:
A n   A f r i c a n   S w a l l o w
*/
