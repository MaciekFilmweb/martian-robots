package maciek.martianrobots;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableMap;

import maciek.martianrobots.input.InputParser;
import maciek.martianrobots.output.OutputFormatter;

@Configuration
public class MartianRobotsAppConfiguration {

	public static final Map<String, RobotCommand> AVAILABLE_COMMANDS = ImmutableMap.<String, RobotCommand>builder()
	        .put("R", RobotCommand.R)
	        .put("L", RobotCommand.L)
	        .put("F", RobotCommand.F)
	        .build();

	@Bean
	public InputParser inputParser() {
		return new InputParser(AVAILABLE_COMMANDS);
	}

	@Bean
	public OutputFormatter outputFormatter() {
		return new OutputFormatter();
	}

	@Bean
	public MartianRobotsService service() {
		return new MartianRobotsService(inputParser(), outputFormatter());
	}

}
