package com.qldv.api.DTO;

public class FastestTicket {
    private String type;
    private int quantity;
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
