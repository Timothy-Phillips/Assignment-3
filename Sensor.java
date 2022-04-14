import java.util.*;
class Sensor extends Thread{
  private Random rand = new Random();

  public int out;
  LockFreeList list;
  Sensor(int i, LockFreeList l){
    out = i;
    list = l;
  }

  private int get_random_temp()
  {
    return (rand.nextInt(171) - 100);
  }

  public void run()
  {
    int temp = get_random_temp();
    list.add(temp);
  }
}
