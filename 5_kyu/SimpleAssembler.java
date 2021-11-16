import java.util.HashMap;
import java.util.Map;

// See the problem
// https://www.codewars.com/kata/58e24788e24ddee28e000053/train/java

public class SimpleAssembler {
	public static Map<String, Integer> interpret(String[] program) {
		Map<String, Integer> output = new HashMap<String, Integer>();

		// iterate over program
		for (int idx = 0; idx < program.length; idx++) {
			// instruction first character is unique
			// mov -> m, inc -> i, dec -> d, jnz -> j
			String instruction = String.valueOf(program[idx].charAt(0));

			// register is one character so it will be index 4
			String register = String.valueOf(program[idx].charAt(4));

			switch (instruction) {
			// increase register
			case "i":
				output.put(register, output.get(register) + 1);
				break;
			// decrease register
			case "d":
				output.put(register, output.get(register) - 1);
				break;
			// jumps to instruction if value of register is not zero
			case "j":
				if (output.containsKey(register) && output.get(register) == 0)
					continue;
				int steps = Integer.parseInt(program[idx].substring(6));
				idx += steps - 1;
				break;
			// copy given value in register
			case "m":
				String thirdParam = program[idx].substring(6);
				// check if third parameter is register or int
				if (output.containsKey(thirdParam))
					output.put(register, output.get(thirdParam));
				else
					output.put(register, Integer.parseInt(thirdParam));
				break;
			}
		}
		return output;
	}
}