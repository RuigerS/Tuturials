package nl.firstact.flappeebee;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
    private static final float WORLD_WIDTH = 480;
    private static final float WORLD_HEIGHT = 640;
    private static final float GAP_BETWEEN_FLOWERS = 200f;


    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private Camera camera;
    private SpriteBatch batch;
    private Flappee flappee;
    private Array<Flower> flowers = new Array<Flower>();
    private int score = 0;
    private BitmapFont bitmapFont;
    private GlyphLayout glyphLayout;
    private TextureRegion background;
    private TextureRegion flowerBottom;
    private TextureRegion flowerTop;
    private TextureRegion flappeeTexture;
    private final FlappeeBeeGame flappeeBeeGame;


    public GameScreen(FlappeeBeeGame flappeeBeeGame) {
        this.flappeeBeeGame = flappeeBeeGame;
    }
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        camera.update();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        glyphLayout = new GlyphLayout();
        TextureAtlas textureAtlas = flappeeBeeGame.getAssetManager().get("flappee_bee_assets.atlas");
        background = textureAtlas.findRegion("bg");
        flowerBottom = textureAtlas.findRegion("flowerBottom");
        flowerTop = textureAtlas.findRegion("flowerTop");
        flappeeTexture = textureAtlas.findRegion("bee");
        flappee = new Flappee(flappeeTexture);
        flappee.setPosition(WORLD_WIDTH / 4, WORLD_HEIGHT / 2);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        draw();
        shapeRenderer.setProjectionMatrix(camera.projection);
        shapeRenderer.setTransformMatrix(camera.view);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        flappee.drawDebug(shapeRenderer);
        for (Flower flower : flowers) {
            flower.drawDebug(shapeRenderer);
        }
        shapeRenderer.end();
        update(delta);
    }
    public void draw(){
        batch.totalRenderCalls = 0;
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.draw(background, 0, 0);
        drawFlowers();
        flappee.draw(batch);
        drawScore();
        batch.end();
        Gdx.app.log("Debug", String.valueOf(batch.totalRenderCalls));
    }

    private void update(float delta) {
        updateFlappee(delta);
        updateFlowers(delta);
        updateScore();
        if (checkForCollision()) {
            restart();
        }
    }
    private void updateFlappee(float delta){
        flappee.update(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            flappee.flyUp();
        }
        blockFlappeeLeavingTheWorld();

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void blockFlappeeLeavingTheWorld() {
        flappee.setPosition(flappee.getX(), MathUtils.clamp(flappee.getY(), 0, WORLD_HEIGHT));
    }
    private void createNewFlower() {
        Flower newFlower = new Flower(flowerBottom, flowerTop);
        newFlower.setPosition(WORLD_WIDTH + Flower.WIDTH);
        flowers.add(newFlower);
    }
    private void checkIfNewFlowerIsNeeded() {
        if (flowers.size == 0) {
            createNewFlower();
        } else {
            Flower flower = flowers.peek();
            if (flower.getX() < WORLD_WIDTH - GAP_BETWEEN_FLOWERS) {
                createNewFlower();
            }
        }
    }
    private void removeFlowersIfPassed() {
        if (flowers.size > 0) {
            Flower firstFlower = flowers.first();
            if (firstFlower.getX() < -Flower.WIDTH) {
                flowers.removeValue(firstFlower, true);
            }
        }
    }
    private void updateFlowers(float delta) {
        for (Flower flower : flowers) {
            flower.update(delta);
        }
        checkIfNewFlowerIsNeeded();
        removeFlowersIfPassed();
    }
    private boolean checkForCollision() {
        for (Flower flower : flowers) {
            if (flower.isFlappeeColliding(flappee)) {
                return true;
            }
        }
        return false;
    }
    private void restart() {
        flappee.setPosition(WORLD_WIDTH / 4, WORLD_HEIGHT / 2);
        flowers.clear();
        score = 0;
    }
    private void updateScore() {
        Flower flower = flowers.first();
        if (flower.getX() < flappee.getX() && !flower.isPointClaimed()) {
            flower.markPointClaimed();
            score++;
        }
    }
    private void drawScore() {
        String scoreAsString = Integer.toString(score);
        glyphLayout.setText(bitmapFont, scoreAsString);
        bitmapFont.draw(batch, scoreAsString, (viewport.getWorldWidth() - glyphLayout.width) / 2, (4 * viewport.getWorldHeight() / 5) - glyphLayout.height / 2);
    }
    private void drawFlowers() {
        for (Flower flower : flowers) {
            flower.draw(batch);
        }
    }

}
