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
	
	//	Lbs -> kg
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
	
	public void testConvertFromOunceToKilograms(){
		float ounces = 1.0f;
		float expectedKilograms = 0.028349523125f;
		float kilograms = converter.ouncesToKilograms(ounces);
		assertEquals(expectedKilograms, kilograms);
	}
	
	public void testConvertFromKilogramsToOunces() {
		float kilogram = 1.0f;
		float expectedOunces = 1 / 0.028349523125f;
		float ounces = converter.kilogramsToOunces(kilogram);
		assertEquals(expectedOunces, ounces);
	}
	
	public void testConvertFromGallonsToLiters() {
		float gallon = 1.0f;
		float expectedLiters = 3.785412f;
		float litres = converter.gallonsToLiters(gallon);
		assertEquals(expectedLiters, litres);
	}
	
	public void testConvertFromLitersToGallons() {
		float liter = 1.0f;
		float expectedGallons = 1 / 3.785412f;
		float gallons = converter.litersToGallons(liter);
		assertEquals(expectedGallons, gallons);
	}
	
	public void testConvertFromMilesToKilometers() {
		float mile = 1.0f;
		float expectedKilometers = 1.609344f;
		float kilometers = converter.milesToKilometers(mile);
		assertEquals(expectedKilometers, kilometers);
	}
	
	public void testConvertFromKilometersToMiles() {
		float kilometer = 1.0f;
		float expectedMiles = 1 / 1.609344f;
		float miles = converter.kilometersToMiles(kilometer);
		assertEquals(expectedMiles, miles);
	}
	
	public void testConvertFromFeetToMeters() {
		float feet = 1.0f;
		float expectedMeters = 0.3048f;
		float meters = converter.feetToMeters(feet);
		assertEquals(expectedMeters, meters);
	}
	
	public void testConvertFromMetersToFeets() {
		float meter = 1.0f;
		float expectedFeets = 1 / 0.3048f;
		float feet = converter.metersToFeet(meter);
		assertEquals(expectedFeets, feet);
	}
	
	
	

//	ounce -> kg
//	Gallon -> liter
//	$ -> kr (manuellt uppdatera i settings, behover ju inte sa extakt)
//	miles -> m (eller km, men en tydlig avgransare funkar med)
//	feet -> m
//	inch -> m
//
//	en intressant grej ar ju ocksa jamforspriser
//	$/lbs -> kr/kg
//	$/gallon -> kr/l
	
//	1 minim (min)	~ 1 drop or 0.95 grain of water	61.61152 μL
//	1 US fluid dram (fl dr)	60 min	3.696691 mL
//	1 teaspoon (tsp)	80 min	4.928921 mL
//	1 tablespoon (Tbsp)	3 tsp or 4 fl dr	14.78676 mL
//	1 US fluid ounce (fl oz)	2 Tbsp or 1.041 oz av of water	29.57353 mL
//	1 jigger (jig)	3 Tbsp	44.36028 mL
//	1 US gill (gi)	4 fl oz	118.2941 mL
//	1 US cup (cp)	2 gi or 8 fl oz	236.5882 mL
//	1 (liquid) US pint (pt)	2 cp or 16.65 oz av of water	473.1765 mL
//	1 (liquid) US quart (qt)	2 pt	0.9463529 L
//	1 (liquid) US gallon (gal)	4 qt or 231 cu in	3.785412 L
//	1 (liquid) barrel (bbl)	31.5 gal or 1⁄2 hogshead	119.2405 L
//	1 oil barrel (bbl)	42 gal or 2⁄3 hogshead	158.9873 L
//	1 hogshead	63 gal or 8.421875 cu ft
//	or 524.7 lb of water	238.4810 L
	
//	1 grain (gr)	1⁄7000 lb	64.79891 mg
//	1 dram (dr)	27 11⁄32 gr	1.7718451953 g
//	1 ounce (oz)	16 dr	28.349523125 g
//	1 pound (lb)	16 oz	453.59237 g
//	1 US hundredweight (cwt)	100 lb	45.359237 kg
//	1 long hundredweight	112 lb	50.80224544 kg
//	1 short ton	20 US cwt or 2000 lb	907.18474 kg
//	1 long ton	20 long cwt or 2240 lb	1016.0469088 kg
//	Troy
//	1 grain (gr)	1⁄7000 lb av or 1⁄5760 lb t	64.79891 mg
//	1 pennyweight (dwt)	24 gr or 7.776 carats	1.55517384 g
//	1 troy ounce (oz t)	20 dwt	31.1034768 g
//	1 troy pound (lb t)	12 oz t or 13.17 oz av	373.2417216 g
	
//	1 point (p)		352.8  µm
//	1 pica (P)	12/p	4.233 mm
//	1 inch (in)	6/P	2.54 cm
//	1 foot (ft)	12 in	0.3048 m[8]
//	1 yard (yd)	3 ft	0.9144 m[8]
//	1 mile (mi)	5280 ft	1.609344 km
//	Survey
//	1 link (li)	33⁄50 ft or 7.92 in	2.012 dm
//	1 (survey) foot (ft)	1200⁄3937 m	0.30480061 m[8]
//	1 rod (rd)	25 li or 16.5 ft	5.029210 m
//	1 chain (ch)	4 rd	2.011684 da m
//	1 furlong (fur)	10 ch	2.011 684 hm
//	1 survey (or statute) mile (mi)	8 fur	1.609347 km[8]
//	1 league (lea)	3 mi	4.828042 km
//	Nautical
//	1 fathom (ftm)	2 yd	1.8288 m
//	1 cable (cb)	120 ftm or 1.091 fur	2.19456 hm
//	1 nautical mile (NM or nmi)	8.439 cb or 1.151 mi	1.852 km
	
	
}
