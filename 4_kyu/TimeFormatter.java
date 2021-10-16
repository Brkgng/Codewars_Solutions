public class TimeFormatter {
    
  public static String formatDuration(int seconds) {
    if (seconds == 0) return "now";
    String[] calculatedFormat = new String[5];
    int outputPartCount = 1; // 'seconds' is already greater than 1 so count must be at least 1
    int temp;
    
    // For the purpose of this Kata, a year is 365 days
    // so 1 year = 31.536.000 seconds
    if (seconds >= 31536000) {
      temp = seconds / 31536000;
      seconds %= 31536000;
      if (temp == 1) calculatedFormat[0] = "1 year";
      else calculatedFormat[0] = String.format("%d years", temp);
      outputPartCount++;
    }
    // 1 day = 86.400 seconds
    if (seconds >= 86400) {
      temp = seconds / 86400;
      seconds %= 86400;
      if (temp == 1) calculatedFormat[1] = "1 day";
      else calculatedFormat[1] = String.format("%d days", temp);
      outputPartCount++;
    }
    // 1 hour = 3.600 seconds
    if (seconds >= 3600) {
      temp = seconds / 3600;
      seconds %= 3600;
      if (temp == 1) calculatedFormat[2] = "1 hour";
      else calculatedFormat[2] = String.format("%d hours", temp);
      outputPartCount++;
    }
    // 1 minute = 60 seconds
    if (seconds >= 60) {
      temp = seconds / 60;
      seconds %= 60;
      if (temp == 1) calculatedFormat[3] = "1 minute";
      else calculatedFormat[3] = String.format("%d minutes", temp);
      outputPartCount++;
    }
    // 1 second
    if (seconds == 0) outputPartCount--;
    else if (seconds == 1) calculatedFormat[4] = "1 second";
    else calculatedFormat[4] = String.format("%d seconds", seconds);
    
    // combine output parts
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      if (calculatedFormat[i] == null) continue;
      if (outputPartCount == 0) break;
      // append space except for the first character of the sentence
      if (output.length() != 0) output.append(" ");
      output.append(calculatedFormat[i]);
      // output must separated by a comma if part count greater than 2 
      if (outputPartCount > 2) {
        output.append(",");
        outputPartCount--;
      }
      // output must separeted by a space if pari count equal to 2
      else if (outputPartCount == 2) {
        // do not need to add space after the 'and' bcz it will be adding in the next iterate
        output.append(" and"); 
        outputPartCount--;
      }
      else {
        outputPartCount--;
      }
    }
    // convert StringBuilder to String
    return output.toString();
  }
}
