package dalcoms.pub.naturesound;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;
import dalcoms.pub.naturesound.SceneManager.SceneType;

public abstract class BaseScene extends Scene{
	//******************************
	// Variables
	//******************************
	protected Engine engine;
	protected Activity activity;
	protected ResourcesManager resourcesManager;
	protected VertexBufferObjectManager vbom;
	protected Camera camera;
	
	//******************************
	// Constructor
	//******************************
	public BaseScene(){
		//ResourcesManager class �� MainActivity ���� prepare�� ���� MainActivity�� �ϱ� ���ڵ��� ��������. 
		//��������� ���ҽ��޴����� �ν���Ʈ�� ���� mainActivity�� �ֿ� ���ڵ��� �� �� �ֵ��� ��.
		this.resourcesManager = ResourcesManager.getInstance();
		this.engine = resourcesManager.engine;
		this.activity = resourcesManager.activity;
		this.vbom = resourcesManager.vbom;
		this.camera = resourcesManager.camera;
		createScene();
	}
	
	//******************************
	// Abstract
	//******************************
	public abstract void createScene();
	public abstract void onBackKeyPressed();
	public abstract SceneType getSceneType();
	public abstract void disposeScene();
	
}
