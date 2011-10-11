package ie.cit.cloud.appdev.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TimeService {

    public Date getTime() {
	return new Date();
    }

    public Object getTime(String format) {
	Map<String, String> map = new HashMap<>();
	try (InputStream is = new FileInputStream("asdasd")) {

	} catch (IOException e) {
	    e.printStackTrace();
	}

	return new SimpleDateFormat(format).format(new Date());
    }
}