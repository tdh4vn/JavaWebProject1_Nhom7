/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author hungtran
 */
public class Product implements Serializable{
    private String code;
    private String description;
    private double price;
    
    public Product()
    {
        code = "";
        description = "";
        price = 0;
    }

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getPriceNumberFormat()
    {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMinimumFractionDigits(2);
        if (price == 0)
            return "";
        else
            return number.format(price); 
    }
    
    public String getPriceCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }        
   
}
