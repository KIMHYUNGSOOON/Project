package FirstProj;

public class MemberVo {
	private String ID;
	private String PASSWORD;
	private String NAME;
	private String TELL;

	public MemberVo() {

	}
	
	public MemberVo(String ID,String PASSWORD) {
		this.ID=ID;
		this.PASSWORD=PASSWORD;
	}
	
	public void MemberVo(String NAME, String TELL) {
		this.NAME=NAME;
		this.TELL=TELL;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public String getTELL() {
		return TELL;
	}

}