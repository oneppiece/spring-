package jvm;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptSample {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine javaScript = manager.getEngineByName("JavaScript");
		String scriptText = "function sum(a,b){return a+b;}";
		javaScript.eval(scriptText);
		Invocable invocable = (Invocable) javaScript;
		Object sum = invocable.invokeFunction("sum", 100, 50);
		System.out.println(sum);
	}
}
