package com.epam.collections.queue;

import java.util.*;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }


        while (!queue.isEmpty()) {
            for (int i = 1; i <= everyDishNumberToEat; i++) {
                int value = queue.poll();
                if (i == everyDishNumberToEat) {
                    result.add(value);
                } else {
                    queue.offerLast(value);
                }
            }
        }
        return result;
    }
}
