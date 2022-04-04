package com.team12.foodforall.controller.donation;

import com.team12.foodforall.paypal.CreateProduct;
import com.team12.foodforall.paypal.Subscription;
import com.team12.foodforall.paypal.CreatePlan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Integer ID;
    public String planID;
    public String productID;

    @GetMapping("/billing")
    public String getBilling(@RequestParam("id") String id, Model model) throws IOException, PayPalRESTException {
        try{
            int number = Integer.parseInt(id);
            System.out.println(number);
            ID = number;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        String newProduct = product.createProduct(ID);
        productID = newProduct;
        Subscription bil = new Subscription();
        model.addAttribute("subscribe", bil);

        return "subscribe";
    }

    @PostMapping("/billing/subscribe")
    public String billing(@ModelAttribute("subscribe") Subscription sub) {
        try {
            switch (sub.getFrequency()){
                case "Monthly":
                    String monthly = service.makeMonthly(ID, productID);
                    planID = monthly;
                    break;
                case "Quarterly":
                    String quarterly = service.makeQuarterly(ID, productID);
                    planID = quarterly;
                    break;
                case "Yearly":
                    String yearly = service.makePlan(ID, productID);
                    planID = yearly;
                    break;
            }
            System.out.println(planID);

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/finalise";
    }

    @GetMapping("/finalise")
    public String finalise(Model newModel){
        newModel.addAttribute("planId", planID);
        return "finaliseSub";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelBill() {
        return "index";
    }

    /*@GetMapping(value = SUCCESS_URL)
    public String successBill(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            String plan = service.retrieve();
            System.out.println(plan.toJSON());
            if (plan.getState().equals("approved")) {
                /**create success message**
                return "index";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }*/


}
