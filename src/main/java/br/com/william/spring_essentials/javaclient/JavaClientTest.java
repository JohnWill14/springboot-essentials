package br.com.william.spring_essentials.javaclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class JavaClientTest {
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		BufferedReader br =null;
		try {
			URL url = new URL("http://localhost:8080/v1/user/students/6");
			connection =  (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			String user="mito";
			String password="qwe123";
			connection.addRequestProperty("Authorization", "Basic "+encodeUsernamePassword(user, password));
			
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSB = new StringBuilder();
			String line;
			while((line=br.readLine())!=null) {
				jsonSB.append(line);
			}
			System.out.println(jsonSB.toString());
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(br);
			if(connection!=null) connection.disconnect();
		}
	}
	private static String encodeUsernamePassword(String user, String password) {
		String userPassword = user+":"+password;
		return new String(Base64.encodeBase64(userPassword.getBytes()));
	}
}
