package com.mycompany.app;

import java.util.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {

	public static boolean advSearch(ArrayList<String> array1, ArrayList<String> array2, int e, int k) {
		if (array1 == null | array2 == null)
			return false;
		boolean flag1 = false;
		boolean flag2 = false;

		for (int i = 0; i < array1.size(); i++) {	//Search Array 1
			int tempValue = array1.get(i).length() + 1;
			if (tempValue >= e && tempValue <= k) {
				flag1 = true;
			}
		}
		for (int i = 0; i < array2.size(); i++) {	//Search Array 2
			int tempValue = array2.get(i).length() + 1;
			if (tempValue >= e && tempValue <= k) {
				flag2 = true;
			}
		}
		if (flag1 == true && flag2 == true)		//If both Array1 and Array2 contains string in given range return True
			return true;

		return false;	//At least one string field doesn't contain conditions.
	}

	public static void main(String[] args) {
		port(getHerokuAssignedPort());

		get("/", (req, res) -> "Hello, World");

		post("/compute", (req, res) -> {
			// System.out.println(req.queryParams("input1"));
			// System.out.println(req.queryParams("input2"));

			String input1 = req.queryParams("input1"); // First Array
			java.util.Scanner sc1 = new java.util.Scanner(input1);
			sc1.useDelimiter("\\n");
			java.util.ArrayList<String> inputList = new java.util.ArrayList<>();

			while (sc1.hasNext()) {
				String value = sc1.next().replaceAll("\\s", "");
				inputList.add(value);
			}
			sc1.close();

			String input4 = req.queryParams("input4"); // Second Array
			java.util.Scanner sc2 = new java.util.Scanner(input4);
			java.util.ArrayList<String> inputList2 = new java.util.ArrayList<>();
			sc2.useDelimiter("\\n");
			while (sc2.hasNext()) {
				String value = sc2.next().replaceAll("\\s", "");
				inputList2.add(value);
			}
			sc2.close();

			String input2 = req.queryParams("input2").replaceAll("\\s", "");
			String input3 = req.queryParams("input3").replaceAll("\\s", "");
			int input2AsInt = Integer.parseInt(input2);
			int input3AsInt = Integer.parseInt(input3);

			boolean result = App.advSearch(inputList, inputList2, input2AsInt, input3AsInt);

			Map map = new HashMap();
			map.put("result", result);
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());

		get("/compute", (rq, rs) -> {
			Map map = new HashMap();
			map.put("result", "not computed yet!");
			return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());
	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
	}
}
