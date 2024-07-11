package com.trello.qsp.genericutility;

import java.time.LocalDateTime;

public class JavaUtility {

	public String timeStamp()
	{
String timeStamp = LocalDateTime.now().toString().replace(':', '-');
return timeStamp;
	}

}
