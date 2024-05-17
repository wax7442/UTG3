package pack;

import java.util.ArrayList;
import java.awt.Color;

public class Mesh {

	public Mesh() {

		private ArrayList<Polygon3D> polys;
		private Color color = Color.white;
		
		public Mesh(Polygon3D[] polygons){
			polys = new ArrayList<Polygon3D>();
			for(Polygon3D poly: polygons)
			{
				polys.add(polygons);
			}
		}
		public Mesh(Polygon3D[] polygons, Color color){
			polys = new ArrayList<Polygon3D>();
			for(Polygon3D poly: polygons)
			{
				polys.add(polygons);
			}
			setColor(color);
		}
		public Mesh(ArrayList<Polygon3D> polygons){
			polys = new ArrayList<Polygon3D>();
			for(int x = 0; x<polygons.size();x++){
				polys.add(polygons.get(x));
			}
			
		}
		public Mesh(ArrayList<Polygon3D> polygons, Color color){
			polys = new ArrayList<Polygon3D>();
			for(int x = 0; x<polygons.size();x++){
				polys.add(polygons.get(x));
			}
			setColor(color);
		}
		public void addPoly(Polygon3D polygon){
			polys.add(polygon);
		}
		public ArrayList<Polygon3D> getPolygons(){
			return polys;
		}
		public Color getColor(){
			return color;
		}
		public void setColor(Color color){
			this.color = color;
		}
	}

}
