package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//>>>>>>>>>>>>>>>>>>>  Job Submit : Page Class  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class JobSubmitPage extends BasePage {

	// >>>>>>>>>>>>>>>>>>>>>>>  JobSubmitPage Constructor  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public JobSubmitPage(WebDriver driver) throws IOException {
		super(driver); // Pass the driver to the parent class
	}

//  >>>>>>>>>>>>>>>>>>>>>>>>>  Elements Locatores	<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	
	@FindBy(xpath = "//div[@class='styles_jhc__apply-button-container__5Bqnb']//button[2]")
	WebElement buttonXPath;

	
	
	
// >>>>>>>>>>>>>>>>>>>>>>>>>>  Click On Apply BUtton of all Open Profile  <<<<<<<<<<<<<<<<<<<<<<<<<<	
	public void ApplyClick() {

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		List<String> childWindows = new ArrayList<>();

		while (iterator.hasNext()) {

			childWindows.add(iterator.next());

		}

		for (int i = 0; i < childWindows.size(); i++) {
			String childWindow = childWindows.get(i);
			driver.switchTo().window(childWindow);

			buttonXPath.click();

		}

		driver.switchTo().window(parentWindow);

	}
}
