package ie.cit.cloud.appdev.week2;

public class CalculatorApplication {

	public static void main(String[] args) {
		Calculator calc = new CalculatorService();

		System.out.println(calc.add(10, 5));
		System.out.println(calc.sub(10, 3));
		System.out.println(calc.factorial(10));
	}
}