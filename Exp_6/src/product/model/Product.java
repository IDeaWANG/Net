package product.model;

import java.util.Date;

public class Product {
    public  Integer id;
    public  String name;
    public  Float prices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrices() {
        return prices;
    }

    public void setPrices(Float prices) {
        this.prices = prices;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
