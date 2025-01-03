package locale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {
	private LocaleResolver localeResolver;
	
	public LocaleController(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		System.out.println("resolver-locale: " + localeResolver.resolveLocale(request).getLanguage());
		return "index";
	}
}
