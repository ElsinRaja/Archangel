package Lanch;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
public class Login {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new LaunchOptions().setHeadless(false)
                );
        Page page = browser.newPage();
        page.navigate("https://mercy-qa.hclvoltmx.net/apps/Archangel/");
        page.locator("(//span[@id='flxLogoptn_imgChkbx_span']//img)[1]").click();
        page.locator("(//div[@class='kcell sknbtnlogingreen']//input)[2]").click();
        page.locator("(//div[normalize-space(text())='User Name']/following::input)[1]").type("Elsinorgone");
        page.locator("(//div[@class='kcell skntxtCircleN']//input)[2]").type("Welcome@20");
        page.locator("(//div[@class='kcell sknbtnlogingreen']//input)[2]").click();
        PlaywrightAssertions.assertThat(page).hasTitle("ArchAngel");
        browser.close();
	}
}
