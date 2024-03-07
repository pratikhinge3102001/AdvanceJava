package beans;

public class Language {
	String lang;

	public Language() {
		super();
		System.out.println("in def cons of Language");
		// TODO Auto-generated constructor stub
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "Language [lang=" + lang + "]";
	}
	
	
	
}
