package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen {
    private Stage stage;
    private Table table;
    private TextureAtlas atlas;
    private TextButton play,settings,highscore,exit;
    private Skin skin;
    private BitmapFont white,black;
	SpriteBatch batch;
	Texture img;
        Texture img2;
        Texture img3;
        Sprite s;
        Sound button_sound;
	
	

    @Override
    public void show() {
                button_sound=Gdx.audio.newSound(Gdx.files.internal("sound/button_sound.wav"));
                batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("img/mega man logo1.png"));
                img2 = new Texture(Gdx.files.internal("img/mega man logo2.png"));
                img3 = new Texture(Gdx.files.internal("img/background2.png"));
                s=new Sprite(img2);
                s.setBounds(850, 0, 700, 500);
                white =new BitmapFont(Gdx.files.internal("fonts/white.fnt"),false);
                black =new BitmapFont(Gdx.files.internal("fonts/black.fnt"),false);
                atlas=new TextureAtlas("pack/Button.pack");
                skin=new Skin(atlas);
                stage=new Stage();
                Gdx.input.setInputProcessor(stage);
                table =new Table();
                table.setBounds(100, 100, 500, 380);
                TextButton.TextButtonStyle tbs=new TextButton.TextButtonStyle();
                tbs.up=skin.getDrawable("button background1");
                tbs.font=white;
                play=new TextButton("Play",tbs);
                play.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    button_sound.play();
                   ((Game) Gdx.app.getApplicationListener()).setScreen(new Levels());
                }
        });
        play.pad(20);
//        settings=new TextButton("Settinges",tbs);
//        settings.addListener(new ClickListener(){
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                   button_sound.play();
//                }
//        });
//        settings.pad(20);
//        highscore=new TextButton("Highscore",tbs);
//        highscore.addListener(new ClickListener(){
//                @Override
//                public void clicked(InputEvent event, float x, float y) {
//                   button_sound.play();
//                }
//        });
//        highscore.pad(20);
        exit=new TextButton("Exit",tbs);
        exit.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Gdx.app.exit();
                    button_sound.play();
                }
                   
        });
        exit.pad(20);
        table.add(play);
        table.row();
//        table.add(settings);
//        table.row();
//        table.add(highscore);
//        table.row();
        table.add(exit);
        stage.addActor(table);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                batch.draw(img3, 0,0);
                s.draw(batch);
		batch.draw(img, 50,550);
		batch.end();
                 stage.act();
                stage.draw();
    }
        @Override
	public void dispose () {
		batch.dispose();
		img.dispose();
                stage.dispose();
		skin.dispose();
	}
    @Override
    public void hide() {
        dispose();
    }
    

    @Override
    public void resize(int i, int i1) {
        //stage.setViewport(i,i1,false);
	table.invalidateHierarchy();
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

}
