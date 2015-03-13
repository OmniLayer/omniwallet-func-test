/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities

waiting {
	timeout = 2
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

    phantomJs {
        driver = { 
            ArrayList cliArgsCap = new ArrayList();
            cliArgsCap.add("--web-security=false");
            cliArgsCap.add("--ssl-protocol=any");
            cliArgsCap.add("--ignore-ssl-errors=true");
 
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
            desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
 
            def d = new PhantomJSDriver(desiredCapabilities)
            d.manage().window().setSize(new Dimension(1028, 768))
            return d
        }
    }

}

// To run the tests with all browsers just run “./gradlew test”

// baseUrl used as base with all relative
baseUrl = "https://www.omniwallet.org/"