package beans;

public class Trainer {
	
	Language lang;

	public Trainer() {		
		super();
		System.out.println("in def cons of Trainer");
		// TODO Auto-generated constructor stub
	}
	
	
	//byType,byName
	public Trainer(Language lang) {
		super();
		System.out.println("in par cons of Trainer");
		this.lang = lang;
	}



	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "Trainer [lang=" + lang + "]";
	}
	
	
	
	

}
