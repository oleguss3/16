package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsServiceTest {

    private final long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    private final StatsService service = new StatsService();

    @Test
    void shouldCalculateSum() {
        long expected = 180;
        long actual = service.sum(sales);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateAverage() {
        long expected = 15; // 180 / 12
        long actual = service.average(sales);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMaxMonth_LastOccurrence() {
        int expected = 8; // максимум 20 в месяцах 6 и 8 -> берём последний (8)
        int actual = service.maxSalesMonth(sales);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMinMonth_LastOccurrence() {
        int expected = 9; // минимум 7 в 9-м месяце
        int actual = service.minSalesMonth(sales);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCountBelowAverage() {
        int expected = 5; // 8, 13, 7, 14, 14
        int actual = service.countBelowAverage(sales);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCountAboveAverage() {
        int expected = 5; // 17, 20, 19, 20, 18
        int actual = service.countAboveAverage(sales);
        assertEquals(expected, actual);
    }
}
