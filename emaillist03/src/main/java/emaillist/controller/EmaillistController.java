package emaillist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import emaillist.repository.EmaillistRepository;
import emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	
}
