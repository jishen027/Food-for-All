package com.team12.foodforall.paypal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Billing {
    private Integer projectID;
    private String currency;
    private String price;
    private String frequency;
    private String description;

}
