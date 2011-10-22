package se.mflodin.yankeeconverter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class YankeeConverterActivity extends ListActivity{
	private ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter listAdapter;
    private Converter converter;
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
       
       converter = new Converter();
       
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

	private void populateToMetricList(float value) {
		addItem("lb => kg", converter.poundsToKilograms(value));
		addItem("°F => °C", converter.fahrenheitToCelcius(value));
		listAdapter.notifyDataSetChanged();
	}
	
	private void populateToUSList(float value) {
		addItem( "kg => lb", converter.kilogramsToPounds(value) );
		addItem( "°C => °F", converter.celciusToFahrenheit(value) );
		listAdapter.notifyDataSetChanged();
	}
	
	private void addItem(String label, float value){
		  HashMap<String,String> listItem = new HashMap<String,String>();
		  listItem.put( "label", label );
		  listItem.put( "value", Float.toString(value));
		  list.add( listItem );
	}
	
	private float getValueFromEditText(){
		String enteredText = mEditValue.getText().toString();
		if (enteredText == null || enteredText.length() == 0){
			return 0f;
		}
		
		return Float.parseFloat(enteredText);
	
	}



}