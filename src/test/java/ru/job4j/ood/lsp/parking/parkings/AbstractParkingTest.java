package ru.job4j.ood.lsp.parking.parkings;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractParkingTest {

    @Test
    void whenAddParkinOnFiveSizeThenCheckFreePlaceFive() {
        Map<Integer, Boolean[]> map = new HashMap<>();
        Boolean[] array = new Boolean[2];
        Arrays.fill(array, true);
        Boolean[] array1 = new Boolean[3];
        Arrays.fill(array1, true);
        map.put(1, array);
        map.put(2, array1);
        Parking firstParking = new FirstParking(map);
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(firstParking);
        int freePlaces = 5;
        assertThat(firstParking.getFreePlace()).isEqualTo(freePlaces);
    }
}