package ua.goit.factory;

public enum ConnectionPoolNames {
	IDB("idb"); 
	ConnectionPoolNames(String name){
		this.name = name;
	}

	private String name;

	public String getStringName() {
		return this.name;
	}
}
