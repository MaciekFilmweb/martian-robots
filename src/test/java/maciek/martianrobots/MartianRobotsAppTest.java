package maciek.martianrobots;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MartianRobotsAppTest {

	private final RestTemplate REST_TEMPLATE = new RestTemplate();

	@Test
	public void test() throws Exception {

		String input = "5 3\r\n" +
		        "1 1 E\r\n" +
		        "RFRFRFRF\r\n" +
		        "3 2 N\r\n" +
		        "FRRFLLFFRRFLL\r\n" +
		        "0 3 W\r\n" +
		        "LLFFFLFLFL";

		String expectedOutput = "1 1 E\r\n" +
		        "3 3 N LOST\r\n" +
		        "2 3 S";

		test(input, expectedOutput);
	}
	
	@Test
	public void twoRobotsShouldntFailFromTheSameCorner() throws Exception {

		String input = "0 0\r\n" +
		        "0 0 E\r\n" +
		        "F\r\n" +
		        "0 0 E\r\n" +
		        "LF";

		String expectedOutput = "0 0 E LOST\r\n" +
		        "0 0 N";

		test(input, expectedOutput);
	}
	
	@Test
	public void twoRobotsCanFinishOnTheSameField() throws Exception {

		String input = "1 1\r\n" +
		        "0 0 N\r\n" +
		        "FR\r\n" +
		        "1 1 W\r\n" +
		        "FRR";

		String expectedOutput = "0 1 E\r\n" +
		        "0 1 E";

		test(input, expectedOutput);
	}
	
	@Test
	public void robotFollowingTheCircumference() throws Exception {

		String input = "3 3\r\n" +
		        "0 0 N\r\n" +
		        "FFRFFRFFRFF";

		String expectedOutput = "0 0 W";

		test(input, expectedOutput);
	}
	
	
	@Test
	public void robotStartingOffGridIsLostImmediately() throws Exception {

		String input = "-1 -1\r\n" +
		        "0 0 N\r\n" +
		        "L";

		String expectedOutput = "0 0 N LOST";

		test(input, expectedOutput);
		
		input = "3 3\r\n" +
		        "4 4 N\r\n" +
		        "LFFRFFRFFRFF";

		expectedOutput = "4 4 N LOST";

		test(input, expectedOutput);
	}

	private void test(String input, String expectedOutput) {
		String actualOutput = REST_TEMPLATE
		        .getForObject("http://localhost:8080/api?input=" + input, String.class);

		assertEquals(expectedOutput, actualOutput);
	}

}
