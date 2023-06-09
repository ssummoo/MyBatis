package kr.co.softsoldesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softsoldesk.beans.DataBean;
import kr.co.softsoldesk.database.MapperInterface;



@Controller
public class TestController {

	@Autowired
	MapperInterface mapper1;
	
	//insert
	@GetMapping("/input_data")
	public String input_data() {
		
		return "input_data";
	}

	@PostMapping("/input_pro")
	public String input_pro(DataBean databean) {
		
		mapper1.insert_data(databean);
		
		
		return "input_pro";
	}
	//select
	@GetMapping("/read_data")
	public String read_data(Model model) {
		
		List<DataBean> list=mapper1.select_data();
		model.addAttribute("list", list);
		
		return "read_data";
	}

}