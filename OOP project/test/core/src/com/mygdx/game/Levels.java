package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.raya.megaman.MegaMan;

public class Levels implements Screen
{
    private Stage stage;
    private Table table;
    private TextureAtlas atlas;
    private TextButton level1,level2,level3,back;
    private Skin skin;
    private BitmapFont white;
    Texture img3;
    SpriteBatch batch;
    Sound button_sound;
    @Override
    public void show() {
                button_sound=Gdx.audio.newSound(Gdx.files.internal("sound/button_sound.wav"));
                batch = new SpriteBatch();
                img3 = new Texture(Gdx.files.internal("img/background2.png"));
                white =new BitmapFont(Gdx.files.internal("fonts/white.fnt"),false);
                atlas=new TextureAtlas("pack/Button.pack");
                skin=new Skin(atlas);
                stage=new Stage();
                Gdx.input.setInputProcessor(stage);
                table =new Table();
                table.setBounds(100, 100, 1250, 600); 
                TextButton.TextButtonStyle tbs=new TextButton.TextButtonStyle();
                tbs.up=skin.getDrawable("button background1");
                tbs.font=white;
                level1=new TextButton("Level 1",tbs);
                level1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                   button_sound.play();
                   ((Game) Gdx.app.getApplicationListener()).setScreen(new MegaMan());
                }
        });
        level1.pad(20);
        level2=new TextButton("Level 2",tbs);
        level2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                   button_sound.play();
                   
                }
        });
        level2.pad(20);
        level3=new TextButton("Level 3",tbs);
        level3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                   button_sound.play();
                }
        });
        level3.pad(20);
        back=new TextButton("Back",tbs);
        back.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    button_sound.play();
                   ((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
                }
                   
        });
        back.pad(20);
                
                
                table.add(level1);
                table.row();
                table.add(level2);
                table.row();
                table.add(level3);
                table.row();
                table.add(back);
                stage.addActor(table);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                batch.draw(img3, 0,0);
                batch.end();
                stage.act();
                stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        table.invalidateHierarchy();
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
                stage.dispose();
		skin.dispose();
    }
    
    
}
