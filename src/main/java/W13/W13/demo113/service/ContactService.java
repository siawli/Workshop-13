package W13.W13.demo113.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import W13.W13.demo113.models.Contact;

@Service
public class ContactService {

    private static Logger logger = Logger.getLogger(ContactService.class.getName());

    public void savingForm(Contact contact, ApplicationArguments appArgs, Model model) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String dataDir = null;
        String dataFile = contact.getId();
        try {
            if (appArgs != null) {
                List<String> optValues = appArgs.getOptionValues("dataDir");
                dataDir = optValues.get(0);
            }

            fileWriter = new FileWriter(dataDir + "/" + dataFile, Charset.forName("UTF-8"));
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            printWriter.println(contact.getPhoneNumber());
        } catch (IOException e) {
            logger.warning(e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }

        model.addAttribute("contact", contact);
    }

    public void loadContact(String Id, Model model, ApplicationArguments appArgs) {
        String filename = Id;
        String dataDir = null;
        List<String> optValues = appArgs.getOptionValues("dataDir");
        if (optValues != null) {
            dataDir = optValues.get(0);
        }
        System.out.println(">>>>>>>>>>> dataDir " + dataDir);
        Contact ct = new Contact();
        try {
            Path filePath = new File(dataDir + "/" + filename).toPath();
            List<String> stringListVal = Files.readAllLines(filePath, Charset.forName("UTF-8"));
            ct.setName(stringListVal.get(0));
            ct.setEmail(stringListVal.get(1));
            ct.setPhoneNumber(Integer.parseInt(stringListVal.get(2)));
            ct.setId(Id);
            System.out.println(">>>>> name " + ct.getName());
            System.out.println(">>>>> name " + ct.getEmail());
            System.out.println(">>>>> name " + ct.getPhoneNumber());
            System.out.println(">>>>> name " + ct.getId());
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        model.addAttribute("contact", ct);
    }
}
