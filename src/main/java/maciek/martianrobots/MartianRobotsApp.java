package maciek.martianrobots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import maciek.martianrobots.endpoint.MartianRobotsEndpoint;

/**
 * The app that processes formatted input string with instructions for robots on
 * martian surface of given dimensions and returns formatted output with final
 * locations and states of the robots.
 * <p>
 * Communication with the app happens by {@linkplain MartianRobotsEndpoint the
 * martial robots endpoint}.
 */
@SpringBootApplication
@RequiredArgsConstructor
public class MartianRobotsApp {

	public static void main(String[] args) {
		SpringApplication.run(MartianRobotsApp.class, args);
	}

}
