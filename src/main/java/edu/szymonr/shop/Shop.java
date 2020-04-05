package edu.szymonr.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Shop  {

    public String productName;
    public int productPrice;
    public double calculatedPrice;
    public ShopPackage shopPackage;

    @Autowired
    public Shop (String productName, ShopPackage shopPackage) {
        this.productName = productName;
        this.productPrice = getRandomPrice();
        this.shopPackage = shopPackage;
        this.calculatedPrice = calculatePrice(productPrice, shopPackage);
    }

    public void addItem(List<Shop> itemList, Shop shop) {
        shop.getInfo(shop.productName, shop.productPrice);
        itemList.add(shop);
        shop.viewBasket(itemList);
    }

    public void getInfo(String productName, int productPrice) {
       System.out.println("-----------------------------------------------------");
        System.out.println("Product name: "+productName);
        System.out.println("Product price: "+productPrice);
        System.out.println("Calculated price: "+ calculatePrice(productPrice, shopPackage));
    }

    public void viewBasket (List<Shop> basket) {
        double sum = 0;

        for(int i =0; i<basket.size(); i++) {
            sum = sum+basket.get(i).calculatedPrice;
        }
        System.out.println("Ammount in basket: "+sum);
        System.out.println("-----------------------------------------------------");
    }

    protected double calculatePrice(int productPrice, ShopPackage shopPackage) {

        double calculatedPrice=0;


        switch (shopPackage) {
            case START:
                System.out.println("Shop Start");
                calculatedPrice = productPrice;
                break;
            case PLUS:
                System.out.println("Shop plus");
                calculatedPrice =  productPrice + productPrice*ShopConfig.VAT;
                break;
            case PRO:
                System.out.println("Shop Pro");
                calculatedPrice =  productPrice - productPrice*ShopConfig.DISCOUNT;
                break;
        }

        return calculatedPrice;
    }


    private int getRandomPrice() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(50, 300);
    }
}
