package memVector;

public class VipMember extends Member{
	private int point = 100;

	public VipMember(int num, String name, int vPoint) {
		super(num, name);
		this.point = vPoint;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
}
