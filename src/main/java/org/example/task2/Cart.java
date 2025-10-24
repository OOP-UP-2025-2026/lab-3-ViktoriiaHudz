package org.example.task2;

public class Cart {

    private Item[] items;  // масив товарів
    private int count;     // кількість доданих товарів

    // Конструктор
    public Cart(int capacity) {
        this.items = new Item[capacity];
        this.count = 0;
    }

    public void add(Item item) {
        if (count >= items.length) {
            System.out.println("Кошик переповнений, не можна додати більше товарів");
            return;
        }
        items[count++] = item;
    }

    public void removeById(long id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i].getId() == id) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--count] = null;
                System.out.println("Товар з id " + id + " видалено з кошика");
                break;
            }
        }
        if (!found) {
            System.out.println("Товар з id " + id + " не знайдено");
        }
    }

    public int getCount() {
        return count;
    }

    public Item getItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Невірний індекс товару");
        }
        return items[index];
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public Item[] getContents() {
        Item[] result = new Item[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cart:\n");
        for (int i = 0; i < count; i++) {
            builder.append(items[i].toString());
        }
        builder.append("\n");
        builder.append("Кількість товарів: ").append(count).append("\n");
        builder.append("Загальна сума: ").append(getTotalPrice()).append("\n");
        return builder.toString();
    }
}
