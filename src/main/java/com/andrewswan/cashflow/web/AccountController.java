package com.andrewswan.cashflow.web;

import com.andrewswan.cashflow.domain.Account;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "account", formBackingObject = Account.class)
@RequestMapping("/account/**")
@Controller
public class AccountController {
	
    @RequestMapping(value = "/account", method = RequestMethod.GET)    
    public String list(
    	@RequestParam(value = "page", required = false) Integer page,
    	@RequestParam(value = "size", required = false) Integer size,
    	ModelMap modelMap)
    {    
        if (page != null || size != null) {        
            int sizeNo = size == null ? 10 : size.intValue();            
            modelMap.addAttribute("accounts", Account.findAccountEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));            
            float nrOfPages = (float) Account.countAccounts() / sizeNo;            
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));            
        }
        else {        
            modelMap.addAttribute("accounts", Account.findAllAccounts());            
        }        
        return "account/list";        
    }    
}
