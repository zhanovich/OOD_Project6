import java.lang.reflect.*;

public class OwnerProxy implements InvocationHandler{
	
	MoviePick selection;
	
	public OwnerProxy(MoviePick selection) {
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