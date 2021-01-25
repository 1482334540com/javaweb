
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//ServletContextListener 监听器
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlete对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Servlete对象被销毁了了");
    }
}
