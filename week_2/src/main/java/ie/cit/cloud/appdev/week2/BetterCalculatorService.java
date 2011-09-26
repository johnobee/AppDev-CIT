package ie.cit.cloud.appdev.week2;

import org.apache.commons.math.util.MathUtils;

public class BetterCalculatorService implements Calculator {

	@Override
	public int add(int i, int j) {
		return MathUtils.addAndCheck(i, j);
	}

	@Override
	public int sub(int i, int j) {
		return MathUtils.subAndCheck(i, j);
	}

	@Override
	public long factorial(int i) {
		return MathUtils.factorial(i);
	}

	@Override
	public String toString() {
		return "BetterCalculatorService";
	}

}
