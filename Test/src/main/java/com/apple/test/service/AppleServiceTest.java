package com.apple.test.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.testng.Assert;

import com.apple.test.model.Car;
import com.apple.test.model.LowestRentalComparator;

public class AppleServiceTest {

	static final String BASE_URL = "https://baseUrl";

	public static void main(String[] args) throws ClientProtocolException, IOException, JAXBException {
		
		HttpResponse responseMsg = ApacheHTTPClientUtil.sendAndReceiveGETResponse(BASE_URL);
		// validate the msgs : status code and status msg
		int statusCode = responseMsg.getStatusLine().getStatusCode();
		String statusMsg = responseMsg.getStatusLine().getReasonPhrase();

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusMsg, "OK");

		List<Car> carList = getCarList(responseMsg);

		getBlueCars(carList);

		findLowestRent(carList);

		findtheHighestRevenue(carList);

	}

	private static void getBlueCars(List<Car> carList) throws IOException, JsonParseException, JsonMappingException {

		for (Car car : carList) {
			if (car.getData().getColor().equals("blue")) {
				System.out.println(car);
			}
		}
	}

	private static void findLowestRent(List<Car> carList) throws ParseException, IOException {

		Collections.sort(carList, new LowestRentalComparator());

		Iterator<Car> itr = carList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	private static void findtheHighestRevenue(List<Car> carList) {
		float highestRevenue = 0;
		Car ans = null;
		for (Car car : carList) {

			float maintenance = car.getMetrics().getYoymaintenancecost() + car.getMetrics().getDepreciation();
			float rentOfYear = car.getMetrics().getRentalCount().getYeartodate()
					* (car.getRent().getPrice() - car.getRent().getDiscount());
			float revenue = rentOfYear - maintenance;

			if (highestRevenue < revenue) {
				highestRevenue = revenue;
				ans = car;
			}
		}
		System.out.println("This car has the highest revenue" + ans);

	}

	private static List<Car> getCarList(HttpResponse responseMsg) throws ParseException, IOException {
		HttpEntity httpEntity = responseMsg.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		ObjectMapper mapper = new ObjectMapper();

		List<Car> carJsonList = mapper.readValue(apiOutput, new TypeReference<List<Car>>() {
		});

		return carJsonList;
	}

}
