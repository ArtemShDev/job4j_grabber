package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.List;

public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void sort(List<Food> list) {
        for (Food food : list) {
            for (Storage storage : storages) {
                if (storage.accept(food)) {
                    storage.add(food);
                    break;
                }
            }
        }
    }

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
        ControllQuality cq = new ControllQuality(List.of(
                new Warehouse(), new Trash(), new Shop()));
        cq.sort(list);
    }
}