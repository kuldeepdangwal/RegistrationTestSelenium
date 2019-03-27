package com.cg.registration.pagebeans;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageBean {
	@FindBy(how=How.NAME,name="userid")
	private WebElement userId ;

	@FindBy(how=How.NAME,name="passid")
	private WebElement password;

	@FindBy(how=How.NAME,name="username")
	private WebElement name;

	@FindBy(how=How.NAME,name="address")
	private WebElement address;

	@FindBy(how=How.NAME,name="country")
	private WebElement country;

	@FindBy(how=How.NAME,name="zip")
	private WebElement zip;

	@FindBy(how=How.NAME,name="email")
	private WebElement email;

	@FindBy(how=How.NAME,name="sex")
	private List<WebElement> gender;

	@FindBy(how=How.NAME,name="languages")
	private List<WebElement> languages;

	@FindBy(how=How.NAME,name="submit")
	private WebElement submitBtn;


	public String getUserId() {
		return userId.getAttribute("value");
	}

	public void setUserId(String  userId) {
		this.userId.sendKeys(userId);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getName() {
		return name.getAttribute("value");
	}

	public void setName(String name) {
		this.name.sendKeys(name);
	}

	public void setAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}

	public String getAddress() {
		return address.getAttribute("value");
	}
	
	public String getCountry() {
		return new Select(this.country).getFirstSelectedOption().getText();
	}

	public void setCountry(String country) {
		Select select=new Select(this.country);
		select.selectByVisibleText(country);
	}

	public String getZip() {
		return zip.getAttribute("zip");
	}

	public void setZip(String zip) {
		this.zip.sendKeys(zip);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);;
	}

	public String  getGender() {
		for (WebElement webElement : gender) 
			if(webElement.isSelected())
				return webElement.getAttribute("value");
			return null;
		}

		public void setGender(String gender) {
			if(gender.equalsIgnoreCase("male"))
				this.gender.get(0).click();
			else 
				this.gender.get(1).click();
		}

		public String[]  getLanguage() {
			return null;
		}

		public void setLanguage(String [] languages) {
			for (String language : languages) {
				if(language.equals("english"))
					this.languages.get(0).click();
				else if(language.equals("nonenglish"))
					this.languages.get(1).click();
			}
			
		}	
		public void clickSignUp() {
			submitBtn.submit();
		}

}
