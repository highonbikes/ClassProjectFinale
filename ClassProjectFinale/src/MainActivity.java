import java.util.Random;

import com.androidclass.classprojectfinale.R;



import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	TextView mText;
	ImageButton[] mButton; // , mButton2, mButton3, mButton4;
	int myResult;
	String output;
	int workers, goods, curses, food, mix, coins;
	boolean[] locked = new boolean[4];

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dicephase);
		loader();

	}

	private void loader() {
		// TODO Auto-generated method stub
		mText = (TextView) findViewById(R.id.textView2);
		mButton[1] = (ImageButton) findViewById(R.id.imageButton1);
		mButton[2] = (ImageButton) findViewById(R.id.imageButton2);
		mButton[3] = (ImageButton) findViewById(R.id.imageButton3);
		mButton[4] = (ImageButton) findViewById(R.id.button2);
		mButton[1].setOnClickListener(this);
		mButton[2].setOnClickListener(this);
		mButton[3].setOnClickListener(this);
		mButton[4].setOnClickListener(this);
		workers = 0;
		goods = 0;
		curses = 0;
		food = 0;
		mix = 0;
		coins = 0;
		locked[1] = false;
		locked[2] = false;
		locked[3] = false;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button2:
			for (int x = 1; x < 4; x++) {
				if (locked[x] == false) {
					myResult = new Random(System.currentTimeMillis())
							.nextInt(6) + 1;
					rollDice(mButton[x]);
				}
			}
			break;

		case R.id.imageButton1:
			if (locked[1] == false)
				locked[1] = true;
			else
				locked[1] = false;

			break;
		case R.id.imageButton2:
			if (locked[2] == false)
				locked[2] = true;
			else
				locked[2] = false;

			break;
		case R.id.imageButton3:
			if (locked[3] == false)
				locked[3] = true;
			else
				locked[3] = false;

			break;
		}
	}

	private void rollDice(ImageButton rolled) {
		switch (myResult) {
		case 1:
			rolled.setImageResource(R.drawable.one);
			food = food + 3;
			break;
		case 2:
			rolled.setImageResource(R.drawable.two);
			goods = goods + 1;
			break;
		case 3:
			rolled.setImageResource(R.drawable.three);
			goods = goods + 2;
			curses = curses + 1;
			break;
		case 4:
			rolled.setImageResource(R.drawable.four);
			workers = workers + 3;
			break;
		case 5:
			rolled.setImageResource(R.drawable.five);
			mix = mix + 2;
			break;
		case 6:
			rolled.setImageResource(R.drawable.six);
			coins = coins + 1;
			break;
		}
	}
}