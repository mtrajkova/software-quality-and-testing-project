package com.example.europa.web;

import com.example.europa.model.*;
import com.example.europa.model.blood.*;
import com.example.europa.persistance.service.*;
import com.example.europa.utils.LocalDateTimeToStringConverter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateEntitiesController {
    private ItemService itemService;
    private PatientService patientService;
    private MedicineService medicineService;
    private BloodTypeService bloodTypeService;
    private BloodTypeGivesService bloodTypeGivesService;
    private BloodTypeReceivesService bloodTypeReceivesService;
    private BloodDonationEventService bloodDonationEventService;
    private ResearchService researchService;

    public CreateEntitiesController(ItemService itemService, PatientService patientService, MedicineService medicineService, BloodTypeService bloodTypeService, BloodTypeGivesService bloodTypeGivesService, BloodTypeReceivesService bloodTypeReceivesService, BloodDonationEventService bloodDonationEventService, ResearchService researchService) {
        this.itemService = itemService;
        this.patientService = patientService;
        this.medicineService = medicineService;
        this.bloodTypeService = bloodTypeService;
        this.bloodTypeGivesService = bloodTypeGivesService;
        this.bloodTypeReceivesService = bloodTypeReceivesService;
        this.bloodDonationEventService = bloodDonationEventService;
        this.researchService = researchService;
    }

    @GetMapping("/patient")
    public List<Patient> createPatients() {
        List<Patient> patients = new ArrayList<>();
        Patient patient = new Patient();
        patient.setFirstName("Vladimir");
        patient.setLastName("Zdraveski");
        BloodType bloodType = this.bloodTypeService.findByType("O-").get();
        patient.setBloodType(bloodType);
        patient.setPoints(0L);
        patient.setCity("Skopje");
        patient.setEmail("vladimir_zdraveski@mail.com");
        patient.setCountry("Macedonia");
        patient.setPersonalId("223305");
        patient.setPostalCode("1000");
        patient.setResearchFunds(100L);
        this.patientService.save(patient);
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Dr. Angelko");
        patient.setLastName("Jankoski");
        bloodType = this.bloodTypeService.findByType("O+").get();
        patient.setBloodType(bloodType);
        patient.setPoints(0L);
        patient.setCity("Gostivar");
        patient.setEmail("angelko_jankoski@mail.com");
        patient.setCountry("Macedonia");
        patient.setPersonalId("12345");
        patient.setPostalCode("1230");
        patient.setResearchFunds(100L);
        this.patientService.save(patient);
        patients.add(patient);

        return patients;
    }

    @GetMapping("/medicine")
    public List<Medicine> createMedicines() throws IOException {
        List<Medicine> medicines = new ArrayList<>();
        DecimalFormat df = new DecimalFormat(".##");
        /*byte[] picture = Files.readAllBytes(path);
        Random random = new Random();
        for (int i = 1; i < 6; i++) {
            Medicine medicine = new Medicine();
            medicine.setName("Medicine" + i);
            medicine.setDescription("Description" + i);
            medicine.setPoints(i + 5L);
            Double price = random.nextDouble() * 10 + i;
            medicine.setPrice(Double.parseDouble(df.format(price)));
            medicine.setPicture(picture);

            medicines.add(medicine);

            this.medicineService.save(medicine);
        }*/
        Path path = Paths.get("./zyrtec.jpg");
        byte[] picture = Files.readAllBytes(path);
        Medicine medicine = new Medicine();
        medicine.setName("Zyrtec");
        medicine.setDescription("Zyrtec (cetirizine hydrochloride) is an antihistamine that treats symptoms, such as itching, runny nose, watery eyes, and sneezing from hay fever (allergic rhinitis) and other allergies, such as allergies to molds and dust mites. Zyrtec is available in generic form and over-the-counter (OTC).");
        medicine.setPicture(picture);
        medicine.setPrice(2.5);
        medicine.setPoints(10L);
        medicines.add(medicine);
        this.medicineService.save(medicine);

        path = Paths.get("./andol.jpg");
        picture = Files.readAllBytes(path);
        medicine = new Medicine();
        medicine.setName("Andol");
        medicine.setDescription("Andol 1.5 MG Tablet is an antipsychotic drug that is used in the treatment of Schizophrenia and other mood disorders. This drug should be taken at the same time regularly. Do not stop taking this medicine suddenly without informing your doctor as it may cause withdrawal symptoms.");
        medicine.setPicture(picture);
        medicine.setPrice(1.8);
        medicine.setPoints(8L);
        medicines.add(medicine);
        this.medicineService.save(medicine);

        path = Paths.get("./letizen.jpeg");
        picture = Files.readAllBytes(path);
        medicine = new Medicine();
        medicine.setName("Letizen");
        medicine.setDescription("Letizen is an antihistamine that reduces the effects of natural chemical histamine in the body. Histamine can produce symptoms of sneezing, itching, watery eyes, and runny nose.");
        medicine.setPicture(picture);
        medicine.setPrice(3D);
        medicine.setPoints(12L);
        medicines.add(medicine);
        this.medicineService.save(medicine);

        path = Paths.get("./paracetamol.jpg");
        picture = Files.readAllBytes(path);
        medicine = new Medicine();
        medicine.setName("Paracetamol");
        medicine.setDescription("Paracetamol, also known as acetaminophen or APAP, is a medicine used to treat pain and fever. It is typically used for mild to moderate pain relief. ... It is often sold in combination with other medications, such as in many cold medications.");
        medicine.setPicture(picture);
        medicine.setPrice(4.2);
        medicine.setPoints(20L);
        medicines.add(medicine);
        this.medicineService.save(medicine);

        path = Paths.get("./fervex.jpg");
        picture = Files.readAllBytes(path);
        medicine = new Medicine();
        medicine.setName("Fervex");
        medicine.setDescription("Fervex Adult Sugar-Free is suitable for treating common cold, rhinitis and flu-like conditions in adults (ages 15 and over): clear nasal discharge and watering eyes, sneezing, headaches and/or fever.");
        medicine.setPicture(picture);
        medicine.setPrice(1.2);
        medicine.setPoints(9L);
        medicines.add(medicine);
        this.medicineService.save(medicine);

        return medicines;

    }

    @GetMapping("/item")
    public List<Item> createItems() throws IOException {
        List<Item> items = new ArrayList<>();
        /*Path path = Paths.get("./item.png");
        byte[] picture = Files.readAllBytes(path);
        Random random = new Random();
        for (int i = 1; i < 6; i++) {
            Item item = new Item();
            item.setName("Item" + i);
            item.setPicture(picture);
            item.setPrice(new Long(random.nextInt(300)));

            items.add(item);
            this.itemService.save(item);
        }*/
        Item item = new Item();
        Path path = Paths.get("./gym.jpg");
        byte[] picture = Files.readAllBytes(path);
        item.setName("Gym membership");
        item.setPicture(picture);
        item.setDescription("This membership lasting for a month (any time of current year) will help you regain your strength and get in better shape overall. Be ready for a change.");
        item.setPrice(1500L);
        this.itemService.save(item);
        items.add(item);

        item = new Item();
        path = Paths.get("./kosmodisk.jpg");
        picture = Files.readAllBytes(path);
        item.setName("Cosmodisc");
        item.setPicture(picture);
        item.setDescription("Having problems with your spine and feeling undescribable pain in your back? Cosmodisc is the perfect answer for you. This device will straigthen your back and the pain will go away in a matter of months.");
        item.setPrice(2500L);
        this.itemService.save(item);
        items.add(item);

        item = new Item();
        path = Paths.get("./massage.jpg");
        picture = Files.readAllBytes(path);
        item.setName("Massage");
        item.setPicture(picture);
        item.setDescription("Get your proper rest and relaxation in one of our facilities. With the gentle firm grip of our strong masseues, you will feel recovered in no time.");
        item.setPrice(1000L);
        this.itemService.save(item);
        items.add(item);

        item = new Item();
        path = Paths.get("./powerJuicer.jpg");
        picture = Files.readAllBytes(path);
        item.setName("Power Juicer");
        item.setPicture(picture);
        item.setDescription("This juicer extracts juice from fruits, herbs, leafy greens and other types of vegetables in a process called juicing. It crushes, grinds, and/or squeezes the juice out of the pulp.");
        item.setPrice(1500L);
        this.itemService.save(item);
        items.add(item);

        item = new Item();
        path = Paths.get("./walkmax.jpg");
        picture = Files.readAllBytes(path);
        item.setName("Walkmaxx");
        item.setPicture(picture);
        item.setDescription("The goal is to offer you the feeling of natural walking thanks to the newest technology and inovation for shoes. These shoes will satisfy the needs for all seasons.");
        item.setPrice(2200L);
        this.itemService.save(item);
        items.add(item);
        return items;
    }

    @GetMapping("/bloodTypes")
    public String createBloodType() throws IOException {
        BloodType aPositive = new BloodType("A+");
        BloodType aNegative = new BloodType("A-");
        BloodType abPositive = new BloodType("AB+");
        BloodType abNegative = new BloodType("AB-");
        BloodType oPositive = new BloodType("O+");
        BloodType oNegative = new BloodType("O-");
        BloodType bPositive = new BloodType("B+");
        BloodType bNegative = new BloodType("B-");

        Path ap = Paths.get("./A+.png");
        Path an = Paths.get("./A-.png");
        Path bp = Paths.get("./B+.png");
        Path bn = Paths.get("./B-.png");
        Path abp = Paths.get("./AB+.png");
        Path abn = Paths.get("./AB-.png");
        Path op = Paths.get("./O+.png");
        Path on = Paths.get("./O-.png");

        aPositive.setPicture(Files.readAllBytes(ap));
        aNegative.setPicture(Files.readAllBytes(an));
        bPositive.setPicture(Files.readAllBytes(bp));
        bNegative.setPicture(Files.readAllBytes(bn));
        abPositive.setPicture(Files.readAllBytes(abp));
        abNegative.setPicture(Files.readAllBytes(abn));
        oPositive.setPicture(Files.readAllBytes(op));
        oNegative.setPicture(Files.readAllBytes(on));

        this.bloodTypeService.save(aPositive);
        this.bloodTypeService.save(aNegative);
        this.bloodTypeService.save(bPositive);
        this.bloodTypeService.save(bNegative);
        this.bloodTypeService.save(abPositive);
        this.bloodTypeService.save(abNegative);
        this.bloodTypeService.save(oPositive);
        this.bloodTypeService.save(oNegative);

        BloodTypeGives btg1 = new BloodTypeGives("O+", "O+");
        BloodTypeGives btg2 = new BloodTypeGives("O+", "A+");
        BloodTypeGives btg3 = new BloodTypeGives("O+", "B+");
        BloodTypeGives btg4 = new BloodTypeGives("O+", "AB+");
        BloodTypeGives btg5 = new BloodTypeGives("A+", "A+");
        BloodTypeGives btg6 = new BloodTypeGives("A+", "AB+");
        BloodTypeGives btg7 = new BloodTypeGives("B+", "B+");
        BloodTypeGives btg8 = new BloodTypeGives("B+", "AB+");
        BloodTypeGives btg9 = new BloodTypeGives("AB+", "AB+");
        BloodTypeGives btg10 = new BloodTypeGives("O-", "O+");
        BloodTypeGives btg11 = new BloodTypeGives("O-", "O-");
        BloodTypeGives btg12 = new BloodTypeGives("O-", "A+");
        BloodTypeGives btg13 = new BloodTypeGives("O-", "A-");
        BloodTypeGives btg14 = new BloodTypeGives("O-", "B+");
        BloodTypeGives btg15 = new BloodTypeGives("O-", "B-");
        BloodTypeGives btg16 = new BloodTypeGives("O-", "AB+");
        BloodTypeGives btg17 = new BloodTypeGives("O-", "AB-");
        BloodTypeGives btg18 = new BloodTypeGives("A-", "A-");
        BloodTypeGives btg19 = new BloodTypeGives("A-", "A+");
        BloodTypeGives btg20 = new BloodTypeGives("A-", "AB+");
        BloodTypeGives btg21 = new BloodTypeGives("A-", "AB-");
        BloodTypeGives btg22 = new BloodTypeGives("B-", "B+");
        BloodTypeGives btg23 = new BloodTypeGives("B-", "B-");
        BloodTypeGives btg24 = new BloodTypeGives("B-", "AB+");
        BloodTypeGives btg25 = new BloodTypeGives("B-", "AB-");
        BloodTypeGives btg26 = new BloodTypeGives("AB-", "AB+");
        BloodTypeGives btg27 = new BloodTypeGives("AB-", "AB-");

        this.bloodTypeGivesService.save(btg1);
        this.bloodTypeGivesService.save(btg2);
        this.bloodTypeGivesService.save(btg3);
        this.bloodTypeGivesService.save(btg4);
        this.bloodTypeGivesService.save(btg5);
        this.bloodTypeGivesService.save(btg6);
        this.bloodTypeGivesService.save(btg7);
        this.bloodTypeGivesService.save(btg8);
        this.bloodTypeGivesService.save(btg9);
        this.bloodTypeGivesService.save(btg10);
        this.bloodTypeGivesService.save(btg11);
        this.bloodTypeGivesService.save(btg12);
        this.bloodTypeGivesService.save(btg13);
        this.bloodTypeGivesService.save(btg14);
        this.bloodTypeGivesService.save(btg15);
        this.bloodTypeGivesService.save(btg16);
        this.bloodTypeGivesService.save(btg17);
        this.bloodTypeGivesService.save(btg18);
        this.bloodTypeGivesService.save(btg19);
        this.bloodTypeGivesService.save(btg20);
        this.bloodTypeGivesService.save(btg21);
        this.bloodTypeGivesService.save(btg22);
        this.bloodTypeGivesService.save(btg23);
        this.bloodTypeGivesService.save(btg24);
        this.bloodTypeGivesService.save(btg25);
        this.bloodTypeGivesService.save(btg26);
        this.bloodTypeGivesService.save(btg27);


        BloodTypeReceives btr1 = new BloodTypeReceives("O+", "O+");
        BloodTypeReceives btr2 = new BloodTypeReceives("O+", "O-");
        BloodTypeReceives btr3 = new BloodTypeReceives("A+", "A+");
        BloodTypeReceives btr4 = new BloodTypeReceives("A+", "A-");
        BloodTypeReceives btr5 = new BloodTypeReceives("A+", "A+");
        BloodTypeReceives btr6 = new BloodTypeReceives("A+", "O+");
        BloodTypeReceives btr7 = new BloodTypeReceives("A+", "O-");
        BloodTypeReceives btr8 = new BloodTypeReceives("B+", "B+");
        BloodTypeReceives btr9 = new BloodTypeReceives("B+", "B-");
        BloodTypeReceives btr10 = new BloodTypeReceives("B+", "O+");
        BloodTypeReceives btr11 = new BloodTypeReceives("B+", "O-");
        BloodTypeReceives btr12 = new BloodTypeReceives("AB+", "O+");
        BloodTypeReceives btr13 = new BloodTypeReceives("AB+", "O-");
        BloodTypeReceives btr14 = new BloodTypeReceives("AB+", "A+");
        BloodTypeReceives btr15 = new BloodTypeReceives("AB+", "A-");
        BloodTypeReceives btr16 = new BloodTypeReceives("AB+", "B+");
        BloodTypeReceives btr17 = new BloodTypeReceives("AB+", "B-");
        BloodTypeReceives btr18 = new BloodTypeReceives("AB+", "AB-");
        BloodTypeReceives btr19 = new BloodTypeReceives("AB+", "AB+");
        BloodTypeReceives btr20 = new BloodTypeReceives("O-", "O-");
        BloodTypeReceives btr21 = new BloodTypeReceives("A-", "A-");
        BloodTypeReceives btr22 = new BloodTypeReceives("A-", "O-");
        BloodTypeReceives btr23 = new BloodTypeReceives("B-", "B-");
        BloodTypeReceives btr24 = new BloodTypeReceives("B-", "O-");
        BloodTypeReceives btr25 = new BloodTypeReceives("B-", "AB-");
        BloodTypeReceives btr26 = new BloodTypeReceives("AB-", "AB-");
        BloodTypeReceives btr27 = new BloodTypeReceives("AB-", "A-");
        BloodTypeReceives btr28 = new BloodTypeReceives("AB-", "B-");
        BloodTypeReceives btr29 = new BloodTypeReceives("AB-", "O-");

        this.bloodTypeReceivesService.save(btr1);
        this.bloodTypeReceivesService.save(btr2);
        this.bloodTypeReceivesService.save(btr3);
        this.bloodTypeReceivesService.save(btr4);
        this.bloodTypeReceivesService.save(btr5);
        this.bloodTypeReceivesService.save(btr6);
        this.bloodTypeReceivesService.save(btr7);
        this.bloodTypeReceivesService.save(btr8);
        this.bloodTypeReceivesService.save(btr9);
        this.bloodTypeReceivesService.save(btr10);
        this.bloodTypeReceivesService.save(btr11);
        this.bloodTypeReceivesService.save(btr12);
        this.bloodTypeReceivesService.save(btr13);
        this.bloodTypeReceivesService.save(btr14);
        this.bloodTypeReceivesService.save(btr15);
        this.bloodTypeReceivesService.save(btr16);
        this.bloodTypeReceivesService.save(btr17);
        this.bloodTypeReceivesService.save(btr18);
        this.bloodTypeReceivesService.save(btr19);
        this.bloodTypeReceivesService.save(btr20);
        this.bloodTypeReceivesService.save(btr21);
        this.bloodTypeReceivesService.save(btr22);
        this.bloodTypeReceivesService.save(btr23);
        this.bloodTypeReceivesService.save(btr24);
        this.bloodTypeReceivesService.save(btr25);
        this.bloodTypeReceivesService.save(btr26);
        this.bloodTypeReceivesService.save(btr27);

        return "blood types created";
    }

    @GetMapping("/event")
    public List<BloodDonationEvent> createEvent() {
        List<BloodDonationEvent> events = new ArrayList<>();
        BloodDonationEvent event = new BloodDonationEvent();

        event.setName("Emergency operation");
        event.setDateCreated("19/06/2018 22:17");
        event.setDescription("Our patient is in the emergency room getting prepared for an operation. We need more supplies of blood type O+.");
        event.setPhoneNumber("+389 41 223 305");
        BloodType bloodType = this.bloodTypeService.findByType("O+").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        event = new BloodDonationEvent();
        event.setName("Car accident");
        event.setDateCreated("11/06/2018 09:43");
        event.setDescription("A father of two kids got in a car accident 1 hour ago. He is in the need of blood transfusion for which we need more blood.");
        event.setPhoneNumber("+389 52 331 412");
        bloodType = this.bloodTypeService.findByType("AB-").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        event = new BloodDonationEvent();
        event.setName("Chemo therapy");
        event.setDateCreated("25/06/2018 17:40");
        event.setDescription("The patient is on her fourth chemo therapy treatment.");
        event.setPhoneNumber("+389 41 223 305");
        bloodType = this.bloodTypeService.findByType("B-").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        event = new BloodDonationEvent();
        event.setName("Severe infection");
        event.setDateCreated("29/05/2018 13:12");
        event.setDescription("The sever infection stops his body from properly making blood.");
        event.setPhoneNumber("+389 41 786 305");
        bloodType = this.bloodTypeService.findByType("A+").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        event = new BloodDonationEvent();
        event.setName("Kidney disease");
        event.setDateCreated("25/06/2018 17:40");
        event.setDescription("Our patient has a kidney disease that causes anemia (not enough healthy red blood cells)");
        event.setPhoneNumber("+389 31 111 305");
        bloodType = this.bloodTypeService.findByType("B+").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        event = new BloodDonationEvent();
        event.setName("Gun shot wound");
        event.setDateCreated("09/06/2018 15:54");
        event.setDescription("The patient has been shot from a stray bullet from a robbery gone wrong.");
        event.setPhoneNumber("+389 41 223 305");
        bloodType = this.bloodTypeService.findByType("O-").get();
        event.setBloodType(bloodType);
        this.bloodDonationEventService.save(event);
        events.add(event);

        return events;
    }

    @GetMapping("/research")
    public List<Research> createResearches() throws IOException {
        List<Research> researches = new ArrayList<>();

        Path path = Paths.get("./breast.jpg");
        byte[] picture = Files.readAllBytes(path);
        Research research = new Research();
        research.setName("Breast cancer research");
        research.setCurrentBudget(14200L);
        research.setTotalBudget(28000L);
        research.setDiscovered(28L);
        research.setDescription("Breast cancer is cancer that develops from breast tissue.Signs of breast cancer may include a lump in the breast, a change in breast shape, dimpling of the skin, fluid coming from the nipple, a newly inverted nipple, or a red or scaly patch of skin. In those with distant spread of the disease, there may be bone pain, swollen lymph nodes, shortness of breath, or yellow skin.");
        research.setOrganization("Europa Breast Cancer Organization");
        research.setPicture(picture);
        research.setBudgetingPercent(research.getCurrentBudget() * 100 / research.getTotalBudget());
        researches.add(research);
        this.researchService.save(research);

        path = Paths.get("./lung.jpg");
        picture = Files.readAllBytes(path);
        research = new Research();
        research.setName("Lung cancer research");
        research.setCurrentBudget(10100L);
        research.setTotalBudget(25000L);
        research.setDiscovered(56L);
        research.setDescription("Lung cancer, also known as lung carcinoma, is a malignant lung tumor characterized by uncontrolled cell growth in tissues of the lung. This growth can spread beyond the lung by the process of metastasis into nearby tissue or other parts of the body. Most cancers that start in the lung, known as primary lung cancers, are carcinomas. The two main types are small-cell lung carcinoma (SCLC) and non-small-cell lung carcinoma (NSCLC). The most common symptoms are coughing (including coughing up blood), weight loss, shortness of breath, and chest pains.");
        research.setOrganization("Europa Lung Cancer Organization");
        research.setPicture(picture);
        research.setBudgetingPercent(research.getCurrentBudget() * 100 / research.getTotalBudget());
        researches.add(research);
        this.researchService.save(research);

        path = Paths.get("./cardio.jpg");
        picture = Files.readAllBytes(path);
        research = new Research();
        research.setName("Cardiovascular disease research");
        research.setCurrentBudget(8000L);
        research.setTotalBudget(19000L);
        research.setDiscovered(49L);
        research.setDescription("Cardiovascular disease (CVD) is a class of diseases that involve the heart or blood vessels. Cardiovascular disease includes coronary artery diseases (CAD) such as angina and myocardial infarction (commonly known as a heart attack). Other CVDs include stroke, heart failure, hypertensive heart disease, rheumatic heart disease, cardiomyopathy, heart arrhythmia, congenital heart disease, valvular heart disease, carditis, aortic aneurysms, peripheral artery disease, thromboembolic disease, and venous thrombosis.");
        research.setOrganization("Europa Cardiovascular Disease Organization");
        research.setPicture(picture);
        research.setBudgetingPercent(research.getCurrentBudget() * 100 / research.getTotalBudget());
        researches.add(research);
        this.researchService.save(research);

        return researches;
    }

    @GetMapping("/application")
    public List<BloodDonationApplication> createApplications(){
        List<BloodDonationApplication> apps = new ArrayList<>();

        BloodDonationApplication bda = new BloodDonationApplication();

        return apps;
    }

}
