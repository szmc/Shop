package edu.szymonr.shop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "shop-config")
public class ShopConfig {

    public static double VAT;
    public static double DISCOUNT;

    public void setVat(double vat) {
        this.VAT = vat;
    }

    public void setDiscount(double discount) {
        this.DISCOUNT = discount;
    }


}
