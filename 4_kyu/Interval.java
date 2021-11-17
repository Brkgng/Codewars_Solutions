// See the problem
// https://www.codewars.com/kata/52b7ed099cdc285c300001cd/train/java

public class Interval {

	public static int sumIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		int sum_of_intervals = 0;
		// iterave over intervals
		for (int interval = 0; interval < intervals.length; interval++) {
			int first = intervals[interval][0];
			int second = intervals[interval][1];
			if (first == second)
				continue;
			for (int idx = interval + 1; idx < intervals.length; idx++) {
				// Compare intervals
				if ((second >= intervals[idx][0]) && (intervals[idx][1] >= first)) {
					// Overlapping intervals
					if (first > intervals[idx][0])
						first = intervals[idx][0];
					if (intervals[idx][1] > second)
						second = intervals[idx][1];
					intervals[idx][0] = 0;
					intervals[idx][1] = 0;
				}
			}
			// iterate again for overlapping intervals
			if (first != intervals[interval][0] || second != intervals[interval][1]) {
				// modify interval with min and max interval values
				intervals[interval][0] = first;
				intervals[interval][1] = second;
				interval -= 1;
			} else {
				sum_of_intervals += second - first;
			}
		}
		return sum_of_intervals;
	}
}
