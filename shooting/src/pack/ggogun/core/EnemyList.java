package pack.ggogun.core;

import java.util.ArrayList;
import java.util.Random;

import pack.ggogun.global.global;
import ryulib.graphic.Boundary;

public class EnemyList {
	
	EnemyList(){
		int i;
		for (i=0; i<10; i++) {
			Enemy _Enemy = new Enemy();
			_Enemy.ID = i;
			_List.add(_Enemy);
		}
	}
	
	private void move_Enemy(int ID, int x, int y) {
		_List.get(ID).getBoundary().setLeft(x);
		_List.get(ID).getBoundary().setTop(y);
		
		if (_OnEnemyMoved != null) _OnEnemyMoved.Moved(ID, _List.get(ID).getBoundary());
		
		if (y > global.Obj().getScreenBoundary().getBottom()) _List.get(ID).Visible = false;
	}
	
	public void Initialize() {
		_Counter = 0;
		
		int i;
		for (i=0; i<10; i++) {
			_List.get(i).Visible = false;
			move_Enemy(i, -100, -100);
		}
		
		_GameStarted = true;
	}
	
	private void create_Enemy() {
		int i;
		for (i=0; i<10; i++) {
			if (_List.get(i).Visible == false) {
				_List.get(i).getBoundary().setLeft(_Random.nextInt(global.Obj().getScreenBoundary().getWidth()-32));
				_List.get(i).getBoundary().setTop(0);
				_List.get(i).Visible = true;
				
				if (_OnEnemyCreated != null) _OnEnemyCreated.Created(i, _List.get(i).getBoundary());
				
				break;
			}
		}
	}
	
	public void Tick(long ATick) {
		if (_GameStarted == false) return;
		
		// 200ms 
		_Counter = _Counter + ((int) ATick);
		if (_Counter >= 200) {
			_Counter = 0;
			create_Enemy();
		}

		int i;
		for (i=0; i<10; i++) {
			if (_List.get(i).Visible == false) continue;
			
			int _Speed = (int) (100*ATick/1000);  // 
			move_Enemy(i, _List.get(i).getBoundary().getLeft(), _List.get(i).getBoundary().getTop()+_Speed);
		}
	}
	
	public boolean CheckCollision(Boundary ABoundary) {
		int i;
		for (i=0; i<10; i++) {
			if (_List.get(i).Visible == false) continue;
			
			if (ABoundary.CheckCollision(_List.get(i).getBoundary())) {
				_List.get(i).Visible = false;
				if (_OnEnemyCrashed != null) _OnEnemyCrashed.Crashed(i);
				return true;
			}
		}
		
		return false;
	}
	
	// OnEnemyCreated Event 
	private OnEnemyCreated _OnEnemyCreated = null;
	public void setOnEnemyCreated(OnEnemyCreated AValue) {
		_OnEnemyCreated = AValue;
	}
	
	// OnEnemyMoved Event
	private OnEnemyMoved _OnEnemyMoved = null;
	public void setOnEnemyMoved(OnEnemyMoved AValue) {
		_OnEnemyMoved = AValue;
	}
	
	// OnEnemyCrashed Event
	private onEnemyCrashed _OnEnemyCrashed = null;
	public void setOnEnemyCrashed(onEnemyCrashed AValue) {
		_OnEnemyCrashed = AValue;
	}
	
	private boolean _GameStarted = false;
	private ArrayList<Enemy> _List = new ArrayList<Enemy>();
	private int _Counter = 0;
	private Random _Random = new Random();
	
}
