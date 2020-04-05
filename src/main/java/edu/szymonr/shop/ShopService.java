package edu.szymonr.shop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    List<Shop> productList;

    public ShopService() {
        Shop shop1 = new Shop("Produkt 1", ShopPackage.PLUS);
        Shop shop2 = new Shop("Produkt 2", ShopPackage.PRO);
        Shop shop3 = new Shop("Produkt 3", ShopPackage.START);
        Shop shop4 = new Shop("Produkt 4", ShopPackage.PLUS);
        Shop shop5 = new Shop("Produkt 5", ShopPackage.PRO);

        productList = new ArrayList<>();
        addItem(productList, shop1);
        addItem(productList, shop2);
        addItem(productList, shop3);
        addItem(productList, shop4);
        addItem(productList, shop5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        double sum = 0;

        for(int i =0; i<productList.size(); i++) {
            sum = sum+productList.get(i).calculatedPrice;
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("total ammount: "+sum);
        System.out.println("-----------------------------------------------------");
    }

    public void addItem(List<Shop> list, Shop shop) {
        shop.addItem(list, shop);
    }
}
