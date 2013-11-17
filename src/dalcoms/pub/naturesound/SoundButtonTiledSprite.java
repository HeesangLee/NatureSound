package dalcoms.pub.naturesound;

import org.andengine.audio.music.Music;
import org.andengine.engine.camera.Camera;
//import org.andengine.entity.modifier.LoopEntityModifier;
//import org.andengine.entity.modifier.RotationModifier;
//import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

//import android.view.animation.RotateAnimation;

public class SoundButtonTiledSprite extends TiledSprite{
	public int flagButtonStatus = 0;
	private Music mySound;
	
	public SoundButtonTiledSprite(float pX, float pY,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			Music pMusic,
			int pButtonIndex) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
		flagButtonStatus = pButtonIndex*2;
		this.setCurrentTileIndex(flagButtonStatus);
		mySound = pMusic;
	}
	
	@Override
	protected void preDraw(final GLState pGLState, final Camera pCamera) {
		super.preDraw(pGLState, pCamera);
		pGLState.enableDither();
	}
	
	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY){
		
		if(pSceneTouchEvent.isActionUp()){
			if (flagButtonStatus%2 == 0){//pause to play
				flagButtonStatus += 1;
				mySound.seekTo(0);
				mySound.play();
				mySound.setLooping(true);
			}else{//play to pause
				flagButtonStatus -= 1;
				mySound.pause();
			}
			this.setCurrentTileIndex(flagButtonStatus);
		}
		return super.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX,
				pTouchAreaLocalY);
	}
	
}
