package com.test.ws.constant;

public class ConfigConstant {

	public static final String DIAL_CENTER_CONFIG_PROPERTY_FILE_LOCATION ="/WEB-INF/config/dial-center-config.properties";
	public static final String COMMON = "COMMON";
	public static final String NETWORK_ADDRESS="networkAddress";
	public static final String NETWORK_PORT="networkPort";
	public static final String MAX_REQUEST_QUEUE_SIZE="maxRequestQueueSize";
	public static final String MAX_THREAD_POOL_SIZE="maxThreadPoolSize";
	public static final String C5_USERNAME = "C5.UserName";
	public static final String C5_REMOTE_ADDRESS = "C5.networkAddress";
	public static final String C5_REMOTE_PORT = "C5.networkPort";
	public static final String SEND_CRON_NAME = "sendcron.name";
	public static final String SEND_CRON_SECRET = "sendcron.secret";
	public static final String LIST_CRON_NAME = "listcron.name";
	public static final String LIST_CRON_SECRET = "listcron.secret";
	public static final String USERNAME = "name";
	public static final String SECRET = "secret";
	
	public static final String dsID="0";
	public static final String dsName="DialCenterServerDB";
	public static final String DB_USERNAME="database.userName";
	public static final String DB_PASSWORD="database.password";
	public static final String DB_URL="database.url";
	
	public static final String LOG_PATH="log.path";
	public static final String LOG_LEVEL="log.level";
	
	public static final int BATCH_SIZE_MIN = 10;
	public static final String DBSCANNER_SERVICEEXECUTIONPERIOD = "dbscanner.serviceExecutionPeriod";
	public static final String DBSCANNER_MAXPARALLELEXECUTION="dbscanner.maxParallelExecution";
	public static final String DBSCANNER_BATCHSIZE="dbscanner.batchSize";
	public static final long DELAY_AFTER_C5_DOWN_IN_MILISECONDS = 60000;
	
	
	public static final String SENT = "SENT";
	public static final String FAILED = "FAILED";
	public static final String NEW = "NEW";
	public static final String QUEUE = "QUEUE";
	public static final String READY = "READY";
	public static final String INCALL = "INCALL";
	public static final String DEAD = "DEAD";
	
	//////////SERVER Properties constants
	public static final String SERVER_IP = "database.server.ip";
	public static final String OUTBOUND_CALLS_PER_SECOND = "server.outbound_calls_per_second";
	public static final String MAX_SERVER_CONCURRENT_SESSION = "server.max_server_concurrent_session";
	public static final String MAX_SERVER_CONCURRENT_SESSION_CHECK = "server.max_server_concurrent_session_check";
	
	public static final long DB_HIGH_QUERY_RESPONSE_TIME_MS = 100;
	public static final String VAR_DUMMYSUBSCRIBER = "44455501";
	public static final String THREAD_WAIT_TIMEOUT = "thread.waittimeout";
	
	
	
	

			
}
