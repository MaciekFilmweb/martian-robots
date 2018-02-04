package maciek.martianrobots.endpoint;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import maciek.martianrobots.MartianRobotsApp;
import maciek.martianrobots.MartianRobotsService;

/**
 * Endpoint for communication with the app..
 * <p>
 * Compatible with the form included in
 * {@code src/main/resources/static/index.html}.
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MartianRobotsEndpoint {

	private final MartianRobotsService service;

	/**
	 * @param input
	 *            the {@linkplain MartianRobotsApp app's} input as in the
	 *            specification
	 */
	@RequestMapping(path = "api", produces = "text/plain")
	public String acceptInput(@RequestParam("input") String input) {
		return service.processInput(input);
	}

}