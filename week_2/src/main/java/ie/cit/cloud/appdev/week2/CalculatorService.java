package ie.cit.cloud.appdev.week2;

public class CalculatorService implements Calculator {

	public int add(int i, int j) {
		return i + j;
	}

	public int sub(int i, int j) {
		return i - j;
	}

	public long factorial(int i) {
		if (i < 0)
			throw new IllegalArgumentException();
		long result = 1;
		while (i > 0)
			result = result * i--;
		return result;
	}

	@Override
	public String toString() {
		return "CalculatorService";
	}
}
