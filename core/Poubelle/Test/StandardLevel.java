//package jks.ht.view.m.filter.Tools;
//
//public class StandardLevel implements Screen 
//{
//    // ... more field vars here...
//    private ShaderProgram shaderProgram;
//
//    public StandardLevel(MyGame game, ShaderProgram shaderProgram) {
//
//        this.shaderProgram = shaderProgram;       
//        // using shaderProgram for tiledMapHelper and spriteBatch means fps drops to ~30-40fps
//        this.tiledMapHelper = new TiledMapHelper(shaderProgram);
//        this.spriteBatch = new SpriteBatch(1000, shaderProgram);
//        this.shapeRenderer = new ShapeRenderer();
//
//        this.camera = new OrthographicCamera();
//        this.camera.setToOrtho(false, MyGame.SCREEN_WIDTH, MyGame.SCREEN_HEIGHT);
//
//        disableShaderOverlay();  // <--- Hide the overlay
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//
//        // Setup camera and projection voodoo
//        camera.update();
//        spriteBatch.setProjectionMatrix(camera.combined);
//        shapeRenderer.setProjectionMatrix(camera.combined);
//        tiledMapHelper.renderMap();
//
//        // Draw the sprites and pretty images!
//        spriteBatch.begin();        
//        drawPlayerCircle();
//        spriteBatch.end();
//
//        // ... game logic/collision detection etc etc
//        // ... inside said logic...
//            if (endGame()) {
//                enableEndGameOverlay(); // <--- Make overlay visible
//            }      
//        // ... game logic etc etc  
//    }    
//
//    public void enableEndGameOverlay() {
//       shaderProgram.begin();
//       shaderProgram.setUniformf("strength", 1f);
//       shaderProgram.end();
//    }
//
//    public void disableShaderOverlay() {
//       shaderProgram.begin();
//       shaderProgram.setUniformf("strength", 0f);
//       shaderProgram.end();
//    }
//}