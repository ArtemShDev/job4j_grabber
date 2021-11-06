package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.List;

public class ControllQuality {

    public static void main(String[] args) {
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH, 1);
        Calendar expDate2 = Calendar.getInstance();
        expDate2.add(Calendar.WEEK_OF_MONTH, 1);
        Calendar twoWeeksAgo = Calendar.getInstance();
        twoWeeksAgo.add(Calendar.DAY_OF_MONTH, -14);
        Calendar monthAgo = Calendar.getInstance();
        monthAgo.add(Calendar.MONTH, -1);
        List<Food> list = List.of(
                new Food("Sausages", expDate, monthAgo, 100, 0),
                new Food("Oil", expDate2, monthAgo, 200, 0),
                new Food("Souse", expDate, Calendar.getInstance(), 150, 0),
                new Food("Eggs", expDate, expDate, 80, 0));
        ControllQuality cq = new ControllQuality();
        cq.sort(list);
    }

    public void sort(List<Food> list) {
        ActionsWithStorage awsWarehouse = new ActionsWithStorage(new Warehouse());
        ActionsWithStorage awsTrash = new ActionsWithStorage(new Trash());
        ActionsWithStorage awsShop = new ActionsWithStorage(new Shop());
        for (Food food : list) {
            if (useExpiryDate(food.getExpiryDate(), food.getCreateDate()) == 0) {
                awsTrash.addToStorage(food);
            } else if (useExpiryDate(food.getExpiryDate(), food.getCreateDate()) < 25) {
                awsWarehouse.addToStorage(food);
            } else if (useExpiryDate(food.getExpiryDate(), food.getCreateDate()) < 75) {
                awsShop.addToStorage(food);
            } else if (useExpiryDate(food.getExpiryDate(), food.getCreateDate()) < 100) {
                food.setDiscount(30.00);
                awsShop.addToStorage(food);
            }
        }
        System.out.println("Warehouse : " + awsWarehouse.returnFood());
        System.out.println("Shop : " + awsShop.returnFood());
        System.out.println("Trash : " + awsTrash.returnFood());
    }

    public double useExpiryDate(Calendar expiryDate, Calendar createDate) {
        if (expiryDate.getTimeInMillis() == createDate.getTimeInMillis()) {
            return 0;
        }
        return ((double) (Calendar.getInstance().getTimeInMillis() - createDate.getTimeInMillis())
                / (expiryDate.getTimeInMillis() - createDate.getTimeInMillis())) * 100;

    }
}

class ActionsWithStorage {

    private Storage storage;

    public ActionsWithStorage(Storage storage) {
        this.storage = storage;
    }

    public void addToStorage(Food food) {
        storage.add(food);
    }

    public List<Food> returnFood() {
        return storage.getFood();
    }
}
