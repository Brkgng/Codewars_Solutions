// See the problem
// https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java

public class CodewarsStyleRankingSystem {
	public int rank, progress;
	
	public CodewarsStyleRankingSystem() {
	  this.rank = -8;
	  this.progress = 0;
	}
	
	private void updateProgress(int earnedProgress) {
	  this.progress += earnedProgress;
	  
	  // Update user rank if points greater than 100
	  if (this.progress >= 100) {
		this.rank += this.progress / 100;
		// Rank cannot be greater than 8
		if (this.rank >= 8) {
		  this.rank = 8;
		  this.progress = 0;
		  return;
		}
		this.progress %= 100;
		// Skip rank '0'
		if (this.rank == 0) this.rank = 1;
	  }
	}
	
	public void incProgress(int questionRank) {
	  // Rank must be between -9 and 9. Also cannot be 0
	  if (questionRank < -8 || questionRank > 8 || questionRank == 0) throw new IllegalArgumentException();
	  
	  // User's rank cannot be greater than 8
	  if (this.rank == 8) return;
	  
	  // Completing an activity that same rank as user (3 Points)
	  if (questionRank == this.rank) updateProgress(3);
	  
	  // Completing an activity that one rank lower than user (1 Point)
	  if ((questionRank == this.rank - 1) || (this.rank == 1 && questionRank == -1)) updateProgress(1);
	  
	  // Completing an activity that ranked highier than user's rank (10 * d * d)
	  if (questionRank > this.rank) {
		// If there is '0' between question and user rank, ignore '0'
		if ((questionRank > 0 && this.rank < 0) ||
			(questionRank < 0 && this.rank > 0)) {
		  updateProgress(10 * (questionRank - this.rank - 1) * (questionRank - this.rank - 1));
		} else {
		updateProgress(10 * (questionRank - this.rank) * (questionRank - this.rank));
		}
	  }
	}
  }