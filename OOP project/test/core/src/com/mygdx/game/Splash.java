package com.mygdx.game;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen{
    private SpriteBatch batch;
    private Sprite splash;
    private Texture img;
    private Texture img2;
    private TweenManager tweenManager;
    //Sound intro;
    @Override
    public void show() {
        //intro=Gdx.audio.newSound(Gdx.files.internal("sound/intro sound.mp3"));
        img=new Texture(Gdx.files.internal("img/mega man logo1.png"));
        img2=new Texture(Gdx.files.internal("img/background2.png"));
        splash=new Sprite(img);
        splash.setBounds(50, 550, 1416, 229);
        batch=new SpriteBatch();
        tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccess());
              Tween.set(splash, SpriteAccess.ALPHA).target(0).start(tweenManager);
		Tween.to(splash, SpriteAccess.ALPHA, 1.5f).target(1).repeatYoyo(1, .5f).setCallback(new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
                                //intro.play();
			}
		}).start(tweenManager);

		tweenManager.update(Float.MIN_VALUE);
    }

    @Override
    public void render(float f) {
        
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                batch.draw(img2, 0,0);
                splash.draw(batch);
                batch.end();
                tweenManager.update(f);
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
       dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        splash.getTexture().dispose();
    }
    
}
