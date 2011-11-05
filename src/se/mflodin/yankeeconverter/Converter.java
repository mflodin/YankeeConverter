package se.mflodin.yankeeconverter;

import se.mflodin.yankeeconverter.Converter.Unit;

public class Converter {
	private static final double FEET_PER_METER = 0.3048;
	private static final double FAHRENHEIT_OFFSET = 32.0;
	private static final double FAHRENHEIT_FACTOR = 9.0 / 5.0;
	private static final double KILOGRAMS_PER_POUND = 0.45359237;
	private static final double KILOGRAMS_PER_OUNCE = 0.028349523125;
	private static final double LITERS_PER_GALLON = 3.785412;
	private static final double KILOMETERS_PER_MILE = 1.609344;
	

	public Converter() {
		// TODO Auto-generated constructor stub
	}

	public enum UnitType {
		DISTANCE, MASS, CURRENCY, VOLUME, TEMPERATURE
	}

	public enum Unit {
		METER		(UnitType.DISTANCE, "m"	, 1.0), 
		FOOT		(UnitType.DISTANCE, "'"	, 0.3048),
		KILOMETER	(UnitType.DISTANCE, "km", 1000.0),
		MILE		(UnitType.DISTANCE, "mi", 1609.344),
		CELCIUS		(UnitType.TEMPERATURE, "°C", 1.0, 273.15),
		FAHRENHEIT	(UnitType.TEMPERATURE, "°F", 5.0/9.0, 459.67);

		private UnitType type;
		private String abbreviation;
		private double siEquivalent;
		private double offset;

		Unit(UnitType type, String abbreviation, double siEquivalent) {
			this.type = type;
			this.abbreviation = abbreviation;
			this.siEquivalent = siEquivalent;
		}
		
		Unit(UnitType type, String abbreviation, double siEquivalent, double offset) {
			this.type = type;
			this.abbreviation = abbreviation;
			this.siEquivalent = siEquivalent;
			this.offset = offset;
		}



		public double convertTo(Unit unitToConvertTo, double value) {
			if (type != unitToConvertTo.type) {
				throw new IllegalArgumentException(
						"Units have to be of the same type to convert");
			}

//			// °C = (5/9)*(°F-32)
//			// °F = (9/5)*°C+32
//			[K] = ([°F] + 459.67) × 5⁄9	[°F] = [K] × 9⁄5 − 459.67
			return ((value + offset) * siEquivalent - unitToConvertTo.offset * unitToConvertTo.siEquivalent)
			/ unitToConvertTo.siEquivalent;
		}
		
		public double in(Unit unitToConvertTo) {
			if (type == UnitType.TEMPERATURE) {
				throw new IllegalArgumentException(
						"Cannot convert units which requires offset with this method. Use convertTemperature() instead.");
			}
			return convertTo(unitToConvertTo, 1.0);
		}

	}

	public double fahrenheitToCelcius(double fahrenheit) {
		// Tc = (5/9)*(Tf-32)
		return (fahrenheit - FAHRENHEIT_OFFSET) / FAHRENHEIT_FACTOR;
	}

	public double celciusToFahrenheit(double celcius) {
		// Tf = (9/5)*Tc+32
		return celcius * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
	}

	public double poundsToKilograms(double pounds) {
		return pounds * KILOGRAMS_PER_POUND;
	}

	public double kilogramsToPounds(double kilograms) {
		return kilograms / KILOGRAMS_PER_POUND;
	}

	public double kilogramsToOunces(double kilograms) {
		return kilograms / KILOGRAMS_PER_OUNCE;
	}

	public double ouncesToKilograms(double ounces) {
		return ounces * KILOGRAMS_PER_OUNCE;
	}

	public double gallonsToLiters(double gallons) {
		return gallons * LITERS_PER_GALLON;
	}

	public double litersToGallons(double liters) {
		return liters / LITERS_PER_GALLON;
	}

	public double milesToKilometers(double miles) {
		return miles * KILOMETERS_PER_MILE;
	}

	public double kilometersToMiles(double kilometers) {
		return kilometers / KILOMETERS_PER_MILE;
	}

	public double feetToMeters(double feet) {
		return feet * FEET_PER_METER;
	}

	public double metersToFeet(double meters) {
		return meters / FEET_PER_METER;
	}
}
