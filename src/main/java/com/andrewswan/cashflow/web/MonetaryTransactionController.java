package com.andrewswan.cashflow.web;

import com.andrewswan.cashflow.domain.MonetaryTransaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "monetarytransaction", formBackingObject = MonetaryTransaction.class)
@RequestMapping("/monetarytransaction/**")
@Controller
public class MonetaryTransactionController {
}
