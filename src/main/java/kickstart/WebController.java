package kickstart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import kickstart.verkaufsbereich.controller.NachbestellungController;

@Controller
public class WebController {
	@Autowired
	private NachbestellungController nachbestellungController;

    @GetMapping("/")
    public String home(Model model) {
        return "index"; 
    }
    @GetMapping("/index")
    public String homeIndex(Model model) {
        return "index"; 
    }
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/welcome")
	public String welcome(Model model) {
		if(nachbestellungController.isReorderNeeded()) 
		    model.addAttribute("hasNotifications","Es gibt Artikels, die nachbestellt werden müssen! Sehen Sie die Nachbestellungsliste Bitte!");
		    return "welcome";
	}
	@GetMapping("/login")
	public String signin() {
		return "login";
	}
	  
}
