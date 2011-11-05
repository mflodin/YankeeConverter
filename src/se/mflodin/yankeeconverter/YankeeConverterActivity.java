package se.mflodin.yankeeconverter;

import java.util.ArrayList;
import java.util.HashMap;

import se.mflodin.yankeeconverter.Converter.Unit;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class YankeeConverterActivity extends ListActivity{
	private static final String PREFS_NAME = "YankeeConverterSettings";
	private static final String PREFKEY_PRECISION = "Precision";
	private static final int DEFAULT_PRECISION = 2;
	private static final String PREFKEY_EXCHANGE_RATE_SEK = "ExchangeRateSEK";
	private static final float DEFAULT_EXCHANGE_RATE_SEK = 6.58692101f; 
	private ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter listAdapter;
    //private final static int ADD_ITEM_ID = 1;
    private Button mToUSButton;
    private Button mToMetricButton;
    private EditText mEditValue;
    

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       
       // Restore preferences
       SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
       float exchangeRateSEK = settings.getFloat(PREFKEY_EXCHANGE_RATE_SEK, DEFAULT_EXCHANGE_RATE_SEK);
       Unit.SEK.setExchangeRate(exchangeRateSEK);
       
       int precision = settings.getInt(PREFKEY_PRECISION, DEFAULT_PRECISION);
       Unit.precision = precision;
       
       listAdapter = new SimpleAdapter( 
				this, 
				list,
				R.layout.list_item,
				new String[] { "label","value" },
				new int[] { R.id.itemUnit, R.id.itemValue }  );
       setListAdapter( listAdapter );
       
       mToUSButton = (Button) findViewById(R.id.btnToUS);
       mToUSButton.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
           	
               list.clear();
               populateToUSList(getValueFromEditText());
             }
         });
       
       mToMetricButton = (Button) findViewById(R.id.btnToMetric);
       mToMetricButton.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
               list.clear();
               populateToMetricList(getValueFromEditText());
             }
         });
       
       mEditValue = (EditText) findViewById(R.id.editValue);
    }
    
    @Override
    protected void onStop(){
       super.onStop();

      // We need an Editor object to make preference changes.
//      // All objects are from android.context.Context
//      SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
//      SharedPreferences.Editor editor = settings.edit();
//      editor.putFloat(PREFKEY_EXCHANGE_RATE_SEK, someFloat);
//      editor.putInt(PREFKEY_PRECISION, someInt);
//      // Commit the edits!
//      editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      boolean result = super.onCreateOptionsMenu(menu);
      //menu.add(0, ADD_ITEM_ID, Menu.NONE, R.string.add_item );
      return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch ( item.getItemId() ) {
//          case ADD_ITEM_ID:
//        	  	populateToMetricList(100f);
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }

	private void populateToMetricList(double value) {
		addConversion(Unit.POUND,		Unit.KILOGRAM, 	value);
		addConversion(Unit.OUNCE,		Unit.KILOGRAM, 	value);
		addConversion(Unit.GALLON,		Unit.LITER, 	value);
		addConversion(Unit.MILE,		Unit.KILOMETER, value);
		addConversion(Unit.FOOT,		Unit.METER, 	value);
		addConversion(Unit.INCH,		Unit.METER, 	value);
		addConversion(Unit.FAHRENHEIT, 	Unit.CELCIUS, 	value);
		addConversion(Unit.USD, 		Unit.SEK, 		value);
		listAdapter.notifyDataSetChanged();
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
	
	private void populateToUSList(double value) {
		addConversion(Unit.KILOGRAM, 	Unit.POUND, 		value);
		addConversion(Unit.KILOGRAM, 	Unit.OUNCE, 		value);
		addConversion(Unit.LITER, 		Unit.GALLON, 		value);
		addConversion(Unit.KILOMETER, 	Unit.MILE, 			value);
		addConversion(Unit.METER, 		Unit.FOOT, 			value);
		addConversion(Unit.METER, 		Unit.INCH, 			value);
		addConversion(Unit.CELCIUS, 	Unit.FAHRENHEIT,	value);
		addConversion(Unit.SEK, 		Unit.USD, 			value);
		listAdapter.notifyDataSetChanged();
	}
	
	private void addItem(String label, double value){
		  HashMap<String,String> listItem = new HashMap<String,String>();
		  listItem.put( "label", label );
		  listItem.put( "value", Double.toString(value));
		  list.add( listItem );
	}
	
	private void addConversion(Unit startUnit, Unit otherUnit, double value){
		String label = startUnit.abbreviation + " => " + otherUnit.abbreviation;
		addItem(label, startUnit.convertTo(otherUnit, value));
	}
	
	private double getValueFromEditText(){
		String enteredText = mEditValue.getText().toString();
		if (enteredText == null || enteredText.length() == 0){
			return 0f;
		}
		return Double.parseDouble(enteredText);
	}
}