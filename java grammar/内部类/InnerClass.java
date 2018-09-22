public class InnerClass{
  String s = "will you find me?";
  void f(){
    System.out.println("outer class");
  }

  private class Inner{
    void f(){
      System.out.println(s + "inner class");
    }
    void callOutf(){
      InnerClass.this.f();
    }
  }

  public Inner inner(){
    return new Inner();
  }

  public static void main(String[] args) {
    // System.out.print(s); // 报错, 在static方法的内部，不能调用非静态方法或变量
    // Inner x = new Inner(); // 报错, 在static方法的内部，不能调用非静态方法或变量
    InnerClass x = new InnerClass();
    x.inner().f();
    x.inner().callOutf();
  }

}