package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto;

import java.util.Objects;

public class LocalizacionDTO {

	private String iso2;
	private String iso3;
	private String country_code;
	private String name;
	private int numeric_code;
	private String phone_code;
	private String capital;
	private String currency;
	private String tld;
	private String region;
	private String subregion;
	private int latitude;
	private int longitude;
	private String emoji;
	private String ip;
	private int statusCode;

	public LocalizacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public LocalizacionDTO(String iso2, String iso3, String country_code, String name, int numeric_code,
			String phone_code, String capital, String currency, String tld, String region, String subregion,
			int latitude, int longitude, String emoji, String ip) {
		super();
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.country_code = country_code;
		this.name = name;
		this.numeric_code = numeric_code;
		this.phone_code = phone_code;
		this.capital = capital;
		this.currency = currency;
		this.tld = tld;
		this.region = region;
		this.subregion = subregion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.emoji = emoji;
		this.ip = ip;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumeric_code() {
		return numeric_code;
	}

	public void setNumeric_code(int numeric_code) {
		this.numeric_code = numeric_code;
	}

	public String getPhone_code() {
		return phone_code;
	}

	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTld() {
		return tld;
	}

	public void setTld(String tld) {
		this.tld = tld;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, country_code, currency, emoji, ip, iso2, iso3, latitude, longitude, name,
				numeric_code, phone_code, region, subregion, tld);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalizacionDTO other = (LocalizacionDTO) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(country_code, other.country_code)
				&& Objects.equals(currency, other.currency) && Objects.equals(emoji, other.emoji)
				&& Objects.equals(ip, other.ip) && Objects.equals(iso2, other.iso2) && Objects.equals(iso3, other.iso3)
				&& latitude == other.latitude && longitude == other.longitude && Objects.equals(name, other.name)
				&& numeric_code == other.numeric_code && Objects.equals(phone_code, other.phone_code)
				&& Objects.equals(region, other.region) && Objects.equals(subregion, other.subregion)
				&& Objects.equals(tld, other.tld);
	}

	@Override
	public String toString() {
		return "Country =" + name + ", capital=" + capital + ", latitude=" + latitude + ", longitude=" +longitude;
	}

}
