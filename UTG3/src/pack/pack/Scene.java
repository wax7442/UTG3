package pack;


import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scene extends ArrayList<Mesh> {
	private Camera cam;
	public Camera getActiveCamera() {
		return cam;
	}
	public Scene(Camera cam) {
		super();
		this.cam = cam;
	}
}