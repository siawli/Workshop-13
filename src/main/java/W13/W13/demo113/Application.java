package W13.W13.demo113;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static W13.W13.demo113.Util.CreateDir.*;

@SpringBootApplication
public class Application {
	private static Logger logger = Logger.getLogger(Application.class.getName());
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		List<String> optValues = appArgs.getOptionValues("dataDir");
		
		if (optValues != null) {
			createDir(optValues.get(0));
		} else {
			logger.warning("No directory provided!");
			System.exit(1);
		}

		app.run(args);
	}
}