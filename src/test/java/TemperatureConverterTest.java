import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();
    private static final double DELTA = 0.0001;

    @Test
    void fahrenheitToCelsius_basicCases() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), DELTA);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), DELTA);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), DELTA);
    }

    @Test
    void celsiusToFahrenheit_basicCases() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), DELTA);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), DELTA);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), DELTA);
    }
    @Test
    void kelvinToCelsius_basicCases() {
        assertEquals(26.85, converter.kelvinToCelsius(300), DELTA);
        assertEquals(-273.15, converter.kelvinToCelsius(0), DELTA);


    }


    @Test
    void isExtremeTemperature_limitsAndNormal() {
        assertTrue(converter.isExtremeTemperature(-41));
        assertTrue(converter.isExtremeTemperature(51));

        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(50));
        assertFalse(converter.isExtremeTemperature(20));
    }
}