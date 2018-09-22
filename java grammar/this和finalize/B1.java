// 理解this指针

class Leaf{
  int i = 0;

  Leaf increment(){
    i++;
    return this;
  }

  public void print(){
    System.out.println(i);
  }

}

public class B1 {
  public static void main(String[] args){
    Leaf x = new Leaf();
    Leaf y = x.increment().increment().increment();  // 连续调用
    x.print(); // 运行结果：3
    y.print(); // 运行结果：3

    Leaf z = x.increment().increment();
    x.print(); // 运行结果：5
    y.print(); // 运行结果：5 ------ maybe surprising
    z.print(); // 运行结果：5

  }
}

