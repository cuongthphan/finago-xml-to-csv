package com.example.finagoxmltocsv;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.example.finagoxmltocsv.Objects.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    private final String FINAGO_DATE_FORMAT = "d.M.yyyy";
    private final String CSV_SEPARATOR = ";";
    
    private VerticalLayout layout;
    private HorizontalLayout controlsLayout;
    private Label fileLabel;
    private Upload fileUpload;
    private Button downloadButton;
    private FileDownloader fileDownloader;
    
    private File xmlFile;
    private File csvFile;
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        layout = new VerticalLayout();
        controlsLayout = new HorizontalLayout();
        
        fileLabel = new Label();
        fileUpload = createNewUpload();
        downloadButton = new Button("Export as CSV");
        downloadButton.addClickListener((Button.ClickListener) event -> {
            if (csvFile != null) {
                System.out.printf("Download.");
            }
        });
        
        controlsLayout.addComponents(fileLabel, fileUpload, downloadButton);
        controlsLayout.setComponentAlignment(fileLabel, Alignment.MIDDLE_LEFT);
        layout.addComponents(controlsLayout);
        
        updateFileLabel();
        updateDownloadButton();
        setContent(layout);
    }
    
    private void updateFileLabel() {
        fileLabel.setVisible(xmlFile != null);
        fileLabel.setValue(xmlFile != null ? xmlFile.getName() : "");
    }
    
    private void updateDownloadButton() {
        downloadButton.setEnabled(xmlFile != null);
    }
    
    private void convertXmlToCsv() {
        try {
            // unmarshal xmlFile
            JAXBContext jaxbContext = JAXBContext.newInstance(Finvoice.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Finvoice finvoice = (Finvoice) unmarshaller.unmarshal(xmlFile);
            
            // write Finvoice to csvFile
            writeCsvFile(finvoice);
        } catch (Exception e) {
            Notification.show("Error parsing xml file. Check file format.", Notification.Type.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    // create csv file based on Finvoice object
    private void writeCsvFile(Finvoice finvoice) throws Exception {
        csvFile = new File("finago.csv");
        try (PrintWriter writer = new PrintWriter(csvFile)) {
            BuyerPartyDetails buyerPartyDetails = finvoice.getBuyerPartyDetails();
            DeliveryPartyDetails deliveryPartyDetails = finvoice.getDeliveryPartyDetails();
            InvoiceDetails invoiceDetails = finvoice.getInvoiceDetails();
            List<InvoiceRow> invoiceRows = finvoice.getInvoiceRow();
            SimpleDateFormat finagoDateFormat = new SimpleDateFormat(FINAGO_DATE_FORMAT);
            
            // write Invoice record
            StringBuilder sb = new StringBuilder();
            // 1-A
            sb.append(invoiceDetails.getInvoiceTypeCode().getValue() + CSV_SEPARATOR);
            // 2-B
            sb.append(invoiceDetails.getInvoiceTotalVatIncludedAmount().getAmountCurrencyIdentifier()
                    + CSV_SEPARATOR);
            // 3-C, 4-D
            sb.append(CSV_SEPARATOR + CSV_SEPARATOR);
            // 5-E
            sb.append(buyerPartyDetails.getBuyerPartyIdentifier() + CSV_SEPARATOR);
            // 6-F
            sb.append(CSV_SEPARATOR);
            // 7-G
            sb.append(buyerPartyDetails.getBuyerOrganisationName() + CSV_SEPARATOR);
            // 8-H, 9-I, 10-J, 11-K
            for (int i = 0; i < 4; i++) {
                sb.append(CSV_SEPARATOR);
            }
            // 12-L
            sb.append(invoiceDetails.getPaymentTermsDetails().getPaymentOverDueFineDetails()
                    .getPaymentOverDueFinePercent() + CSV_SEPARATOR);
            // 13-M
            String finvoiceDateFormat = finvoice.getInvoiceDetails().getInvoiceDate().getFormat();
            if (finvoiceDateFormat.equalsIgnoreCase("CCYYMMDD")) {
                finvoiceDateFormat = "yyyyMMdd";
            }
            Date invoiceDate = (new SimpleDateFormat(finvoiceDateFormat))
                    .parse(finvoice.getInvoiceDetails().getInvoiceDate().getValue());
            sb.append(finagoDateFormat.format(invoiceDate) + CSV_SEPARATOR);
            // 14-N, 15-O, 16-P
            for (int i = 0; i < 3; i++) {
                sb.append(CSV_SEPARATOR);
            }
            // 17-Q
            BuyerPartyDetails.BuyerPostalAddressDetails buyerPostalAddressDetails =
                    buyerPartyDetails.getBuyerPostalAddressDetails();
            sb.append(buyerPartyDetails.getBuyerOrganisationName() + "\\"
                    + buyerPostalAddressDetails.getBuyerStreetName() + "\\"
                    + buyerPostalAddressDetails.getBuyerPostCodeIdentifier() + "\\"
                    + buyerPostalAddressDetails.getBuyerTownName() + "\\"
                    + buyerPostalAddressDetails.getCountryCode() + CSV_SEPARATOR);
            // 18-R
            DeliveryPartyDetails.DeliveryPostalAddressDetails deliveryPostalAddressDetails =
                    deliveryPartyDetails.getDeliveryPostalAddressDetails();
            sb.append(deliveryPartyDetails.getDeliveryOrganisationName() + "\\"
                    + deliveryPostalAddressDetails.getDeliveryStreetName() + "\\"
                    + deliveryPostalAddressDetails.getDeliveryPostCodeIdentifier() + "\\"
                    + deliveryPostalAddressDetails.getDeliveryTownName() + "\\"
                    + deliveryPostalAddressDetails.getCountryCode() + CSV_SEPARATOR);
            // 19-S
            sb.append(invoiceDetails.getInvoiceFreeText() + CSV_SEPARATOR);
            // 20-T, 21-U, 22-V, 23-W, 24-X, 25-Y
            for (int i = 0; i < 6; i++) {
                sb.append(CSV_SEPARATOR);
            }
            // 26-Z
            sb.append("2" + CSV_SEPARATOR);
            // the rest
            sb.append("\n");
            
            // write Invoice row records
            for (InvoiceRow invoiceRow : invoiceRows) {
                // 1-A
                sb.append(CSV_SEPARATOR);
                // 2-B
                sb.append(invoiceRow.getArticleName() + CSV_SEPARATOR);
                // 3-C
                sb.append(invoiceRow.getArticleIdentifier() + CSV_SEPARATOR);
                // 4-D
                sb.append(invoiceRow.getOrderedQuantity().getValue() + CSV_SEPARATOR);
                // 5-E
                sb.append(invoiceRow.getOrderedQuantity().getQuantityUnitCode() + CSV_SEPARATOR);
                // 6-F
                sb.append(invoiceRow.getUnitPriceAmount().getValue() + CSV_SEPARATOR);
                // 7-G
                sb.append(CSV_SEPARATOR);
                // 8-H
                sb.append(invoiceRow.getRowVatRatePercent() + CSV_SEPARATOR);
                // the rest
                sb.append("\n");
            }
            
            writer.write(sb.toString());
            
            // update FileDownloader
            updateFileDownloader();
        }
    }
    
    private void updateFileDownloader() throws Exception {
        StreamResource resource = new StreamResource((StreamResource.StreamSource) () -> {
            try {
                return new FileInputStream(csvFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Notification.show("Can't create new file downloader.", Notification.Type.ERROR_MESSAGE);
            }
            return null;
        }, null);
        
        if (resource != null) {
            resource.setFilename("finagoinvoice.csv");
            fileDownloader = new FileDownloader(resource);
            fileDownloader.extend(downloadButton);
        }
    }
    
    private Upload createNewUpload() {
        Upload newUpload = new Upload(null, (Upload.Receiver) (filename, mimeType) -> {
            FileOutputStream fos;
            try {
                xmlFile = new File(filename);
                fos = new FileOutputStream(xmlFile);
            } catch (FileNotFoundException e) {
                Notification.show("Could not open xmlFile<br/>",
                        e.getMessage(),
                        Notification.Type.ERROR_MESSAGE);
                return null;
            }
            return fos;
        });
        
        newUpload.addSucceededListener((Upload.SucceededListener) event -> {
            if (!xmlFile.getName().split("\\.")[1].equalsIgnoreCase("xml")) {
                xmlFile = null;
            }
            updateFileLabel();
            updateDownloadButton();
            csvFile = null;
            convertXmlToCsv();
        });
        
        newUpload.setButtonCaption("Upload Finvoice file");
        newUpload.setAcceptMimeTypes("text/xml");
        
        return newUpload;
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
