package com.team12.foodforall.controller.donation;

import com.team12.foodforall.paypal.Billing;
import com.team12.foodforall.paypal.CreatePlan;

import com.team12.foodforall.paypal.CreateProduct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Plan;
import com.paypal.base.rest.PayPalRESTException;

import java.io.IOException;

@Controller
public class BillingController {

    @Autowired
    CreatePlan service;
    @Autowired
    CreateProduct product;

    public static final String SUCCESS_URL = "billing/success";
    public static final String CANCEL_URL = "billing/cancel";

    @RequestMapping("/billing")
    public String donate() {
        return "billing";
    }

    @PostMapping("/subscribe")
    public String billing(@ModelAttribute("subscribe") Billing bill) {
        try {
            Plan plan = service.createPlan(bill.getProjectID(), bill.getFrequency(), "http://localhost:8000/" + CANCEL_URL,
                    "http://localhost:8000/" + SUCCESS_URL);
            for(Links link:plan.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "index";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Plan plan = service.retrieve();
            System.out.println(plan.toJSON());
            if (plan.getState().equals("approved")) {
                /**create success message**/
                return "index";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }


}
