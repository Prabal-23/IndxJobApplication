import com.Indx.qa.Base.IndxBase;
import com.Indx.qa.PO.INdxContactFormPO;
import com.Indx.qa.PO.INdxCurrentOpeningPO;
import org.testng.annotations.*;

public class JobApplicationTest extends IndxBase {

    @BeforeMethod
    public  void login(){
      JobApplicationTest j=new JobApplicationTest();

      j.start();  //Reading Property file where url and test data is stored
      j.initialization(); // Launch the browser and hit the url

  }


   @Test(priority =0)
   public  void launchApp(){
       INdxCurrentOpeningPO indxPo =new INdxCurrentOpeningPO();
       indxPo.getCurrentOpeningsAndApplyJob();   // this method fetches the list and validate errormessage and then apply to all available jobs one by one it has other methods inside it in PO class
  }

  @Test(priority =1)
    public void fillAndSubmitContactForm(){
      INdxContactFormPO contactFormPO =new INdxContactFormPO();
      contactFormPO.fillDetaisslContactForm();    // this method fill contact form and submit
  }

  @AfterMethod
   public void closeInstance(){
      endSession();  // closes browser after every @Test method
}




}
