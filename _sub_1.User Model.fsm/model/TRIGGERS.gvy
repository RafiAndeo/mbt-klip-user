// Trigger script - define one function for each state or transition to be executed when traversed,
// To add a trigger: Ctrl/Cmd-I and select the state or transition.
// Do not remove the following import statement.

import com.testoptimal.mscript.groovy.TRIGGER
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TRIGGER('MBT_START')
def 'MBT_START'() {
	if ($SYS.isSubModel()){
		$SELENIUM.setBrowser($SYS.getExecDir().getExecSetting().getOption('ideBrowser'));
	}
	$VAR.HasTransaction = false;
	$VAR.HasLogin = false;
	$VAR.TotalRegister = 0;
	$VAR.HasAddProduct = false;
	$VAR.HasShowTransaction = false;
}


@TRIGGER('Ud52672b9')
def 'Start: e_Access_Home_Page'() {
	if ($SYS.isSubModel()){
		$SELENIUM.getWebDriver().get('http://127.0.0.1:8000/');
	}
}


@TRIGGER('U89c0b66d')
def 'v_Home_Page: e_Access_Login_Page'() {
	if ($VAR.HasLogin == false){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Login_Element.click();
	}else if ($VAR.HasLogin){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Main_Dashboard_Element.click();

		WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
		End_Element_1.click();

		WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
		End_Element_2.click();
		$VAR.HasTransaction = false;
		$VAR.HasLogin = false;
		$VAR.HasAddProduct = false;
		$VAR.HasShowTransaction = false;
	}
}


@TRIGGER('Ua4f317fb')
def 'v_Home_Page: e_Access_Register_Page'() {
	if ($VAR.TotalRegister == 0){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Register_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/register' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Register_Element.click();
	}else if ($VAR.TotalRegister >= 1){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Main_Dashboard_Element.click();

		WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
		End_Element_1.click();

		WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
		End_Element_2.click();
		$VAR.HasTransaction = false;
		$VAR.HasLogin = false;
		$VAR.HasAddProduct = false;
		$VAR.HasShowTransaction = false;
	}
}


@TRIGGER('Uf722ec6d')
def 'v_Login_Page: e_Access_Main_Dashboard_Page'() {
	email = $SYS.getData('email');
	password = $SYS.getData('password');

	$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
	$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
	$VAR.HasLogin = true;
}


@TRIGGER('Uf568eb23')
def 'v_Register_Page: e_Access_Main_Dashboard_Page'() {
	name = $SYS.getData('name');
	email = $SYS.getData('email');
	password = $SYS.getData('password');
	confirm_password = $SYS.getData('confirm_password');

	$SELENIUM.getWebDriver().findElement(By.id('name')).sendKeys(name);
	$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
	$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
	$SELENIUM.getWebDriver().findElement(By.id('password_confirmation')).sendKeys(confirm_password);
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-4']")).click();
	$VAR.TotalRegister+=1;
}


@TRIGGER('U530cf014')
def 'v_Main_Dashboard_Page: e_Return_Home_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Home_Page_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000' and contains(@class, 'bg-green-500 rounded-full px-4 py-2 mx-4 my-4 text-xs font-semibold text-white')]")));
	Home_Page_Element.click();
}


@TRIGGER('U82319613')
def 'v_Home_Page: e_Access_Product_Details_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Product_Details_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/details/seragam-merah-telkom-university' and contains(@class, 'stretched-link')]")));
	Product_Details_Element.click();
}


@TRIGGER('U61d35aa4')
def 'v_Product_Details_Page: e_Access_Cart_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Cart_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'transition-all duration-200 bg-red-600 text-white focus:bg-black focus:text-red-600 rounded-full px-8 py-3 mt-4 inline-flex')]")));
	Cart_Element.click();
	$VAR.HasAddProduct = true;
}


@TRIGGER('Uc6b9ab89')
def 'v_Cart_Page: e_Access_Success_Checkout_Page'() {
	name = $SYS.getData('name');
	email = $SYS.getData('email');
	address = $SYS.getData('address');
	phone = $SYS.getData('phone');
	size = $SYS.getData('size');

	$SELENIUM.getWebDriver().findElement(By.id('complete-name')).sendKeys(name);
	$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
	$SELENIUM.getWebDriver().findElement(By.id('address')).sendKeys(address);
	$SELENIUM.getWebDriver().findElement(By.id('phone-number')).sendKeys(phone);
	$SELENIUM.getWebDriver().findElement(By.id('desc')).sendKeys(size);

	$SELENIUM.getWebDriver().findElement(By.xpath("//input[@id='url']")).sendKeys("C:\\Users\\LENOVO\\Pictures\\aurora-borealis-9h.jpg");
	$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='bg-red-600 text-white hover:bg-red-800 hover:text-white focus:outline-none w-full py-3 rounded-full text-lg focus:text-black transition-all duration-200 px-6']")).click();
	$VAR.HasTransaction = true;
}


@TRIGGER('U1a892b95')
def 'v_Cart_Page: e_Access_Main_Dashboard_Page'() {
	if ($VAR.HasLogin == true){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-black hover:underline')]")));
		Main_Dashboard_Element.click();
	}else {
		email = $SYS.getData('email');
		password = $SYS.getData('password');

		$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
		$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
		$SELENIUM.getWebDriver().get('http://127.0.0.1:8000/dashboard');
		$VAR.HasLogin = true;
	}
}


@TRIGGER('U121df579')
def 'v_Cart_Page: e_Return_Home_Page'() {
	if ($VAR.HasLogin == true){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Home_Page_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000']")));
		Home_Page_Element.click();
	}else {
		email = $SYS.getData('email');
		password = $SYS.getData('password');

		$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
		$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
		$SELENIUM.getWebDriver().get('http://127.0.0.1:8000/');
		$VAR.HasLogin = true;
	}
}


