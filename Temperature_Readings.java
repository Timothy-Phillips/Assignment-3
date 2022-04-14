import java.util.*;
import java.lang.Thread;

class Temperature_Readings{

  public static void main(String[] args) throws Exception
  {
    LockFreeList list = new LockFreeList<Integer>();

    int num_of_threads = 8;

    Thread ThreadSet[] = new Thread[num_of_threads];

    for (int i = 0; i < num_of_threads; i++)
    {
      ThreadSet[i] = new Sensor(i, list);
      ThreadSet[i].start();
    }

    for (int i = 0; i < num_of_threads; i++)
    {
      ThreadSet[i].join();
    }

    list.display();
  }
}
