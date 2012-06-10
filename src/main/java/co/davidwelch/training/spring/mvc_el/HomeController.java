package co.davidwelch.training.spring.mvc_el;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		return "home";
	}


	
	/**
	 * Displays the login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Displaying Login page!");
		return "login";
	}
	
	/**
	 * Displays the (secured) user page
	 */
	@RequestMapping(value = "/secure/users", method = RequestMethod.GET)
	public String users(Model model) {
		logger.info("Displaying Users page!");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// auth should never be null, but check just in case
		String message = String.format("Welcome %s! This is the secure section", auth == null ? "null" : auth.getName());
		model.addAttribute("controllerMessage", message );
		return "users";
	}

	
}
