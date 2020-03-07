package ru.spbu.apmath.prog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MyFlappyVoiceGame extends ApplicationAdapter {
    static SpriteBatch batch;
    static Background bg;
    static Bird bird;
    static Obstacles obstacles;
    static boolean gameOver;
    static Texture restartTexture;
    static Score score;
    static Sound sound;


    protected boolean k = false;
    int i = 0;
    public void update(){
        bg.update();
        bird.update();
        obstacles.update();
        score.update();
        for (int i = 0; i < Obstacles.obs.length; i++) {
            if(bird.position.x > Obstacles.obs[i].position.x     && bird.position.x < Obstacles.obs[i].position.x+50){
                if(!Obstacles.obs[i].emptySpace.contains(bird.position)){
                    gameOver = true;
                }
            }
        }
        if(bird.position.y <0 || bird.position.y > 600){
            gameOver = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
            recreate();
        }
    }

    public void create() {
        batch = new SpriteBatch();
        bg = new Background();
        sound = new Sound();
        bird = new Bird();
        obstacles = new Obstacles();
        gameOver = false;
        restartTexture = new Texture("D:\\code\\dz\\prjct2\\core\\assets\\RestartBtn.png");
        score = new Score();
        score.create();
    }

    public  void render() {
        update();
        batch.begin();
        bg.render(batch);
        obstacles.render(batch);
        if(!gameOver) {
            bird.render(batch);
        }else{
            batch.draw(restartTexture, 200, 200);
        }
        if (!gameOver){
            score.render();
        }
        batch.end();
    }
<<<<<<< HEAD

=======
protected boolean k = false;
    int i = 0;
    public void update(){
        bg.update();
        i++;
        if (i >10){
            k = true;
            i = 0;
        }
        //System.out.println("k ="+k);
        bird.update(k);
        k = false;

        obstacles.update();
        score.update();
        for (int i = 0; i < Obstacles.obs.length; i++) {
            if(bird.position.x > Obstacles.obs[i].position.x     && bird.position.x < Obstacles.obs[i].position.x+50){
                if(!Obstacles.obs[i].emptySpace.contains(bird.position)){
                    gameOver = true;
                }
            }
        }
        if(bird.position.y <0 || bird.position.y > 600){
            gameOver = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
            recreate();
        }


    }
>>>>>>> 5c9f8ea31987a75e708b77e805010cb1a698daf3

    @Override
    public void dispose () {
        batch.dispose();
    }

    public static void recreate(){
        bird.recreate();
        obstacles.recreate();
        score.recreate();
        sound.recreate();
        gameOver = false;
    }
}
