package FirstProj;

public class MemberVo {
	private String ID;
	private String PASSWORD;


	public MemberVo() {

	}
	
	public MemberVo(String ID,String PASSWORD) {
		this.ID=ID;
		this.PASSWORD=PASSWORD;
	
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}

}