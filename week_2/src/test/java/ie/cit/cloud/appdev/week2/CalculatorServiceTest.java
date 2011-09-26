package ie.cit.cloud.appdev.week2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {

	Calculator tested;

	@Before
	public void setup() {
		tested = new CalculatorService();
	}

	@Test
	public void testAdd() {
		assertThat(tested.add(1, 1), is(2));
		assertThat(tested.add(2, 5), is(7));
	}

	@Test
	public void testSub() {
		assertThat(tested.sub(3, 1), is(2));
		assertThat(tested.sub(2, 5), is(-3));
	}

	@Test
	public void testFactorial() throws Exception {
		assertThat(tested.factorial(5), is(120L));
		assertThat(tested.factorial(0), is(1L));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFactorialIllegalValue() {
		tested.factorial(-1);
	}
}
