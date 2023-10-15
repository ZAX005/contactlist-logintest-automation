package contactlist;

import org.testng.annotations.DataProvider;

public class DataProviderPage {

    @DataProvider(name="successful")
    public Object[][]dataSet1()
    {
        return new Object[][]
                {
                        {"usethiscontacts@gmail.com","Blaster1985+"},
                        {"usethiscontacts01@gmail.com","Blaster1985"}
                };
    }

    @DataProvider(name="failed")
    public Object[][]dataSet2()
    {
        Object[][] data=
                {
                        {"usethiscontacts@gmail","Blaster1985+"},
                        {"usethiscontacts@gmail.com","Blaster1985"},
                        //{"    usethiscontacts@gmail.com","Blaster1985+"},
                        //{"usethiscontacts@gmail.com    ","Blaster1985+"},
                        {"usethiscontacts@gmail.co","   Blaster1985+"},
                        {"use thiscontacts@gmail.com","Blaster1985+"},
                        //{"USETHISCONTACTS@GMAIL.COM","Blaster1985+"},
                        {"usethiscontacts@gmail.com"," "},
                        {"usethiscontacts@gmail.com","BLASTER1985+"},
                        {"usethiscontacts@gmail.com","  Blaster1985+"},
                        {"usethiscontacts@gmail.com","Blaster1985 +"},
                };
        return data;
    }

}