package hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * @RequestMapping 클래스 + 메서드 매핑
 * 
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") Long no) {
		/*
		 *  만일, n이라는 파라미터 이름이 없거나 값이 올바르지 못하면
		 *  400 Bad Request Error가 발생한다.
		 */
		return "UserController:update(" + no + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value ="n", required=true, defaultValue="") String name) {
		return "UserController:update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value ="p", required=true, defaultValue="1") Integer pageNo) {
		return "UserController:list(" + pageNo + ")";
	}
}
