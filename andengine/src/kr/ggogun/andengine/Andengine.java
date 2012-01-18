package kr.ggogun.andengine;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class Andengine extends BaseGameActivity {
    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//    }
	public static final int CAMERA_WIDTH = 480;//만들고자 하는 게임의 가로 해상도 값을 넣는다.
	 public static final int CAMERA_HEIGHT = 320;//만들고자 하는 게임의 세로 해상도 값을 넣는다.
	 private Camera mCamera;
	 private Scene scene;
	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public Engine onLoadEngine() {
		// TODO Auto-generated method stub
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		 return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera).setNeedsMusic(true));
		
	}

	@Override
	public void onLoadResources() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Scene onLoadScene() {
		// TODO Auto-generated method stub
		 scene = new Scene(3);
		return scene;
	}
}