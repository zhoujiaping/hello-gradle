import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;

public class ServerUtil {
	public static class ServerUtilException extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public ServerUtilException(Exception e) {
			super(e);
		}
	}
    public static String getHttpPort(){
		try {
			MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
			Set<ObjectName> objectNames;
			objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
			        Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
			Iterator<ObjectName> iter = objectNames.iterator();
			if(iter.hasNext()){
				return iter.next().getKeyProperty("port");
			}
			return null;
		} catch (MalformedObjectNameException e) {
			throw new ServerUtilException(e);
		}
    }
    public static String getHost(){
    	InetAddress addr = NetUtils.getLocalAddress();
		if (addr != null) {
			String hostAddr = addr.getHostAddress();
			if (hostAddr != null) {
				return hostAddr;
			}
		}
		return null;
    }
}