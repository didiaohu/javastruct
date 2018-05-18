package graph;

public class DirectedEdge {
	private final int v;         // 边的起点
	private final int w;         // 边的终点
	private final double weight; // 边的权重
	
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	public double weight() {
		return weight;
	}
	public int from() {    // 指出这条边的顶点
		return v;
	}
	public int to() {      // 这条边指向的顶点
		return w;
	}
	public String toString() {
		return String.format("%d->%d %.2f", v, w, weight);
	}
}
