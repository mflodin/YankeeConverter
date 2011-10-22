package se.mflodin.yankeeconverter.test;

import se.mflodin.yankeeconverter.YankeeConverterActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import android.widget.Button;

public class YankeeConverterActivityTest extends
		ActivityInstrumentationTestCase2<YankeeConverterActivity> {
    private YankeeConverterActivity mActivity;  // the activity under test
    private TextView mView;          // the activity's TextView (the only view)
    private Button mToUSButton;
    private Button mToMetricButton;
    private String convertLabel;

	public YankeeConverterActivityTest() {
		super("se.mflodin.yankeeconverter", YankeeConverterActivity.class);
		// TODO Auto-generated constructor stub
	}
	
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (TextView) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.txtConvert);
        mToMetricButton = (Button) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.btnToMetric);
        mToUSButton = (Button) mActivity.findViewById(se.mflodin.yankeeconverter.R.id.btnToUS);
        convertLabel = mActivity.getString(se.mflodin.yankeeconverter.R.string.convertLabel);
    }
    
    public void testPreconditions() {
      assertNotNull(mView);
      assertNotNull(mToMetricButton);
      assertNotNull(mToUSButton);
    }
    
    public void testText() {
      assertEquals(convertLabel,(String)mView.getText());
    }
	
	

}
