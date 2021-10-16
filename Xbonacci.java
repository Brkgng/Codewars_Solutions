public class Xbonacci {

  public double[] tribonacci(double[] s, int n) {
    if (n == 0) return new double[0];
    
    double[] output = new double[n];
    
    // if n less than three, we do not need to calculate next numbers
    if (n < 3) {
      for (int i = 0; i < n; i++) output[i] = s[i];
      return output;
    }
    
    // copy the values of the array of s into the output 
    for (int i = 0; i < 3; i++){
      System.out.print(" s: " + s[i]);
      output[i] = s[i];
    }
    
    // next number will be the sum of the previous 3 num
    for (int i = 3; i < n; i++) {
      output[i] = output[i-1] + output[i-2] + output[i-3];
      System.out.print(output[i] + " ");
    }

    return output;
  }
}