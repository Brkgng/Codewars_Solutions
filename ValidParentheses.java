public class Solution{
  
  public static boolean validParentheses(String parens)
  {
    // opening parentheses count
    int openingCount = 0;
    
    // iterate over String for looking parentheses
    for (int i = 0; i < parens.length(); i++) {
      // for opening parentheses, increment openingCount
      if (parens.charAt(i) == '(')
        openingCount++;
      // for closing parentheses, decrement openingCount
      else if (parens.charAt(i) == ')') {
        // if string has closing parenthes without opening parenthes, return false
        if (openingCount == 0)  return false;
        openingCount--;
      }
    }
    // if size of opening parentheses and closing parentheses are equal, return true
    if (openingCount == 0)  return true;
    return false;
  }
}