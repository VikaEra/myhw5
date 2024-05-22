package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
//import ru.netology.services.VacationService;

public class VacationServiceTest {

    @ParameterizedTest
    //@CsvSource({
    //"10000,3000,20000,3",
    //"100000,60000,150000,2",
    //"0,120667, 160000,0"
    //})

    @CsvFileSource(files = "src/test/resources/vacation.csv")
    public void vacationMonths(int income, int expenses, int threshold, int expected) {
        VacationService service = new VacationService();

        //int income = 10_000;
        //int expenses = 3_000;
        //int threshold = 20_000;
        //int expected = 3;

        int actual = service.calcVacationsMonths(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }

    // @Test
    public void vacationThreeMonths() {
        VacationService service = new VacationService();

        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;
        int expected = 3;

        int actual = service.calcVacationsMonths(10_000, 3_000, 20_000);

        Assertions.assertEquals(expected, actual);
    }

    // @Test
    public void vacationTwoMonths() {
        VacationService service = new VacationService();

        int income = 100_000;
        int expenses = 60_000;
        int threshold = 150_000;
        int expected = 2;

        int actual = service.calcVacationsMonths(100_000, 60_000, 150_000);

        Assertions.assertEquals(expected, actual);
    }

    // @Test
    public void noVacaion() {
        VacationService service = new VacationService();

        int income = 0;
        int expenses = 120_667;
        int threshold = 160_000;
        int expected = 0;

        int actual = service.calcVacationsMonths(0, 120_667, 160_000);

        Assertions.assertEquals(expected, actual);
    }
}
