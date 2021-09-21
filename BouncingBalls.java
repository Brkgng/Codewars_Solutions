public class BouncingBall {
	
	public static int bouncingBall(double h, double bounce, double window) {
    // checking given conditions
    if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h) return -1;
    // For first falling, ball pass in front of window so it start with 1
    int ballPassWindow = 1;
    double ballHeight = h * bounce;
    do {
      // if ball bounces height greater than window height
      // ball pass in frong of window 2 times (bouncing and falling)
      if (ballHeight > window) ballPassWindow += 2;
      // ball will not reach the height of the window if bounce height and window height is equal
      else if (ballHeight == window) return ballPassWindow;
      ballHeight *= bounce;
    } while(ballHeight >= window);
    
    return ballPassWindow;
	}
}