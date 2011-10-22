package se.mflodin.yankeeconverter;

public class Converter {
	private final float FAHRENHEIT_OFFSET = 32.0f;
	private final float FAHRENHEIT_FACTOR = 9.0f/5.0f;
	private final float POUND_FACTOR = 0.45359237f;
	
//	public final enum UNITS {
//		
//		
//	}

	public Converter() {
		// TODO Auto-generated constructor stub
	}
	
	public float fahrenheitToCelcius(float degrees){
		// Tc = (5/9)*(Tf-32)
		return (degrees - FAHRENHEIT_OFFSET) / FAHRENHEIT_FACTOR;
	}

	public float celciusToFahrenheit(float degrees) {
		// Tf = (9/5)*Tc+32
		return degrees * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
	}

	public float poundsToKilograms(float pounds) {
		return pounds * POUND_FACTOR;
	}
	
	public float kilogramsToPounds(float kilograms) {
		return kilograms / POUND_FACTOR;
	}
	
	//private float fromSI(float value, )

}
