package pack.ggogun.core;

import pack.ggogun.view.ViewList;
import ryulib.graphic.Boundary;
import ryulib.mvc.ValueList;
import ryulib.timer.OnTimer;
import ryulib.timer.Timer;

public class Core {

	static private Core _Cores = null;	
	
	static public Core Obj() {
		if (_Cores == null) _Cores = new Core();
		return _Cores;
	}
	
	private Timer _Timer = null;
	private AirCraft _AirCraft = null;
	private Missile _Missile = null;
	private EnemyList _EnemyList = null;
	
	Core() {
		_AirCraft = new AirCraft();
		_AirCraft.setOnAirCraftMoved(on_AirCraftMoved);
		
		_Missile = new Missile();
		_Missile.setOnMissileMoved(on_MissileMoved);
		
		_EnemyList = new EnemyList();
		_EnemyList.setOnEnemyCreated(on_EnemyCreated);
		_EnemyList.setOnEnemyMoved(on_EnemyMoved);
		_EnemyList.setOnEnemyCrashed(on_EnemyCrashed);

		_Timer = new Timer();
		_Timer.setInterval(0);
		_Timer.setOnTimer(on_Timer);
	}
	
	public void StartGame() {
		ValueList APacket = new ValueList();
		APacket.put("Code", "StartGame");
		pack.ggogun.view.ViewList.Obj().Broadcast(APacket);

		_AirCraft.Initialize();
		_Missile.Initialize();
		_EnemyList.Initialize();

		_Timer.Start();
	}
	
	public void MoveAirCraft(int dx) {
		_AirCraft.MoveAirCraft(dx);
	}
	
	public void FireMissile() {
		_Missile.FireMissile(_AirCraft.getBoundary());
	}
	
	private OnTimer on_Timer = new OnTimer() {
		public void Run(long ATick) {
			_AirCraft.Tick(ATick);
			_Missile.Tick(ATick);
			_EnemyList.Tick(ATick);
		}
	};
	private OnAirCraftMoved on_AirCraftMoved = new OnAirCraftMoved() {
		public void Moved(Boundary ABoundary) {
			ViewList.Obj().sp_AirCraftMoved(ABoundary.getLeft(), ABoundary.getTop());
		}
	};
	
	private OnMissileMoved on_MissileMoved = new OnMissileMoved() {
		public void Moved(Boundary ABoundary) {
			ViewList.Obj().sp_MissileMoved(ABoundary.getLeft(), ABoundary.getTop());

			if (_EnemyList.CheckCollision(ABoundary)) {
				_Missile.Bang();
			}
		}
	};
	
	private OnEnemyCreated on_EnemyCreated = new OnEnemyCreated() {
		public void Created(int AEnemyID, Boundary ABoundary) {
			ViewList.Obj().sp_EnemyCreated(AEnemyID, ABoundary.getLeft(), ABoundary.getTop());
		}
	};
	
	private OnEnemyMoved on_EnemyMoved = new OnEnemyMoved() {
		public void Moved(int AEnemyID, Boundary ABoundary) {
			ViewList.Obj().sp_EnemyMoved(AEnemyID, ABoundary.getLeft(), ABoundary.getTop());
			
			// GameEnd
			if (_AirCraft.CheckCollision(ABoundary)) {
				_Timer.Stop();
			}
		}
	};
	
	private OnEnemyCrashed on_EnemyCrashed = new OnEnemyCrashed() {
		public void Crashed(int AEnemyID) {
			ViewList.Obj().sp_EnemyCrashed(AEnemyID);
		}
	};
	
}

