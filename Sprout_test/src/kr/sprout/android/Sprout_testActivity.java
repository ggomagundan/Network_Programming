package kr.sprout.android;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Sprout_testActivity extends Activity {
    /** Called when the activity is first created. */
	EditText msg_text;
	Button msg_send;
	private OutputStream out = null;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	//C2DM 등록ID 발급
	Intent registrationIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
	registrationIntent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0)); // 어플리케이션ID
	registrationIntent.putExtra("sender", "ggogun@gmail.com"); //개발자ID
	startService(registrationIntent); //서비스 시작(등록ID발급받기)
	                 // 위에서 지정한 "app"와 "sender"은 맘대로 지정하시는게 아니라 구글에서 필요한 변수명들입니다.
	        
	        
	        msg_text = (EditText)findViewById(R.id.msg_text);
	        msg_send = (Button)findViewById(R.id.msg_send);
	        
	        msg_send.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
	// TODO Auto-generated method stub
	try {
	// 메시지를 보낼때 sender(발급받은 ID, 토큰인증값, 메시지)
	sender(C2dm_BroadcastReceiver.registration_id,getAuthToken(),msg_text.getText().toString());
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	});
	    }
	    
	    public void sender(String regId,String authToken,String msg) throws Exception{
	     StringBuffer postDataBuilder = new StringBuffer();
	        
	     postDataBuilder.append("registration_id="+regId); //등록ID
	     postDataBuilder.append("&collapse_key=1"); 
	     postDataBuilder.append("&delay_while_idle=1");
	     postDataBuilder.append("&data.msg="+URLEncoder.encode(msg, "UTF-8")); //태울 메시지

	        byte[] postData = postDataBuilder.toString().getBytes("UTF8");

	        URL url = new URL("https://android.apis.google.com/c2dm/send");
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setUseCaches(false);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
	        conn.setRequestProperty("Authorization", "GoogleLogin auth=" + authToken);

	        OutputStream out = conn.getOutputStream();
	        out.write(postData);
	        out.close();

	        conn.getInputStream();


	    }
	    
	    public String getAuthToken() throws Exception{
	     String authtoken = "";
	        
	     StringBuffer postDataBuilder = new StringBuffer();
	        postDataBuilder.append("accountType=HOSTED_OR_GOOGLE"); //똑같이 써주셔야 합니다.
	        postDataBuilder.append("&Email=ggogun@gmail.com");  //개발자 구글 id
	        postDataBuilder.append("&Passwd=wldnjs12");           //개발자 구글 비빌번호
	        postDataBuilder.append("&service=ac2dm");
	        postDataBuilder.append("&source=test-1.0");

	        byte[] postData = postDataBuilder.toString().getBytes("UTF8");

	        URL url = new URL("https://www.google.com/accounts/ClientLogin");
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setUseCaches(false);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", Integer.toString(postData.length));

	        
	        OutputStream out = conn.getOutputStream();
	        out.write(postData);
	        out.close();

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String sidLine = br.readLine();
	        String lsidLine = br.readLine();
	        String authLine = br.readLine();
	        
	        System.out.println("sidLine----------->>>"+sidLine);
	        System.out.println("lsidLine----------->>>"+lsidLine);
	        System.out.println("authLine----------->>>"+authLine);
	        System.out.println("AuthKey----------->>>"+authLine.substring(5, authLine.length()));
	        
	        authtoken = authLine.substring(5, authLine.length());
	        
	     return authtoken;
	    }
}