import java.awt.Point;
import java.util.Random;

public class MyRandomPoint {

   final static int N = 16;
   final static double INF = 0x3f3f3f3f;
   final static int DEFAULT_X = 90;
   final static int DEFAULT_Y = 90;
   final static int DEFAULT_DIMENSION = 4;
   public static boolean[] vis = new boolean[16+4];
   public static boolean t;
   public static int[] num = new int[16];
   static Point temp,ans;
   static int i,ansi,j;
   static double dist,dist1;
   
   public static Point GetPoint(int x)
   {
	  return new Point((x % DEFAULT_DIMENSION) * DEFAULT_X,(x / DEFAULT_DIMENSION) * DEFAULT_Y);
   }
   
   public static Point GetRandomPoint(int x)
   {
	  vis[num[x]] = false;
	  Random random = new Random();
	  while(vis[j = random.nextInt(N+4)]) ;
	  vis[j] = true;
	  num[x] = j;
	  return MyRandomPoint.GetPoint(j);
   }
  
   public static Point GetPostionPoint(Point x,int y)
   {
	  vis[num[y]] = false;
	  dist = INF;
	  for(i = 0; i < N+4; i++)
	  {
		  if(vis[i]) continue;
		  temp = MyRandomPoint.GetPoint(i);
		  dist1 = Point.distance(x.getX(), x.getY(), temp.getX(), temp.getY());
		  if(dist > dist1) {dist = dist1; ans = temp;ansi = i;}	
	  }
	  num[y] = ansi;
	  vis[ansi] = true;
	  return ans;
   }
  
   public static boolean check()
   {
	t = true;
	for(i = 0; i < N; i++)  if(num[i] != i) t = false;
	if(t) return t;
	t = true;
	for(int i = 0; i < N; i++) if(num[i] != i+4) t = false;
	return t;
   }
}
