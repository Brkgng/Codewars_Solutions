import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
      int result = 0;
      int length = binary.size();
      for(int i = length - 1; i >= 0; i--) {
        if (binary.get(i) == 1)
          result += Math.pow(2,(length - i - 1));
      }
      return result;
    }
}