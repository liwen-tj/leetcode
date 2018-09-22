// 构造函数的重载，this关键字调用其他构造函数
public class B2{
  int n = 0;
  String s = "initial";

  B2(int x){
    n = x;
    System.out.println("call int only");
  }

  B2(String x){
    s = x;
    System.out.println("call string only");
  }

  B2(int x, String y){
    this(x);
    // this(y);
    s = y;
    System.out.println("call int and string");
  }
  
  B2(){
    this(22, "happy");
    System.out.println("call empty");
  }

  public static void main(String[] args){
    new B2();
    /*
    call int only
    call int and string
    call empty
    */
  }

}