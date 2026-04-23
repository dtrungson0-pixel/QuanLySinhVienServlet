package Model;

public class sinhvien {
	private int id;
	private String name, diaChi, tenLop, namSinh;

	public sinhvien() {
		super();
	}

	public sinhvien(int id, String name, String diaChi, String tenLop, String namSinh) {
		super();
		this.id = id;
		this.name = name;
		this.diaChi = diaChi;
		this.tenLop = tenLop;
		this.namSinh = namSinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	@Override
	public String toString() {
		return "sinhvien [id=" + id + ", name=" + name + ", diaChi=" + diaChi + ", tenLop=" + tenLop + ", namSinh="
				+ namSinh + "]";
	}

}
