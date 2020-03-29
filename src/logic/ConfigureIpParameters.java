package logic;

import com.serotonin.modbus4j.ip.IpParameters;

public class ConfigureIpParameters {
	private IpParameters ipParameters = new IpParameters();

	public ConfigureIpParameters(String host) {
		this(host, 502); // Default port.
	}
	
	public ConfigureIpParameters(String host, int port) {
        this.ipParameters.setHost(host);
        this.ipParameters.setPort(port);
        this.ipParameters.setEncapsulated(false);
	}

	public IpParameters getIpParameters() {
		return ipParameters;
	}
	
}
