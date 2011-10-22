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
		float fahrenheit = 0.0f;
		float expectedCelsius = 32.0f;
		float celsius = converter.fahrenheitToCelcius(fahrenheit);
		assertTrue(celsius == expectedCelsius);
		
	}


}
