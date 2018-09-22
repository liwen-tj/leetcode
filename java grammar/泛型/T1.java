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

public class T1{
  //@SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    for(int i=0; i<3; ++i){
      al.add(new Apple());
    }
    al.add(new Orange());
    for(int i=0; i<al.size(); ++i){
      if(i==3){
        System.out.println(((Orange)al.get(i)).gety());
      }
      else{
        System.out.println(((Apple)al.get(i)).gety());
      }
    }
  }
}