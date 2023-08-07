package turbotrip.model;

public class Car {

	
	@Override
	public String toString() {
		return "Car [carmodel=" + carmodel + ", carImage=" + carImage + ", carNo=" + carNo + ", description="
				+ description + ", getCarmodel()=" + getCarmodel() + ", getCarImage()=" + getCarImage()
				+ ", getCarNo()=" + getCarNo() + ", getDescription()=" + getDescription() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	private String carmodel;
	private String  carImage;
	private String carNo;
	private String description;
	
	public Car(String carNo) {
		this.carNo = carNo;
	}
	
	
	public Car(  String carNo, String carmodel, String carImage, String description) {
		super();
	
		this.carmodel = carmodel;
		this.carImage = carImage;
		this.carNo = carNo;
		this.description = description;
	}
	
	
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	
}
