package se.mflodin.yankeeconverter;

public class Converter {
	final float FAHRENHEIT_OFFSET = 32.0f;
	final float FAHRENHEIT_FACTOR = 9.0f/5.0f;

	public Converter() {
		// TODO Auto-generated constructor stub
	}
	
	public float fahrenheitToCelcius(float degrees){
		return degrees * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
	}

}
