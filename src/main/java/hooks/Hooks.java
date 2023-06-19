package hooks;

import java.net.InetAddress;
import java.net.UnknownHostException;

import driverfactory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before(order = 0)
	public void before(Scenario scenaio) throws Exception {

		WebDriverFactory.setDriver();
		System.out.println("Current Thread Name:" + Thread.currentThread().getName());
		System.out.println("Current Thread ID:" + Thread.currentThread().getId());
	}

	@After(order = 0)
	public void after() throws Exception {
		WebDriverFactory.closeDriver();
	}

	@AfterAll(order = 0)
	public static void afterAll() throws UnknownHostException {
		System.out.println("AfterAll - with order=0");

		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println("System IP Address : " + (localhost.getHostAddress()).trim());

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("Write email code in this method - Shutdown Hook is running and this text prints before JVM shut downs!");
			}
		}));
		System.out.println("This text prints before Shutdown hook");

	}

}
