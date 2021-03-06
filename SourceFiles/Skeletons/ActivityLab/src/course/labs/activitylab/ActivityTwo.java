package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
    private int mCreate = 0;
    private int mStart = 0;
    private int mResume = 0;
    private int mRestart = 0;

    private TextView mTvCreate;
    private TextView mTvStart;
    private TextView mTvResume;
    private TextView mTvRestart;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);


        mTvCreate = (TextView) findViewById(R.id.create);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvRestart = (TextView)findViewById(R.id.restart);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// This function closes Activity Two
				// Hint: use Context's finish() method
               ActivityTwo.this.finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
            mCreate = savedInstanceState.getInt("mCreate");
            mStart = savedInstanceState.getInt("mStart");
            mResume = savedInstanceState.getInt("mResume");
            mRestart = savedInstanceState.getInt("mRestart");
		}

		// Emit LogCat message
        Log.i(TAG, "Entered the onCreate() method");
        mCreate++;

		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
        displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

        Log.i(TAG, "Entered the onStart() method");
		// Update the appropriate count variable
		// Update the user interface
        mStart++;
        displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
        Log.i(TAG, "Entered the onResume() method");
		// Update the appropriate count variable
		// Update the user interface
        mResume++;
        displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();
        Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();
        Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();
        Log.i(TAG, "Entered the onRestart() method");
		// Update the appropriate count variable
		// Update the user interface
        mRestart++;
        displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
        Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("mCreate", mCreate);
        savedInstanceState.putInt("mStart", mStart);
        savedInstanceState.putInt("mResume", mResume);
        savedInstanceState.putInt("mRestart", mRestart);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	}
}
