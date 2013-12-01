package com.pucrs.devsys.tf.rest.data;

import java.util.HashMap;
import java.util.Map;

import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.Talk;
import com.pucrs.devsys.tf.persistence.User;


/**
 * This class will register all the Rest Gateways.
 * @author I833488
 *
 */
public class DataGatewayRegister 
{

	private static DataGatewayRegister instance = null;
	
	private Map<String, DataGateway> _gatewayMap = null;
	
	protected DataGatewayRegister() 
	{
		_gatewayMap = new HashMap<String, DataGateway>();
		registerGateways();
	}
	
	public static DataGatewayRegister getInstance() {
		if(instance == null) {
			instance = new DataGatewayRegister();
		}
		
		return instance;
	}
	
	public final DataGateway get(String className) 
	{
		return _gatewayMap.get( className );
	}
	
    private void registerGateways()
    {
    	_gatewayMap.put(User.class.getSimpleName(), UserGateway.getInstance() );
    	_gatewayMap.put(Event.class.getSimpleName(), EventGateway.getInstance() );
    	_gatewayMap.put(Talk.class.getSimpleName(), TalkGateway.getInstance() );
    }
	
}
