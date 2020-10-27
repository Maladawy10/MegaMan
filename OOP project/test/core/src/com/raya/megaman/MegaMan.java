package com.raya.megaman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MainMenu;
import com.raya.screens.PlayScreen;


        
public class MegaMan extends Game implements Screen{

    //virtual width and height for game
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT =250;
	public static final float PPM=100;//pixelspermeter;used to scale all meausurements
	//public SpriteBatch batch;//container that holds all images and textures until rendered to be drawn, memory intensive, public so all screens have access 
	
	public SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
	((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen(this));//this:pass game itself
    }
    @Override
    public void resize(int i, int i1)
    {
        super.resize(i, i1);
    }
    @Override
    public void render()
    {
        super.render();
    }
    @Override
    public void dispose() 
    {
        batch.dispose();
    }
    @Override
    public void pause()
    {
        super.pause();
    }
    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void show() {
       batch = new SpriteBatch();
	((Game) Gdx.app.getApplicationListener()).setScreen(new PlayScreen(this));//this:pass game itself        
    }

    @Override
    public void render(float f) {
        super.render();
    }

    @Override
    public void hide() {
        dispose();
    }
	

   
}
