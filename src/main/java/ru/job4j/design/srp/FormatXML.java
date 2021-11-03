package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class FormatXML implements Format {
    @Override
    public String toFormat(Object report) {
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(String.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(report, writer);
            return writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}