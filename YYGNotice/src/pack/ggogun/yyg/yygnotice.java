package pack.ggogun.yyg;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;


public class yygnotice  extends TabActivity 
{ 
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) 
    { 
    	
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main); 
        
        TabHost tabHost = getTabHost(); 
        
        TabHost.TabSpec spec;
        //xmlParses xml = new xmlParses();
        
        Log.d("PBS","go the parsing");
        
      
  
   
       
	
	 ArrayList<TextView> strs=new ArrayList<TextView>();
	 TextView str, url_text;
	 str = (TextView)findViewById(pack.ggogun.yyg.R.id.tads);
     TextView tv = null;
     String string;
    
     try {
         //�ļ�
    	 
    	 //URL url = new URL("http://ggogunbm.tistory.com/rss");
    	 URL url = new URL("http://www.yyg.go.kr/open_content/organization/military_news/efocus/rss");
    	 Log.w("PBS",url.openStream().toString());
    	// URLConnection urlc = url.openConnection();
    	
    	 
    	

    	
    	 //InputStream is = urlc.getInputStream();
    	 /* XmlPullParser parser = Xml.newPullParser();
    	 parser.setInput(is, null);
    	
    
    	
	     int parserEvent = parser.getEventType(); 
       
	     
	     while (true) {
	    	 int type=parser.next();
	     
	    	 if (type==XmlPullParser.START_DOCUMENT) {  		// ��ť��Ʈ����
	    		 
	    		 Log.w("PBS","type = End Document");
	    		 
             } else if (type==XmlPullParser.START_TAG) {			// �±׽���
                // string="type=START_TAG"+
                //     ",text="+parser.getText()+
                //     ",depth="+parser.getDepth()+ "name : " +  parser.getName();
                // strs.add(str);
                 //Log.d("PBS",str);	
                 //�Ӽ�
                // str=" attribute,";
               //  for (int i=0;i<parser.getAttributeCount();i++) {
                //     str+=parser.getAttributeName(i)+"="+parser.getAttributeValue(i)+",";    
               //      strs.add(str);
                // }
                 
             } else if (type==XmlPullParser.TEXT) {   			// �ؽ�Ʈ
                 string = "type=TEXT"+
                     ", text= "+parser.getText()+
                     ", depth= "+parser.getDepth()+ "name : " +  parser.getName();
                // strs.add(str);
                 Log.w("PBS",string );
             } else if (type==XmlPullParser.END_TAG) {  			// �±�����
            	 string = "type=END_TAG"
                	 + ",text= " + parser.getText()
                	 + ",depth= " + parser.getDepth();
                 //strs.add(str);
                 
            	 
            	 // Log.w("PBS",string);
            
            
             
             } else if (type==XmlPullParser.END_DOCUMENT) {  	// ��ť��Ʈ����
	              
	    		 Log.w("PBS","type = End Document");
                 break;
             }   
	     }
	     /*
	     while (true) {
             int type=parser.next();
             //��ť��Ʈ����
             if (type==XmlPullParser.START_DOCUMENT) {
              //   str="type=START_DOCUMENT"+
               //      ",text="+parser.getText()+
               //      ",depth="+parser.getDepth() + "name : " +  parser.getName();
                // strs.add(str);
                // Log.d("PBS",str);
             } 
             //�±׽���
             else if (type==XmlPullParser.START_TAG) {
                // str="type=START_TAG"+
                //     ",text="+parser.getText()+
                //     ",depth="+parser.getDepth()+ "name : " +  parser.getName();
                // strs.add(str);
                 //Log.d("PBS",str);	
                 //�Ӽ�
                // str=" attribute,";
               //  for (int i=0;i<parser.getAttributeCount();i++) {
                //     str+=parser.getAttributeName(i)+"="+parser.getAttributeValue(i)+",";    
               //      strs.add(str);
                // }
                 if(parser.getName().equals("title") && parser.getDepth() == 4){
	                 parser.next();
	                 
	                 
	                 tv.setText("Title is"+",text="+parser.getText());
	                 //str="Title is"+
	                 //",text="+parser.getText();
	               
	                
	               
	                 Log.d("PBS",str.toString());
	                 strs.add(tv);
	                 
                 }
             } 
             //�ؽ�Ʈ
             else if (type==XmlPullParser.TEXT) {
               //  str="type=TEXT"+
               //      ",text="+parser.getText()+
               //      ",depth="+parser.getDepth()+ "name : " +  parser.getName();
              //   strs.add(str);
               //  Log.d("PBS",str + "    1");
             } 
             //�±�����
             else if (type==XmlPullParser.END_TAG) {
                // str="type=END_TAG"+
                //     ",text="+parser.getText()+
                //     ",depth="+parser.getDepth();
               //  strs.add(str);
                 //Log.d("PBS",str + "    1");
             } 
             //��ť��Ʈ����
             else if (type==XmlPullParser.END_DOCUMENT) {
               //  str="type=END_DOCUMENT"+
               //      ",text="+parser.getText()+
               //      ",depth="+parser.getDepth();
              
                 break;
             }                
         }*/
      } catch (Exception e) {
         Log.e("PBS","error : " + e.toString());
         Log.d("PBS","go the failse");
     }        

      Log.w("PBS","End Application");
      
      
      
        /*
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setValidating(false);
            XmlPullParser myxml = factory.newPullParser();
            InputStream raw = getApplicationContext().getAssets().open("http://www.yyg.go.kr/open_content/organization/military_news/efocus/rss");
            myxml.setInput(raw, null);
            int eventType = myxml.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_DOCUMENT) {

                   Log.d("PBS", "In start document");
                }
                else if(eventType == XmlPullParser.START_TAG) {
                    Log.d("PBS", "In start tag = "+myxml.getName());
                }
                else if(eventType == XmlPullParser.END_TAG) {
                    Log.d("PBS", "In end tag = "+myxml.getName());

                }
                else if(eventType == XmlPullParser.TEXT) {
                    Log.d("PBS", "Have text = "+myxml.getText());
                }
                eventType = myxml.next();
            }
        } catch (XmlPullParserException e) {
        	Log.d("PBS", "exception");
        	
        } 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d("PBS", "ioexception");
		}
        
*/
	
	
	
	
      
        
        
              
        // ù ��° ��
        spec = tabHost.newTabSpec( "Tab 01" );
        spec.setIndicator( "������Ŀ��", 
        		getResources().getDrawable( R.drawable.icon ) );
        spec.setContent( R.id.TabView1 );
        tabHost.addTab( spec );
        
        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#734512"));  
        // �� �� ����

        
      /*  ArrayList<TextView> listArrray = new ArrayList<TextView>();
		listArrray.add("������");
		
		listArrray.add("�̼���");
		listArrray.add("������");
		listArrray.add("��������");/*/

		final ArrayAdapter<TextView> adapter;
		adapter = new ArrayAdapter<TextView>(this,
				android.R.layout.simple_list_item_1, strs);
		
		final ListView list = (ListView) findViewById(R.id.TabView2);
		
		list.setAdapter(adapter);

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView listview, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				//Toast awesomeToast = Toast.makeText(yygnotice.this, adapter.getItem(position),Toast.LENGTH_SHORT);
				//awesomeToast.show();
				
			}
		});
        
        
        
        
        
        
        
        
        
        // �� ��° ��
        spec = tabHost.newTabSpec( "Tab 02" );
        spec.setIndicator( "�����Խ���" );
        spec.setContent( R.id.TabView2 );
        tabHost.addTab( spec );
        
        // �� ��° ��
        spec = tabHost.newTabSpec( "Tab 03" );
        spec.setIndicator( "�������������" );
        spec.setContent( R.id.TabView3 );
        tabHost.addTab( spec );
        
        tabHost.setCurrentTab( 1 );
    } 
} 