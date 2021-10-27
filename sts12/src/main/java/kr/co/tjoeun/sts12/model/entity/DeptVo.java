package kr.co.tjoeun.sts12.model.entity;

public class DeptVo {
    private int detpno;
    private String dname,loc;
    
    public DeptVo() {
    	
    }

	public DeptVo(int detpno, String dname, String loc) {
		super();
		this.detpno = detpno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDetpno() {
		return detpno;
	}

	public void setDetpno(int detpno) {
		this.detpno = detpno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + detpno;
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptVo other = (DeptVo) obj;
		if (detpno != other.detpno)
			return false;
		if (dname == null) {
			if (other.dname != null)
				return false;
		} else if (!dname.equals(other.dname))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeptVo [detpno=" + detpno + ", dname=" + dname + ", loc=" + loc + "]";
	}
    
    
}
