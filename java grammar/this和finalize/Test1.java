class Book{
  private Boolean flag = false;

  Book(Boolean flag){
    this.flag = flag;
  }
  protected void finalize(){
    if(this.flag == true){
      System.out.println("flag=true");
    }
    else{
      System.out.println("flag=false");
    }
  }
}
public class Test1{
  public static void main(String[] args) {
    Book x = new Book(true);
    Book y = new Book(false);
    
    new Book(true);
    new Book(false);
    new Book(true);
    new Book(true);
    System.gc(); // 强制进行终结动作，进行垃圾回收
    new Book(true);
    new Book(false);
    
  }
}
