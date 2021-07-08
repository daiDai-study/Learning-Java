// polymorphism/PrivateOverride.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Trying to override a private method
// {java polymorphism.PrivateOverride}
package polymorphism;

public class PrivateOverride {
  private void f() {
    System.out.println("private f()");
  }
  protected void f1() {
    System.out.println("protected f1()");
  }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
    po.f1();

    Derived d = new Derived();
    d.f();
    d.f1();
  }
}

class Derived extends PrivateOverride {
  public void f() { System.out.println("public f()"); }
  @Override
  public void f1() {
    System.out.println("public f1()");
  }
}
/* Output:
private f()
public f1()
*/
