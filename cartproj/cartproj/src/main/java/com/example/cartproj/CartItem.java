package com.example.cartproj;

public class CartItem {
        private Long id;
        private String name;
        private int quantity;
        private double price;
        // Getters and setters
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getQty() {
            return quantity;
        }
        public void setQty(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
}
