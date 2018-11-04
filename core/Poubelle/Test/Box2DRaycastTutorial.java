package Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DRaycastTutorial extends ScreenAdapter {

	World world = new World(new Vector2(0, -9.81f), true);
	OrthographicCamera camera = new OrthographicCamera();
	Box2DDebugRenderer renderer = new Box2DDebugRenderer();
	ShapeRenderer sr = new ShapeRenderer();

	Vector2 p1 = new Vector2(), p2 = new Vector2(), collision = new Vector2(), normal = new Vector2();

	@Override
	public void show() {
		// put stuff in the world
//		TiledMap map = new TmxMapLoader().load(Assets.testMap1);
//		new Box2DMapObjectParser().load(world, map);
//		map.dispose();

		Gdx.input.setInputProcessor(new InputAdapter() {

			Vector3 tmp = new Vector3();

			RayCastCallback callback = new RayCastCallback() {

				@Override
				public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
					collision.set(point);
					Box2DRaycastTutorial.this.normal.set(normal).add(point);
					return 1;
				}

			};

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				tmp.set(screenX, screenY, 0);
				camera.unproject(tmp);
				if(Gdx.input.isButtonPressed(Buttons.LEFT))
					p2.set(tmp.x, tmp.y);
				else if(Gdx.input.isButtonPressed(Buttons.RIGHT))
					p1.set(tmp.x, tmp.y);
				world.rayCast(callback, p1, p2);
				return true;
			}

		});
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width / 25;
		camera.viewportHeight = height / 25;
		camera.update();
	}

	@Override
	public void render(float delta) {
		world.step(1 / 60f, 8, 3);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render(world, camera.combined);

		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Line);
		sr.line(p1, p2);
		sr.line(collision, normal);
		sr.end();
	}

	@Override
	public void dispose() {
		world.dispose();
		renderer.dispose();
		sr.dispose();
	}

}