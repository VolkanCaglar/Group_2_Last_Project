/**
 * @Author:Group_2 Tarih :30/10/2020
 */
package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class TemplateContent extends _Parent{
    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(linkText = "Got it!")
    public WebElement gotItBtn;

    @FindBy(id = "cookieconsent")
    public WebElement cookieConsent;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton; //sorun olursa bunu kullan

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']/input")
    private WebElement integrationCodeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='priority']/input")
    private WebElement priorityInput;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']/input")
    private WebElement searchNameInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    private WebElement msjContainer;

    @FindBy(xpath = "//span[text()=' Yes ']")
    private WebElement yesButton;

    @FindBy(css = "div[role=alertdialog]")
    private WebElement alertdialog;

    @FindAll({
            @FindBy(xpath = "//div[@id='toast-container']")
    })
    private List<WebElement> msjContainers;

    @FindAll(
            {
                    @FindBy(xpath = "//span[@class='mat-option-text']")
            }
    )
    public List<WebElement> userTypeAllOptions;

    @FindBy(xpath = "//input[@class='mat-autocomplete-trigger mat-chip-input mat-input-element']")
// "//button[@class='mat-autocomplete-trigger mat-chip-input mat-input-element']")
    private WebElement userTypeDropdown;
    /*
        @FindAll({
                @FindBy(xpath = "//mat-option[@class='mat-option mat-focus-indicator ng-star-inserted']")
        })
        public List<WebElement> userTypeAllOptions;

    */
    @FindAll({
            @FindBy(xpath = "//table/tbody/tr/td[2]")
    })
    public List<WebElement> nameList;

    @FindAll({
            @FindBy(xpath = "//ms-delete-button/button")
    })
    private List<WebElement> deleteButtonList;

    @FindAll({
            @FindBy(xpath = "//ms-edit-button/button")
    })
    private List<WebElement> editButtonList;

    @FindAll({
            @FindBy(linkText = "Got it!")
    })
    public List<WebElement> gotItBtns;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']/input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'Error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    /**
     * Parametre olarak ismi girilen WebElementi bulur ve dondurur.
     *
     * @param webElementName
     * @return
     */
    public WebElement findWebElement(String webElementName) {
        switch (webElementName) {
            case "loginButton":
                myElement = loginButton;
                break;

            case "gotItBtn":    //Buradaki sorunu LoginStepste cookieConsent elemaninin gorunur olmasini sorgulayarak cozdum
                // bu eleman yok ise çoklu olarak yinede bulduk
                // eğer gerçekten yok ise size 0 olacağı için
                // bekletmeye düşmesin diye fonksiyonu geri gönderdik.
//                if (gotItBtns.size() == 0)
//                    return;
                myElement = gotItBtn;
                break;

            case "addButton":
                myElement = addButton;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "yesButton":
                myElement = yesButton;
                break;
            case "closeDialog":
                myElement = closeDialog;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "UserTypeDropdown":
                myElement = userTypeDropdown;
                break;
            case "username":
                myElement = username;
                break;

            case "password":
                myElement = password;
                break;

            case "nameInput":
                myElement = nameInput;
                break;

            case "codeInput":
                myElement = codeInput;
                break;

            case "shortName":
                myElement = shortName;
                break;

            case "searchNameInput":
                myElement = searchNameInput;
                break;
            case "integrationCodeInput":
                myElement = integrationCodeInput;
                break;
            case "priorityInput":
                myElement = priorityInput;
                break;
            case "msjContainer":
                myElement = msjContainer;
                break;

            case "errorMessage":
                myElement = errorMessage;
                break;
        }
        return myElement;
    }
    /**
     * Parametre olarak ismi girilen WebElementListi dondurur.
     *
     * @param webElementListName
     * @return
     */
    public List<WebElement> findWebElementList(String webElementListName) {
        switch (webElementListName) {
            case "userTypeAllOptions":
                myElementList = userTypeAllOptions;
                break;
            case "deleteButtonList":
                myElementList = deleteButtonList;
                break;
            case "editButtonList":
                myElementList = editButtonList;
                break;
            case "nameList":
                myElementList = nameList;
                break;
        }
        return myElementList;
    }
    /**
     * Bu metod steps classtan calistirilacak parametre olarak string olarak tiklanacak WebElementin ismini alir.
     *
     * @param element
     */
    public void findElementAndClickFunction(String element) {
        clickFunction(findWebElement(element));
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve value parametresini secilen WebElemente gonderir.
     *
     * @param element
     * @param value
     */
    public void findElementAndSendKeysFunction(String element, String value) {
        sendKeysFunction(findWebElement(element), value);
    }

    /**
     * Bu metod steps classindan cagrilir.
     * Parametre olarak seceneklerin oldugu WebElementListesinin adini ve secim kriterini string olarak alir.
     * Secim parametresi sayi olursa index olarak degerlendirilir ve o indexli WebElement secilir.
     * Parametre sayi degilse WebElementin texti ile karsilastirilir ve kapsayan WebElement secilir.
     * @param listName
     * @param secenek
     */
    public void findElementAndSelectOption(String listName, String secenek) {
        selectOptionByString(findWebElementList(listName), secenek);
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve gorundugunu dogrular.
     * @param elementName
     */
    public void findElementAndVerifyDisplayed(String elementName) {
        verifyMyElementIsDisplayed(findWebElement(elementName));
    }

    /**
     * Parametre olarak ismi gonderilen WebElementi bulur ve
     * parametre olarak giriilen msg nin WebElementin textinde bulundugunu dogrular.
     * @param elementName
     * @param msg
     */
    public void findElementAndVerifyContainsText(String elementName, String msg) {
        verifyElementContainsText(findWebElement(elementName), msg);
    }

    /**
     * Parametre olarak ismi girilen WebElementListin butun elemanlarina clickFunctioni uygular.
     * @param listName
     */
    public void findElementListAndClickToAllElement(String listName) {
        for (WebElement element : findWebElementList(listName)) {
            clickFunction(element);
        }
    }

    /**
     * Parametre olarak ismi girilen WebElementListin ikinci parametrede girilen sayi kadar elemana sahip oldugu dogrulanir.
     * Ikinci parametre "0" girilirse listedeki elemenlari yazdirir.
     * @param elementName
     * @param numberOfItems
     */
    public void findElementListAndNumberOfLstOrPrintItemsOfList(String elementName, int numberOfItems) {
        if (numberOfItems > 0)
            verifyTheNumberOfItemsOnTheList(waitVisibleListAllElement(findWebElementList(elementName)), numberOfItems);
        else
            printToList(findWebElementList(elementName));
    }

    public void findWebElementListAndClickEachOneElementWithForeachAndPrintOfList(String clickElementList, String printElementList) {
        System.out.println("************************************************************");
        System.out.println("List printing started");
        int list = 1;
        for (WebElement element : findWebElementList(clickElementList)) {
            clickFunction(element);
            System.out.println("List:" + list++);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            findElementListAndNumberOfLstOrPrintItemsOfList(printElementList, 0);
        }
        System.out.println("List printing finished");
        System.out.println("************************************************************");
    }
    public void editAndDeleteFunction(String countryName, String editOrDelete) {
        List<WebElement> btnList = new ArrayList<>();
        // invisible olma beklemesini, display ise şartına bağladık, yani
        // gözüküyorsa kaybolana kadar bekle.

        if (msjContainers.size()>0) {
            if (msjContainer.isDisplayed())
                wait.until(ExpectedConditions.invisibilityOfAllElements(msjContainer));
        }
        if (editOrDelete.equalsIgnoreCase("delete")) {
            btnList = waitVisibleListAllElement(deleteButtonList);
        } else btnList = waitVisibleListAllElement(editButtonList);

        for (int i = 0; i < waitVisibleListAllElement(nameList).size(); i++) {
            System.out.println(waitVisibleListAllElement(nameList).get(i).getText());
            if (waitVisibleListAllElement(nameList).get(i).getText().equalsIgnoreCase(countryName)) {
                clickFunction(btnList.get(i));
            }
        }
    }

    /**
     *
     */
    public void deleteAllItemsOfList() {
        List<WebElement> btnList = new ArrayList<>();
        beklet(100);
        for (WebElement e : nameList) {
            beklet(300);
            clickFunction(deleteButtonList.get(0));
            clickFunction(yesButton);
            waitUntilVisible(alertdialog);
            if (alertdialog.getText().contains("You can not delete")) break;
            System.out.println(alertdialog.getText());
        }
    }
}
