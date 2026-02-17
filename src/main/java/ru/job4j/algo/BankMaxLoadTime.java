package ru.job4j.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankMaxLoadTime {

    public static int[] findMaxLoadTime(List<int[]> visitTimes) {
        int maxLoadStartTime = 0;
        int maxLoadEndTime = 0;
        int currentLoad = 0;
        int maxLoad = 0;
        List<Event> eventList = new ArrayList<>();
        for (int[] visit : visitTimes) {
            eventList.add(new Event(visit[0], EventType.ARRIVAL));
            eventList.add(new Event(visit[1], EventType.DEPARTURE));
        }
        Collections.sort(eventList);
        for (int index = 0; index < eventList.size(); index++) {
            Event event = eventList.get(index);
            if (event.type == EventType.ARRIVAL) {
                currentLoad++;
            } else {
                currentLoad--;
            }

            if (currentLoad > maxLoad) {
                maxLoad = currentLoad;
                maxLoadStartTime = event.time;
                if (index + 1 < eventList.size()) {
                    maxLoadEndTime = eventList.get(index + 1).time;
                }
            }
        }
        return new int[]{maxLoadStartTime, maxLoadEndTime};
    }

    static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}