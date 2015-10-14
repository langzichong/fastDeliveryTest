package com.ringcentral.ta.pages.independent;

import com.ringcentral.ta.pages.base.Page;
import com.ringcentral.ta.pages.common.TitleBar;
import com.ringcentral.ta.util.CommonFinder;
import com.ringcentral.ta.util.FindHelper;
import com.ringcentral.ta.util.MobileDevice;
import org.openqa.selenium.WebElement;

public class ContactsPage extends Page {
    public ContactsPage(MobileDevice mobileDevice) {
        super(mobileDevice);
    }

    public WebElement scrollToItemByName(String name) {
        return FindHelper.findElemByNameWithScroll(mobileDevice.getAppiumDriver(), name);
    }

    public void switchToPersonal() {
        new TitleBar(mobileDevice).getTitle().click();
        new CommonFinder(mobileDevice).findElemByText(TitleBar.PERSONAL_CONTACT).click();
    }

    public void switchToCompany() {
        new TitleBar(mobileDevice).getTitle().click();
        new CommonFinder(mobileDevice).findElemByText(TitleBar.COMPANY_CONTACT).click();
    }
}
