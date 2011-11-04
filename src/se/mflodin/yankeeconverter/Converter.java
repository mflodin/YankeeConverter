package se.mflodin.yankeeconverter;

public class Converter {
	private static final float FEET_PER_METER = 0.3048f;
	private static final float FAHRENHEIT_OFFSET = 32.0f;
	private static final float FAHRENHEIT_FACTOR = 9.0f/5.0f;
	private static final float KILOGRAMS_PER_POUND = 0.45359237f;
	private static final float KILOGRAMS_PER_OUNCE = 0.028349523125f;
	private static final float LITERS_PER_GALLON = 3.785412f;
	private static final float KILOMETERS_PER_MILE = 1.609344f;
	
	
//	public final enum UNITS {
//		
//		
//	}

	public Converter() {
		// TODO Auto-generated constructor stub
	}
	
	public float fahrenheitToCelcius(float fahrenheit){
		// Tc = (5/9)*(Tf-32)
		return (fahrenheit - FAHRENHEIT_OFFSET) / FAHRENHEIT_FACTOR;
	}

	public float celciusToFahrenheit(float celcius) {
		// Tf = (9/5)*Tc+32
		return celcius * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
	}

	public float poundsToKilograms(float pounds) {
		return pounds * KILOGRAMS_PER_POUND;
	}
	
	public float kilogramsToPounds(float kilograms) {
		return kilograms / KILOGRAMS_PER_POUND;
	}

	public float kilogramsToOunces(float kilograms) {
		return kilograms / KILOGRAMS_PER_OUNCE;
	}

	public float ouncesToKilograms(float ounces) {
		return ounces * KILOGRAMS_PER_OUNCE;
	}

	public float gallonsToLiters(float gallons) {
		return gallons * LITERS_PER_GALLON;
	}

	public float litersToGallons(float liters) {
		return liters / LITERS_PER_GALLON;
	}

	public float milesToKilometers(float miles) {
		return miles * KILOMETERS_PER_MILE;
	}

	public float kilometersToMiles(float kilometers) {
		return kilometers / KILOMETERS_PER_MILE;
	}

	public float feetToMeters(float feet) {
		return feet * FEET_PER_METER;
	}

	public float metersToFeet(float meters) {
		return meters / FEET_PER_METER;
	}
	
	//private float fromSI(float value, )

}
