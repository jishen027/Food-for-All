package com.team12.foodforall.paypal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer projectID;
    private Integer quantity;
    private String currency;
    private String method;
    private String intent;
    private String description;

}
