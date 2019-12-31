package org.wt;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
//@Lazy(true)
@Controller
public class EchoController {
	@ResponseBody
	@RequestMapping("/login")
	public Object login(){
		Map<String,Object> res = new HashMap<>();
		return res;
	}
}

