package se.mflodin.yankeeconverter.test;

import se.mflodin.yankeeconverter.YankeeConverterActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

public class YankeeConverterActivityTest extends
		ActivityInstrumentationTestCase2<YankeeConverterActivity> {
    private YankeeConverterActivity mActivity;  // the activity under test
    private TextView mConvertLabel;          // the activity's TextView (the only view)
    private Button mToUSButton;
    private Button mToMetricButton;
    private ListView mConversionList;
    private String convertLabelText;

	public YankeeConverterActivityTest() {
		super("se.mflodin.yankeeconverter", YankeeConverterActivity.class);
	}
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mConvertLabel = (TextView) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.txtConvert);
        mToMetricButton = (Button) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.btnToMetric);
        mToUSButton = (Button) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.btnToUS);
        mConversionList = (ListView) mActivity.findViewById(android.R.id.list);
    	convertLabelText = mActivity.getString(se.mflodin.yankeeconverter.R.string.convertLabel);
    }
    
    public void testPreconditions() {
      assertNotNull(mConvertLabel);
      assertNotNull(mToMetricButton);
      assertNotNull(mToUSButton);
      assertNotNull(mConversionList);
    }
    
    public void testText() {
      assertEquals(convertLabelText,(String)mConvertLabel.getText());
    }
	
	

}
