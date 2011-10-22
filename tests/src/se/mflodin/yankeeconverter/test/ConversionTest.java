/**
 * 
 */
package se.mflodin.yankeeconverter.test;

import junit.framework.TestCase;
import se.mflodin.yankeeconverter.*;

/**
 * @author mflodin
 *
 */
public class ConversionTest extends TestCase {
	Converter converter;


	public ConversionTest() {
		converter = new Converter();
	}
	
	public void testConvertFromFahrenheitToCelsius(){
		float fahrenheit = 32.0f;
		float expectedCelsius = 0.0f;
		float celsius = converter.fahrenheitToCelcius(fahrenheit);
		assertEquals(expectedCelsius, celsius);
		
		fahrenheit = 212.0f;
		expectedCelsius = 100.0f;
		celsius = converter.fahrenheitToCelcius(fahrenheit);
		assertEquals(expectedCelsius, celsius);
	}

	public void testConvertFromCelsiusToFahrenheit(){
		float celsius = 100.0f;
		float expectedFahrenheit = 212.0f;
		float fahrenheit = converter.celciusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit);
		
		celsius = 0.0f;
		expectedFahrenheit = 32.0f;
		fahrenheit = converter.celciusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit);
	}
	
	public void testConvertFromPoundsToKilograms(){
		float pounds = 1.0f;
		float expectedKilograms = 0.45359237f;
		float kilograms = converter.poundsToKilograms(pounds);
		assertEquals(expectedKilograms, kilograms);
	}
	
	public void testConvertFromKilogramsToPounds(){
		float kilograms = 1.0f;
		float expectedPounds = 1 / 0.45359237f;
		float pounds = converter.kilogramsToPounds(kilograms);
		assertEquals(expectedPounds, pounds);
	}
	

}
