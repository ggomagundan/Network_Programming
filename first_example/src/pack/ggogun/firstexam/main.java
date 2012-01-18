package pack.ggogun.firstexam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class main extends Activity implements View.OnClickListener{
	private Button button;
	private ImageButton imageButton;
	@Override
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundColor(Color.WHITE);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		Button button = new Button(this);
		button.setText("¹öÆ°");
		button.setOnClickListener(this);
		setLLParams(button);
		layout.addView(button);
		
		Bitmap image = BitmapFactory.decodeResource(
				this.getResources(), R.drawable.icon);
		imageButton = new ImageButton(this);
		imageButton.setImageBitmap(image);
		imageButton.setOnClickListener(this);
		setLLParams(imageButton);
		layout.addView(imageButton);
	}
	
	public void onClick(View view){
		//showDialog(this,"",view.toString());
		if(view == button){
			showDialog(this, "", "button clicked");
		} else if(view == imageButton){
			showDialog(this, "", "imageButton clicked");
		}
	}
	private static void showDialog(final Activity activity, String title, String text){
		AlertDialog.Builder ad = new AlertDialog.Builder(activity);
		ad.setTitle(title);
		ad.setMessage(text);
		ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			
			public void onClick(DialogInterface dialog, int whichButton){
				activity.setResult(Activity.RESULT_OK);
			}
		});
		ad.create();
		ad.show();
	}
	private static void setLLParams(View view){
		view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
		LinearLayout.LayoutParams.WRAP_CONTENT));
		}

}