package ru.job4j.algo.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int index = 0; index < gas.length; index++) {
            totalGas = totalGas + gas[index];
            totalCost = totalCost + cost[index];
            tank = tank + (gas[index] - cost[index]);
            if (tank < 0) {
                tank = 0;
                start = index + 1;
            }
        }
        return (totalGas - totalCost) >= 0 ? start : -1;
    }
}