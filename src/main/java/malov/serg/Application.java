package malov.serg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(final ContactService contactService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Group group = new Group("Test");
                Group group2 = new Group("Learn");
                Contact contact;

                contactService.addGroup(group);
                contactService.addGroup(group2);

                for (int i = 0; i < 13; i++) {
                    contact = new Contact(null, "Roma" + i, "Surname" + i, "050123456" + i, "user" + i + "@gmail.com");
                    contactService.addContact(contact);
                }
                for (int i = 0; i < 10; i++) {
                    contact = new Contact(group, "Masha" + i, "QwertySurname" + i, "096765432" + i, "user" + i + "@ukr.net");
                    contactService.addContact(contact);
                }
                for (int i = 0; i < 10; i++) {
                    contact = new Contact(group2, "Sergey" + i, "SergeySurname" + i, "068543218" + i, "user" + i + "@mail.ru");
                    contactService.addContact(contact);
                }
            }
        };
    }
}