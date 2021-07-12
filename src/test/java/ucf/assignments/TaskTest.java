package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest
{

    @Test
    void testToString()
    {
        //Given...
        //String literal expected "Cleaning, due 2021-07-26. Not Done".
        String expected = "Cleaning, due 2021-07-26. Not done";
        //Task result("Cleaning", 2021-07-26)
        Task task = new Task(LocalDate.parse("2021-07-26"), "Cleaning");

        //When...
        //Expected calls toString
        //Save result on String vars
        String result = task.toString();

        //Then...
        //Assert expected == result
        assertEquals(expected, result);
    }
}