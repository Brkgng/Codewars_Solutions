public class VasyaClerk {

  public static String Tickets(int[] peopleInLine) {
    // store how many dolar bill clerk has
    int count25, count50;
    count25 = count50 = 0;
    // iterate over every people
    for (int bill : peopleInLine) {
      // increment count25 for every 25$
      if (bill == 25) {
        count25++;
      } else if (bill == 50) {
        // if clerk does not have 25$, return NO
        if (count25 == 0)
          return "NO";
        // take person's 50$ and give them 25$
        count25--;
        count50++;
      }

      // 100 dolar bill
      else {
        // clerk must have either 3 25$ or 1 25$ and 1 50$
        if (count25 < 3 && (count25 == 0 && count50 == 0))
          return "NO";
        if (count25 > 0 && count50 > 0) {
          // take person's 100$ and give them 25$ and 50$
          count25 -= 1;
          count50 -= 1;
        } else if (count25 > 2) {
          // give 3 25$ to person
          count25 -= 3;
        }
        // if clerk does not have enough bill return NO
        else
          return "NO";
      }
    } // end of loop
    return "YES";
  }
}