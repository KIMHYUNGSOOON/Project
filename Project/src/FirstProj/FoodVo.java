package FirstProj;

public class FoodVo {
    private String NAME;
    private String TELL;
    private String ADDRESS;
    private String STAR;
    private String PRICE;
    private String BESTMENU;
    private String CHARACTERSS;
    private String KIND;
    // Add more fields as needed

    public FoodVo(String NAME, String TELL,String ADDRESS, String STAR,String PRICE, String BESTMENU,String CHARACTERSS, String KIND) {
        this.NAME = NAME;
        this.TELL = TELL;
        this.ADDRESS = ADDRESS;
        this.STAR = STAR;
        this.PRICE = PRICE;
        this.BESTMENU = BESTMENU;
        this.CHARACTERSS = CHARACTERSS;
        this.KIND = KIND;
    }

    public FoodVo() {
		// TODO Auto-generated constructor stub
	}

	public String getNAME() {
        return NAME;
    }

    public String getTELL() {
        return TELL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getSTAR() {
        return STAR;
    }

    public String PRICE() {
        return PRICE;
    }

    public String getBESTMENU() {
        return BESTMENU;
    }

    public String getCHARACTERSS() {
        return CHARACTERSS;
    }

    public String getKIND() {
        return KIND;
    }

	public Object getID() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPASSWORD() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPRICE() {
		// TODO Auto-generated method stub
		return PRICE;
	}

 
}