@TRIGGER('U9cc7465a')
def 'v_Success_Checkout_Page: e_Return_Cart_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Cart_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/cart' and contains(@class, 'flex items-center justify-center w-8 h-8 text-black  md:text-black')]")));
	Cart_Element.click();
}


@TRIGGER('U598f895a')
def 'v_Success_Checkout_Page: e_Return_Home_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Home_Page_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000']")));
	Home_Page_Element.click();
}


@TRIGGER('U320e2979')
def 'v_Success_Checkout_Page: e_Access_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-black hover:underline')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U5225dcb2')
def 'v_Home_Page: e_Access_Cart_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Cart_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/cart' and contains(@class, 'flex items-center justify-center w-8 h-8 text-black  md:text-white')]")));
	Cart_Element.click();
}


@TRIGGER('Uac93e89a')
def 'v_Home_Page: e_Access_Main_Dashboard_Page'() {
	if ($VAR.HasLogin == true) {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Main_Dashboard_Element.click();
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Login_Element.click();

		email = $SYS.getData('email');
		password = $SYS.getData('password');

		$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
		$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
		$VAR.HasLogin = true;
	}
}


@TRIGGER('Uc9488546')
def 'v_Main_Dashboard_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasTransaction = false;
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasShowTransaction = false;
}


@TRIGGER('U83d5ca75')
def 'v_Product_Details_Page: e_Access_Main_Dashboard_Page'() {
	if ($VAR.HasLogin == true) {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-black hover:underline')]")));
		Main_Dashboard_Element.click();
	}else {
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-black hover:underline')]")));
		Login_Element.click();

		email = $SYS.getData('email');
		password = $SYS.getData('password');

		$SELENIUM.getWebDriver().findElement(By.id('email')).sendKeys(email);
		$SELENIUM.getWebDriver().findElement(By.id('password')).sendKeys(password);
		$SELENIUM.getWebDriver().findElement(By.xpath("//button[@class='inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent rounded-md font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:ring ring-gray-300 disabled:opacity-25 transition ease-in-out duration-150 ml-3']")).click();
		$VAR.HasLogin = true;
	}
}


@TRIGGER('Ufe8a3f68')
def 'v_Product_Details_Page: e_Return_Home_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Home_Page_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000']")));
	Home_Page_Element.click();
}


@TRIGGER('U93c8f287')
def 'v_Product_Details_Page: e_Access_Login_Page'() {
	if ($VAR.HasLogin == false){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-black hover:underline')]")));
		Login_Element.click();
	}else if ($VAR.HasLogin){
		WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
		WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'text-black md:text-black hover:underline')]")));
		Main_Dashboard_Element.click();

		WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
		End_Element_1.click();

		WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
		End_Element_2.click();
		$VAR.HasTransaction = false;
		$VAR.HasLogin = false;
		$VAR.HasAddProduct = false;
		$VAR.HasShowTransaction = false;

		WebElement Login_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/login' and contains(@class, 'text-black md:text-white hover:underline')]")));
		Login_Element.click();
	}
}


@TRIGGER('U2075e020')
def 'v_Main_Dashboard_Page: e_Access_Dashboard_My_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_My_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/my-transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_My_Transaction_Element.click();
}


@TRIGGER('U7ff77694')
def 'v_Dashboard_My_Transaction_Page: e_Access_Show_My_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Show_My_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/my-transaction/1' and contains(@class, 'inline-block border border-green-700 bg-green-500 text-white rounded-md px-2 py-1 m-1 transition duration-500 ease select-none hover:bg-blue-800 focus:outline-none focus:shadow-outline')]")));
	Show_My_Transaction_Element.click();
	$VAR.HasShowTransaction = true;
}


@TRIGGER('U1c0f9d55')
def 'v_Dashboard_My_Transaction_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasTransaction = false;
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasShowTransaction = false;
}


@TRIGGER('U4c67f25b')
def 'v_Dashboard_My_Transaction_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('U4530fd20')
def 'v_Show_My_Transaction_Page: e_End'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement End_Element_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='flex items-center text-sm font-medium text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out']")));
	End_Element_1.click();

	WebElement End_Element_2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/logout' and contains(@class, 'block px-4 py-2 text-sm leading-5 text-gray-700 hover:bg-gray-100 focus:outline-none focus:bg-gray-100 transition duration-150 ease-in-out')]")));
	End_Element_2.click();
	$VAR.HasTransaction = false;
	$VAR.HasLogin = false;
	$VAR.HasAddProduct = false;
	$VAR.HasShowTransaction = false;
}


@TRIGGER('U3f19065b')
def 'v_Show_My_Transaction_Page: e_Return_Dashboard_My_Transaction_Page'() {
	WebDriverWait wait = new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Dashboard_My_Transaction_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard/my-transaction' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Dashboard_My_Transaction_Element.click();
}


@TRIGGER('U6300ac30')
def 'v_Show_My_Transaction_Page: e_Return_Main_Dashboard_Page'() {
	WebDriverWait wait  =new WebDriverWait($SELENIUM.getWebDriver(), 5);
	WebElement Main_Dashboard_Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://127.0.0.1:8000/dashboard' and contains(@class, 'inline-flex items-center px-1 pt-1 border-b-2 border-transparent text-sm font-medium leading-5 text-gray-500 hover:text-gray-700 hover:border-gray-300 focus:outline-none focus:text-gray-700 focus:border-gray-300 transition duration-150 ease-in-out')]")));
	Main_Dashboard_Element.click();
}


@TRIGGER('MBT_FAIL')
def 'MBT_FAIL'() {
	$SELENIUM.snapScreen('');
}