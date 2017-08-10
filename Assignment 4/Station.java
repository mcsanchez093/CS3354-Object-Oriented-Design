/*****************************
 * Author: Maria Sanchez
 * CS3354 Summer II
 *****************************/

public class Station
{
	private int message;
  private boolean carrierStatus;
  private int reveivedMessage;
  public Station(int message, boolean carrierStatus)
  {
  	this.message = message;
  	this.carrierStatus = carrierStatus;
  	}
  public int getMessage()
  {
  	return message;
  	}
  public void setMessage(int message)
  {
  	this.message = message;
  	}
  public boolean isCarrierStatus()
  {
  	return carrierStatus;
  	}
  public void setCarrierStatus(boolean carrierStatus)
  {
  	this.carrierStatus = carrierStatus;
  	}
  public int getReveivedMessage()
  {
  	return reveivedMessage;
  	}
  public void setReveivedMessage(int reveivedMessage)
  {
  	this.reveivedMessage = reveivedMessage;
  	}
  }

