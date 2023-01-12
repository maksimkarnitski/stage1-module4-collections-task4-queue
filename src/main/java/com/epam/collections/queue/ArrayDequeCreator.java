package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Deque<Integer> firstDeque = new ArrayDeque<>(firstQueue);
        Deque<Integer> secondDeque = new ArrayDeque<>(secondQueue);

        List<Deque<Integer>> list = new ArrayList<>(Arrays.asList(firstDeque, secondDeque));
        //Game precondition to get two first cards from each queue
        for (Deque<Integer> q : list) {
            result.add(q.poll());
            result.add(q.poll());
        }

        //Play with cards
        while (!firstDeque.isEmpty() && !secondDeque.isEmpty()) {
            for (Deque<Integer> q : list) {
                q.offerLast(result.pollLast());
                result.add(q.poll());
                result.add(q.poll());
            }
        }

        return result;
    }
}
