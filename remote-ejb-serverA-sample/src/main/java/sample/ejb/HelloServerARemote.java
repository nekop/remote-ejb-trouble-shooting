package sample.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloServerARemote {
	String helloServerA();
}
