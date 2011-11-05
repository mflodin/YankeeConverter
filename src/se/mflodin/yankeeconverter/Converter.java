package se.mflodin.yankeeconverter;

public class Converter {
	private static final int PRECISION = 2;

	public enum UnitType {
		DISTANCE, MASS, CURRENCY, VOLUME, TEMPERATURE
	}

	public enum Unit {
		METER		(UnitType.DISTANCE, 	"m"	, 1.0), 
		FOOT		(UnitType.DISTANCE, 	"ft", 0.3048),
		INCH		(UnitType.DISTANCE, 	"in", 0.0254),
		KILOMETER	(UnitType.DISTANCE, 	"km", 1000.0),
		MILE		(UnitType.DISTANCE, 	"mi", 1609.344),
		KELVIN		(UnitType.TEMPERATURE, 	"K" , 1.0),
		CELCIUS		(UnitType.TEMPERATURE, 	"°C", 1.0, 273.15),
		FAHRENHEIT	(UnitType.TEMPERATURE, 	"°F", 5.0/9.0, 459.67),
		KILOGRAM	(UnitType.MASS, 		"kg", 1.0),
		POUND		(UnitType.MASS, 		"lb", 0.45359237),
		OUNCE		(UnitType.MASS, 		"oz", 0.028349523125),
		LITER		(UnitType.VOLUME, 		"l", 1.0),
		GALLON		(UnitType.VOLUME, 		"gal", 3.785412),
		USD			(UnitType.CURRENCY, 	"$", 1.0),
		SEK			(UnitType.CURRENCY, 	"kr", 1 / 6.58692101);
		
		public final UnitType type;
		public final String abbreviation;
		private double siEquivalent;
		private double offset;
		public static int precision = 2;

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
		
		public void setExchangeRate(double costOfOneUSD) {
			if (type != UnitType.CURRENCY) {
				throw new IllegalArgumentException(
				"Can only set exchange rate of currencies");
			}
			
			if (this == USD) {
				throw new IllegalArgumentException(
						"USD is used as index for currencies and can thus not be set");
			}
			
			this.siEquivalent = 1 / costOfOneUSD;
		}

		public static double round(double value, int precision){
			double factor = Math.pow(10, precision);
			return Math.round(value * factor) / factor;
		}

		public double convertTo(Unit unitToConvertTo, double value) {
			if (type != unitToConvertTo.type) {
				throw new IllegalArgumentException(
						"Units have to be of the same type to convert");
			}

			// °C = (5/9)*(°F-32)
			// °F = (9/5)*°C+32
			//[K] = ([°F] + 459.67) × 5⁄9	[°F] = [K] × 9⁄5 − 459.67
			return round(
					((value + offset) * siEquivalent - unitToConvertTo.offset * unitToConvertTo.siEquivalent)
					/ unitToConvertTo.siEquivalent
					, precision);
		}

	}
}
