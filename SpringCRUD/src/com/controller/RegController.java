package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.sun.research.ws.wadl.Method;
import com.vo.RegVO;

@Controller
public class RegController {
	
	@Autowired
	private RegDAO regdao; 
	
	@RequestMapping(value = "reg.html", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("Reg", "regvo", new RegVO());

	}
	
	@RequestMapping(value = "insert.html", method = RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute RegVO regvo) {
		
		regdao.insert(regvo);

		return new ModelAndView("redirect:/search.html");

	}
	
	@RequestMapping(value="search.html", method= RequestMethod.GET)
	public ModelAndView search(){
		
		List<RegVO> ls = regdao.search();
		return new ModelAndView("search","searchlist",ls);
	}
	
	@RequestMapping(value="delete.html", method= RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegVO regvo, @RequestParam int id){
		
		regvo.setId(id);
		regdao.delete(regvo);
		return new ModelAndView("redirect:/search.html");
	}
	
	@RequestMapping(value="edit.html",method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegVO regvo, @RequestParam int id){
		
		regvo.setId(id);
		List<RegVO> editlist=regdao.edit(regvo);
		
		return new ModelAndView("Reg","regvo",editlist.get(0));
		
	}

}
