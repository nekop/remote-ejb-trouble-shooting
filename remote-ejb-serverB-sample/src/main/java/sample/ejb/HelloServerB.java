package sample.ejb;

import javax.ejb.Stateful;

@Stateful
public class HelloServerB implements HelloServerBRemote {
	
	public String helloServerB() {
		System.out.println("executed helloServerB()");
		return "Hello Server B.";
	}
}
