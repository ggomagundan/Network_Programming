package pack.ggogun.livewall;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class LiveWallpaperEx extends WallpaperService{
	
	@Override
	public void onCreate(){
		super.onCreate();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	
	@Override
	public WallpaperService.Engine onCreateEngine(){
		return new WallpaperEngine(getResources());
	}
	
	public class WallpaperEngine extends WallpaperService.Engine{
		private final Handler handler = new Handler();
		
		private Bitmap image;
		private int px = 0;
		private int py = 0;
		private int vx = 10;
		private int vy = 10;
		
		private boolean visible;
		private int width;
		private int height;
		
		private final Runnable drawThread = new Runnable(){
			public void run(){
				drawFrame();
			}
		};
		
		public WallpaperEngine(Resources r){
			image = BitmapFactory.decodeResource(r, R.drawable.icon);
		}
		
		@Override
		public void onCreate(SurfaceHolder surfaceHolder){
			super.onCreate(surfaceHolder);
		}
		
		@Override
		public void onDestroy(){
			super.onDestroy();
			handler.removeCallbacks(drawThread);
		}
		
		public void onVisiblityChanged(boolean visible){
			this.visible = visible;
			if(visible){
				drawFrame();
			} else {
				handler.removeCallbacks(drawThread);
			}
		}
		
		@Override
		public void onSurfaceCreated(SurfaceHolder holder){
			super.onSurfaceCreated(holder);
		}
		
		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height){
			super.onSurfaceChanged(holder, format, width, height);
			this.width = width;
			this.height = height;
			drawFrame();
		}
		
		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder){
			super.onSurfaceDestroyed(holder);
			visible = false;
			handler.removeCallbacks(drawThread);
		}
		
		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep, float yStep, int xPixels, int yPixels){
			drawFrame();
		}
		
		private void drawFrame(){
			SurfaceHolder holder = getSurfaceHolder();
			Canvas c = holder.lockCanvas();
			
			c.drawColor(Color.WHITE);
			c.drawBitmap(image, px-57, py-57, null);
			
			holder.unlockCanvasAndPost(c);
			
			if(px<0 || width<px){
				vx = -vx;
			}
			if(py<0 || height<py){
				vy = -vy;
			}
			
			px+=vx;
			py+=vy;
			
			handler.removeCallbacks(drawThread);
			if(visible){
				handler.postDelayed(drawThread, 100);
			}
		}
	}
}