package pumpsoft.ibm.menu;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import pumpsoft.ibm.R;
import pumpsoft.ibm.net.LoginConstant;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Writing extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writing);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Intent intent = getIntent();
		titleString = intent.getExtras().getString("where");

		setBtnListener();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(Writing.this)
		.setTitle("종료 하시겠습니까?")
		.setIcon(R.drawable.shutdownicon)
		.setCancelable(false)
		.setPositiveButton("예", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// TODO Auto-generated method stub
				finish();
			}
		})
		.setNegativeButton("아니요", null)
		.show();
	}

	private String titleString;

	private TextView title;
	private Button backBtn;
	private Button writeBtn;

	private EditText subjectEditText;
	private EditText contentEditText;
	private ImageView photoImageView;

	private Bitmap bm;
	private String filename;
	private String selectedImagePath;
	private static final int SELECT_PICTURE = 1;
	private String imgPath="";

	private void setBtnListener() {
		title = (TextView)findViewById(R.id.Writing_Title_TextView);
		title.setText(titleString);

		backBtn = (Button)findViewById(R.id.Back_Button);
		backBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Writing.this, DoIt.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		writeBtn = (Button)findViewById(R.id.Write_Button);
		writeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				postData();

				Toast.makeText(Writing.this, "글이 등록되었습니다", Toast.LENGTH_LONG).show();

				Intent intent = new Intent(Writing.this, WritingList.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
			}
		});

		subjectEditText = (EditText)findViewById(R.id.Subject_EditText);
		contentEditText = (EditText)findViewById(R.id.Content_EditText);

		photoImageView = (ImageView)findViewById(R.id.Writing_ImageView);
		photoImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgPath = "";

				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);

				startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
			}
		});
	}

	private void postData() {
		try {
			
			try {
				bm = BitmapFactory.decodeFile(imgPath);
				executeMultipartPost();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Log.d("PBS",filename);
			
			
			HttpClient client = new DefaultHttpClient();

			String postURL = "http://211.109.180.43:9080/Article/InsertArticle";
			HttpPost post = new HttpPost(postURL);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("id", LoginConstant.getId()));
			params.add(new BasicNameValuePair("title", subjectEditText.getText().toString()));
			params.add(new BasicNameValuePair("article", contentEditText.getText().toString()));
			params.add(new BasicNameValuePair("picture", filename));
			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);

			post.setEntity(ent);

			HttpResponse responsePOST = client.execute(post);
			@SuppressWarnings("unused")
			HttpEntity resEntity = responsePOST.getEntity();

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void executeMultipartPost() throws Exception {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			bm.compress(CompressFormat.JPEG, 60, bos);
			byte[] data = bos.toByteArray();

			HttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost("http://211.109.180.43:9080/Image/ImageUpload");
			ByteArrayBody bab = new ByteArrayBody(data, filename);

			MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			reqEntity.addPart("uploaded", bab);

			postRequest.setEntity(reqEntity);
			HttpResponse response = httpClient.execute(postRequest);

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

			String sResponse;
			StringBuilder s = new StringBuilder();

			while ((sResponse = reader.readLine()) != null)
				s = s.append(sResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == SELECT_PICTURE) {
				Uri selectedImageUri = data.getData();

				selectedImagePath = getPath(selectedImageUri);

				StringTokenizer tokenizer = new StringTokenizer(selectedImagePath, "/");
				tokenizer.nextToken();
				while(tokenizer.hasMoreTokens()) {
					filename = tokenizer.nextToken();
					imgPath += "/"+filename;
				}
				
				Calendar oCalendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
				
				//String[] pictureName = filename.split("jpg");
				
				Log.d("PBS",filename.subSequence(0, filename.length()-4).toString()+oCalendar.get(Calendar.DAY_OF_MONTH) + "_" 
						+ oCalendar.get(Calendar.HOUR_OF_DAY) + "_"+oCalendar.get(Calendar.MINUTE)
						+ "_" + oCalendar.get(Calendar.SECOND)+".jpg");
				filename = filename.subSequence(0, filename.length()-4).toString()+oCalendar.get(Calendar.DAY_OF_MONTH) + "_" 
				+ oCalendar.get(Calendar.HOUR_OF_DAY) + "_"+oCalendar.get(Calendar.MINUTE)
				+ "_" + oCalendar.get(Calendar.SECOND)+".jpg";
				photoImageView.setImageURI(selectedImageUri);
			}
		}
	}

	private String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };

		Cursor cursor = managedQuery(uri, projection, null, null, null);

		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

		cursor.moveToFirst();

		return cursor.getString(column_index);
	}

}
