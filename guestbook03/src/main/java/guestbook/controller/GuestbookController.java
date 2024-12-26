package guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guestbook.repository.GuestbookRepository;
import guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	private GuestbookRepository guestbookRepository;
	
	public GuestbookController(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {
		model.addAttribute("id", id);
		return "delete";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable("id") Long id, GuestbookVo vo) {
		guestbookRepository.deleteByIdAndPassword(id, vo.getPassword());
		return "redirect:/";
	}
	
	
	
}
