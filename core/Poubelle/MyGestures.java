//package jks.ht.inputs;
//
//import com.badlogic.gdx.input.GestureDetector.GestureListener;
//import com.badlogic.gdx.math.Vector2;
//
//public class MyGestures implements GestureListener 
//{
//
//	@Override
//	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
//			Vector2 pointer1, Vector2 pointer2) 
//	{
//		//grab all the positions
//		touchPos.set(initialPointer1.x, initialPointer1.y, 0);
//		camera.unproject(touchPos);
//		float x1n = touchPos.x;
//		float y1n = touchPos.y;
//		touchPos.set(initialPointer2.x, initialPointer2.y, 0);
//		camera.unproject(touchPos);
//		float x2n = touchPos.x;
//		float y2n = touchPos.y;
//		touchPos.set(pointer1.x, pointer1.y, 0);
//		camera.unproject(touchPos);
//		float x1p = touchPos.x;
//		float y1p = touchPos.y;
//		touchPos.set(pointer2.x, pointer2.y, 0);
//		camera.unproject(touchPos);
//		float x2p = touchPos.x;
//		float y2p = touchPos.y;
//
//		float dx1 = x1n - x2n;
//		float dy1 = y1n - y2n;
//		float initialDistance = (float) Math.sqrt(dx1*dx1+dy1*dy1);
//		float dx2 = x1p - x2p;
//		float dy2 = y1p - y2p;
//		float distance = (float) Math.sqrt(dx2*dx2+dy2*dy2);
//
//		if(zooming == false) {
//			zooming = true;
//			cx = (_x1 + _x2)/2;
//			cy = (_y1 + _y2)/2;
//			px = camera.position.x;
//			py = camera.position.y;
//			initZoom = camera.zoom;
//		} else {
//			float nextZoom = (initialDistance/distance)*scale;
//			/* do some ifs here to check if nextZoom is too zoomed in or out*/
//			camera.zoom = nextZoom;
//			camera.update();
//
//			Vector3 pos = new Vector3((pointer1.x + pointer2.x)/2, (pointer1.y + pointer2.y)/2, 0f);
//			camera.unproject(pos);
//			dx = cx - pos.x;
//			dy = cy - pos.y;
//			/* do some ifs here to check if we are in bounds*/
//			camera.translate(dx, dy);
//			camera.update();
//		}
//		return false;
//	}
//
//	@Override
//	public boolean touchDown(float x, float y, int pointer, int button) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean tap(float x, float y, int count, int button) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean longPress(float x, float y) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean fling(float velocityX, float velocityY, int button) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean pan(float x, float y, float deltaX, float deltaY) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean panStop(float x, float y, int pointer, int button) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean zoom(float initialDistance, float distance) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void pinchStop() {
//		// TODO Auto-generated method stub
//		
//	}
//}