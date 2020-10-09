import java.lang.reflect.*;

public class NonOwnerProxy implements InvocationHandler {

	MoviePick selection;
	
	public NonOwnerProxy(MoviePick selection) {
		this.selection = selection;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(selection, args);
   			} else if (method.getName().startsWith("set")) {
				return method.invoke(selection, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}

}