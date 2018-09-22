import java.util.ArrayList;

class Apple{
  private static long x = 1;
  private final long y = x + 3;
  public long gety(){
    return y;
  }
}

class Orange{
  public long gety(){
    return 2;
  }
}

public class T2 {
  //@SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList<Apple> al = new ArrayList<Apple>();
    for(int i=0; i<3; ++i){
      al.add(new Apple());
    }
    // al.add(new Orange()); // 编译报错
    for(int i=0; i<al.size(); ++i){
      System.out.println(al.get(i).gety());
    }
  }

}
