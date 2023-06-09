package dk.tec.jaj;

public class Elev 
{
	int id;
	String navn;
	int alder;
	String job;
	
	public Elev() {};
	
	public Elev(int id, String navn, int alder, String job) {
		super();
		this.id = id;
		this.navn = navn;
		this.alder = alder;
		this.job = job;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getAlder() {
		return alder;
	}
	public void setAlder(int alder) {
		this.alder = alder;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

}
