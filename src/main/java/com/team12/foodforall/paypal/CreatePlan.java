package com.team12.foodforall.paypal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.api.payments.ChargeModels;
import com.paypal.api.payments.Currency;
import com.paypal.api.payments.MerchantPreferences;
import com.paypal.api.payments.Patch;
import com.paypal.api.payments.PaymentDefinition;
import com.paypal.api.payments.Plan;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePlan{

    protected Plan instance = null;

    @Autowired
    private APIContext apiContext;

    public Plan createPlan(
            Integer projectID,
            String frequency,
            String cancelUrl,
            String successUrl
    ) throws PayPalRESTException, IOException {

        String desc = "";
        String freq = "";
        String interval = "";
        String name = "Project 1";
        String curr = "GBP";
        String price = "10";

        if(frequency=="Monthly"){
            desc = "Monthly Donation";
            freq = "MONTH";
            interval = "1";
        }else if(frequency=="Quarterly"){
            desc = "Quarterly Donation";
            freq = "MONTH";
            interval = "3";
        }else{
            desc = "Yearly Donation";
            freq = "YEAR";
            interval = "1";
        }

        // Build Plan object
        Plan plan = new Plan();
        //plan.setName("Charity Plan 1");
        plan.setName(name);
        plan.setDescription(desc);
        plan.setType("fixed");

        //payment_definitions
        PaymentDefinition paymentDefinition = new PaymentDefinition();
        //paymentDefinition.setName(paymentType);
        paymentDefinition.setName("Regular Payments");
        paymentDefinition.setType("REGULAR");
        paymentDefinition.setFrequency(freq);
        //paymentDefinition.setFrequency("MONTH");
        paymentDefinition.setFrequencyInterval(interval);
        //paymentDefinition.setFrequencyInterval("1");
        paymentDefinition.setCycles("12");

        //currency
        Currency currency = new Currency();
        currency.setCurrency(curr);
        //currency.setCurrency("USD");
        currency.setValue(price);
        //currency.setValue("20");
        paymentDefinition.setAmount(currency);

        //charge_models
        ChargeModels chargeModels = new com.paypal.api.payments.ChargeModels();
        chargeModels.setType("SHIPPING");
        chargeModels.setAmount(currency);
        List<ChargeModels> chargeModelsList = new ArrayList<ChargeModels>();
        chargeModelsList.add(chargeModels);
        paymentDefinition.setChargeModels(chargeModelsList);

        //payment_definition
        List<PaymentDefinition> paymentDefinitionList = new ArrayList<PaymentDefinition>();
        paymentDefinitionList.add(paymentDefinition);
        plan.setPaymentDefinitions(paymentDefinitionList);

        //merchant_preferences
        MerchantPreferences merchantPreferences = new MerchantPreferences();
        merchantPreferences.setSetupFee(currency);
        merchantPreferences.setCancelUrl(cancelUrl);
        merchantPreferences.setReturnUrl(successUrl);
        merchantPreferences.setMaxFailAttempts("0");
        merchantPreferences.setAutoBillAmount("YES");
        merchantPreferences.setInitialFailAmountAction("CONTINUE");
        plan.setMerchantPreferences(merchantPreferences);

        this.instance = plan.create(apiContext);
        return this.instance;
    }

    /**
     * Update a plan
     *
     * https://developer.paypal.com/webapps/developer/docs/api/#update-a-plan
     *
     * @return updated Plan instance
     * @throws PayPalRESTException
     */
    public Plan update(APIContext context) throws PayPalRESTException, IOException {

        List<Patch> patchRequestList = new ArrayList<Patch>();
        Map<String, String> value = new HashMap<String, String>();
        value.put("state", "ACTIVE");

        Patch patch = new Patch();
        patch.setPath("/");
        patch.setValue(value);
        patch.setOp("replace");
        patchRequestList.add(patch);

        this.instance.update(context, patchRequestList);
        return this.instance;
    }

    /**
     * Retrieve a plan
     *
     * https://developer.paypal.com/webapps/developer/docs/api/#retrieve-a-plan
     *
     * @return the retrieved plan
     * @throws PayPalRESTException
     */
    public Plan retrieve() throws PayPalRESTException {
        return Plan.get(apiContext, this.instance.getId());
    }
}