package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();

        builder.append("Замовлення №").append(this.id)
                .append(" для клієнта: ").append(this.customer).append("\n")
                .append("\n");

        double total = 0.0;
        Item[] items = cart.getContents();

        for (Item item : items) {
            builder.append("ID: ").append(item.getId())
                    .append("Назва: ").append(item.getName())
                    .append("Ціна: ").append(item.getPrice()).append(" грн\n");
            total += item.getPrice();
        }

        builder.append("\n")
                .append("Загальна сума: ").append(total).append(" грн\n");

        return builder.toString();
    }
}