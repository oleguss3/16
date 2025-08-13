package ru.netology.stats;

public class StatsService {

    // 1) Сумма всех продаж
    public long sum(long[] sales) {
        long total = 0;
        for (long s : sales) {
            total += s;
        }
        return total;
    }

    // 2) Средняя сумма продаж в месяц (целочисленно)
    public long average(long[] sales) {
        if (sales == null || sales.length == 0) {
            return 0;
        }
        return sum(sales) / sales.length;
    }

    // 3) Номер месяца последнего пика (максимум), месяцы нумеруются с 1
    public int maxSalesMonth(long[] sales) {
        int maxMonth = 0; // индекс последнего максимума на данный момент
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // ">=" чтобы брать последний максимум
                maxMonth = i;
            }
        }
        return maxMonth + 1;
    }

    // 4) Номер месяца последнего минимума, месяцы с 1
    public int minSalesMonth(long[] sales) {
        int minMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // "<=" чтобы брать последний минимум
                minMonth = i;
            }
        }
        return minMonth + 1;
    }

    // 5) Кол-во месяцев с продажами ниже среднего (строго меньше)
    public int countBelowAverage(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long s : sales) {
            if (s < avg) {
                count++;
            }
        }
        return count;
    }

    // 6) Кол-во месяцев с продажами выше среднего (строго больше)
    public int countAboveAverage(long[] sales) {
        long avg = average(sales);
        int count = 0;
        for (long s : sales) {
            if (s > avg) {
                count++;
            }
        }
        return count;
    }
}
