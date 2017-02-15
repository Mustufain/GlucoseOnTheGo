package com.saad.theglucoseonthego;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LineGraph extends Activity {
	GraphView graphView;

	Bitmap myBitmap;
	ImageView share;
	LinearLayout layout;
	static int imagecount=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line);

		Button daily,weekly,monthly,cap;
		daily=(Button)findViewById(R.id.button1);
		monthly=(Button)findViewById(R.id.button2);
		weekly=(Button)findViewById(R.id.button3);
		graph();

		daily.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				graphView.removeAllSeries();
    			GraphViewSeries Carbohydrate;
				GraphViewSeries Ketones;
				GraphViewSeries Glucose;  

				Glucose = new GraphViewSeries("",new GraphViewSeriesStyle(Color.BLUE,3),new GraphViewData[] {  
					new GraphViewData(1, 40)  
					, new GraphViewData(2, 12)  
					, new GraphViewData(3, 7)
					, new GraphViewData(2, 8)
					, new GraphViewData(2, 10)
					, new GraphViewData(3, 26)
					, new GraphViewData(1, 37)
					, new GraphViewData(1, 53)
					, new GraphViewData(3, 253)

				});

				Carbohydrate= new GraphViewSeries("",new GraphViewSeriesStyle(Color.RED,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(20, 20)  
					, new GraphViewData(65, 65)
					, new GraphViewData(20, 20)
					, new GraphViewData(2, 2)
					, new GraphViewData(30, 30)
					, new GraphViewData(15, 15)
					, new GraphViewData(10, 10)
					, new GraphViewData(3, 3)

				});  

				Ketones = new GraphViewSeries("",new GraphViewSeriesStyle(Color.GREEN,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(20, 20)  
					, new GraphViewData(30, 30)
					, new GraphViewData(20, 20)
					, new GraphViewData(20, 20)
					, new GraphViewData(30, 30)
					, new GraphViewData(10, 10)
					, new GraphViewData(10, 10)
					, new GraphViewData(30, 30)

				}); 

				graphView.addSeries(Glucose); // data
				graphView.addSeries(Carbohydrate);
				graphView.addSeries(Ketones);


			}


		});

		monthly.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				graphView.removeAllSeries(); 
				GraphViewSeries Carbohydrate;
				GraphViewSeries Ketones;
				GraphViewSeries Glucose;  
		 				Glucose = new GraphViewSeries("",new GraphViewSeriesStyle(Color.BLUE,3),new GraphViewData[] {  
					new GraphViewData(0, 0)  
					, new GraphViewData(1, 7)  
					, new GraphViewData(5, 7)
					, new GraphViewData(9, 11)
					, new GraphViewData(12, 12)
					, new GraphViewData(14, 2.5)
					, new GraphViewData(15, 3.9)
					, new GraphViewData(16, 2.4)
					, new GraphViewData(33, 3.7)

				});

				Carbohydrate= new GraphViewSeries("",new GraphViewSeriesStyle(Color.RED,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(20, 20)  
					, new GraphViewData(65, 65)
					, new GraphViewData(20, 20)
					, new GraphViewData(2, 2)
					, new GraphViewData(30, 30)
					, new GraphViewData(15, 15)
					, new GraphViewData(10, 10)
					, new GraphViewData(3, 3)

				});  

				Ketones = new GraphViewSeries("",new GraphViewSeriesStyle(Color.GREEN,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(20, 20)  
					, new GraphViewData(30, 30)
					, new GraphViewData(20, 20)
					, new GraphViewData(20, 20)
					, new GraphViewData(30, 30)
					, new GraphViewData(10, 10)
					, new GraphViewData(10, 10)
					, new GraphViewData(30, 30)

				}); 


				graphView.addSeries(Glucose); // data
				graphView.addSeries(Carbohydrate);
				graphView.addSeries(Ketones);

			}

		});

		weekly.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				graphView.removeAllSeries(); 
				GraphViewSeries Carbohydrate;
				GraphViewSeries Ketones;
				GraphViewSeries Glucose;  
				Glucose = new GraphViewSeries("",new GraphViewSeriesStyle(Color.BLUE,3),new GraphViewData[] {  
					new GraphViewData(1, 40)  
					, new GraphViewData(20, 12)  
					, new GraphViewData(30, 7)
					, new GraphViewData(20, 8)
					, new GraphViewData(20, 10)
					, new GraphViewData(30, 26)
					, new GraphViewData(10, 37)
					, new GraphViewData(10, 53)
					, new GraphViewData(30, 253)

				});

				Carbohydrate= new GraphViewSeries("",new GraphViewSeriesStyle(Color.RED,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(20, 20)  
					, new GraphViewData(65, 65)
					, new GraphViewData(20, 20)
					, new GraphViewData(2, 2)
					, new GraphViewData(30, 30)
					, new GraphViewData(15, 15)
					, new GraphViewData(10, 10)
					, new GraphViewData(3, 3)

				});  

				Ketones = new GraphViewSeries("",new GraphViewSeriesStyle(Color.GREEN,3),new GraphViewData[]{
					new GraphViewData(10, 10)  
					, new GraphViewData(2, 20)  
					, new GraphViewData(3, 30)
					, new GraphViewData(2, 20)
					, new GraphViewData(2, 20)
					, new GraphViewData(3, 30)
					, new GraphViewData(1, 10)
					, new GraphViewData(0, 10)
					, new GraphViewData(3, 30)

				}); 


				graphView.addSeries(Glucose); // data
				graphView.addSeries(Carbohydrate);
				graphView.addSeries(Ketones);

			}


		});

	}

	public void onClick_share(View arg0) {

		imagecount++;
		layout.post(new Runnable() {
			public void run() {

				//take screenshot
				myBitmap = captureScreen(layout);

				Toast.makeText(getApplicationContext(), "Screenshot captured..!", Toast.LENGTH_LONG).show();



			}

		});


		try {
			if(myBitmap!=null){
				//save image to SD card
				saveImage(myBitmap);
			}
			Toast.makeText(getApplicationContext(), "Screenshot saved..!", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		sharingIntent.setType("image/*");
		sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);  	

		String imagePath = Environment.getExternalStorageDirectory() + "/test" + "imagecount" + ".png";  //path of sd card

		File imageFileToShare = new File(imagePath);


		sharingIntent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(imageFileToShare));

		// Verify the intent will resolve to at least one activity
		startActivity(Intent.createChooser(sharingIntent, "Share image using"));

	}

	public static Bitmap captureScreen(View v) {

		Bitmap screenshot = null;
		try {

			if(v!=null) {

				screenshot = Bitmap.createBitmap(v.getMeasuredWidth(),v.getMeasuredHeight(), Config.ARGB_8888);
				Canvas canvas = new Canvas(screenshot);
				v.draw(canvas);
			}

		}catch (Exception e){
			Log.d("ScreenShotActivity", "Failed to capture screenshot because:" + e.getMessage());
		}

		return screenshot;
	}

	public static void saveImage(Bitmap bitmap) throws IOException{

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 40, bytes);
		File f = new File(Environment.getExternalStorageDirectory() + File.separator + "test"+"imagecount"+".png");
		f.createNewFile();
		FileOutputStream fo = new FileOutputStream(f);

		fo.write(bytes.toByteArray());
		fo.close();
	}

	public void graph()
	{
		graphView = new LineGraphView(  
				this // context  
				,"Carbohydrates" + "Ketones" + "Glucose"// heading  
				);

		graphView.setVerticalLabels(new String[] { "14","12","10","8",
				"6","4","2","0" });


		graphView.setHorizontalLabels(new String[] {   "16" + "/" , "7" + "/" , "2014" });
		graphView.setBackgroundColor(getResources().getColor(android.R.color.black));
		layout = (LinearLayout) findViewById(R.id.Linearlayout);  
		layout.setBackgroundColor(Color.BLACK);
		graphView.getGraphViewStyle().setTextSize(11);
		graphView.setTitle( "Glucose:Blue" + "  "+ "Carbohydrate:Red" + "   " + "Ketones:Green");

		layout.addView(graphView);



	}

}
 